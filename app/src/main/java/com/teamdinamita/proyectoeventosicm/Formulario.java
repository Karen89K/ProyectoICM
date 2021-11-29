package com.teamdinamita.proyectoeventosicm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {
    CheckBox formulario [] = new CheckBox[7];
    TextView texto [] = new TextView[2];
    Boolean contactot1=false;
    Boolean temperatura=false;
    Boolean resfriado=false;
    Boolean dolor=false;
    Boolean respiracion =false;
    Boolean cbt2=false;
    Boolean olfato = false;
    Button btn_validar;
    String correo;
    int puntaje=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Bundle correoB = getIntent().getExtras();
        System.out.println(correoB);
        if (correoB != null) {
            correo = correoB.getString("correoUs");
        }
        initUI();

    }

    private void initUI() {
        //txt
        texto[0] = (TextView) findViewById(R.id.txt_contacto_tiempo);
        texto[1] = (TextView) findViewById(R.id.txt_sintomas);

        //check
        formulario[0] = (CheckBox) findViewById(R.id.cb_contactot1);
        formulario[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulario[1].setEnabled(false);
                if(!contactot1){
                    contactot1=true;
                    puntaje++;
                }else{
                    contactot1=false;
                    formulario[1].setEnabled(true);
                    puntaje--;
                }
            }
        });

        formulario[1] = (CheckBox) findViewById(R.id.cb_contactot2);
        formulario[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cbt2){
                    formulario[0].setEnabled(cbt2);
                    cbt2=true;
                }else {
                    formulario[0].setEnabled(cbt2);
                    cbt2=false;
                }

            }
        });




        formulario[2] = (CheckBox) findViewById(R.id.cb_sint_temp);
        formulario[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!temperatura){
                    temperatura=true;
                    puntaje++;
                }else{
                    temperatura=false;
                    puntaje--;
                }
            }
        });



        formulario[3]= (CheckBox) findViewById(R.id.cb_sint_estornudo);
        formulario[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!resfriado){
                    resfriado=true;
                    puntaje++;
                }else{
                    resfriado=false;
                    puntaje--;
                }
            }
        });




        formulario[4]= (CheckBox) findViewById(R.id.cb_sint_cuerpo);
        formulario[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dolor){
                    dolor=true;
                    puntaje++;
                }else{
                    dolor=false;
                    puntaje--;
                }
            }
        });

        formulario[5]= (CheckBox) findViewById(R.id.cb_sint_respiracion);
        formulario[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!respiracion){
                    respiracion=true;
                    puntaje++;
                }else{
                    respiracion=false;
                    puntaje--;
                }
            }
        });



        formulario[6] = (CheckBox) findViewById(R.id.cb_sint_olfato);
        formulario[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!olfato){
                    olfato=true;
                    puntaje++;
                }else{
                    olfato=false;
                    puntaje--;
                }
            }
        });

        //boton
        this.btn_validar = (Button) findViewById(R.id.btn_validarFormulario);
        this.btn_validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(puntaje <= 2){
                    //cambiar a todos los eventos de la app
                    Intent intent = new Intent(Formulario.this, MisEventos.class);
                    intent.putExtra("correoUs",correo);
                    System.out.println(correo);
                    startActivity(intent);
                }else{
                    if(puntaje >=3){
                        Intent intent = new Intent(Formulario.this, ErrorEvento.class);
                        startActivity(intent);
                    }
                }
            }
        });




    }






}