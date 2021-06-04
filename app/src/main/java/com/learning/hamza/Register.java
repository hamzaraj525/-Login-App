package com.learning.hamza;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    Button register;
    EditText userId, password, name;
    TextView surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        userId = findViewById(R.id.username);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#2d5f8b"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle("Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        register = findViewById(R.id.buttonRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Student student = new Student();
                student.setUserId(userId.getText().toString());
                student.setPassword(password.getText().toString());
                student.setName(name.getText().toString());
                student.setSurname(surname.getText().toString());
                if (validateInput(student)) {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    final UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(student);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    Toast.makeText(Register.this, "User Registered", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Register.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    }).start();
                } else {
                    Toast.makeText(Register.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private Boolean validateInput(Student student) {
        return
                !student.getPassword().isEmpty() &&
                        !student.getName().isEmpty();
    }
}