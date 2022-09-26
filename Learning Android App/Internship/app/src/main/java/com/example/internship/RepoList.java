package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.internship.databinding.ActivityRepoListBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RepoList extends AppCompatActivity {

    private ActivityRepoListBinding binding;
    private ArrayList<RepoModel> repoModelArrayList = new ArrayList<>();
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRepoListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        Log.d("Main", "in the onCreate of repo list activity before makeHttpRequest");
        makeHttpRequest(userName);
        Log.d("Main", "in the onCreate of repo list activity after make request");


    }

    private void makeHttpRequest(String userName) {
        adapter = new Adapter(RepoList.this, repoModelArrayList);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String url = "https://api.github.com/users/" + userName + "/repos";
        Log.d("Main", url);
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        Log.d("Main", "here in the for loop of repo list activity");

                        JSONObject repositoryInfo = response.getJSONObject(i);
                        String repoName = repositoryInfo.getString("name");
                        String repoDescription = repositoryInfo.getString("description");
                        String repoUrl = repositoryInfo.getString("html_url");
                        repoModelArrayList.add(new RepoModel(repoName, repoUrl, repoDescription));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Main", "in the error section of repo list activity");

                new AlertDialog.Builder(RepoList.this)
                        .setTitle("User Not Found !!")
                        .setMessage("Enter the user name again.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
            }

        });
        queue.add(jsonArrayRequest);


    }
}