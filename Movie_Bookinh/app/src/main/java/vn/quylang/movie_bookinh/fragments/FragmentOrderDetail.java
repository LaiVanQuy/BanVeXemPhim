package vn.quylang.movie_bookinh.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.quylang.movie_bookinh.Activity.ThankyouActivity;
import vn.quylang.movie_bookinh.Adapter.OrderDetailsAdapter;
import vn.quylang.movie_bookinh.Models.Account;
import vn.quylang.movie_bookinh.Models.OrderResponse;
import vn.quylang.movie_bookinh.Models.Ticket;
import vn.quylang.movie_bookinh.R;
import vn.quylang.movie_bookinh.Retrofit.APIService;
import vn.quylang.movie_bookinh.Retrofit.RetrofitClient;
import vn.quylang.movie_bookinh.Retrofit.SharedPref.SharedPrefManager;

public class FragmentOrderDetail extends Fragment {

    Button btnPay;
    ImageView imgMovie;
    TextView tvMovieName,tvShowTime,tvTotal;
    RecyclerView rcvOrderDetail;
    List<Ticket>yourTickets;
    OrderDetailsAdapter adapter;
    APIService apiService;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order_detail,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        getYourTickets();
        loadView(yourTickets);
        List<Integer>idList=new ArrayList<>();
        for (Ticket ticket: yourTickets
        ) {
            idList.add(ticket.getMaVe());
        }
        Account account= SharedPrefManager.getInstance(getContext()).getUser();
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderTickets(account.getEmail(), account.getPass(), idList);
                SharedPreferences sharedPref= (SharedPreferences) getContext().getSharedPreferences("MyCart", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPref.edit();
                editor.clear();
                editor.apply();
                Intent intent=new Intent(getContext(), ThankyouActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(), yourTickets.size()+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void init(View view){
        btnPay=view.findViewById(R.id.btnPay);
        imgMovie=view.findViewById(R.id.imgMovieOrder);
        tvMovieName=view.findViewById(R.id.txtMovieName);
        tvShowTime=view.findViewById(R.id.txtShowTime);
        rcvOrderDetail=view.findViewById(R.id.rcv_OrderDetail);
        tvTotal=view.findViewById(R.id.tvTotal);
    }
    private void getYourTickets(){
        SharedPreferences sharedPref= (SharedPreferences) getContext().getSharedPreferences("MyCart", Context.MODE_PRIVATE);
        String jsonTickets=sharedPref.getString("ticketList","");
        Type type=new TypeToken<List<Ticket>>() {}.getType();
        Gson gson=new Gson();
        yourTickets=gson.fromJson(jsonTickets,type);
    }
    public void loadView(List<Ticket> tickets){
        Ticket ticket=tickets.get(0);
        tvMovieName.setText(ticket.getSuatChieuModel().getPhimModel().getTenPhim());
        tvShowTime.setText(ticket.getSuatChieuModel().getGioChieu()+"");
        Glide.with(getContext()).load(ticket.getSuatChieuModel().getPhimModel().getHinhAnh()).into(imgMovie);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        adapter=new OrderDetailsAdapter(getContext(),tickets);
        rcvOrderDetail.setHasFixedSize(true);
        rcvOrderDetail.setLayoutManager(linearLayoutManager);
        rcvOrderDetail.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        int total=0;
        for (Ticket tk:tickets
             ) {
            total=total+tk.getGiaVe();
        }
        tvTotal.setText("Total:"+total+"VNĐ");
    }
    public void orderTickets(String email, String password, List<Integer> listmaVe){
        apiService= RetrofitClient.getRetrofit().create(APIService.class);
        apiService.orderTickets(email,password,listmaVe).enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                if(response.isSuccessful()){
                    OrderResponse orderResponse=response.body();
                    if(orderResponse.getStatus()){
                        Toast.makeText(getContext(), orderResponse.getMessage()+" "+orderResponse.getlChiTietDHModels().size(), Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(getContext(), orderResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getContext(), "Không gọi được API", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Failll", Toast.LENGTH_SHORT).show();
                Log.d("error",t.getMessage());
            }
        });

    }
}
