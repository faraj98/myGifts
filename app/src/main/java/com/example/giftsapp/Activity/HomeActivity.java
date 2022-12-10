package com.example.giftsapp.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giftsapp.Firebase.MyFirebase;
import com.example.giftsapp.Interface.RecycleViewOnItemClick;
import com.example.giftsapp.R;
import com.example.giftsapp.Serveis.MapService;
import com.example.giftsapp.adapters.CategoryAdapter;
import com.example.giftsapp.adapters.FavouriteAdapter;
import com.example.giftsapp.adapters.LastOrderAdapter;
import com.example.giftsapp.adapters.MallAdapter;
import com.example.giftsapp.adapters.ProductAdapter;
import com.example.giftsapp.apiManager.ApiManager;
import com.example.giftsapp.models.Category;
import com.example.giftsapp.models.Favourite;
import com.example.giftsapp.models.LastOrder;
import com.example.giftsapp.models.Mall;
import com.example.giftsapp.models.Product;
import com.example.giftsapp.models.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity implements RecycleViewOnItemClick {
    Mall m;
    Category c;
    Product p;
    LastOrder lo;
    Favourite f;
    FirebaseAuth mAuth;
    FirebaseFirestore db;
    FirebaseUser currentUser;
    MallAdapter mallAdapter;
    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        @SuppressLint("WrongViewCast") Toolbar toolbar =  findViewById(R.id.toool);
//        // Sets the Toolbar to act as the ActionBar for this Activity window.
//        // Make sure the toolbar exists in the activity and is not null
//        setSupportActionBar(toolbar);


        if (ActivityCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(HomeActivity.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                                  Manifest.permission.ACCESS_FINE_LOCATION},
                                 0);


        }


        //
        Intent service = new Intent(HomeActivity.this, MapService.class);
        startService(service);
        //
        ApiManager apiManager=new ApiManager(HomeActivity.this);
        String url="https://pastebin.com/raw/Em972E5s";
//        ArrayList<Mall>mallArrayList= apiManager.GetMall(url);
//        for (Mall mall:mallArrayList){
//            Log.d("mmmmm", "onCreate: "+mall.getName()+"\n"+mall.getUri()+"\n"+mall.getImage());
//        }
//        ArrayList<Category>categories= apiManager.GetCategory(UrlCategories);
//        for (Category c:categories){
//            Log.d("TAGonCreate", "onCreate: "+c.getId()+"\n"+c.getTitle());
//        }
        String UrlCategories="http://ibraheammattar-001-site1.itempurl.com/api/Category";
        String s=apiManager.getstring(url);
        Log.d("qqq", "onCreate: "+s);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
// Build a GoogleSignInClient with the options specified by gso.
         mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        mAuth=FirebaseAuth.getInstance();
         currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            String id=currentUser.getUid();
            String name=currentUser.getDisplayName();
            String email=currentUser.getEmail();
            Uri image= currentUser.getPhotoUrl();
            String phoneNumber=currentUser.getPhoneNumber();


            Log.d("User", "onCreate: "+id+"\n"+
                   "\n"+email+"\n"+name+"\n"+image+"" +
                    phoneNumber);

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

        RecyclerView rvcategory = findViewById(R.id.rvss);
        RecyclerView rvlastOrders = findViewById(R.id.rvlast);



        RecyclerView rvmall = findViewById(R.id.rvc);

        LinearLayoutManager linearLayoutManagerr =
                new LinearLayoutManager(HomeActivity.this ,
                                        LinearLayoutManager.HORIZONTAL,
                                        false);

        rvmall.setLayoutManager(linearLayoutManagerr);
        rvmall.setHasFixedSize(true);
         mallAdapter= new MallAdapter(HomeActivity.this ,
                                                    getAllMall(),
                                    HomeActivity.this);
        Log.d("eee", "onCreate: "+getAllMall().size());
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






        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this ,  LinearLayoutManager.HORIZONTAL, false);
        rvcategory.setLayoutManager(linearLayoutManager);
        rvcategory.setHasFixedSize(true);
        CategoryAdapter categoryAdapter = new CategoryAdapter(HomeActivity.this , new Category().getAllGategory(),HomeActivity.this);
        rvcategory.setAdapter(categoryAdapter);



//        getAllCategory();
//        getAllProduct();
//        getAllLastOrder();
//        getAllFavourite();



        LinearLayoutManager linearLayoutManagerrr = new LinearLayoutManager(this ,  LinearLayoutManager.VERTICAL, false);

        rvlastOrders.setLayoutManager(linearLayoutManagerrr);
        rvlastOrders.setHasFixedSize(true);
        LastOrderAdapter ffrr = new LastOrderAdapter(this , new LastOrder().getAllLastOrder());

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
    public void onItemClickc(int position) {
        Category category=new Category();
        Intent intent=new Intent(HomeActivity.this,CategoryDetailsActivity.class);
        intent.putExtra("categoryName",category.getAllGategory().get(position).getTitle() );
        intent.putExtra("categoryImage",category.getAllGategory().get(position).getImg() );

        startActivity(intent);

    }

    @Override
    public void onLongItemClick(int position) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.menusignout) {
              SignOut();
              signOutgoogle();
              startActivity(new Intent(HomeActivity.this,LoginActivity.class));
        }else if (item.getItemId()==R.id.menuprofile){
                if(currentUser != null) {
                    String id = currentUser.getUid();
                    startActivity(new Intent(HomeActivity.this, ProfileActivity.class)
                            .putExtra("id",id));
                }
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));

            }else if(item.getItemId()==R.id.menuMalls){
                startActivity(new Intent(HomeActivity.this,MallActivity.class));
            }else if (item.getItemId()==R.id.menucategory){
                startActivity(new Intent(HomeActivity.this,MainCategoriesActivity.class));
            }else if (item.getItemId()==R.id.menufavourite){
                startActivity(new Intent(HomeActivity.this,FavouriteActivity.class));
            }else if (item.getItemId()==R.id.menuproduct){
                startActivity(new Intent(HomeActivity.this, ProductDetailsActivity.class));
            }else if (item.getItemId()==R.id.menumap){
                startActivity(new Intent(HomeActivity.this,MapsActivity.class));
            }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }


    private void SignOut(){
        FirebaseAuth.getInstance().signOut();
    }


    public ArrayList<Mall> getAllMall(){

        ArrayList<Mall> arrayListmalls=new ArrayList<>();

        db = FirebaseFirestore.getInstance();
        db.collection("Mall")
                .get().onSuccessTask(new SuccessContinuation<QuerySnapshot, Object>() {
                    @NonNull
                    @Override
                    public Task<Object> then(QuerySnapshot queryDocumentSnapshots) throws Exception {

                        List<DocumentSnapshot> documentSnapshotList=queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot documentSnapshot:documentSnapshotList){
                            m=  documentSnapshot.toObject(Mall.class);
                            arrayListmalls.add(m);
                            Log.d("then", "then: "+m.getName()+"////--"+m.getUri());
                        }
                        mallAdapter.notifyDataSetChanged();
                        return null;
                    }
                });

        return arrayListmalls;
    }



    public ArrayList<Category> getAllCategory(){

        ArrayList<Category> categoryArrayList=new ArrayList<>();

        db = FirebaseFirestore.getInstance();
        db.collection("Category")
                .get().onSuccessTask(new SuccessContinuation<QuerySnapshot, Object>() {
                    @NonNull
                    @Override
                    public Task<Object> then(QuerySnapshot queryDocumentSnapshots) throws Exception {

                        List<DocumentSnapshot> documentSnapshotList=queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot documentSnapshot:documentSnapshotList){
                            c=  documentSnapshot.toObject(Category.class);
                            categoryArrayList.add(c);
                        }
                        new CategoryAdapter().notifyDataSetChanged();
                        return null;
                    }
                });

        return categoryArrayList;
    }



    public ArrayList<Product> getAllProduct(){

        ArrayList<Product> productArrayList=new ArrayList<>();

        db = FirebaseFirestore.getInstance();
        db.collection("Product")
                .get().onSuccessTask(new SuccessContinuation<QuerySnapshot, Object>() {
                    @NonNull
                    @Override
                    public Task<Object> then(QuerySnapshot queryDocumentSnapshots) throws Exception {

                        List<DocumentSnapshot> documentSnapshotList=queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot documentSnapshot:documentSnapshotList){
                            p=  documentSnapshot.toObject(Product.class);
                            productArrayList.add(p);
                        }
                       new  ProductAdapter().notifyDataSetChanged();
                        return null;
                    }
                });

        return productArrayList;
    }



    public ArrayList<LastOrder> getAllLastOrder(){

        ArrayList<LastOrder> lastOrderArrayList=new ArrayList<>();

        db = FirebaseFirestore.getInstance();
        db.collection("LastOrder")
                .get().onSuccessTask(new SuccessContinuation<QuerySnapshot, Object>() {
                    @NonNull
                    @Override
                    public Task<Object> then(QuerySnapshot queryDocumentSnapshots) throws Exception {

                        List<DocumentSnapshot> documentSnapshotList=queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot documentSnapshot:documentSnapshotList){
                            lo=  documentSnapshot.toObject(LastOrder.class);
                            lastOrderArrayList.add(lo);
                        }
                        new  LastOrderAdapter().notifyDataSetChanged();
                        return null;
                    }
                });

        return lastOrderArrayList;
    }

    public ArrayList<Favourite> getAllFavourite(){

        ArrayList<Favourite> favouriteArrayList=new ArrayList<>();

        db = FirebaseFirestore.getInstance();
        db.collection("Favourite")
                .get().onSuccessTask(new SuccessContinuation<QuerySnapshot, Object>() {
                    @NonNull
                    @Override
                    public Task<Object> then(QuerySnapshot queryDocumentSnapshots) throws Exception {

                        List<DocumentSnapshot> documentSnapshotList=queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot documentSnapshot:documentSnapshotList){
                            f=  documentSnapshot.toObject(Favourite.class);
                            favouriteArrayList.add(f);
                        }
                        new FavouriteAdapter().notifyDataSetChanged();
                        return null;
                    }
                });

        return favouriteArrayList;
    }

    private void signOutgoogle() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                    }
                });
    }


}