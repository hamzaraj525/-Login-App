package com.learning.hamza;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText userId, password;
    Button login, createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        userId = findViewById(R.id.editTxtName);
        password = findViewById(R.id.editTxtPassword);

        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#2d5f8b"));
        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle("Login");

        login = findViewById(R.id.buttonLogin);
        createAccount = findViewById(R.id.buttonCreateAccount);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userIdText = userId.getText().toString();
                String passwordText = password.getText().toString();
                if (userIdText.isEmpty() || passwordText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fill All Fields", Toast.LENGTH_SHORT).show();
                } else {
                    //perform query
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Student student = userDao.login(userIdText, passwordText);
                            if (student == null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                String name = student.name;
                                String surname = student.surname;
                                Intent intent = new Intent(MainActivity.this, Home.class);
                                intent.putExtra("name", name);
                                intent.putExtra("surname",surname);
                                startActivity(intent);
                                finish();

                            }
                        }
                    }).start();
                }


            }
        });
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);

            }
        });
    }

}