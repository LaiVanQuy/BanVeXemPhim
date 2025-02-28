package vn.quylang.movie_bookinh.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import vn.quylang.movie_bookinh.Models.Ticket;
import vn.quylang.movie_bookinh.R;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder>{
    Context context;
    List<Ticket> ticketList;
    List<Ticket>yourtickets=new ArrayList<>();

    public TicketAdapter(Context context, List<Ticket> ticketList) {
        this.context = context;
        this.ticketList = ticketList;
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket,null);
        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position) {

        Ticket ticket=ticketList.get(position);
        holder.btnSeat.setText(ticket.getSeatModel().getHang()+ticket.getSeatModel().getSoGhe());
        if(ticket.getTrangThai()==1){
            holder.btnSeat.setBackgroundColor(context.getResources().getColor(R.color.red));
        }
        else {
            holder.setFlag(true);

        holder.btnSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.isChoose()){
                    holder.btnSeat.setBackgroundColor(context.getResources().getColor(R.color.teal_700));
                    holder.setFlag(false);
                    yourtickets.add(ticket);
                    SharedPreferences sharedPreferences = context.getSharedPreferences("MyCart", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    Gson gson = new Gson();
                    String jsonTickets = gson.toJson(yourtickets);
                    editor.putString("ticketList", jsonTickets);
                    editor.apply();
                }
                else{
                    holder.btnSeat.setBackgroundColor(context.getResources().getColor(R.color.green));
                    holder.setFlag(true);
                    yourtickets.remove(ticket);
                    SharedPreferences sharedPreferences = context.getSharedPreferences("MyCart", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    Gson gson = new Gson();
                    String jsonTickets = gson.toJson(yourtickets);
                    editor.putString("ticketList", jsonTickets);
                    editor.apply();
                }


//                Toast.makeText(context, "Ban da chon ghe "+holder.btnSeat.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        }
    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }

    protected class TicketViewHolder extends RecyclerView.ViewHolder {
        Button btnSeat;
        boolean choose;

        public boolean isChoose() {
            return choose;
        }

        public void setFlag(boolean flag) {
            this.choose = flag;
        }

        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);
            btnSeat=itemView.findViewById(R.id.btnTicket);

        }
    }
}
