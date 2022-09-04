package com.example.giftsapp.models;

import com.example.giftsapp.R;

import java.util.ArrayList;

public class LastOrder {

    int id ;
    int img ;
    String title ;

    public LastOrder() {
    }


    public LastOrder(int img, String title) {
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

    public ArrayList<LastOrder> getAllLastOrder(){
        ArrayList<LastOrder> lastOrders = new ArrayList<>();
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        lastOrders.add(new LastOrder(R.drawable.gfg  , "جبنة دنماركية بسعر ₪3.5"));
        return lastOrders;
    }
}
