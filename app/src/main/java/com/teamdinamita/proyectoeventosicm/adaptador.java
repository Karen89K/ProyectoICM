package com.teamdinamita.proyectoeventosicm;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class adaptador extends ArrayAdapter<ClaseEvento> {

        Context context;
        List<ClaseEvento> arrayEventos;

        public adaptador(@NonNull Context context, List<ClaseEvento> arrayEventos) {
            super(context, R.layout.list_eventosdisponibles,arrayEventos);
            this.context =context;
            this.arrayEventos =arrayEventos;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_eventosdisponibles,null,true);

            TextView tvID = view.findViewById(R.id.txt_id);
            TextView tvName = view.findViewById(R.id.txt_name);

            tvID.setText(arrayEventos.get(position).getId_evento());
            tvName.setText(arrayEventos.get(position).getNombre());

            return view;
        }

}
