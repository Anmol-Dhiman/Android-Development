package com.example.aradhya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ChangeText(View view){
        display(0);
    }
    public void display(int s)
    {
        TextView text = (TextView) findViewById(R.id.anmolview);
        text.setText("The ans is "+s);
    }
}