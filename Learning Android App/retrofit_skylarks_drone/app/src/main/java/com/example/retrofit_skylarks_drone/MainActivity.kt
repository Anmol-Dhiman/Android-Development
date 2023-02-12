package com.example.retrofit_skylarks_drone

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.Observer

import com.example.retrofit_skylarks_drone.ui.theme.Retrofit_skylarks_droneTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ViewModelClass by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Retrofit_skylarks_droneTheme {
                viewModel.getData()
                viewModel.getLiveData().observe(this, Observer {
                    Log.d("api data", it)
                })
                Log.d("viewModel", viewModel.toString())
            }
        }
    }
}



