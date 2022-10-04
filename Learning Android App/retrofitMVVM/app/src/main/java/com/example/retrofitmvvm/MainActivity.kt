package com.example.retrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example.QuizData
import com.example.retrofitmvvm.Repository.Retrofit.GetDataAPI
import com.example.retrofitmvvm.Repository.Retrofit.RetrofitResponse
import com.example.retrofitmvvm.ViewModel.QuizViewModel
import com.example.retrofitmvvm.databinding.ActivityMainBinding
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
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: QuizViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[QuizViewModel::class.java]

        viewModel.getQuizLiveDataRepo()?.observe(this, androidx.lifecycle.Observer {


            var quiz = it as QuizData
            var adapter = QuizAdapter()
            adapter.setQuizData(quiz.result.questions)
            binding.quizRecyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })



        binding.quizRecyclerView.layoutManager = LinearLayoutManager(this)
    }

}