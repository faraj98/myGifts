package com.example.giftsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.giftsapp.adapters.MainCategoryAdapter;
import com.example.giftsapp.adapters.storeDtailAdapter;
import com.example.giftsapp.models.MainCategory;
import com.example.giftsapp.models.storeDtail;

import java.util.ArrayList;

public class storeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);

        RecyclerView rvsd = findViewById(R.id.rvsd);



        ArrayList<storeDtail> storeDtails = new ArrayList<>();
        storeDtails.add(new storeDtail(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        storeDtails.add(new storeDtail(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        storeDtails.add(new storeDtail(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        storeDtails.add(new storeDtail(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        storeDtails.add(new storeDtail(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        storeDtails.add(new storeDtail(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        storeDtails.add(new storeDtail(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        storeDtails.add(new storeDtail(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        storeDtails.add(new storeDtail(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        storeDtails.add(new storeDtail(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        storeDtails.add(new storeDtail(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        storeDtails.add(new storeDtail(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        storeDtails.add(new storeDtail(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));








        // LinearLayoutManager linearLayoutManagerr = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);
        rvsd.setLayoutManager(new GridLayoutManager(this, 3));
        rvsd.setHasFixedSize(true);
        storeDtailAdapter fff = new storeDtailAdapter(this , storeDtails);

        rvsd.setAdapter(fff);
    }
}