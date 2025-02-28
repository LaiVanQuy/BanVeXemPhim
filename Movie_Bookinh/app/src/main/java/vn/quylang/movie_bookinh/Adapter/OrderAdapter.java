package vn.quylang.movie_bookinh.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.quylang.movie_bookinh.Models.Order;
import vn.quylang.movie_bookinh.Models.OrderDetail;
import vn.quylang.movie_bookinh.Models.Ticket;
import vn.quylang.movie_bookinh.R;
import vn.quylang.movie_bookinh.Retrofit.APIService;
import vn.quylang.movie_bookinh.Retrofit.RetrofitClient;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{
    Context context;
    List<Order> orderList;
    APIService apiService;
    List<OrderDetail>orderDetailList;
    RecyclerView rcvOrderDetail;
    ImageView imgMovie;
    TextView txtMovieName,txtShowTime,txtRoom,txtTotal;
    OrderDetailsAdapter orderDetailsAdapter;
    public OrderAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }
    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order,parent,false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order=orderList.get(position);
        holder.tvId.setText(order.getMaDH()+"");
        holder.tvDate.setText(order.getGioDat()+"");
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(holder.itemView.getContext());
                dialog.setContentView(R.layout.dialog_order_detail);
                Window window = dialog.getWindow();
                window.setGravity(Gravity.CENTER);

                init(dialog);
                loadOrderDetail(order.getMaDH());
                dialog.show();
            }
        });
    }
    public void init(Dialog dialog){
        imgMovie=dialog.findViewById(R.id.imgMovieOrder);
        txtMovieName = dialog.findViewById(R.id.txtMovieName);
        txtShowTime = dialog.findViewById(R.id.txtShowTime);
        txtRoom = dialog.findViewById(R.id.txtCinemaRoom);
        rcvOrderDetail=dialog.findViewById(R.id.rcv_OrderDetail);
        txtTotal=dialog.findViewById(R.id.tvTotal);
    }
    public void loadOrderDetail(int id){
        apiService= RetrofitClient.getRetrofit().create(APIService.class);
        apiService.getOrderDetailById(id).enqueue(new Callback<List<OrderDetail>>() {
            @Override
            public void onResponse(Call<List<OrderDetail>> call, Response<List<OrderDetail>> response) {
                if(response.isSuccessful()){
                    orderDetailList=response.body();
                    List<Ticket>tickets=new ArrayList<>();
                    for (OrderDetail orderDetail:orderDetailList
                         ) {
                        tickets.add(orderDetail.getVeModel());
                    }
                    int total=0;
                    for (Ticket tk :tickets
                         ) {
                        total=total+tk.getGiaVe();
                    }
                    orderDetailsAdapter=new OrderDetailsAdapter(context,tickets);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,RecyclerView.VERTICAL,false);
                    rcvOrderDetail.setHasFixedSize(true);
                    rcvOrderDetail.setLayoutManager(linearLayoutManager);
                    rcvOrderDetail.setAdapter(orderDetailsAdapter);
                    orderDetailsAdapter.notifyDataSetChanged();
                    Glide.with(context).load(orderDetailList.get(0).getVeModel().
                            getSuatChieuModel().getPhimModel().getHinhAnh()).into(imgMovie);
                    txtMovieName.setText(orderDetailList.get(0).getVeModel().getSuatChieuModel().getPhimModel().getTenPhim());
                    txtRoom.setText("CinemaRoom "+orderDetailList.get(0).getVeModel().getSuatChieuModel().getPhongChieuModel().getTenPhong());
                    txtShowTime.setText(orderDetailList.get(0).getVeModel().getSuatChieuModel().getGioChieu()+"");
                    txtTotal.setText("Total:"+total+"VNĐ");
                }
            }

            @Override
            public void onFailure(Call<List<OrderDetail>> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    protected class OrderViewHolder extends RecyclerView.ViewHolder{

        TextView tvId,tvDate;
        Button btnDetail;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId=itemView.findViewById(R.id.tvOrderId);
            tvDate=itemView.findViewById(R.id.tvOrderDate);
            btnDetail=itemView.findViewById(R.id.btnDetail);
        }
    }
}
