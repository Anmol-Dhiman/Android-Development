package com.example.chats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.chats.Adapters.FragmentsAdapter;
import com.example.chats.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//here in this project we will do the work of viewpager
//which will help to see the chats section and status section and calls section


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tab.setupWithViewPager(binding.viewPager);

    }
}