package com.example.api_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.chromium.net.CronetEngine;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);
        RequestQueue queue = Volley.newRequestQueue(this);
        String cityName = "jind";
        String url = "https://api.weatherapi.com/v1/forecast.json?key=cf08f776e9d64f458ba151049222502&q=" + cityName + "&days=1&aqi=no&alerts=no";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("try", "here in the try block");
                textView.setText("Response is: " + response.toString().substring(0, 500));
                Log.d("result", response.toString());

//                    int temp_cel = response.getJSONObject("current").getInt("temp_c");
//                    binding.temperature.setText(temp_cel + "°c");
//
//                    String conditionText = response.getJSONObject("current").getJSONObject("condition").getString("text");
//                    binding.condition.setText(conditionText);
//
//                    String conditionImage = response.getJSONObject("current").getJSONObject("condition").getString("icon");
//                    Picasso.get().load("http:".concat(conditionImage)).into(binding.conditionIcon);
//
//                    JSONObject forecast = response.getJSONObject("forecast");
//                    JSONObject forecastday = forecast.getJSONArray("forecastday").getJSONObject(0);
//                    JSONArray hour = forecastday.getJSONArray(("hour"));
//
//                    for (int i = 0; i < hour.length(); i++) {
//                        Log.d("forLoop", "here we are in the for loop");
//                        JSONObject slot = hour.getJSONObject(i);
//
//                        String time = slot.getString("time");
//                        int temper = slot.getInt("temp_c");
//                        String img = slot.getJSONObject("condition").getString("icon");
//                        int wind = slot.getInt("wind_kph");
//
//                        weatherModles.add(new WeatherModle(time, "" + temper, img, "" + wind));
//                    }
//

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", "error in json get request");
            }
        });
        queue.add(jsonObjectRequest);


    }


}