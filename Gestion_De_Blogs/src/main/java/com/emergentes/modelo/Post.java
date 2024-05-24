package com.emergentes.modelo;

import java.sql.Date;

public class Post {
    private int id;
    private Date fecha;
    private String titulo;
    private String contenido;

    public Post(int id, Date fecha, String titulo, String contenido) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public Post() {
        this.id = 0;
        this.fecha = new Date(System.currentTimeMillis());;
        this.titulo = "";
        this.contenido = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
}
