package com.example.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //here is the onclicklistner of number activity
        TextView number = (TextView) findViewById(R.id.numbers);
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numberList = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numberList);
            }
        });
//       //here is the onclicklistner of family activity
        TextView family = (TextView) findViewById(R.id.family_members);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familylist = new Intent(MainActivity.this, FamilyMembers.class);
                startActivity(familylist);
            }
        });
//        //here is the onclicklistner of colors activity
//
        TextView colors = (TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorlist = new Intent(MainActivity.this, ColorsAcitivity.class);
                startActivity(colorlist);
            }
        });
//        //here is the onclicklistner of pharase activity
//
        TextView pharase = (TextView) findViewById(R.id.pharas);
        pharase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pharaselist = new Intent(MainActivity.this, Pharases.class);
                startActivity(pharaselist);
            }
        });

    }

    //   to open the number list page
//    public void openNumberList(View view) {
//        Intent numberList = new Intent(this, NumbersActivity.class);
//        startActivity(numberList);
//    }
//
//    public void openColorsList(View view) {
//        Intent colorsList = new Intent(this, ColorsAcitivity.class);
//        startActivity(colorsList);
//    }
//
//    public void openFamilyMamersList(View view) {
//        Intent familymambersList = new Intent(this, FamilyMembers.class);
//        startActivity(familymambersList);
//    }
//
//    public void openPharasesList(View view) {
//        Intent pharasesList = new Intent(this, Pharases.class);
//        startActivity(pharasesList);
//    }
}