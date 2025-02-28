package vn.quylang.movie_bookinh.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.quylang.movie_bookinh.Adapter.MovieAdapter;
import vn.quylang.movie_bookinh.Adapter.PhotoAdapter;

import vn.quylang.movie_bookinh.Models.Movie;
import vn.quylang.movie_bookinh.R;
import vn.quylang.movie_bookinh.Retrofit.APIService;
import vn.quylang.movie_bookinh.Retrofit.RetrofitClient;

public class FragmentHome extends Fragment {
    ViewPager viewPager;

    CircleIndicator circleIndicator;
    RecyclerView rvUpcoming, rvtheate;
    List<Movie>movieList,upcomingList;
    APIService apiService;
    MovieAdapter movieAdapterr,movieAdapter2;
    PhotoAdapter photoAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        loadMoviesInTheater();
        loadMoviesUpcoming();


    }
    private void init(View view) {
        movieList=new ArrayList<>();
        viewPager = view.findViewById(R.id.vpSlide);
        circleIndicator = view.findViewById(R.id.ciSlide);
        rvUpcoming = view.findViewById(R.id.rvUpcoming);
        rvtheate = view.findViewById(R.id.rvFilms);
    }
    public void loadMoviesInTheater(){
        apiService= RetrofitClient.getRetrofit().create(APIService.class);
        apiService.getMovieByStatus(1).enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()){
                    movieList=response.body();
                    movieAdapterr=new MovieAdapter(movieList,getContext());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
                    rvtheate.setHasFixedSize(true);
                    rvtheate.setLayoutManager(linearLayoutManager);
                    rvtheate.setAdapter(movieAdapterr);
                    movieAdapterr.notifyDataSetChanged();
                    LoadSlider(movieList);
                }
                else {
                    int statusCode=response.code();
                }

            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }
    public void loadMoviesUpcoming(){
        apiService=RetrofitClient.getRetrofit().create(APIService.class);
        apiService.getMovieByStatus(2).enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()){
                    upcomingList=response.body();
                    movieAdapter2=new MovieAdapter(upcomingList,getContext());
                    rvUpcoming.setHasFixedSize(true);

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
                    rvUpcoming.setLayoutManager(linearLayoutManager);
                    rvUpcoming.setAdapter(movieAdapter2);
                    movieAdapter2.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }
    public void LoadSlider(List<Movie> arrayList){
        photoAdapter = new PhotoAdapter(getContext(),arrayList, this);
        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        photoAdapter.notifyDataSetChanged();
    }
}
