package com.pdmsubecum.mm14031;

import android.content.ContentValues;

public class Dia {

    private int idDia;
    private String descripcion;

    public Dia() {
    }

    public Dia(int idDia, String descripcion) {
        this.idDia = idDia;
        this.descripcion = descripcion;
    }

    public int getIdDia() {
        return idDia;
    }

    public void setIdDia(int idDia) {
        this.idDia = idDia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("idDia", idDia);
        contentValues.put("descripcion", descripcion);
        return contentValues;
    }
}
