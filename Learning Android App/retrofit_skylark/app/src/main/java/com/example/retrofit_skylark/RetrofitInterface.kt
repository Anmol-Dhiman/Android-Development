package com.example.retrofit_skylark

import com.example.example.QuizData
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("/")
    fun getData(): Call<QuizData>
}