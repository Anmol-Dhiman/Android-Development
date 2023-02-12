package com.example.kotlin_java_mix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_java_mix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.kotlin.setOnClickListener {
            binding.textView.text = "hello from kotlin"
        }
        binding.java.setOnClickListener {
            val javaHelper = Helper()
            javaHelper.updateFromJava(binding.textView)
        }

    }
}