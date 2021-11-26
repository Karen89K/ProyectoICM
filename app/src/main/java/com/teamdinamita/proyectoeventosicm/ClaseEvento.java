package com.teamdinamita.proyectoeventosicm;

public class ClaseEvento {
    String id_evento, nombre, descripcion, fecha, direccion, entorno, foro, estado;

    public ClaseEvento() {
    }

    public ClaseEvento(String id_evento, String nombre, String descripcion, String fecha, String direccion, String entorno, String foro, String estado) {
        this.id_evento = id_evento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.direccion = direccion;
        this.entorno = entorno;
        this.foro = foro;
        this.estado = estado;
    }

    public String getId_evento() {
        return id_evento;
    }

    public void setId_evento(String id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEntorno() {
        return entorno;
    }

    public void setEntorno(String entorno) {
        this.entorno = entorno;
    }

    public String getForo() {
        return foro;
    }

    public void setForo(String foro) {
        this.foro = foro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}


