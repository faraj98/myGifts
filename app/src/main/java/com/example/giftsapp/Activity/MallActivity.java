package com.example.giftsapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giftsapp.Interface.RecycleViewOnItemClick;
import com.example.giftsapp.R;
import com.example.giftsapp.adapters.StoreAdapter;
import com.example.giftsapp.models.Mall;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MallActivity extends AppCompatActivity implements RecycleViewOnItemClick {
    Mall m;
    StoreAdapter storeAdapter;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);

        db=FirebaseFirestore.getInstance();
        RecyclerView rv = findViewById(R.id.rvstores);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setHasFixedSize(true);
        storeAdapter = new StoreAdapter(this ,getAllMall(), this);

        rv.setAdapter(storeAdapter);


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
    public void onItemClickc(int position) {

    }

    @Override
    public void onLongItemClick(int position) {

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
                        storeAdapter.notifyDataSetChanged();
                        return null;
                    }
                });

        return arrayListmalls;
    }

}