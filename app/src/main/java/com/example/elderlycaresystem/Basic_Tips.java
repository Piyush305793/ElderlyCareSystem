package com.example.elderlycaresystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Basic_Tips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic__tips);
    }

    public void back(View view) {
        startActivity(new Intent(Basic_Tips.this, Dashboard.class));
    }
}