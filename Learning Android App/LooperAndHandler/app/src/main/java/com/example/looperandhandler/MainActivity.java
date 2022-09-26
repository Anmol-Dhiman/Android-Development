package com.example.looperandhandler;

import static com.example.looperandhandler.HandlerClass.TAG_1;
import static com.example.looperandhandler.HandlerClass.TAG_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import com.example.looperandhandler.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main";
    private ActivityMainBinding binding;
    private LooperClass looperClass = new LooperClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                looperClass.start();
            }
        });
        binding.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                quiting the looper now the thread will destroyed
                looperClass.handler.getLooper().quit();
            }
        });
        binding.taskA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Message msg = new Message().obtain();
                msg.what=TAG_1;
                looperClass.handler.sendMessage(msg);

//                looperClass.handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        for (int i = 0; i < 5; i++) {
//
//                            Log.d(TAG, "run " + i);
//                            SystemClock.sleep(1000);
//                        }
//                    }
//                });
            }
        });
        binding.taskB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message msg = new Message().obtain();
                msg.what=TAG_2;
                looperClass.handler.sendMessage(msg);
            }
        });


    }
}