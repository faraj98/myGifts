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
import com.example.giftsapp.models.product;
import com.example.giftsapp.models.storeDtail;

import java.util.ArrayList;

public class storeDtailAdapter extends RecyclerView.Adapter<storeDtailAdapter.storeDtailViewHolder> {

    Context context ;
    ArrayList<storeDtail> storeDtails ;

    public storeDtailAdapter(Context context, ArrayList<storeDtail> storeDtails) {
        this.context = context;
        this.storeDtails = storeDtails;
    }

    @NonNull
    @Override
    public storeDtailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.store_detail_item , parent , false);
        return new storeDtailViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull storeDtailViewHolder holder, int position) {

        final storeDtail ss = storeDtails.get(position);




        holder.img.setImageResource(ss.getImg());

        holder.title.setText(ss.getTitle() );
        holder.oldPrice.setText(ss.getTitle() );
        holder.newPrice.setText(ss.getTitle() );




    }

    @Override
    public int getItemCount() {
        return storeDtails.size();
    }

    public class storeDtailViewHolder extends RecyclerView.ViewHolder{
        ImageView img  ;
        TextView title  ,  oldPrice , newPrice ;

        public storeDtailViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.storeDtail_img);
            title  =itemView.findViewById(R.id.storeDtail_title);
            oldPrice  =itemView.findViewById(R.id.storeDtail_oldprice);
            newPrice  =itemView.findViewById(R.id.storeDtail_newprice);

        }
    }
}
