package com.example.retrofit_dagger.DataModel

import com.google.gson.annotations.SerializedName


data class Options(

    @SerializedName("key") var key: Int,
    @SerializedName("lable") var lable: String

)