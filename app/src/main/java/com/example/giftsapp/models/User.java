package com.example.giftsapp.models;

import android.net.Uri;

public class User {
    String id;
    String name;
    String email;
    Uri image;
    String PhoneNumber;

    public User(String id, String name, String email, Uri image, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.image = image;
        PhoneNumber = phoneNumber;
    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
