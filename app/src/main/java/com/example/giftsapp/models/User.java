package com.example.giftsapp.models;

import android.net.Uri;
<<<<<<< HEAD
=======
import android.text.Editable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde

public class User {
    String id;
    String name;
    String email;
<<<<<<< HEAD
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
=======

    String PhoneNumber;

    public User() {
    }

    public User(String id, String name, String email, String phoneNumber) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.PhoneNumber = phoneNumber;

    }

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.PhoneNumber = phoneNumber;
    }

    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }

    private boolean mIsValid = false;

    public boolean isValid() {
        return mIsValid;
    }

    public static boolean isValidEmail(CharSequence email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidPassword(CharSequence pass) {
        return pass != null && pass.length()>=8;
    }


    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }


    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }


    public void afterTextChanged(Editable editableText) {
        mIsValid=isValidEmail(editableText);
        mIsValid=isValidPassword(editableText);
    }
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
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

<<<<<<< HEAD
    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }
=======

>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
<<<<<<< HEAD
=======


>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
}
