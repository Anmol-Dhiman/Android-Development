package com.example.retrofit_skylark

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.QuizData
import com.example.retrofit_skylark.RetrofitRepo.retrofitInstance
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
//            val stringData = retrofitRepo.getData()
//            Log.d("resp values view model",stringData)
//            data.postValue(stringData)

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