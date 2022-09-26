package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofit.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        here is the sample for the url
//        here the GsonConverterFactory is used to convert the Json data into java objects
        getContent();
    }

    public void getContent() {
//        the baseUrl has to end with /
        

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitSample retrofitSample = retrofit.create(RetrofitSample.class);
        Call<List<DataModel>> call = retrofitSample.getData();


        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {

                if (!response.isSuccessful()) {

                    Toast.makeText(MainActivity.this, "there is an issue with the website", Toast.LENGTH_SHORT).show();
                    return;
                }
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(response.body(), MainActivity.this);
                Log.d("main", "onResponse: " + response.body());
                binding.recyclerView.setAdapter(adapter);
                binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "there is defect the url", Toast.LENGTH_SHORT).show();
            }
        });
    }

}