package com.pdmsubecum.DB.modelo.am15005;

import android.content.ContentValues;

public class Marca {

    private int idmarca;
    private String descripcion;

    public Marca() {
    }

    public Marca(int idmarca, String descripcion) {
        this.idmarca = idmarca;
        this.descripcion = descripcion;
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("idmarca", idmarca);
        contentValues.put("descripcion", descripcion);
        return contentValues;
    }
}
