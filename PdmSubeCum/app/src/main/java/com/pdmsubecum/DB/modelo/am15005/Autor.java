package com.pdmsubecum.DB.modelo.am15005;

import android.content.ContentValues;

public class Autor {

    private int idautor;
    private String nombreAutor;
    private String apellidosAutor;

    public Autor() {
    }

    public Autor(int idautor, String nombreAutor, String apellidosAutor) {
        this.idautor = idautor;
        this.nombreAutor = nombreAutor;
        this.apellidosAutor = apellidosAutor;
    }

    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getApellidosAutor() {
        return apellidosAutor;
    }

    public void setApellidosAutor(String apellidosAutor) {
        this.apellidosAutor = apellidosAutor;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("idautor", idautor);
        contentValues.put("nombreautor",nombreAutor);
        contentValues.put("apellidosuator",apellidosAutor);
        return contentValues;
    }
}
