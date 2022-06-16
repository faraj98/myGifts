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
import com.example.giftsapp.models.MainCategory;
import com.example.giftsapp.models.category;

import java.util.ArrayList;

public class MainCategoryAdapter extends RecyclerView.Adapter<MainCategoryAdapter.MainCategoryViewHolder> {

    Context context ;
    ArrayList<MainCategory> mainCategories ;

    public MainCategoryAdapter(Context context, ArrayList<MainCategory> mainCategories) {
        this.context = context;
        this.mainCategories = mainCategories;
    }

    @NonNull
    @Override
    public MainCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.main_category_item , parent , false);
        return new MainCategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainCategoryViewHolder holder, int position) {

        final MainCategory ss = mainCategories.get(position);




        holder.img.setImageResource(ss.getImg());

        holder.title.setText(ss.getTitle() );




    }

    @Override
    public int getItemCount() {
        return mainCategories.size();
    }

    public class MainCategoryViewHolder extends RecyclerView.ViewHolder{
        ImageView img  ;
        TextView title ;

        public MainCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.Main_category_img);
            title  =itemView.findViewById(R.id.Main_category_title);

        }
    }
}
