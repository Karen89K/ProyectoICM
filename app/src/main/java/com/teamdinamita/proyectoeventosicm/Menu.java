package com.teamdinamita.proyectoeventosicm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void Eventos(View view) {
        Intent intent = new Intent(Menu.this, Eventos.class);
        startActivity(intent);
    }

    public void MisEventos(View view) {
        Intent intent = new Intent(Menu.this, MisEventos.class);
        startActivity(intent);
    }

    public void MedidasSanitarias(View view) {
        Intent intent = new Intent(Menu.this, Medidas_sanitarias.class);
        startActivity(intent);
    }

    public void Acercade(View view) {
        Intent intent = new Intent(Menu.this, InfoApp.class);
        startActivity(intent);
    }

    public void Salir(View view) {
    }
}