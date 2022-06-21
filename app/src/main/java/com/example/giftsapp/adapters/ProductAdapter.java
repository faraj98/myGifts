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
import com.example.giftsapp.models.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context ;
    ArrayList<Product> products ;
    RecycleViewOnItemClick recycleViewOnItemClick;
    String mallName;

    public ProductAdapter(Context context, ArrayList<Product> products, String mallName) {
        this.context = context;
        this.products = products;
        this.mallName=mallName;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.product_item , parent , false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        final Product ss = products.get(position);




        holder.img.setImageResource(ss.getImg());

        holder.title.setText(ss.getTitle() );
        holder.p_resturant.setText(mallName);
        holder.oldPrice.setText(ss.getOldPrice() );
        holder.newPrice.setText(ss.getNewPrice());




    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView img  ;
        TextView title  , p_resturant,oldPrice , newPrice ;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.p_img);
            title  =itemView.findViewById(R.id.p_title);
            p_resturant=itemView.findViewById(R.id.p_resturant);
            oldPrice  =itemView.findViewById(R.id.p_oldprice);
            newPrice  =itemView.findViewById(R.id.p_newprice);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recycleViewOnItemClick.onItemClick(getAdapterPosition());
                }
            });

        }
    }
}
