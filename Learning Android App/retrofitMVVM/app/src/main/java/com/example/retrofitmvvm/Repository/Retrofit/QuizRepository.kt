package com.example.retrofitmvvm.Repository.Retrofit

import android.util.Log
import android.widget.Toast

import androidx.lifecycle.MutableLiveData
import com.example.example.QuizData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuizRepository {

    companion object {
        fun getQuizLiveData(): MutableLiveData<QuizData>? {
            val quizLiveData: MutableLiveData<QuizData> = MutableLiveData<QuizData>()

            CoroutineScope(Dispatchers.IO).launch {
                val data: Call<QuizData> = RetrofitResponse.quizData.getData(true)
                data.enqueue(object : Callback<QuizData> {
                    override fun onResponse(call: Call<QuizData>, response: Response<QuizData>) {
                        val quizData: QuizData? = response.body()
                        if (quizData != null) {
                            quizLiveData.postValue(quizData)
                        }
                    }

                    override fun onFailure(call: Call<QuizData>, t: Throwable) {

                    }

                })
            }
            return quizLiveData
        }
    }
}