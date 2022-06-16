package com.example.giftsapp.models;

public class category {

    int id ;
    int img ;
    String title ;

    public category(int id, int img, String title) {
        this.id = id;
        this.img = img;
        this.title = title;
    }

    public category(int img, String title) {
        this.img = img;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
