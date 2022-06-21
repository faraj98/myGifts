package com.example.giftsapp.apiManager;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.giftsapp.models.Category;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiManager {
    Context context;
    String url="https://pastebin.com/raw/Em972E5s";
    // Initialize a new RequestQueue instance
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    public boolean GetMall() {
        final boolean[] issuccess = {true};
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
                                JSONObject student = response.getJSONObject(i);

                                // Get the current "student" (json object) data
                                String firstName = student.getString("firstname");
                                String lastName = student.getString("lastname");
                                String age = student.getString("age");
                                Log.d("onResponse: ", "onResponse: "+firstName+"\n"+lastName+"\n"+age);
                                // Display the formatted json data in text view

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
        return issuccess[0];
    }
    public ArrayList<Category> GetCategory() {
        ArrayList<Category>categories=new ArrayList<>();
        final boolean[] issuccess = {true};
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
                                String id = category.getString("id");
                                String urlImage = category.getString("urlImage");
                                String title = category.getString("title");
                                categories.add(new Category(id,urlImage,title));


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


}
