package com.example.giftsapp.adapters;

import android.content.Context;
import android.location.GnssAntennaInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giftsapp.Interface.RecycleViewOnItemClick;
import com.example.giftsapp.R;
import com.example.giftsapp.models.Mall;

import java.util.ArrayList;
import java.util.function.Function;

public class MallAdapter extends RecyclerView.Adapter<MallAdapter.ShopViewHolder> {

    Context context ;
    ArrayList<Mall> malls ;
   RecycleViewOnItemClick recycleViewOnItemClick;

    public MallAdapter(Context context, ArrayList<Mall> malls) {
        this.context = context;
        this.malls = malls;
    }

    public MallAdapter(Context context, ArrayList<Mall> malls, RecycleViewOnItemClick recycleViewOnItemClick) {
        this.context = context;
        this.malls = malls;
        this.recycleViewOnItemClick = recycleViewOnItemClick;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.mall_item, parent , false);
        return new ShopViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {

        final Mall ss = malls.get(position);




        holder.img.setImageResource(ss.getImage());

        holder.title.setText(ss.getName() );




    }

    @Override
    public int getItemCount() {
        return malls.size();
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder{
        ImageView img  ;
        TextView title ;

        public ShopViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.shop_img);
            title  =itemView.findViewById(R.id.shop_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recycleViewOnItemClick.onItemClick(getAdapterPosition());
                }
            });


        }
    }

}
