package com.example.chats.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chats.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserRecyclerView extends RecyclerView.Adapter<UserRecyclerView.ViewHolder> {

//    we have just build the recycler view over here
//    which is used to show the contacts in the chats section

    ArrayList<User> list;
    Context context;

    public UserRecyclerView(ArrayList<User> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_sample_source, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = list.get(position);
        holder.userName.setText(user.getUserName());
        holder.lastMessage.setText(user.lastMessage);
        Picasso.get().load(user.getProfliePic()).placeholder(R.drawable.avatar).into(holder.proflieImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView proflieImg;
        TextView userName, lastMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            proflieImg = itemView.findViewById(R.id.profile_image);
            userName = itemView.findViewById(R.id.userName);
            lastMessage = itemView.findViewById(R.id.lastMessage);
        }
    }
}
