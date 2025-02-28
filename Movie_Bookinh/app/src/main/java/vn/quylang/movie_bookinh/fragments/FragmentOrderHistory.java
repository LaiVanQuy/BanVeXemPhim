package vn.quylang.movie_bookinh.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.quylang.movie_bookinh.Adapter.OrderAdapter;
import vn.quylang.movie_bookinh.Models.Account;
import vn.quylang.movie_bookinh.Models.Order;
import vn.quylang.movie_bookinh.R;
import vn.quylang.movie_bookinh.Retrofit.APIService;
import vn.quylang.movie_bookinh.Retrofit.RetrofitClient;
import vn.quylang.movie_bookinh.Retrofit.SharedPref.SharedPrefManager;

public class FragmentOrderHistory extends Fragment {

    RecyclerView rcv_order_history;
    List<Order> orderList;
    APIService apiService;
    OrderAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order_history,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        Account account= SharedPrefManager.getInstance(getContext()).getUser();
        loadYourOrders(account);
    }
    private void init(View view){
        rcv_order_history=view.findViewById(R.id.rcv_orderHistory);
    }
    private void loadYourOrders(Account account){
        apiService= RetrofitClient.getRetrofit().create(APIService.class);
        apiService.getOrdersByAccount(account.getEmail(),account.getPass()).enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if(response.isSuccessful()){
                    orderList=response.body();
                    adapter=new OrderAdapter(getContext(),orderList);
                    rcv_order_history.setHasFixedSize(true);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
                    rcv_order_history.setLayoutManager(linearLayoutManager);
                    rcv_order_history.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(getContext(), "respone not succesfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
