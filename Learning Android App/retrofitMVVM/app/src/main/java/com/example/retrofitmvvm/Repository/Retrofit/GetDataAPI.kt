package com.example.retrofitmvvm.Repository.Retrofit

import com.example.example.QuizData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataAPI {

    @GET("/")
    fun getData(@Query("quiz") quiz: Boolean): Call<QuizData>
}

