package com.example.giftsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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


        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));






       // LinearLayoutManager linearLayoutManagerr = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);
        rvp.setLayoutManager(new GridLayoutManager(this, 3));
        rvp.setHasFixedSize(true);
        ProductAdapter fff = new ProductAdapter(this , products,"مطعم مهران");

        rvp.setAdapter(fff);
    }
}