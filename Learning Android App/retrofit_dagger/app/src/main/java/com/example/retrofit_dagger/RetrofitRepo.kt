package com.example.retrofit_dagger


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitRepo {


    val retrofitInstance: RetrofitInterface = Retrofit.Builder()
        .baseUrl("https://b4e7d359-c58f-4aa3-a314-726b3baa3852.mock.pstmn.io")
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(RetrofitInterface::class.java)

}