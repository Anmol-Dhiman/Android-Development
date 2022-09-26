package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment1 extends Fragment {

    public static final String ARG_S = "arg text";
    public static final String ARG_N = "arg number";

    public static Fragment1 frag(String val, int num) {
        Fragment1 temp = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_S, val);
        bundle.putInt(ARG_N, num);
        temp.setArguments(bundle);
        return temp;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_1, container, false);

        if (getArguments() != null) {
            TextView textView = v.findViewById(R.id.textView2);
            textView.setText(getArguments().getString(ARG_S));
        }
        return v;
    }


}