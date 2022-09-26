package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import com.example.threads.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


//    if we want to change the ui based on the background thread then we have to use handlers

//where looper is a ui thread which is in a continious loop to execute the task of the message queue

//    and the handler is middle person which put the task from other thread to the message queue for the ui changes
//handler always execute the runnable interfaces


    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private volatile boolean stopMessage = false;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //here we can use the mulithreading by making the new thread and run that thread or
        //we can use the runnable class where we will define the task which will happen in
        //second thread and by assigning it to the new thread and run that, this is how we can
        //use the multithreading system.

//        here this handler is associted with the main thread which already have the looper
//        that's we do need to pass the argumets about the main thread details
        handler = new Handler();

        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                run();

            }
        });
        binding.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopMessage = true;
            }
        });

    }

    private void run() {
//        thread thread = new thread(10);
//        thread.start();

//        this is how we use the runnable interface
        stopMessage = false;
        runnable runnable = new runnable(10);
//        if we do
//        runnable.run();
//        then it will the run runnable into the main thread
        new Thread(runnable).start();
    }

    class thread extends Thread {
        int seconds;

        thread(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < seconds; i++) {
                try {
                    Log.d(TAG, "sleep second " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //this is the runnable class where we define the code which we have perfrom in the second thread
    class runnable implements Runnable {
        int seconds;

        runnable(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < seconds; i++) {

                if (stopMessage) return;

                try {
                    Log.d(TAG, "sleep second " + i);
                    Handler threadHandler = new Handler(Looper.getMainLooper());

//                    here in the other thread which is a runnable interface we can give the request in the message queue to change the ui
                    if (i == 4) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                binding.start.setText("hello");
                                Log.d(TAG, "start changed");
                            }
                        });
                        threadHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                binding.stop.setText("world");
                                Log.d(TAG, "stop changed");
                            }
                        });


                    }

                    if (i == 6) {

//                        there is a view method post() which do the same work
//                        so we can use that also
                        binding.start.post(new Runnable() {
                            @Override
                            public void run() {
                                binding.start.setText("printf");
                                Log.d(TAG, "start changed");
                            }
                        });
                    }


                    if (i == 8) {
//                        we also have the activity method which we can do the same work as well
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                binding.stop.setText("hello world");
                            }
                        });

                    }


                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}