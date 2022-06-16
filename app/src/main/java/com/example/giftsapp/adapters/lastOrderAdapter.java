package com.example.giftsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giftsapp.R;
import com.example.giftsapp.models.category;
import com.example.giftsapp.models.lastOrder;

import java.util.ArrayList;

public class lastOrderAdapter extends RecyclerView.Adapter<lastOrderAdapter.lastOrderViewHolder> {

    Context context ;
    ArrayList<lastOrder> lastOrders ;

    public lastOrderAdapter(Context context, ArrayList<lastOrder> lastOrders) {
        this.context = context;
        this.lastOrders = lastOrders;
    }

    @NonNull
    @Override
    public lastOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.lastorder_item , parent , false);
        return new lastOrderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull lastOrderViewHolder holder, int position) {

        final lastOrder ss = lastOrders.get(position);




        holder.img.setImageResource(ss.getImg());

        holder.title.setText(ss.getTitle() );
        holder.cart_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "lastorder cart", Toast.LENGTH_SHORT).show();
            }
        });

        holder.heart_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "lastorder heart", Toast.LENGTH_SHORT).show();
            }
        });





    }

    @Override
    public int getItemCount() {
        return lastOrders.size();
    }

    public class lastOrderViewHolder extends RecyclerView.ViewHolder{
        ImageView img  ;
        TextView title ;
        ImageButton cart_shop , heart_shop ;

        public lastOrderViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.lastorder_img);
            title  =itemView.findViewById(R.id.lastorder_tv);
            cart_shop  =  itemView.findViewById(R.id.lastorder_cart);
            heart_shop  =itemView.findViewById(R.id.lastorder_heart);

        }
    }
}
