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
import com.example.giftsapp.models.store;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context ;
    ArrayList<category> categories ;

    public CategoryAdapter(Context context, ArrayList<category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.category_item , parent , false);
        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        final category ss = categories.get(position);




        holder.img.setImageResource(ss.getImg());

        holder.title.setText(ss.getTitle() );




    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        ImageView img  ;
        TextView title ;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.category_img);
            title  =itemView.findViewById(R.id.category_title);

        }
    }
}
