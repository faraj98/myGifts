package com.example.giftsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.giftsapp.Interface.RecycleViewOnItemClick;
import com.example.giftsapp.adapters.MallAdapter;
import com.example.giftsapp.adapters.StoreAdapter;
import com.example.giftsapp.models.Mall;

import java.util.ArrayList;

public class MallActivity extends AppCompatActivity implements RecycleViewOnItemClick {
    Mall m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);

        RecyclerView rv = findViewById(R.id.rvstores);
         m=new Mall();
        ArrayList<Mall>mallArrayList=m.getAllMall();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setHasFixedSize(true);
        StoreAdapter ffr = new StoreAdapter(this ,mallArrayList, this);

        rv.setAdapter(ffr);


    }



    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(MallActivity.this,MallDetailsActivity.class);
        intent.putExtra("MallName", m.getAllMall().get(position).getName()+"");
        intent.putExtra("MallImage", m.getAllMall().get(position).getImage());
        startActivity(intent);
        Toast.makeText(this, "name"+m.getAllMall().get(position).getName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLongItemClick(int position) {

    }
}