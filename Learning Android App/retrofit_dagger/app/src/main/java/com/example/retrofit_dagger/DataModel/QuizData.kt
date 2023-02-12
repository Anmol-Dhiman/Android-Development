package com.example.retrofit_dagger.DataModel

import com.google.gson.annotations.SerializedName


data class QuizData(

    @SerializedName("code") var code: Int,
    @SerializedName("result") var result: Result = Result()

)