package com.example.giftsapp.models;

import com.example.giftsapp.R;

import java.util.ArrayList;

public class Mall {

    String name;
    int Image;
    String uri;
    double lat;
    double lng;

    public Mall() {

    }

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
    public Mall(int image, String name,double lat,double lng) {
        this.Image=image;
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
}
