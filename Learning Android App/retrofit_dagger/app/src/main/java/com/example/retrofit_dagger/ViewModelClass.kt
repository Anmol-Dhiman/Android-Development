package com.example.retrofit_dagger

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_dagger.DataModel.QuizData
import com.example.retrofit_dagger.RetrofitRepo.retrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class ViewModelClass @Inject constructor() : ViewModel() {
    private val data: MutableLiveData<String> = MutableLiveData()
    fun getData() {
        viewModelScope.launch {
            retrofitInstance.getData().enqueue(object : Callback<QuizData> {
                override fun onResponse(call: Call<QuizData>, response: Response<QuizData>) {
                    if (response.isSuccessful) {
                        data.postValue(response.body().toString())
                    } else {
                        data.postValue("")
                    }
                }

                override fun onFailure(call: Call<QuizData>, t: Throwable) {
                }
            })
        }
    }
    fun getLiveData(): MutableLiveData<String> {
        return data
    }
}