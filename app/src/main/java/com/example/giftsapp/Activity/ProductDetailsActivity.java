package com.example.giftsapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.giftsapp.Interface.RecycleViewOnItemClick;
import com.example.giftsapp.R;

public class ProductDetailsActivity extends AppCompatActivity {
    TextView textViewnameProductDetailsActivity;
    TextView textViewnpriceProductDetailsActivity;
    TextView textViewopriceProductDetailsActivity;
    ImageView imageViewProductDetailsActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent intent=getIntent();
        textViewnameProductDetailsActivity=findViewById(R.id.textViewnameProductDetailsActivity);
        textViewnpriceProductDetailsActivity=findViewById(R.id.textViewnpriceProductDetailsActivity);
        textViewopriceProductDetailsActivity=findViewById(R.id.textViewopriceProductDetailsActivity);
        imageViewProductDetailsActivity=findViewById(R.id.imageViewProductDetailsActivity);
        String name=intent.getStringExtra("productname");
        int img=intent.getIntExtra("productImg",0);
        String nprice=intent.getStringExtra("NewPrice");
        String oprice=intent.getStringExtra("OldPrice");

        Log.d("ProductDetailsActivity", "onCreate: "+name+"\n"+
                img+"\n"+nprice+"\n"+oprice);
        imageViewProductDetailsActivity.setImageResource(img);
        textViewnameProductDetailsActivity.setText(name);
        textViewnpriceProductDetailsActivity.setText(nprice);
        textViewopriceProductDetailsActivity.setText(oprice);

    }


}