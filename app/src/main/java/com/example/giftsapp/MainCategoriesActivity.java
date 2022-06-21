package com.example.giftsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.giftsapp.adapters.MainCategoryAdapter;
import com.example.giftsapp.models.Category;

import java.util.ArrayList;

public class MainCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_categories);

        RecyclerView rvmc = findViewById(R.id.rvmc);



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








        // LinearLayoutManager linearLayoutManagerr = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);
        rvmc.setLayoutManager(new GridLayoutManager(this, 2));
        rvmc.setHasFixedSize(true);
        MainCategoryAdapter fff = new MainCategoryAdapter(this , categories);

        rvmc.setAdapter(fff);
    }
}