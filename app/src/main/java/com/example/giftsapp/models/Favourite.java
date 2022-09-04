package com.example.giftsapp.models;

import com.example.giftsapp.R;

import java.util.ArrayList;

public class Favourite {

    int id ;
    int img ;
    int iconCart ;
    int heart ;
    String title ;
    String descireption ;
    String prise ;

    public Favourite() {
    }

    public Favourite(int id, int img, int iconCart, int heart, String title, String descireption, String prise) {
        this.id = id;
        this.img = img;
        this.iconCart = iconCart;
        this.heart = heart;
        this.title = title;
        this.descireption = descireption;
        this.prise = prise;
    }

    public Favourite(int img, int iconCart, int heart, String title, String descireption, String prise) {
        this.img = img;
        this.iconCart = iconCart;
        this.heart = heart;
        this.title = title;
        this.descireption = descireption;
        this.prise = prise;
    }

    public Favourite(int img, String title, String descireption, String prise) {
        this.img = img;
        this.title = title;
        this.descireption = descireption;
        this.prise = prise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getIconCart() {
        return iconCart;
    }

    public void setIconCart(int iconCart) {
        this.iconCart = iconCart;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescireption() {
        return descireption;
    }

    public void setDescireption(String descireption) {
        this.descireption = descireption;
    }

    public String getPrise() {
        return prise;
    }

    public void setPrise(String prise) {
        this.prise = prise;
    }

    public ArrayList<Favourite> getAllFavourite(){

        ArrayList<Favourite> favourites = new ArrayList<>();
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        favourites.add(new Favourite(R.drawable.iimg  , "apple" , "applesssd"  , "6$"));
        return  favourites;
    }
}
