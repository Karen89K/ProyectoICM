package com.teamdinamita.proyectoeventosicm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Medidas_sanitarias extends AppCompatActivity {
    String valores [];
Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medidas_sanitarias);
        this.ok = (Button)findViewById(R.id.btnVolver);
        Bundle datos = getIntent().getExtras();

        if (datos != null) {
            valores = datos.getStringArray("datos");
        }

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valores[1].equals("0")){
                    Intent intent = new Intent(Medidas_sanitarias.this, Menu.class);
                    intent.putExtra("correoUs", valores[0]);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(Medidas_sanitarias.this, RegistrarEvento.class);
                    intent.putExtra("correoUs", valores[0]);
                    startActivity(intent);
                }

            }
        });

    }


    public void RegistrarEventos(View view) {

    }

}