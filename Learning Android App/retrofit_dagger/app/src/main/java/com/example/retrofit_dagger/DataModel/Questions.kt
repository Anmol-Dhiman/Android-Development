package com.example.retrofit_dagger.DataModel

import com.google.gson.annotations.SerializedName


data class Questions(

    @SerializedName("lable") var lable: String? = null,
    @SerializedName("options") var options: ArrayList<Options> = arrayListOf(),
    @SerializedName("correct_answers") var correctAnswers: ArrayList<Int> = arrayListOf()

)