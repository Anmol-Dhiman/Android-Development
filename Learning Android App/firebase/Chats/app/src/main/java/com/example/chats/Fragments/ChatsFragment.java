package com.example.chats.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chats.Adapters.FragmentsAdapter;
import com.example.chats.Adapters.User;
import com.example.chats.Adapters.UserRecyclerView;
import com.example.chats.R;
import com.example.chats.databinding.ActivityMainBinding;
import com.example.chats.databinding.FragmentChatsBinding;

import java.util.ArrayList;


public class ChatsFragment extends Fragment {

    private FragmentChatsBinding binding;
    private ArrayList<User> list;


    public ChatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = FragmentChatsBinding.inflate(getLayoutInflater());


        binding.chatRecyclerView.setAdapter(new UserRecyclerView(list, getContext()));

        binding.chatRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        and after that we have to add the database user elements in the list which will be gone
//        i.e. fetch the data from database and then show it to the user

    }
}