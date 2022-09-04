package com.example.giftsapp.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giftsapp.Interface.RecycleViewOnItemClick;
import com.example.giftsapp.R;
import com.example.giftsapp.adapters.MainCategoryAdapter;
import com.example.giftsapp.models.Category;
import com.example.giftsapp.models.Product;

import java.util.ArrayList;


public class MainCategoriesActivity extends AppCompatActivity implements RecycleViewOnItemClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_categories);

        RecyclerView rvmc = findViewById(R.id.rvmc);

        // LinearLayoutManager linearLayoutManagerr = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);
        rvmc.setLayoutManager(new GridLayoutManager(this, 2));
        rvmc.setHasFixedSize(true);
        MainCategoryAdapter fff = new MainCategoryAdapter(this , new Category().getAllGategory(),this);

        rvmc.setAdapter(fff);
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemClickc(int position) {
        Category category=new Category();
        Intent intent=new Intent(MainCategoriesActivity.this,CategoryDetailsActivity.class);
        intent.putExtra("categoryName",category.getAllGategory().get(position).getTitle() );
        intent.putExtra("categoryImage",category.getAllGategory().get(position).getImg() );

        startActivity(intent);
    }

    @Override
    public void onLongItemClick(int position) {

    }
}