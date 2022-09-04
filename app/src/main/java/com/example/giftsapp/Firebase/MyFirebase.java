package com.example.giftsapp.Firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.giftsapp.adapters.MallAdapter;
import com.example.giftsapp.models.Mall;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MyFirebase {
    FirebaseFirestore db ;
    Mall m;

   public void addmall(){
       db = FirebaseFirestore.getInstance();

      ArrayList<Mall>mallArrayList=  new Mall().getAllMall();
      for (int i=0;i<mallArrayList.size();i++) {
          db.collection("Mall")
                  .add(mallArrayList.get(i))
                  .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                      @Override
                      public void onSuccess(DocumentReference documentReference) {
                          Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                      }
                  })
                  .addOnFailureListener(new OnFailureListener() {
                      @Override
                      public void onFailure(@NonNull Exception e) {
                          Log.w("TAG", "Error adding document", e);
                      }
                  });
      }
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
                        }

                        return null;
                    }
                });

        return arrayListmalls;
    }
}
