package com.example.weahterforecast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout secondRl_homeRl;
    private ProgressBar progressBar;
    private TextView cityName, temperature, condition;
    private RecyclerView recyclerView;
    private TextInputEditText cityEnt;
    private ImageView backGround, icon, search;
    private ArrayList<WeatherData> weatherDataArrayList;
    private WeatherAdapter weatherAdapter;
    private LocationManager locationManager;
    private int PERMISSION_CODE = 1;
    private String foundCityName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        this will be used to make our app full screen so that we can not see the status bar in our app

        setContentView(R.layout.activity_main);
        secondRl_homeRl = (RelativeLayout) findViewById(R.id.second_relative_layout);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        cityName = (TextView) findViewById(R.id.city_name);
        temperature = (TextView) findViewById(R.id.temperature);
        condition = (TextView) findViewById(R.id.condition_text);
        recyclerView = (RecyclerView) findViewById(R.id.RV_with_time);
        cityEnt = (TextInputEditText) findViewById(R.id.inputText);
        backGround = (ImageView) findViewById(R.id.background_image);
        icon = (ImageView) findViewById(R.id.weather_image);
        search = (ImageView) findViewById(R.id.search_button);

        weatherDataArrayList = new ArrayList<>();
        weatherAdapter = new WeatherAdapter(this, weatherDataArrayList);
        recyclerView.setAdapter(weatherAdapter);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

//       if the permission for the location is not granted which is checked by this if condition so we will ask for the location permission
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_CODE);
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        foundCityName = getCityName(location.getLatitude(), location.getLongitude());
        getWeatherInfo(foundCityName);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = cityEnt.getText().toString();

                if (city.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter City Name", Toast.LENGTH_SHORT).show();
                } else {
                    cityName.setText(city);
                    getWeatherInfo(city);
                }
            }
        });
    }


    //    after the permission request result this method will call up and if the permission granted then the app will run other than that the app will not run
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted...", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please provide the permission", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    //    this method will provide the city name from latitude and longitude
    private String getCityName(double latitude, double longitude) {
        String cityName = "Not Found";
        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        try {
            List<Address> addresses = gcd.getFromLocation(latitude, longitude, 10);
            for (Address adr : addresses) {
                if (adr.getLocality() != null && adr.getLocality() != "") {

                    cityName = adr.getLocality();
                } else {
                    Toast.makeText(this, "User City Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityName;
    }

    private void getWeatherInfo(String CityName) {
        String url = "http://api.weatherapi.com/v1/current.json?key=cf08f776e9d64f458ba151049222502&q=" + CityName + "&aqi=no";
        cityName.setText(CityName);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility(View.GONE);
                secondRl_homeRl.setVisibility(View.VISIBLE);
                weatherDataArrayList.clear();

                try {
                    String temp_cel = response.getJSONObject("current").getString("temp_c");
                    temperature.setText(temp_cel + "°C");
                    int isDay = response.getJSONObject("current").getInt("is_day");
                    String condt = response.getJSONObject("current").getJSONObject("condition").getString("text");
                    String condt_icon = response.getJSONObject("current").getJSONObject("condition").getString("icon");
                    Picasso.get().load("http:".concat(condt_icon)).into(icon);
                    condition.setText(condt);

//                    here we will set the background image based on wether it is day or night : -
                    if (isDay == 1) {
//                      2  morning
//                        Picasso.get().load("").into(backGround);
                        backGround.setImageResource(R.drawable.day);
                    } else {
//                        night
//                        Picasso.get().load("").into(backGround);
                        backGround.setImageResource(R.drawable.night);
                    }

                    JSONObject forecastObj = response.getJSONObject("forecast");
                    JSONObject forecastO = forecastObj.getJSONArray("forecastday").getJSONObject(0);
                    JSONArray hourArray = forecastO.getJSONArray("hour");

                    for (int i = 0; i < hourArray.length(); i++) {
                        JSONObject hour = hourArray.getJSONObject(i);
                        String time = hour.getString("time");
                        String temper = hour.getString("temp_c");
                        String img = hour.getJSONObject("condition").getString("icon");
                        String wind = hour.getString("wind_kph");
                        weatherDataArrayList.add(new WeatherData(time, temper, img, wind));
                    }

                    weatherAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Please Enter Valid City Name...", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}