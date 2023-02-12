package com.example.retrofit_skylarks_drone

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_skylarks_drone.DataModel.QuizData
import com.example.retrofit_skylarks_drone.DataModel.dataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class ViewModelClass @Inject constructor(
    private val retrofitInterface: RetrofitInterface
) : ViewModel() {
    private val data: MutableLiveData<String> = MutableLiveData()

    fun getData() {

        viewModelScope.launch {
//            retrofitInterface.getData().enqueue(object : Callback<List<dataModel>> {
//                override fun onResponse(
//                    call: Call<List<dataModel>>,
//                    response: Response<List<dataModel>>
//                ) {
//                    Log.d("api data view model", response.body().toString())
//                    if (response.isSuccessful) {
//                        data.postValue(response.body().toString())
//                    }
//                }
//
//                override fun onFailure(call: Call<List<dataModel>>, t: Throwable) {
//                    TODO("Not yet implemented")
//                    Log.d("api data view model", "failed $t")
//
//                }
//
//            })
            retrofitInterface.postData(13, "anmol", "dhiman").enqueue(
                object : Callback<dataModel> {
                    override fun onResponse(call: Call<dataModel>, response: Response<dataModel>) {
                        Log.d("api data view model", response.body().toString())
                        if (response.isSuccessful) {
                            data.postValue(response.body().toString())
                        }
                    }

                    override fun onFailure(call: Call<dataModel>, t: Throwable) {
                        TODO("Not yet implemented")
                        Log.d("api data view model", "failed $t")
                    }

                })
        }
    }

    fun getLiveData(): MutableLiveData<String> {
        return data
    }
}