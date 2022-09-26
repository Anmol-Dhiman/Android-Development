package com.example.looperandhandler;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class HandlerClass extends Handler {
    public static final int TAG_1 = 1;
    public static final int TAG_2 = 2;
    private static final String TAG = "main";

    @Override
    public void handleMessage(@NonNull Message msg) {
        switch (msg.what) {
            case TAG_1:
                Log.d(TAG, "handleMessage: task a");
                break;
            case TAG_2:
                Log.d(TAG, "handleMessage: task b");
                break;
        }
    }
}
