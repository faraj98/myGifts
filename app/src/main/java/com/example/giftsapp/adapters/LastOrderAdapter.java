package com.example.giftsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giftsapp.R;
import com.example.giftsapp.models.LastOrder;

import java.util.ArrayList;

public class LastOrderAdapter extends RecyclerView.Adapter<LastOrderAdapter.lastOrderViewHolder> {

    Context context ;
    ArrayList<LastOrder> lastOrders ;
<<<<<<< HEAD
=======
    boolean iscart=false;
    boolean isfavourite=false;
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde

    public LastOrderAdapter(Context context, ArrayList<LastOrder> lastOrders) {
        this.context = context;
        this.lastOrders = lastOrders;
    }

    public LastOrderAdapter() {

    }

    @NonNull
    @Override
    public lastOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.lastorder_item , parent , false);
        return new lastOrderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull lastOrderViewHolder holder, int position) {

        final LastOrder ss = lastOrders.get(position);




        holder.img.setImageResource(ss.getImg());

        holder.title.setText(ss.getTitle() );
        holder.cart_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (iscart==false){
                Toast.makeText(context, "lastorder cart", Toast.LENGTH_SHORT).show();
                holder.cart_shop.setImageResource(R.drawable.ic_baseline_shopping_cart_24);
                iscart=true;
            }else {
                    holder.cart_shop.setImageResource(R.drawable.shoppingcart);
                    iscart=false;
                }
            }
        });

        holder.heart_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isfavourite == false) {
                    Toast.makeText(context, "lastorder heart", Toast.LENGTH_SHORT).show();
                    holder.heart_shop.setImageResource(R.drawable.ic_baseline_favorite_24);
                    isfavourite=true;
                }else {
                    holder.heart_shop.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                    isfavourite=false;
                }
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
