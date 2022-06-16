package com.example.giftsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giftsapp.R;
import com.example.giftsapp.models.favourite;
import com.example.giftsapp.models.store;

import java.util.ArrayList;

public class storeAdapter extends RecyclerView.Adapter<storeAdapter.StoreViewHolder> {

    Context context ;
    ArrayList<store> stores ;

    public storeAdapter(Context context, ArrayList<store> stores) {
        this.context = context;
        this.stores = stores;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.stores_item , parent , false);
        return new StoreViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {

        final store ss = stores.get(position);




        holder.img.setImageResource(ss.getImg());

        holder.title.setText(ss.getTitle() );




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

        }
    }
}
