package com.example.retrofitmvvm.Repository.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val baseUrl = "https://b4e7d359-c58f-4aa3-a314-726b3baa3852.mock.pstmn.io"

object RetrofitResponse {
    val quizData: GetDataAPI

    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        quizData = retrofit.create(GetDataAPI::class.java)
    }
}


