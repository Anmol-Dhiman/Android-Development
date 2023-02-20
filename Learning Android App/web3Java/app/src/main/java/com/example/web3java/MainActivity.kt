package com.example.web3java

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.web3java.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val web3 = Helper()

        binding.balance.setOnClickListener {
            binding.textView.text = web3.getBalance("0x501e0636c64b28840e0C38409Beb87d6BdfA835A")
        }

    }
}