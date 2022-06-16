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
import com.example.giftsapp.models.store;

import java.util.ArrayList;

public class productAdapter extends RecyclerView.Adapter<productAdapter.ProductViewHolder> {

    Context context ;
    ArrayList<product> products ;

    public productAdapter(Context context, ArrayList<product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.product_item , parent , false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        final product ss = products.get(position);




        holder.img.setImageResource(ss.getImg());

        holder.title.setText(ss.getTitle() );
        holder.resturant_name.setText(ss.getTitle() );
        holder.oldPrice.setText(ss.getTitle() );
        holder.newPrice.setText(ss.getTitle() );




    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView img  ;
        TextView title  , resturant_name , oldPrice , newPrice ;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.store_img);
            title  =itemView.findViewById(R.id.store_title);
            resturant_name  =itemView.findViewById(R.id.store_resturant);
            oldPrice  =itemView.findViewById(R.id.store_oldprice);
            newPrice  =itemView.findViewById(R.id.store_newprice);

        }
    }
}
