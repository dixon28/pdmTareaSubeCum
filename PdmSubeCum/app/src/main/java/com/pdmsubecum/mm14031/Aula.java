package com.pdmsubecum.mm14031;

import android.content.ContentValues;

public class Aula {

    private int idAula;
    private  String descripcion;

    public Aula() {
    }

    public Aula(int idAula, String descripcion) {
        this.idAula = idAula;
        this.descripcion = descripcion;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("idAula", idAula);
        contentValues.put("descripcion", descripcion);
        return contentValues;
    }
}
