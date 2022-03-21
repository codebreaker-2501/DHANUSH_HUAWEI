package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // getting intent
        Intent intent = getIntent();
        TextView name, age, mobile, location, bio;

        //assigning views
        name = findViewById(R.id.profile);
        age = findViewById(R.id.age);
        mobile = findViewById(R.id.number);
        location = findViewById(R.id.location);
        bio = findViewById(R.id.bio);

        //retrieving the values from the intent received and setting it in the textField
        name.setText(intent.getStringExtra("fullName"));
        age.setText(intent.getStringExtra("age"));
        mobile.setText(intent.getStringExtra("contact"));
        location.setText(intent.getStringExtra("place"));
        bio.setText(intent.getStringExtra("place"));
    }
}