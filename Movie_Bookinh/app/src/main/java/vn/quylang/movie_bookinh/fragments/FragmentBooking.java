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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.quylang.movie_bookinh.Adapter.TicketAdapter;
import vn.quylang.movie_bookinh.Const;
import vn.quylang.movie_bookinh.Models.Showtime;
import vn.quylang.movie_bookinh.Models.Ticket;
import vn.quylang.movie_bookinh.R;
import vn.quylang.movie_bookinh.Retrofit.APIService;
import vn.quylang.movie_bookinh.Retrofit.RetrofitClient;

public class FragmentBooking extends Fragment implements View.OnClickListener{

    private RecyclerView rcvTickets;
    private TextView tvMovieName, tvMovieSlot;
    ImageView imageView;
    private Button btnBooked;
    APIService apiService;
    List<Ticket> tickets;
    TicketAdapter ticketAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_booking,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
        loadTicketByShowTime(Const.currentShowTime.getMaSuatChieu());
        btnBooked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new FragmentOrderDetail();
                FragmentManager fragmentManager = ((FragmentActivity)getContext()).getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(fragmentManager.findFragmentById(R.id.content_frame)).commit();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.content_frame, fragment ,null);
                fragmentTransaction.commit();
                Const.CURRENT_FRAGMENT=Const.FRAGMENT_ORDER_DETAILS;
            }
        });
    }
    public void init(View view) {
        imageView = view.findViewById(R.id.imageViewMovie);
        rcvTickets = view.findViewById(R.id.rcv_Ticket);
        btnBooked = view.findViewById(R.id.btn_booked);
        tvMovieName = view.findViewById(R.id.tv_movie_name);
        tvMovieSlot = view.findViewById(R.id.tv_time_slot);
    }
    private void loadTicketByShowTime(int showTimeId){
        apiService= RetrofitClient.getRetrofit().create(APIService.class);
        apiService.getTicketByShowTime(showTimeId).enqueue(new Callback<List<Ticket>>() {
            @Override
            public void onResponse(Call<List<Ticket>> call, Response<List<Ticket>> response) {
                if(response.isSuccessful()){

                    tickets=response.body();
                    tvMovieName.setText(tickets.get(0).getSuatChieuModel().getPhimModel().getTenPhim());
                    tvMovieSlot.setText(tickets.get(0).getSuatChieuModel().getGioChieu()+"");
                    Glide.with(getContext()).load(tickets.get(0).getSuatChieuModel().getPhimModel().getHinhAnh()).into(imageView);

                    ticketAdapter=new TicketAdapter(getContext(),tickets);
                    rcvTickets.setHasFixedSize(true);
                    LinearLayoutManager linearLayoutManager=new GridLayoutManager(getContext(),5,RecyclerView.VERTICAL,false);
                    rcvTickets.setAdapter(ticketAdapter);
                    rcvTickets.setLayoutManager(linearLayoutManager);
                    ticketAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<Ticket>> call, Throwable t) {
                Log.d("error",t.getMessage());
            }
        });
    }
    @Override
    public void onClick(View view) {

    }
}
