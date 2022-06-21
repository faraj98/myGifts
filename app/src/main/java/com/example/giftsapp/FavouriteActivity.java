package com.example.giftsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.giftsapp.adapters.FavouriteAdapter;
import com.example.giftsapp.models.Favourite;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rv = findViewById(R.id.rv);

        ArrayList<Favourite> favourites = new ArrayList<>();
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setHasFixedSize(true);
        FavouriteAdapter ff = new FavouriteAdapter(this , favourites);

        rv.setAdapter(ff);
    }
}