package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.song);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button play = (Button) findViewById(R.id.play_button);
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        Button pause = (Button) findViewById(R.id.pause_button);
        pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
    }


}