package com.example.giftsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giftsapp.Interface.RecycleViewOnItemClick;
import com.example.giftsapp.R;
import com.example.giftsapp.models.Mall;
import com.example.giftsapp.models.Shop;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {

    Context context ;
    ArrayList<Mall> stores ;
    RecycleViewOnItemClick recycleViewOnItemClick;

    public StoreAdapter(Context context, ArrayList<Mall> stores) {
        this.context = context;
        this.stores = stores;
    }

    public StoreAdapter(Context context, ArrayList<Mall> stores, RecycleViewOnItemClick recycleViewOnItemClick) {
        this.context = context;
        this.stores = stores;
        this.recycleViewOnItemClick = recycleViewOnItemClick;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.stores_item , parent , false);
        return new StoreViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {

        final Mall ss = stores.get(position);




        holder.img.setImageResource(ss.getImage());

        holder.title.setText(ss.getName() );




    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    public class StoreViewHolder extends RecyclerView.ViewHolder{
        ImageView img  ;
        TextView title ;

        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.store_img);
            title  =itemView.findViewById(R.id.store_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recycleViewOnItemClick.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
