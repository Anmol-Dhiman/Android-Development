package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {
//    score counting variables for both the team

//    here
    int TeamAScore = 0;
    int TeamBScore = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);
        displayForTeamB(0);
    }

    public void addThreeForTeamA(View view) {
        TeamAScore += 3;
        displayForTeamA(TeamAScore);
    }
    public void addTwoForTeamA(View view) {
        TeamAScore += 2;
        displayForTeamA(TeamAScore);
    }
    public void addOneForTeamA(View view) {
        TeamAScore ++;
        displayForTeamA(TeamAScore);
    }
    public void displayForTeamA(int score) {
        TextView teamScore = (TextView) findViewById(R.id.team_a_score);
        teamScore.setText("" + score);
    }
    public void addThreeForTeamB(View view) {
        TeamBScore += 3;
        displayForTeamB(TeamBScore);
    }
    public void addTwoForTeamB(View view) {
        TeamBScore += 2;
        displayForTeamB(TeamBScore);
    }
    public void addOneForTeamB(View view) {
        TeamBScore ++;
        displayForTeamB(TeamBScore);
    }
    public void displayForTeamB(int score) {
        TextView teamScore = (TextView) findViewById(R.id.team_b_score);
        teamScore.setText("" + score);
    }
    public void resetText(View view) {
        TeamBScore =0;
        TeamAScore=0;
        displayForTeamB(0);
        displayForTeamA(0);
    }
}