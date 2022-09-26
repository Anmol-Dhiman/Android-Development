package com.example.looperandhandler;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;


public class LooperClass extends Thread {
    private static final String TAG = "main";
    public Handler handler;

    @Override
    public void run() {
        Looper.prepare();
        handler = new HandlerClass();
//        here we make the loop in this thread, now until we quit the thread, it will be get running
        Looper.loop();


//        for (int i = 0; i < 5; i++) {
//            Log.d(TAG, "run: " + i);
////        this also work same as the Thread.sleep() but here we do need to use the try catch block, it do that work internally
//            SystemClock.sleep(1000);
//        }
        Log.d(TAG, "end of the thread");

    }
}
