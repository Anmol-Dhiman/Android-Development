package com.example.sample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import  com.example.sample.databinding.ActivityMainBinding
import org.json.JSONArray
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var data: ArrayList<options>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        data = ArrayList<options>()
        readJson(this@MainActivity)
        binding.recyclerView.adapter = Adapter(data)
    }


    private fun readJson(context: Context) {


        try {
            val jsonString =
                context.assets.open("quiz_data.json").bufferedReader().use { it.readText() }
            var jsonArr = JSONArray(jsonString)
            for (i in 0 until jsonArr.length() - 1) {
                var temp: MutableList<String> = mutableListOf()
                temp.add(
                    jsonArr.getJSONObject(i).getJSONArray("options").getJSONObject(0)
                        .getString("id")
                )

                data.add(options(opt = temp))
            }

        } catch (
            ioException: IOException
        ) {
            ioException.printStackTrace()
        }


    }

    data class options(
        var opt: MutableList<String> = mutableListOf()
    )
}