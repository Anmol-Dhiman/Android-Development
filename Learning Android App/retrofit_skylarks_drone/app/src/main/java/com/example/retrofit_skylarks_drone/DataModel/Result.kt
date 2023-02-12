package com.example.retrofit_skylarks_drone.DataModel

import com.google.gson.annotations.SerializedName


data class Result(

    @SerializedName("timeInMinutes") var timeInMinutes: Int? = null,
    @SerializedName("questions") var questions: ArrayList<Questions> = arrayListOf()

)