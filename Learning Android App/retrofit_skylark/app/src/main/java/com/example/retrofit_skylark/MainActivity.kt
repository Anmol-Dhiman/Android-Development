package com.example.retrofit_skylark

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: ViewModelClass by viewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.textView)
        val button = findViewById<TextView>(R.id.button)

        viewModel = ViewModelProvider(this)[ViewModelClass::class.java]

        viewModel.getLiveData().observe(this, Observer {
            Log.d("resp values", it)
            if (it != "") {
                text.text = it
            } else {
                text.text = "empty"
            }
        })

        button.setOnClickListener {
//            here we can show the loading state as we are making the http request in background
            viewModel.getData()
        }

    }
}