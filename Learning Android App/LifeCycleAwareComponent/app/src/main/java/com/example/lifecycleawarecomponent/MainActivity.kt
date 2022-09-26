package com.example.lifecycleawarecomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver

class MainActivity : AppCompatActivity() {

/*    in lifecycle aware component we have two things : -
1. lifecycle owner
2. lifecycle observer

where the owner is the activity itself and for the observer we
have to build the another class which will do the task at the different stages of
activity.

observer have to code of different stages i.e. onCreate, onStop... etc

 */








    private val TAG = "main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        added the observer to the activity
        lifecycle.addObserver(Observer())
        Log.d(TAG, "activity onCreate")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "activity onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "activity onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "activity onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "activity onDestroy")
    }
}