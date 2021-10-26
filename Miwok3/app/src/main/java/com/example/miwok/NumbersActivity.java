package com.example.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private MediaPlayer.OnCompletionListener mOnCompleteListner = (mp) -> {
        releaseMediaPlayer();
    };
  private   AudioManager.OnAudioFocusChangeListener mAudioManagerListner = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
//        here AUDIO_SERVICE is the defination of what type of audio i want ot play
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//        ArrayList<String> words = new ArrayList<String>();
//        words.add("one");
//        words.add("two");
//        words.add("three");
//        words.add("four");
//        words.add("five");
//        words.add("six");
//        words.add("seven");
//        words.add("eight");
//        words.add("nine");
//        words.add("ten");

//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//        for (int i = 0; i < words.size(); i++) {
//            TextView wordText = new TextView(this);
//            wordText.setText(words.get(i));
//            rootView.addView(wordText);
//        }
//     ArrayAdapter<String> items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
//        ListView temp = (ListView) findViewById(R.id.rootView);
//        temp.setAdapter(items);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("One", "temp", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Two", "temp", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three", "temp", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four", "temp", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five", "temp", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six", "temp", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven", "temp", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight", "temp", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine", "temp", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten", "temp", R.drawable.number_ten, R.raw.number_ten));

        WordAdaptor words_adaptor = new WordAdaptor(this, words, R.color.numberActivityColor);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(words_adaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // this Word object is built to get the audio id of the list item w.r.t position
                Word temp_word = words.get(position);
                int result = mAudioManager.requestAudioFocus(mAudioManagerListner, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    //here we set the audio file with the mediaPlayer object and context
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, temp_word.getAudioId());
                    mMediaPlayer.start();
// when the start function ends the oncomplete listner will run which will release the mediaplayer
                    mMediaPlayer.setOnCompletionListener(mOnCompleteListner);
                }
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
        mAudioManager.abandonAudioFocus(mAudioManagerListner);
    }
}