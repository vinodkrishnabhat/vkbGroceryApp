package com.vkb.myfirstapp.post;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

public class CallAPI {
    public static void call(final Map<String, String> postMap, Context context)
    {
        RequestQueue myRequestQueue = Volley.newRequestQueue(context);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //This code is executed if the server responds, whether or not the response contains data.
                //The String 'response' contains the server's response.
            }
        };

        Response.ErrorListener responseErrorListener = new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
            @Override
            public void onErrorResponse(VolleyError error) {
                //This code is executed if there is an error.
                error.printStackTrace();
            }
        };

        String URL_PRE = "http://192.168.1.";
        String URL_POST = ":8000/printGroceryList";

        for(int ctr = 1; ctr <= 255; ctr++) {
            String url = URL_PRE + ctr + URL_POST;

            StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, responseListener, responseErrorListener) {
                protected Map<String, String> getParams() {
                    return postMap;
                }
            };

            myRequestQueue.add(myStringRequest);
        }
    }
}
