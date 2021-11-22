package com.teamdinamita.proyectoeventosicm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    EditText txtCorreo, txtNombre, txtApellidos, txtEdad, txtPassw;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        initUI();
    }



    private void initUI() {
        txtCorreo = findViewById(R.id.txtCorreo);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtEdad = findViewById(R.id.txtEdad);
        txtPassw = findViewById(R.id.txtPassw);
        btnRegistro = findViewById(R.id.btnRegistrar);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertData();
            }
        });
    }

    private void insertData() {
        final String correo = txtCorreo.getText().toString().trim();
        final String nombre = txtNombre.getText().toString().trim();
        final String apellidos = txtApellidos.getText().toString().trim();
        final String edad = txtEdad.getText().toString().trim();
        final String password = txtPassw.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando...");

        if (nombre.isEmpty()) {
            txtNombre.setError("complete los campos");
            return;
        } else if (correo.isEmpty()) {

            txtCorreo.setError("complete los campos");
            return;
        } else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "-",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if (response.equalsIgnoreCase("Datos insertados")) {
                                Toast.makeText(Registro.this, "Datos insertados", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                Intent intent = new Intent(Registro.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Registro.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                Toast.makeText(Registro.this, "No se puede insertar", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Registro.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> params = new HashMap<String, String>();

                    params.put("correo", correo);
                    params.put("nombre", nombre);
                    params.put("apellidos", apellidos);
                    params.put("edad", edad);
                    params.put("password", password);

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(Registro.this);
            requestQueue.add(request);


        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }

    public void Login(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();

    }


}


