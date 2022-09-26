package com.example.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Name(View view) {
        EditText temp = (EditText) findViewById(R.id.name_field);
        return temp.getText().toString();

    }

    public void decrement(View view) {
        if (number == 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Can't go beyond 0", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            number--;
            display();
        }
    }

    public void increment(View view) {
        if (number == 100) {
            Toast toast = Toast.makeText(getApplicationContext(), "Can't go beyond 100", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            number++;
            display();
        }
    }

    public void display() {
        TextView temp = (TextView) findViewById(R.id.count);
        temp.setText("" + number);
    }

    public String content() {
        int sum = 0;
        CheckBox whippedcreambox = (CheckBox) findViewById(R.id.whipped_cream);
        boolean temp1 = whippedcreambox.isChecked();
        CheckBox chocolatebox = (CheckBox) findViewById(R.id.chocolate);
        boolean temp2 = chocolatebox.isChecked();
        if (temp1 && temp2) {
            sum = 8 * number;
        } else if (temp1) {
            sum = 6 * number;
        } else if (temp2) {
            sum = 7 * number;
        } else {
            sum = 5 * number;
        }
        String temp = "Name: " + Name() + "\nAdded Whipped Cream? " + temp1 + "\nAdded Chocolate? " + temp2
                + "\nTotal Amount: " + sum + "\nThank You!!";
        return temp;
    }

    public void OrderButton(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "dummy@gamil.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order for " + Name());
        intent.putExtra(Intent.EXTRA_TEXT, content());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}