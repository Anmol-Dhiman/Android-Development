package com.example.retrofitmvvm.Repository.Retrofit

import com.example.example.QuizData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataAPI {

    //   http://172.16.200.150:3000/patrolingofficers/12345/checkpoint
    @GET("/")
    fun getData(@Query("quiz") quiz: Boolean): Call<QuizData>
}

