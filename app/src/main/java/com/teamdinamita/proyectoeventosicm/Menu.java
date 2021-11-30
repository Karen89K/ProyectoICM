package com.teamdinamita.proyectoeventosicm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    NotificationManagerCompat notificationManagerCompat;
    Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("myCh", "My Channel", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "myCh")
                .setSmallIcon(android.R.drawable.stat_notify_sync)
                .setContentTitle("¡Alerta Covid!")
                .setContentText("Un asistente de un evento en común alertó que está contagiado de Covid-19");

        notification = builder.build();

        notificationManagerCompat = NotificationManagerCompat.from(this);
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
        notificationManagerCompat.notify(1, notification);
    }

    public void registrareventos(View view) {
        Intent intent = new Intent(Menu.this, RegistrarEvento.class);
        startActivity(intent);
    }
}