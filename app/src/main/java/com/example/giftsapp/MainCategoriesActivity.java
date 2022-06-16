package com.example.giftsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.giftsapp.adapters.MainCategoryAdapter;
import com.example.giftsapp.adapters.productAdapter;
import com.example.giftsapp.models.MainCategory;
import com.example.giftsapp.models.product;

import java.util.ArrayList;

public class MainCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_categories);

        RecyclerView rvmc = findViewById(R.id.rvmc);



        ArrayList<MainCategory> mainCategories = new ArrayList<>();
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));
        mainCategories.add(new MainCategory(R.drawable.shopp  , "أدوات منزلية" ));







        // LinearLayoutManager linearLayoutManagerr = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);
        rvmc.setLayoutManager(new GridLayoutManager(this, 2));
        rvmc.setHasFixedSize(true);
        MainCategoryAdapter fff = new MainCategoryAdapter(this , mainCategories);

        rvmc.setAdapter(fff);
    }
}