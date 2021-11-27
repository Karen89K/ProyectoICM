package com.teamdinamita.proyectoeventosicm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InfoApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_app);
    }

    public void back(View view) {
        Intent intent = new Intent(InfoApp.this, Menu.class);
        startActivity(intent);
    }
}