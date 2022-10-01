package com.example.retrofitmvvm.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example.QuizData
import com.example.retrofitmvvm.Repository.Retrofit.QuizRepository

class QuizViewModel : ViewModel() {
    private var quizLiveData = MutableLiveData<QuizData>()
    fun getQuizLiveDataRepo(): MutableLiveData<QuizData>? {
        return quizLiveData
    }

    init {
        quizLiveData = QuizRepository.getQuizLiveData()!!
    }
}