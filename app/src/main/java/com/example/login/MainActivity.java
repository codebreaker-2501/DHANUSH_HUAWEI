/*
  @author DHANUSH N
 * @version 1.0
 */
package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;



import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialButton signInButton = findViewById(R.id.sign_in);
        TextInputEditText name, years, number, bio, location;

        //assigning views
        name = findViewById(R.id.name);
        years = findViewById(R.id.age);
        number = findViewById(R.id.number);
        bio = findViewById(R.id.bio);
        location = findViewById(R.id.location);

        // listens the changes in editText
        TextWatcher signUpWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String fullName, age, contact, about, place;

                // gets string value from editText
                fullName = Objects.requireNonNull(name.getText()).toString().trim();
                age = Objects.requireNonNull(years.getText()).toString().trim();
                contact = Objects.requireNonNull(number.getText()).toString().trim();
                about = Objects.requireNonNull(bio.getText()).toString().trim();
                place = Objects.requireNonNull(location.getText()).toString().trim();

                //check for empty string
                int count = 0;
                if (fullName.isEmpty()) name.setError("Enter name");
                else count++;
                if (age.isEmpty()) years.setError("enter age");
                else count++;
                if (contact.isEmpty()) number.setError("enter number");
                else count++;
                if (about.isEmpty()) bio.setError("enter bio");
                else count++;
                if (place.isEmpty()) location.setError("enter location");
                else count++;

                //if no empty edit text present, enable button
                signInButton.setEnabled(count == 5);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        //listens for change in editText
        name.addTextChangedListener(signUpWatcher);
        years.addTextChangedListener(signUpWatcher);
        number.addTextChangedListener(signUpWatcher);
        bio.addTextChangedListener(signUpWatcher);
        location.addTextChangedListener(signUpWatcher);

        // called when the button is pressed
        signInButton.setOnClickListener(view -> {
            String fullName, age, contact, about, place;
            fullName = Objects.requireNonNull(name.getText()).toString().trim();

            //get the final text once the button got enabled
            age = Objects.requireNonNull(years.getText()).toString().trim();
            contact = Objects.requireNonNull(number.getText()).toString().trim();
            about = Objects.requireNonNull(bio.getText()).toString().trim();
            place = Objects.requireNonNull(location.getText()).toString().trim();

            //creates intent to pass value to next activity
            Intent intent = new Intent(this,Profile.class);
            intent.putExtra("fullName",fullName);
            intent.putExtra("age",age);
            intent.putExtra("contact",contact);
            intent.putExtra("about",about);
            intent.putExtra("place",place);

            //starts intent
            startActivity(intent);
        });
    }
}