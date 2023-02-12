package com.example.retrofit_dagger

import com.example.retrofit_dagger.DataModel.QuizData
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("/")
    fun getData(): Call<QuizData>
}