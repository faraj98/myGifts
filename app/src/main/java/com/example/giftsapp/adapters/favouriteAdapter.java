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

import java.util.ArrayList;

public class favouriteAdapter extends RecyclerView.Adapter<favouriteAdapter.favouriteViewHolder> {

    Context context ;
    ArrayList<favourite> favourite ;

    public favouriteAdapter(Context context, ArrayList<favourite> favourite) {
        this.context = context;
        this.favourite = favourite;
    }

    @NonNull
    @Override
    public favouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_full_details , parent , false);
        return new favouriteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull favouriteViewHolder holder, int position) {

        final favourite ss = favourite.get(position);




        holder.img.setImageResource(ss.getImg());

        holder.title.setText(ss.getTitle() );
        holder.decription.setText(ss.getDescireption());
        holder.price.setText(ss.getPrise());
        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "cart pressed", Toast.LENGTH_SHORT).show();
            }
        });

        holder.heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "heart pressed", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return favourite.size();
    }

    public class favouriteViewHolder extends RecyclerView.ViewHolder{
        ImageView img , cart , heart ;
        TextView title , decription , price ;

        public favouriteViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            cart = itemView.findViewById(R.id.cart);
            heart = itemView.findViewById(R.id.heart);
            decription = itemView.findViewById(R.id.subtitle);
            title  =itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }
    }
}
