package com.example.giftsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giftsapp.R;
import com.example.giftsapp.models.category;
import com.example.giftsapp.models.shop;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {

    Context context ;
    ArrayList<shop> shops ;

    public ShopAdapter(Context context, ArrayList<shop> shops) {
        this.context = context;
        this.shops = shops;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.shop_item , parent , false);
        return new ShopViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {

        final shop ss = shops.get(position);




        holder.img.setImageResource(ss.getImg());

        holder.title.setText(ss.getTitle() );




    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder{
        ImageView img  ;
        TextView title ;

        public ShopViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.shop_img);
            title  =itemView.findViewById(R.id.shop_title);

        }
    }
}
