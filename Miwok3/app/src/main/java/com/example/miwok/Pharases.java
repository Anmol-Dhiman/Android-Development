package com.example.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Pharases extends AppCompatActivity {
    private MediaPlayer mMediaPlayer = null;
    private MediaPlayer.OnCompletionListener mOnCompleteListner = (mp) -> {
        releaseMediaPlayer();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharases);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Are You Coming", "temp", R.raw.phrase_are_you_coming));
        words.add(new Word("Come Here", "temp", R.raw.phrase_come_here));
        words.add(new Word("How are you feeling", "temp", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I am coming", "temp", R.raw.phrase_im_coming));
        words.add(new Word("I am feeling good", "temp", R.raw.phrase_im_feeling_good));
        words.add(new Word("Let's go", "temp", R.raw.phrase_lets_go));
        words.add(new Word("My name is", "temp", R.raw.phrase_my_name_is));
        words.add(new Word("What is your name", "temp", R.raw.phrase_what_is_your_name));
        words.add(new Word("Where are you going", "temp", R.raw.phrase_where_are_you_going));
        words.add(new Word("Yes I am coming", "temp", R.raw.phrase_yes_im_coming));
        WordAdaptor words_adaptor = new WordAdaptor(this, words, R.color.pharesesActivityColor);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(words_adaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word temp_word = words.get(position);
                mMediaPlayer = MediaPlayer.create(Pharases.this, temp_word.getAudioId());
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