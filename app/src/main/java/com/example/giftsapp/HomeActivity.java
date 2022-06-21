package com.example.giftsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.giftsapp.Interface.RecycleViewOnItemClick;
import com.example.giftsapp.Serveis.MapService;
import com.example.giftsapp.adapters.CategoryAdapter;
import com.example.giftsapp.adapters.MallAdapter;
import com.example.giftsapp.adapters.LastOrderAdapter;
import com.example.giftsapp.models.Category;
import com.example.giftsapp.models.LastOrder;
import com.example.giftsapp.models.Mall;
import com.example.giftsapp.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;



public class HomeActivity extends AppCompatActivity implements RecycleViewOnItemClick {
    Mall m;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       // @SuppressLint("WrongViewCast") Toolbar toolbar =  findViewById(R.id.toool);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
       // setSupportActionBar(toolbar);


        Intent service = new Intent(HomeActivity.this, MapService.class);
        startService(service);
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            String id=currentUser.getUid();
            String name=currentUser.getDisplayName();
            String email=currentUser.getEmail();
            Uri image= currentUser.getPhotoUrl();
            String PhoneNumber=currentUser.getPhoneNumber();

            User user=new User(id,name,email,image,PhoneNumber);

            Log.d("User", "onCreate: "+user.getId()+"\n"+
                    user.getName()+"\n"+user.getEmail()+"\n"+user.getImage()+"\n"+user.getPhoneNumber());

        }
        ImageView moregategories=findViewById(R.id.moregategories);

        ImageView morestores=findViewById(R.id.morestores);

        moregategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainCategoriesActivity.class));
            }
        });
        morestores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MallActivity.class));

            }
        });

        RecyclerView rvmall = findViewById(R.id.rvc);
        RecyclerView rvcategory = findViewById(R.id.rvss);
        RecyclerView rvlastOrders = findViewById(R.id.rvlast);



        m=new Mall();


        LinearLayoutManager linearLayoutManagerr = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);

        rvmall.setLayoutManager(linearLayoutManagerr);
        rvmall.setHasFixedSize(true);
        MallAdapter mallAdapter = new MallAdapter(this , m.getAllMall(),this);
        rvmall.setAdapter(mallAdapter);
/*
1-الأغذية الطازجة .
2-البقول الجافة و المجمدات .
3-المخبوزات و الحلويات .
4-المشروبات و المعلبات .
5-الأطعمة الجاهزة .
6-الجزارة و الأسماك .
7-الألبان و منتجاتها .
8-الخضروات و الفاكهة .
9-الأجهزة المنزلية .
10-مستلزمات السيارات و المركبات .
11-الأدوات الكهربائية .
12-العدد و الآلات و المهمات .
13-الكمبيوتر و التكنولوجيا و الهواتف .
14-الوسائط المتعددة .
15-الملابس و المنسوجات .
16-الأثاث المنزلي و المكتبي .
17-الستائر و المفروشات .
18-الأحذية و المنتجات الجلدية .
19-لعب الأطفال .
20-مستحضرات التجميل .
21-أدوات و مهمات النظافة و الغسيل .
22-أقسام أخري
*/


        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(R.drawable.shose  , "الأغذية الطازجة"));
        categories.add(new Category(R.drawable.shose  , "البقول الجافة و المجمدات"));
        categories.add(new Category(R.drawable.shose  , "المخبوزات و الحلويات"));
        categories.add(new Category(R.drawable.shose  , "المشروبات و المعلبات"));
        categories.add(new Category(R.drawable.shose  , "الأطعمة الجاهزة"));
        categories.add(new Category(R.drawable.shose  , "الجزارة و الأسماك"));
        categories.add(new Category(R.drawable.shose  , "الألبان و منتجاتها"));
        categories.add(new Category(R.drawable.shose  , "الخضروات و الفاكهة"));
        categories.add(new Category(R.drawable.shose  , "الأجهزة المنزلية"));
        categories.add(new Category(R.drawable.shose  , "مستلزمات السيارات و المركبات"));
        categories.add(new Category(R.drawable.shose  , "الأدوات الكهربائية"));
        categories.add(new Category(R.drawable.shose  , "العدد و الآلات و المهمات"));
        categories.add(new Category(R.drawable.shose  , "الكمبيوتر و التكنولوجيا و الهواتف"));
        categories.add(new Category(R.drawable.shose  , "الوسائط المتعددة"));
        categories.add(new Category(R.drawable.shose  , "الملابس و المنسوجات"));
        categories.add(new Category(R.drawable.shose  , "الأثاث المنزلي و المكتبي"));
        categories.add(new Category(R.drawable.shose  , "الستائر و المفروشات"));
        categories.add(new Category(R.drawable.shose  , "الأحذية و المنتجات الجلدية"));
        categories.add(new Category(R.drawable.shose  , "لعب الأطفال"));
        categories.add(new Category(R.drawable.shose  , "مستحضرات التجميل"));
        categories.add(new Category(R.drawable.shose  , "أدوات و مهمات النظافة و الغسيل"));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);
        rvcategory.setLayoutManager(linearLayoutManager);
        rvcategory.setHasFixedSize(true);
        CategoryAdapter ff = new CategoryAdapter(this , categories);
        rvcategory.setAdapter(ff);


        ArrayList<LastOrder> lastOrders = new ArrayList<>();
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));






        LinearLayoutManager linearLayoutManagerrr = new LinearLayoutManager(this ,  LinearLayoutManager.VERTICAL, false);

        rvlastOrders.setLayoutManager(linearLayoutManagerrr);
        rvlastOrders.setHasFixedSize(true);
        LastOrderAdapter ffrr = new LastOrderAdapter(this , lastOrders);

        rvlastOrders.setAdapter(ffrr);
    }
    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(HomeActivity.this,MallDetailsActivity.class);
        intent.putExtra("MallName", m.getAllMall().get(position).getName()+"");
        intent.putExtra("MallImage", m.getAllMall().get(position).getImage());
        startActivity(intent);
        Toast.makeText(this, "name"+m.getAllMall().get(position).getName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLongItemClick(int position) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}