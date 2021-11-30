package com.teamdinamita.proyectoeventosicm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {
    String  correo;
    String  arregloDatos [] = new String [2];
    NotificationManagerCompat notificationManagerCompat;
    Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("myCh", "My Channel", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "myCh")
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle("¡Alerta Covid!")
                .setContentText("Un asistente de un evento en común alertó que está contagiado de Covid-19");

        notification = builder.build();
        notificationManagerCompat = NotificationManagerCompat.from(this);
        Bundle correoB = getIntent().getExtras();
        System.out.println(correoB);
        if (correoB != null) {
            correo = correoB.getString("correoUs");
        }
        this.arregloDatos[0]=correo;
    }


    public void Eventos(View view) {
        Intent intent = new Intent(Menu.this, Eventos.class);
        intent.putExtra("correoUs", correo);
        startActivity(intent);
    }

    public void MisEventos(View view) {
        Intent intent = new Intent(Menu.this, MisEventos.class);
        intent.putExtra("correoUs", correo);
        startActivity(intent);
    }

    public void MedidasSanitarias(View view) {
        this.arregloDatos[1]="0";
        Intent intent = new Intent(Menu.this, Medidas_sanitarias.class);
        intent.putExtra("datos", arregloDatos);
        startActivity(intent);
    }

    public void registrareventos(View view) {
        this.arregloDatos[1]="1";
        Intent intent = new Intent(Menu.this, Medidas_sanitarias.class);
        intent.putExtra("datos", arregloDatos);
        startActivity(intent);
    }




    public void Acercade(View view) {
        Intent intent = new Intent(Menu.this, InfoApp.class);
        startActivity(intent);
    }

    public void Salir(View view) {
        notificationManagerCompat.notify(1, notification);
    }


}