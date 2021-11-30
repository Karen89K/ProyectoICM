package com.teamdinamita.proyectoeventosicm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MisEventos extends AppCompatActivity {

    ListView listView;
    adaptador adapter;
    String url = "https://zjbicqfh.lucusvirtual.es/mostrarmiseventos.php";
    ClaseEvento evento;
    public static ArrayList<ClaseEvento> eventoArrayList = new ArrayList<>();
    String eventoCuerpo[] = new String[8];
    Button volver;
    String correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_eventos);
        Bundle correoB = getIntent().getExtras();
        System.out.println(correoB);
        if (correoB != null) {
            correo = correoB.getString("correoUs");
        }
        listView = findViewById(R.id.myListView);
        adapter = new adaptador(this, eventoArrayList);
        listView.setAdapter(adapter);
        volver = (Button)findViewById(R.id.id_regresar);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {
                        "Descripcion: " + eventoArrayList.get(position).getDescripcion() + '\n' + "Fecha: " + eventoArrayList.get(position).getFecha() + '\n' + "Direccion: "
                        + eventoArrayList.get(position).getDireccion() + '\n' + "Entorno: " + eventoArrayList.get(position).getEntorno() + '\n' + "Foro: " + eventoArrayList.get(position).getForo() +
                        '\n' + "Estado: " + eventoArrayList.get(position).getEstado()
                };
                builder.setTitle(eventoArrayList.get(position).getNombre());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                });


                builder.create().show();


            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MisEventos.this, Menu.class);
                intent.putExtra("correoUs",correo);
                startActivity(intent);
            }
        });

        retrieveData();
    }

    public void retrieveData() {

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        eventoArrayList.clear();
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            System.out.println(jsonObject);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("datos");

                            if (exito.equals("1")) {
                                System.out.println("entro");

                                for (int i = 0; i < jsonArray.length(); i++) {

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    eventoCuerpo[0] = object.getString("id_evento");
                                    eventoCuerpo[1] = object.getString("nombre");
                                    eventoCuerpo[2] = object.getString("descripcion");
                                    eventoCuerpo[3] = object.getString("fecha");
                                    eventoCuerpo[4] = object.getString("direccion");
                                    eventoCuerpo[5] = object.getString("entorno");
                                    eventoCuerpo[6] = object.getString("foro");
                                    eventoCuerpo[7] = object.getString("estado");

                                    evento = new ClaseEvento(eventoCuerpo[0], eventoCuerpo[1], eventoCuerpo[2], eventoCuerpo[3], eventoCuerpo[4], eventoCuerpo[5], eventoCuerpo[6], eventoCuerpo[7]);
                                    eventoArrayList.add(evento);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MisEventos.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }


}