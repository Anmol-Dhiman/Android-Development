package com.example.trivia3.datac

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Restaurant(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val string2ResourceId: Int,
    @StringRes val string3ResourceId: Int,
    val price: Int
)