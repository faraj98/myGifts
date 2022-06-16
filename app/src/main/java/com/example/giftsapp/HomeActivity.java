package com.example.giftsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.giftsapp.adapters.CategoryAdapter;
import com.example.giftsapp.adapters.ShopAdapter;
import com.example.giftsapp.adapters.lastOrderAdapter;
import com.example.giftsapp.adapters.storeAdapter;
import com.example.giftsapp.models.category;
import com.example.giftsapp.models.lastOrder;
import com.example.giftsapp.models.shop;
import com.example.giftsapp.models.store;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        @SuppressLint("WrongViewCast") Toolbar toolbar =  findViewById(R.id.toool);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        RecyclerView rvc = findViewById(R.id.rvc);
        RecyclerView rvss = findViewById(R.id.rvss);
        RecyclerView rvl = findViewById(R.id.rvlast);

        ArrayList<category> categories = new ArrayList<>();
        categories.add(new category(R.drawable.shose  , "أحذية"));
        categories.add(new category(R.drawable.shose  , "طاعم"));
        categories.add(new category(R.drawable.shose  , "أحذية"));
        categories.add(new category(R.drawable.shose  , "أحذية"));
        categories.add(new category(R.drawable.shose  , "أحذية"));
        categories.add(new category(R.drawable.shose  , "أحذية"));
        categories.add(new category(R.drawable.shose  , "أحذية"));
        categories.add(new category(R.drawable.shose  , "أحذية"));





        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);
        rvc.setLayoutManager(linearLayoutManager);
        rvc.setHasFixedSize(true);
        CategoryAdapter ff = new CategoryAdapter(this , categories);

        rvc.setAdapter(ff);


        ArrayList<shop> shops = new ArrayList<>();
        shops.add(new shop(R.drawable.fox  , "فوكس شوز"));
        shops.add(new shop(R.drawable.fox  , "فوكس شوز"));
        shops.add(new shop(R.drawable.fox  , "فوكس شوز"));
        shops.add(new shop(R.drawable.fox  , "فوكس شوز"));
        shops.add(new shop(R.drawable.fox  , "فوكس شوز"));
        shops.add(new shop(R.drawable.fox  , "فوكس شوز"));
        shops.add(new shop(R.drawable.fox  , "فوكس شوز"));
        shops.add(new shop(R.drawable.fox  , "فوكس شوز"));
        shops.add(new shop(R.drawable.fox  , "فوكس شوز"));





        LinearLayoutManager linearLayoutManagerr = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);

        rvss.setLayoutManager(linearLayoutManagerr);
        rvss.setHasFixedSize(true);
        ShopAdapter ffr = new ShopAdapter(this , shops);

        rvss.setAdapter(ffr);


        ArrayList<lastOrder> lastOrders = new ArrayList<>();
        lastOrders.add(new lastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new lastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new lastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new lastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new lastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new lastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new lastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new lastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new lastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new lastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));






        LinearLayoutManager linearLayoutManagerrr = new LinearLayoutManager(this ,  LinearLayoutManager.VERTICAL, false);

        rvl.setLayoutManager(linearLayoutManagerrr);
        rvl.setHasFixedSize(true);
        lastOrderAdapter ffrr = new lastOrderAdapter(this , lastOrders);

        rvl.setAdapter(ffrr);
    }
}