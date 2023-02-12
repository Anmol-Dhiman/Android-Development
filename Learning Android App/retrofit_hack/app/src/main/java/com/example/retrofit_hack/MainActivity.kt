package com.example.retrofit_hack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val value = Retrofit main = new Retrofit.Builder()
            .baseUrl("https://hackathon-2022-cc.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}