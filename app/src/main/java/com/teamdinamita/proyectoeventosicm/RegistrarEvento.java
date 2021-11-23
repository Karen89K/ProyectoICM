package com.teamdinamita.proyectoeventosicm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class RegistrarEvento extends AppCompatActivity {
    EditText txtNombreE,txtDesc,txtFecha,txtDireccion,txtEntorno,txtForo,txtEstado,txtCorreo;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_evento);


        initUI();
    }

    private void initUI() {
        txtNombreE = findViewById(R.id.txtNombreE);
        txtDesc = findViewById(R.id.txtDesc);
        txtFecha = findViewById(R.id.txtFecha);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtEntorno = findViewById(R.id.txtEntorno);
        txtForo = findViewById(R.id.txtForo);
        txtEstado = findViewById(R.id.txtEstado);
        txtCorreo = findViewById(R.id.txtCorreoConf);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }


}





























