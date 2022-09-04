package com.example.giftsapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giftsapp.R;
import com.example.giftsapp.adapters.FavouriteAdapter;
import com.example.giftsapp.models.Favourite;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rv = findViewById(R.id.rv);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setHasFixedSize(true);
        FavouriteAdapter ff = new FavouriteAdapter(this , new Favourite().getAllFavourite());

        rv.setAdapter(ff);
    }
}