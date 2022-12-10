package com.example.giftsapp.models;

<<<<<<< HEAD
=======
import com.example.giftsapp.R;

import java.util.ArrayList;

>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
public class Product {

    int id ;
    int img ;
    String title ;
    String restrant_name ;
    String oldPrice ;
    String newPrice ;

<<<<<<< HEAD
=======
    public Product() {
    }

>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
    public Product(int id, int img, String title, String restrant_name, String oldPrice, String newPrice) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.restrant_name = restrant_name;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public Product(int img, String title, String oldPrice, String newPrice) {

        this.img = img;
        this.title = title;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public Product(int img, String title, String restrant_name, String oldPrice, String newPrice) {
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
<<<<<<< HEAD
=======

    public ArrayList<Product> getAllProduct(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));
        products.add(new Product(R.drawable.shopp  , "مسخن فلسطيني" , "مطعم مهران" , "السعر القديم : 60ش" , " السعر الجديد : 50ش"));

        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));
        products.add(new Product(R.drawable.submah  , "وجبة أفخاذ دجاج" , "السعر القديم : 30ش" , " السعر الجديد : 25ش"));

        return products;
    }
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
}
