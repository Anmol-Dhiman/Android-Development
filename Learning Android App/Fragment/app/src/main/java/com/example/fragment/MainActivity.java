package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.fragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        when we want to share the data with the fragment from the activity then we use the bundle for that


        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                doing the whole code of frag method in this onClick is hectic for the big application as the code base is also large in those applications so we introduce the frag function to do our work

                Fragment2 temp = Fragment2.frag("for fragment 2", 123);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, temp).commit();

            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment1 temp = Fragment1.frag("for framgent 1", 123);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, temp).commit();
            }
        });

    }
}