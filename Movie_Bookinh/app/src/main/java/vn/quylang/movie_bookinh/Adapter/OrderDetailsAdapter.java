package vn.quylang.movie_bookinh.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.quylang.movie_bookinh.Models.Ticket;
import vn.quylang.movie_bookinh.R;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.OrderDetailViewHolder> {
    Context context;
    List<Ticket> yourTickets;

    public OrderDetailsAdapter(Context context, List<Ticket> yourTickets) {
        this.context = context;
        this.yourTickets = yourTickets;
    }

    @NonNull
    @Override
    public OrderDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_detail,null);
        OrderDetailViewHolder myViewHolder=new OrderDetailViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull OrderDetailViewHolder holder, int position) {
        Ticket ticket=yourTickets.get(position);
        holder.tvSeat.setText(ticket.getSeatModel().getHang()+ticket.getSeatModel().getSoGhe());
        holder.tvPrice.setText(ticket.getGiaVe()+"VNĐ");
    }

    @Override
    public int getItemCount() {
        return yourTickets.size();
    }

    protected class OrderDetailViewHolder extends RecyclerView.ViewHolder{
        TextView tvSeat,tvPrice;
        public OrderDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSeat=itemView.findViewById(R.id.tvSeat);
            tvPrice=itemView.findViewById(R.id.tvPrice);
        }
    }
}
