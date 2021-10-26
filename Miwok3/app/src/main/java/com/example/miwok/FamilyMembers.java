package com.example.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {
    private MediaPlayer mMediaPlayer=null;
    private MediaPlayer.OnCompletionListener mOnCompleteListner = (mp) -> {
        releaseMediaPlayer();
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Grand Father", "temp", R.drawable.family_grandfather,R.raw.family_grandfather));
        words.add(new Word("Grand Mother", "temp", R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new Word("Father", "temp", R.drawable.family_father,R.raw.family_father));
        words.add(new Word("Mother", "temp", R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word("Older Brother", "temp", R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("Older Sister", "temp", R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("Son", "temp", R.drawable.family_son,R.raw.family_son));
        words.add(new Word("Daughter", "temp", R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Word("Younger Brohter", "temp", R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("Younger Sister", "temp", R.drawable.family_younger_sister,R.raw.family_younger_sister));
        WordAdaptor words_adaptor=new WordAdaptor(this, words,R.color.familyMembersActivityColor);
        ListView listView =(ListView) findViewById(R.id.list);
        listView.setAdapter(words_adaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word temp_word = words.get(position);
                mMediaPlayer = MediaPlayer.create(FamilyMembers.this, temp_word.getAudioId());
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