package com.example.notes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notes.R
import com.example.notes.adapters.Adapter
import com.example.notes.data.dataSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<dataSet>()
        list.add( dataSet ("temp1", "temp2"))
        list.add( dataSet ("temp1", "temp2"))
        list.add( dataSet ("temp1", "temp2"))
        list.add( dataSet ("temp1", "temp2"))

        val adapter = Adapter(list)
        notesRecyclerView.adapter

    }
}