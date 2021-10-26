package com.example.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdaptor extends ArrayAdapter<Word> {
    public static final String LOG_TAG = WordAdaptor.class.getSimpleName();

    private int colourId;

    public WordAdaptor(Activity context, ArrayList<Word> words, int rescolorId) {
        super(context, 0, words);
        colourId = rescolorId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Word currentWord = getItem(position);
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        int color = ContextCompat.getColor(getContext(), colourId);
//        this code is for setting the background color of the button
        ImageView button = (ImageView) listView.findViewById(R.id.button_color_set);
        button.setBackgroundColor(color);


//        this code is for the normal text
        TextView nameTextView = (TextView) listView.findViewById(R.id.number_text_view);
        nameTextView.setText(currentWord.getName());
        nameTextView.setBackgroundColor(color);

//        this code is for the miwok text
        TextView miwTextView = (TextView) listView.findViewById(R.id.miwNumber_text_view);
        miwTextView.setText(currentWord.getMiw_name());
        miwTextView.setBackgroundColor(color);

//       this code for the image of pharses activity
        ImageView num_image = (ImageView) listView.findViewById(R.id.number_images);
        if (currentWord.hasImage())
            num_image.setImageResource(currentWord.getImage_id());
        else
            num_image.setVisibility(View.GONE);

        return listView;
    }

}
