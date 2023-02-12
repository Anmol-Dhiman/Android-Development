package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface data {
    @GET("/")
    fun getData(@Query("quiz") quiz: Boolean): Call<QuizData>
}