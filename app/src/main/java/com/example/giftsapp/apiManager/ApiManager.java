package com.example.giftsapp.apiManager;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.giftsapp.models.Category;
import com.example.giftsapp.models.Mall;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiManager {
    Context context;
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
        // Initialize a new JsonArrayRequest instance
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // Loop through the array elements
                            for (int i = 0; i < response.length(); i++) {
                                // Get current json object
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

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        Toast.makeText(context, "error" + error.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                }

        );
        // Add JsonArrayRequest to the RequestQueue
        requestQueue.add(jsonArrayRequest);
        return mallArrayList;
    }



    public ArrayList<Category> GetCategory(String url) {
        ArrayList<Category>categories=new ArrayList<>();
        final boolean[] issuccess = {true};
        // Initialize a new RequestQueue instance
        requestQueue = Volley.newRequestQueue(context);
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
                                int id = category.getInt("id");
                                String title = category.getString("title");

                                categories.add(new Category(id,title));

                                Log.d("rrr", "onResponse: "+id+"\n"+title);
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


}
