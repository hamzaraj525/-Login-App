package com.learning.hamza;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    TextView textView, textViewSurname;
    Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#2d5f8b"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toast.makeText(Home.this, "Login Successful", Toast.LENGTH_SHORT).show();
        buttonLogout = findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);

            }
        });

        textView = findViewById(R.id.textViewMain);

        String name = getIntent().getStringExtra("name");
        String surname = getIntent().getStringExtra("surname");
        textView.setText("Name:" + name + "  " + surname);

    }
}