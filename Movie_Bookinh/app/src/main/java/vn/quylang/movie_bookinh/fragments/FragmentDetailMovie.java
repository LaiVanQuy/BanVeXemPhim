package vn.quylang.movie_bookinh.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.quylang.movie_bookinh.Adapter.ShowTimeAdapter;
import vn.quylang.movie_bookinh.Const;
import vn.quylang.movie_bookinh.Models.Movie;
import vn.quylang.movie_bookinh.Models.Showtime;
import vn.quylang.movie_bookinh.R;
import vn.quylang.movie_bookinh.Retrofit.APIService;
import vn.quylang.movie_bookinh.Retrofit.RetrofitClient;

public class FragmentDetailMovie extends Fragment {

    RecyclerView recyclerView;
    Movie movieAPI;
    ImageView imgMovie;
    TextView txtCast, txtReleaseDate, txtDecs,txtCate;
    final int postcode = 7171;
    Button btnWatchTrailer;
    APIService apiService;
    List<Showtime>showtimeList;
    ShowTimeAdapter showTimeAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        movie = (Movie) getArguments().getSerializable("movie");
        return inflater.inflate(R.layout.fragment_detail_movie,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        loadDetailMovie(Const.currentMovie.getMaPhim());
        loadShowTimesByMovie(Const.currentMovie.getMaPhim());
    }
    private void loadShowTimesByMovie(int id){
        apiService= RetrofitClient.getRetrofit().create(APIService.class);
        apiService.getShowTimesByMovie(id).enqueue(new Callback<List<Showtime>>() {
            @Override
            public void onResponse(Call<List<Showtime>> call, Response<List<Showtime>> response) {
                if(response.isSuccessful()){
                    showtimeList=response.body();
                    showTimeAdapter=new ShowTimeAdapter(showtimeList,getContext());
                    recyclerView.setHasFixedSize(true);
                    LinearLayoutManager linearLayoutManager=new GridLayoutManager(getContext(),2,LinearLayoutManager.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(showTimeAdapter);
                    showTimeAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Showtime>> call, Throwable t) {

            }
        });
    }
    private void loadDetailMovie(int id){
        apiService= RetrofitClient.getRetrofit().create(APIService.class);
        apiService.getMovieDetail(id).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if(response.isSuccessful()){
                    movieAPI=response.body();
                    txtCast.setText("Diễn Viên:"+movieAPI.getDienVien());
                    txtDecs.setText("Mô tả:"+movieAPI.getMoTa());
                    txtReleaseDate.setText("Ngày xuất bản:"+movieAPI.getNgayXuatBan()+"");
                    txtCate.setText("Thể loại:"+movieAPI.getTheLoaiModel().getTenTheLoai());
                    Glide.with(getContext()).load(movieAPI.getHinhAnh()).into(imgMovie);
                }
                else {
                    int statusCode=response.code();
                }
            }
            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }
    public void init(View view) {
        btnWatchTrailer = view.findViewById(R.id.btnWatchTrailer);
        recyclerView = view.findViewById(R.id.rcDetailMovie);
        txtCast = view.findViewById(R.id.txtCastDetail);
        txtDecs = view.findViewById(R.id.txtDesc);
        txtReleaseDate = view.findViewById(R.id.txtRelease);
        imgMovie = view.findViewById(R.id.imgDetailMovie);
        txtCate=view.findViewById(R.id.txtCate);
    }
}
