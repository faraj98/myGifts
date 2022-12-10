package com.example.giftsapp.apiManager;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
<<<<<<< HEAD
import com.android.volley.toolbox.Volley;
import com.example.giftsapp.models.Category;
import com.google.android.material.snackbar.Snackbar;
=======
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.giftsapp.models.Category;
import com.example.giftsapp.models.Mall;
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiManager {
    Context context;
<<<<<<< HEAD
    String url="https://pastebin.com/raw/Em972E5s";
    // Initialize a new RequestQueue instance
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    public boolean GetMall() {
        final boolean[] issuccess = {true};
=======
   static String urlMall="https://pastebin.com/raw/Em972E5s";


    public ApiManager(Context context) {
        this.context = context;
    }

    // Initialize a new RequestQueue instance
    RequestQueue requestQueue ;
    public ArrayList<Mall> GetMall(String url) {
       ArrayList<Mall> mallArrayList=new ArrayList<>();
        // Initialize a new RequestQueue instance
        requestQueue = Volley.newRequestQueue(context);
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
        // Initialize a new JsonArrayRequest instance
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
<<<<<<< HEAD
                        // Do something with response
                        //mTextView.setText(response.toString());

                        // Process the JSON
=======
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
                        try {
                            // Loop through the array elements
                            for (int i = 0; i < response.length(); i++) {
                                // Get current json object
<<<<<<< HEAD
                                JSONObject student = response.getJSONObject(i);

                                // Get the current "student" (json object) data
                                String firstName = student.getString("firstname");
                                String lastName = student.getString("lastname");
                                String age = student.getString("age");
                                Log.d("onResponse: ", "onResponse: "+firstName+"\n"+lastName+"\n"+age);
                                // Display the formatted json data in text view
=======
                                JSONObject mall = response.getJSONObject(i);
                                // Get the current "student" (json object) data
                                String Name = mall.getString("name");
                                String UrlImage = mall.getString("UrlImage");
                                String StoreUrl = mall.getString("uri");
                                double lat=mall.getDouble("lat");
                                double lng=mall.getDouble("lmg");
                              Mall mall1=new Mall();
                                mall1.setName(Name);
                                mall1.setUrlImage(UrlImage);
                                mall1.setUri(StoreUrl);
                                mall1.setLat(lat);
                                mall1.setLng(lng);
                        mallArrayList.add(mall1);
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
<<<<<<< HEAD
                            issuccess[0] =false;
=======

>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        Toast.makeText(context, "error" + error.getMessage(), Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
                       issuccess[0] =false;
=======

>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
                    }

                }

        );
        // Add JsonArrayRequest to the RequestQueue
        requestQueue.add(jsonArrayRequest);
<<<<<<< HEAD
        return issuccess[0];
    }
    public ArrayList<Category> GetCategory() {
        ArrayList<Category>categories=new ArrayList<>();
        final boolean[] issuccess = {true};
=======
        return mallArrayList;
    }



    public ArrayList<Category> GetCategory(String url) {
        ArrayList<Category>categories=new ArrayList<>();
        final boolean[] issuccess = {true};
        // Initialize a new RequestQueue instance
        requestQueue = Volley.newRequestQueue(context);
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
        // Initialize a new JsonArrayRequest instance
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Do something with response
                        //mTextView.setText(response.toString());

                        // Process the JSON
                        try {
                            // Loop through the array elements
                            for (int i = 0; i < response.length(); i++) {
                                // Get current json object
                                JSONObject category = response.getJSONObject(i);
                                // Get the current "Category" (json object) data
<<<<<<< HEAD
                                String id = category.getString("id");
                                String urlImage = category.getString("urlImage");
                                String title = category.getString("title");
                                categories.add(new Category(id,urlImage,title));


=======
                                int id = category.getInt("id");
                                String title = category.getString("title");

                                categories.add(new Category(id,title));

                                Log.d("rrr", "onResponse: "+id+"\n"+title);
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            issuccess[0] =false;
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        Toast.makeText(context, "error" + error.getMessage(), Toast.LENGTH_SHORT).show();
                        issuccess[0] =false;
                    }

                }

        );
        // Add JsonArrayRequest to the RequestQueue
        requestQueue.add(jsonArrayRequest);
        return categories;
    }

<<<<<<< HEAD
=======
    public String getstring(String url){
        final String[] result = {"mahmoud"};
        requestQueue = Volley.newRequestQueue(context);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        result[0] =response;
                        Log.d("sss", "onResponse: "+response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        requestQueue.add(stringRequest);
        return result[0];
    }

>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde

}
