package com.example.retrofit_skylark


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitRepo {


//    suspend fun getData(): String {
//        var rsp = ""
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://b4e7d359-c58f-4aa3-a314-726b3baa3852.mock.pstmn.io")
//            .addConverterFactory(GsonConverterFactory.create()).build()
//            .create(RetrofitInterface::class.java)
//
//        withContext(Dispatchers.IO) {
//
//            retrofit.getData().enqueue(object : Callback<QuizData> {
//                override fun onResponse(call: Call<QuizData>, response: Response<QuizData>) {
//                    Log.d("resp values 2", response.body().toString())
//                    rsp = response.body().toString()
//                }
//
//                override fun onFailure(call: Call<QuizData>, t: Throwable) {
//
//                }
//            })
//
//        }
//
//
//        return rsp
//    }

    val retrofitInstance: RetrofitInterface = Retrofit.Builder()
        .baseUrl("https://b4e7d359-c58f-4aa3-a314-726b3baa3852.mock.pstmn.io")
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(RetrofitInterface::class.java)

}