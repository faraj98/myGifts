package com.example.giftsapp.models;

public class Category {

    String id ;
    int img ;
    String urlImage;
    String title ;

    public Category(String id, int img, String title) {
        this.id = id;
        this.img = img;
        this.title = title;
    }

    public Category(String id, String urlImage, String title) {
        this.id = id;
        this.urlImage = urlImage;
        this.title = title;
    }

    public Category(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
