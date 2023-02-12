package com.example.retrofit_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.retrofit_hack.databinding.ActivityMainBinding;

import org.json.JSONArray;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //    https://hackathon-2022-cc.herokuapp.com/getpolicedata/d
    private static final String baseUrl = "https://hackathon-2022-cc.herokuapp.com/";
    private GetUserDetails getUserDetails;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Retrofit main = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getUserDetails = main.create(GetUserDetails.class);
        makeRequest();

    }

    private void makeRequest() {


        Toast.makeText(this, "making response", Toast.LENGTH_SHORT).show();
        Call<ArrayList<Checkpoints>> call = getUserDetails.getCheckPoints();

        call.enqueue(new Callback<ArrayList<Checkpoints>>() {
            @Override
            public void onResponse(Call<ArrayList<Checkpoints>> call, Response<ArrayList<Checkpoints>> response) {
                binding.text.setText(response.body().get(0).getFirstName());
            }

            @Override
            public void onFailure(Call<ArrayList<Checkpoints>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void make() {
        Call<UserDetails> call = getUserDetails.getQuotes();
        call.enqueue(new Callback<UserDetails>() {
            @Override
            public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
                binding.text.setText(response.body().getQ());
            }

            @Override
            public void onFailure(Call<UserDetails> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}