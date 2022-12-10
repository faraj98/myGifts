package com.example.giftsapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giftsapp.Interface.RecycleViewOnItemClick;
import com.example.giftsapp.R;
import com.example.giftsapp.adapters.ProductAdapter;
import com.example.giftsapp.models.Product;

import java.util.ArrayList;

public class MallDetailsActivity extends AppCompatActivity implements RecycleViewOnItemClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_details);

       int MallImage=(int) getIntent().getExtras().get("MallImage");
       String MallName=(String) getIntent().getExtras().get("MallName");
        ImageView imageView = findViewById(R.id.imageViewMallDetailsActivity);
        imageView.setImageResource(MallImage);

        RecyclerView rvsd = findViewById(R.id.rvsd);

        // LinearLayoutManager linearLayoutManagerr = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);
        rvsd.setLayoutManager(new GridLayoutManager(this, 3));
        rvsd.setHasFixedSize(true);
        ProductAdapter fff = new ProductAdapter(this , new Product().getAllProduct()
                                                    ,this,MallName);

        rvsd.setAdapter(fff);
    }

    @Override
    public void onItemClick(int position) {
        Product product=new Product();
        Intent intent=new Intent(MallDetailsActivity.this,ProductDetailsActivity.class);
        intent.putExtra("productname", product.getAllProduct().get(position).getTitle());
        intent.putExtra("productImg", product.getAllProduct().get(position).getImg());
        intent.putExtra("NewPrice", product.getAllProduct().get(position).getNewPrice());
        intent.putExtra("OldPrice", product.getAllProduct().get(position).getOldPrice());
        startActivity(intent);

    }

    @Override
    public void onItemClickc(int position) {

    }

    @Override
    public void onLongItemClick(int position) {

    }
}