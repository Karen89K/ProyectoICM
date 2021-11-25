package com.teamdinamita.proyectoeventosicm;

import androidx.appcompat.app.AppCompatActivity;

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


        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }

        });

    }

    private void insertData() {
        final String EventoNombre = txtNombreE.getText().toString().trim();
        final String Descripcion = txtDesc.getText().toString().trim();
        final String Fecha = txtFecha.getText().toString().trim();
        final String Direccion = txtDireccion.getText().toString().trim();
        final String Entorno = txtEntorno.getText().toString().trim();
        final String Foro = txtForo.getText().toString().trim();
        final String Estado = txtEstado.getText().toString().trim();


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando...");

        if (EventoNombre.isEmpty()) {
            txtNombreE.setError("complete los campos");
            return;
        } else if (Entorno.isEmpty()) {

            txtCorreo.setError("complete los campos");
            return;
        } else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://zjbicqfh.lucusvirtual.es/insertE.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if (response.equalsIgnoreCase("Datos insertados")) {
                                Toast.makeText(RegistrarEvento.this, "Datos insertados", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                Intent intent = new Intent(RegistrarEvento.this, MisEventos.class);
                                startActivity(intent);
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(RegistrarEvento.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(RegistrarEvento.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> params = new HashMap<String, String>();

                    params.put("nombre", EventoNombre);
                    params.put("descripcion", Descripcion);
                    params.put("fecha", Fecha);
                    params.put("direccion", Direccion);
                    params.put("entorno", Entorno);
                    params.put("foro", Foro);
                    params.put("estado", Estado);
                    params.put("correo", "deeper41swg@gmail.com");
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(RegistrarEvento.this);
            requestQueue.add(request);


        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }


}





























