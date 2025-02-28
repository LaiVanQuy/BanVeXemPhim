package vn.quylang.movie_bookinh.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.quylang.movie_bookinh.Const;
import vn.quylang.movie_bookinh.Models.Movie;
import vn.quylang.movie_bookinh.R;
import vn.quylang.movie_bookinh.fragments.FragmentDetailMovie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    List<Movie> alMovie;
    Context context;
    public MovieAdapter(List<Movie> alMovie, Context context){
        this.alMovie = alMovie;
        this.context = context;
    }
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,null);
        MovieViewHolder myViewHolder=new MovieViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie=alMovie.get(position);
        holder.txtNameMovie.setText(movie.getTenPhim());
        Glide.with(context).load(movie.getHinhAnh()).into(holder.imgMovie);

        holder.imgMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new FragmentDetailMovie();
                FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(fragmentManager.findFragmentById(R.id.content_frame)).commit();

                Const.currentMovie=movie;

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.content_frame, fragment ,null);
                fragmentTransaction.commit();
                Const.CURRENT_FRAGMENT=Const.FRAGMENT_DETAIL_MOVIE;
            }
        });
    }

    @Override
    public int getItemCount() {
        return alMovie.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{

        ImageView imgMovie;
        TextView txtNameMovie;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.imgMoie);
            txtNameMovie = itemView.findViewById(R.id.txtNameMovie);
        }
    }
}
