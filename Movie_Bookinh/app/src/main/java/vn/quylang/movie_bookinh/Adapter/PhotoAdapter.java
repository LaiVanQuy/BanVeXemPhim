package vn.quylang.movie_bookinh.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
//import com.example.ticketbooking.Model.Bean.Movie;
//import com.example.ticketbooking.Model.Service.MySingleton;
//import com.example.ticketbooking.R;
//import com.example.ticketbooking.View.fragment.HomeFragment;
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import vn.quylang.movie_bookinh.Models.Movie;
import vn.quylang.movie_bookinh.R;
import vn.quylang.movie_bookinh.fragments.FragmentHome;

public class PhotoAdapter extends PagerAdapter {
    Context context;
    List<Movie> listMovie;
    FragmentHome homeFragment;
    public PhotoAdapter(Context context, List<Movie> listMovie, FragmentHome homeFragment) {
        this.context = context;
        this.listMovie = listMovie;
        this.homeFragment = homeFragment;
    }

    @Override
    public int getCount() {
        return listMovie.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo, container, false);
        Movie movie = listMovie.get(position);

        ImageView imageView = view.findViewById(R.id.imgPhoto);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_video);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                Window window = dialog.getWindow();
                window.setGravity(Gravity.CENTER);

                YouTubePlayerView youTubePlayerView = dialog.findViewById(R.id.youtube_player_view);
                homeFragment.getLifecycle().addObserver(youTubePlayerView);
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        String videoId[] = movie.getTrailer().split("=");
                        youTubePlayer.loadVideo(videoId[1], 0);
                    }
                });

                dialog.show();
            }
        });
        Glide.with(context).load(movie.getHinhAnh()).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);

    }
}
