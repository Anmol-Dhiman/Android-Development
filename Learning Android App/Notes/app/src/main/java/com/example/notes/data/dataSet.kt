package com.example.notes.data

class dataSet(t: String, d: String) {

    val title: String
    val description: String


    init {
        title = t
        description = d
    }

    @JvmName("getTitle1")
    fun getTitle(): String {
        return title
    }


    @JvmName("getDescription1")
    fun getDescription(): String {
        return description
    }


}

