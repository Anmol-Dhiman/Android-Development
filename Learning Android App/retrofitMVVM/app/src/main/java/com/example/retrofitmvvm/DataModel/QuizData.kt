package com.example.example

import com.google.gson.annotations.SerializedName


data class QuizData (

  @SerializedName("code"   ) var code   : Int?    = null,
  @SerializedName("result" ) var result : Result? = Result()

)