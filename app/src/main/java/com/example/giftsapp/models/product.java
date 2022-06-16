package com.example.giftsapp.models;

public class product {

    int id ;
    int img ;
    String title ;
    String restrant_name ;
    String oldPrice ;
    String newPrice ;

    public product(int id, int img, String title, String restrant_name, String oldPrice, String newPrice) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.restrant_name = restrant_name;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public product( int img, String title, String restrant_name, String oldPrice, String newPrice) {
        this.img = img;
        this.title = title;
        this.restrant_name = restrant_name;
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

    public String getRestrant_name() {
        return restrant_name;
    }

    public void setRestrant_name(String restrant_name) {
        this.restrant_name = restrant_name;
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
