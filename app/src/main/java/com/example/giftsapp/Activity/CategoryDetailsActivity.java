package com.example.giftsapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giftsapp.R;
import com.example.giftsapp.adapters.ProductAdapter;
import com.example.giftsapp.models.Product;

import java.util.ArrayList;

public class CategoryDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);

      //  RecyclerView rv = findViewById(R.id.rv_store);
        RecyclerView rvp = findViewById(R.id.rv_product);

//        ArrayList<store> stores = new ArrayList<>();
//        stores.add(new store(R.drawable.iimg  , "مطعم مهران"));
//        stores.add(new store(R.drawable.iimg  , "مطعم مهران"));
//        stores.add(new store(R.drawable.iimg  , "مطعم مهران"));
//        stores.add(new store(R.drawable.iimg  , "مطعم مهران"));
//        stores.add(new store(R.drawable.iimg  , "مطعم مهران"));
//        stores.add(new store(R.drawable.iimg  , "مطعم مهران"));
//        stores.add(new store(R.drawable.iimg  , "مطعم مهران"));
//
//
//
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);
//        rv.setLayoutManager(linearLayoutManager);
//        rv.setHasFixedSize(true);
//        storeAdapter ff = new storeAdapter(this , stores);
//
//        rv.setAdapter(ff);

        /////////////////////////////////








       // LinearLayoutManager linearLayoutManagerr = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);
        rvp.setLayoutManager(new GridLayoutManager(this, 3));
        rvp.setHasFixedSize(true);
        ProductAdapter fff = new ProductAdapter(this , new Product().getAllProduct(),getIntent().getStringExtra("categoryName"));

        rvp.setAdapter(fff);
    }
}