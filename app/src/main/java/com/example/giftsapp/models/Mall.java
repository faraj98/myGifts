package com.example.giftsapp.models;

<<<<<<< HEAD
import com.example.giftsapp.R;

import java.util.ArrayList;
=======
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.giftsapp.R;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde

public class Mall {

    String name;
    int Image;
<<<<<<< HEAD
    String uri;
    double lat;
    double lng;
=======
    String urlImage;
    String uri;
    double lat;
    double lng;
    FirebaseFirestore db;
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde

    public Mall() {

    }

<<<<<<< HEAD
=======
    public Mall(String name, String urlImage, String uri, double lat, double lng) {
        this.name = name;
        this.urlImage = urlImage;
        this.uri = uri;
        this.lat = lat;
        this.lng = lng;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Mall(String name, int image, String uri) {
        this.name=name;
        this.Image=image;
        this.uri=uri;
    }
    public Mall(int image, String name) {
        this.Image=image;
        this.name=name;

    }
<<<<<<< HEAD
    public Mall(int image, String name,double lat,double lng) {
        this.Image=image;
=======
    public Mall(int image, String uri,String name,double lat,double lng) {
        this.Image=image;
        this.uri=uri;
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
        this.name=name;
        this.lat=lat;
        this.lng=lng;

    }
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
<<<<<<< HEAD
    public ArrayList<Mall> getAllMall(){
        ArrayList<Mall> mallArrayList = new ArrayList<>();
        mallArrayList.add(new Mall(R.drawable.metro  , "مترو مول",31.517801936795212, 34.44436970673966));
        mallArrayList.add(new Mall(R.drawable.abodlal  , "أبو دلال مول",31.448338406400303, 34.392056924182306));
        mallArrayList.add(new Mall(R.drawable.haiper  , "هايبر مول",31.44998012196165, 34.39290758647573));
        mallArrayList.add(new Mall(R.drawable.capital  , "كابيتال مول",31.515989645020195, 34.44937513299946));
        mallArrayList.add(new Mall(R.drawable.city  , "ستي سنتر",31.518900265358486, 34.44028107269639));
        mallArrayList.add(new Mall(R.drawable.alandalusia  , "الأندلسية مول",31.521072983541895, 34.43961304986022));
        mallArrayList.add(new Mall(R.drawable.alarap  , "مول العرب",31.271840156914717, 34.257259736817936));
        mallArrayList.add(new Mall(R.drawable.alrehab  , "الرحاب مول",30.05711624834082, 31.491569903260025));
        mallArrayList.add(new Mall(R.drawable.care4  , "كيرفور مول",31.51173803439373, 34.429309091567234));
        mallArrayList.add(new Mall(R.drawable.tag  , "تاج مول",31.516830085483598, 34.45001418750293));
        mallArrayList.add(new Mall(R.drawable.meet  , "مدينة اللحوم",31.521990961349935, 34.44507682953942));
        return mallArrayList;
    }
=======
    public ArrayList<Mall> getAllMall(){//lat/lng/name/uri/urlImage
        ArrayList<Mall> mallArrayList = new ArrayList<>();
        mallArrayList.add(new Mall(R.drawable.city ,"https://www.facebook.com/MallCity2021/" , "ستي مول",31.518900265358486, 34.44028107269639));
        mallArrayList.add(new Mall(R.drawable.haiper,"https://ar-ar.facebook.com/HyperMall.Danaf/"  , "هايبر مول",31.44998012196165, 34.39290758647573));
        mallArrayList.add(new Mall(R.drawable.alandalusia,"https://ar-ar.facebook.com/andmall/" , "الأندلسية مول",31.521072983541895, 34.43961304986022));
        mallArrayList.add(new Mall(R.drawable.capital,"https://ar-ar.facebook.com/CapitalMallGaza/"  , "كابيتال مول",31.515989645020195, 34.44937513299946));
        mallArrayList.add(new Mall(R.drawable.metro ,"https://ar-ar.facebook.com/metromarket.gaza/" ,"مترو مول",31.517801936795212, 34.44436970673966));
        mallArrayList.add(new Mall(R.drawable.tag ,"https://ar-ar.facebook.com/tajmallpal/" , "تاج مول",31.516830085483598, 34.45001418750293));
        mallArrayList.add(new Mall(R.drawable.meet ,"https://ar-ar.facebook.com/MeatCity.Danaf/" , "مدينة اللحوم",31.521990961349935, 34.44507682953942));
        mallArrayList.add(new Mall(R.drawable.alrehab,"https://www.facebook.com/%D9%85%D9%88%D9%84-%D8%A7%D9%84%D8%B1%D8%AD%D8%A7%D8%A8-Al-Rehab-Mall-258309267986177/"  , "الرحاب مول",30.05711624834082, 31.491569903260025));
        mallArrayList.add(new Mall(R.drawable.care4 ,"https://ar-ar.facebook.com/careforGaza/" , "كيرفور مول",31.51173803439373, 34.429309091567234));
        mallArrayList.add(new Mall(R.drawable.alarap,"https://www.facebook.com/ArabMallGaza/"  , "مول العرب",31.271840156914717, 34.257259736817936));
        mallArrayList.add(new Mall(R.drawable.abodlal,"https://www.facebook.com/AbuDalalMall/"  , "أبو دلال مول",31.448338406400303, 34.392056924182306));
        return mallArrayList;
    }
    public ArrayList<Mall> getallmallfirebase(){
        ArrayList<Mall> arrayListmalls=new ArrayList<>();

        db = FirebaseFirestore.getInstance();
        db.collection("Mall")
                .get().onSuccessTask(new SuccessContinuation<QuerySnapshot, Object>() {
                    @NonNull
                    @Override
                    public Task<Object> then(QuerySnapshot queryDocumentSnapshots) throws Exception {
                        List<DocumentSnapshot> documentSnapshotList=queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot documentSnapshot:documentSnapshotList){
                           Mall m=  documentSnapshot.toObject(Mall.class);
                            arrayListmalls.add(m);
                            Log.d("then", "then: "+m.getName()+"////--"+m.getUri());
                        }
                   notify();
                        return null;
                    }
                });

        return arrayListmalls;
    }
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
}
