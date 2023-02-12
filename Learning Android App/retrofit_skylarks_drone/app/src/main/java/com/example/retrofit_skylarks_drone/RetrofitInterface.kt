package com.example.retrofit_skylarks_drone


import com.example.retrofit_skylarks_drone.DataModel.QuizData
import com.example.retrofit_skylarks_drone.DataModel.dataModel
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {

    @GET("posts")
    fun getData(): Call<List<dataModel>>

    @FormUrlEncoded
    @POST("posts")
    fun postData(
        @Field("userId") userID: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ): Call<dataModel>



}