package com.example.giftsapp.models;

public class storeDtail {

    int id ;
    int img ;
    String title ;
    String oldPrice ;
    String newPrice ;

    public storeDtail(int id, int img, String title,  String oldPrice, String newPrice) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public storeDtail(int img, String title,  String oldPrice, String newPrice) {
        this.img = img;
        this.title = title;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
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



    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }
}
