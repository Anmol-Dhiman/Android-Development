package com.example.retrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.example.QuizData
import com.example.retrofitmvvm.Repository.Retrofit.GetDataAPI
import com.example.retrofitmvvm.Repository.Retrofit.RetrofitResponse
import com.example.retrofitmvvm.ViewModel.QuizViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: QuizViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = QuizViewModel()
        viewModel.getQuizLiveDataRepo()?.observe(this, androidx.lifecycle.Observer {
            Log.d("main", "onCreate: " + it)
        })

    }
}