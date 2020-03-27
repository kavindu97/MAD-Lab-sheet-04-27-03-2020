package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RegisterForm extends AppCompatActivity {

    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name = bundle.getString("name");
        }
    }
}
