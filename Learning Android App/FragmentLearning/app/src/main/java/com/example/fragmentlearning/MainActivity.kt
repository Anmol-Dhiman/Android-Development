package com.example.fragmentlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





//when we want to show the interactive interface within the activity then we will use the fragments
//for that we have to build the framgent java file and xml file for the interface




        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, firstFragment)
            commit()
        }
        button.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, firstFragment)
//               here we use the addToBackStack() method to add the fragment to the activity stack

                addToBackStack(null)
                commit()
            }
        }
        button2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, secondFragment)
                addToBackStack(null)
                commit()
            }
        }

    }
}