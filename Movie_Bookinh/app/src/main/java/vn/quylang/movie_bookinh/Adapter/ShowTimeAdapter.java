package vn.quylang.movie_bookinh.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.quylang.movie_bookinh.Const;
import vn.quylang.movie_bookinh.Models.Showtime;
import vn.quylang.movie_bookinh.R;
import vn.quylang.movie_bookinh.fragments.FragmentBooking;

public class ShowTimeAdapter extends RecyclerView.Adapter<ShowTimeAdapter.ShowTimeHolder> {
    List<Showtime> showtimeList;
    Context context;

    public ShowTimeAdapter(List<Showtime> showtimeList, Context context) {
        this.showtimeList = showtimeList;
        this.context = context;
    }

    @NonNull
    @Override
    public ShowTimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_time_show,null);
        ShowTimeHolder myViewHolder=new ShowTimeHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShowTimeHolder holder, int position) {
        Showtime showtime=showtimeList.get(position);
        holder.txtTimeStart.setText(showtime.getGioChieu()+"");
        holder.txtTimeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new FragmentBooking();
                FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(fragmentManager.findFragmentById(R.id.content_frame)).commit();

                Const.currentShowTime=showtime;

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.content_frame, fragment ,null);
                fragmentTransaction.commit();
                Const.CURRENT_FRAGMENT=Const.FRAGMENT_BOOKING;

                Toast.makeText(context, "Bạn đã chọn suất chiếu "+showtime.getGioChieu()+" cho phim "+showtime.getPhimModel().getTenPhim(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return showtimeList.size();
    }

    public class ShowTimeHolder extends RecyclerView.ViewHolder {
        TextView txtTimeStart;
        public ShowTimeHolder(@NonNull View itemView) {
            super(itemView);
            txtTimeStart=itemView.findViewById(R.id.txtStartTime);
        }
    }
}
