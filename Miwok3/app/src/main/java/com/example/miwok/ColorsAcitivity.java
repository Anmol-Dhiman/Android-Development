package com.example.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsAcitivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer=null;
    private MediaPlayer.OnCompletionListener mOnCompleteListner = (mp) -> {
        releaseMediaPlayer();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors_acitivity);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Red", "temp", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("Black", "temp", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("Brown", "temp", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("Dusty Yellow", "temp", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("Gray", "temp", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("Green", "temp", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("Yellow", "temp", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new Word("White", "temp", R.drawable.color_white, R.raw.color_white));

        WordAdaptor words_adaptor = new WordAdaptor(this, words, R.color.colorActivityColor);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(words_adaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word temp_word = words.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsAcitivity.this, temp_word.getAudioId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mOnCompleteListner);

            }
        });
    }
    //this override function will stop the audio when we close the app
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    //this function is used to relase the media player object as we do not need it now
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
        }
        mMediaPlayer = null;
    }
}