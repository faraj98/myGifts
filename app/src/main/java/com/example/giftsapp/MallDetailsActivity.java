package com.example.giftsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.giftsapp.adapters.ProductAdapter;
import com.example.giftsapp.models.Product;

import java.util.ArrayList;

public class MallDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_details);

       int MallImage=(int) getIntent().getExtras().get("MallImage");
       String MallName=(String) getIntent().getExtras().get("MallName");
        ImageView imageView = findViewById(R.id.imageViewMallDetailsActivity);

            imageView.setImageResource(MallImage);

        RecyclerView rvsd = findViewById(R.id.rvsd);



        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));








        // LinearLayoutManager linearLayoutManagerr = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);
        rvsd.setLayoutManager(new GridLayoutManager(this, 3));
        rvsd.setHasFixedSize(true);
        ProductAdapter fff = new ProductAdapter(this , products,MallName);

        rvsd.setAdapter(fff);
    }
}