package com.example.retrofit_skylarks_drone.DataModel

import com.google.gson.annotations.SerializedName

data class dataModel(
    @SerializedName("userId") var userId: Int,
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("body") var body: String,
)
