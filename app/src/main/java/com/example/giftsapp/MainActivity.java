package com.example.giftsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.giftsapp.adapters.favouriteAdapter;
import com.example.giftsapp.models.favourite;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rv = findViewById(R.id.rv);

        ArrayList<favourite> favourites = new ArrayList<>();
        favourites.add(new favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setHasFixedSize(true);
        favouriteAdapter ff = new favouriteAdapter(this , favourites);

        rv.setAdapter(ff);
    }
}