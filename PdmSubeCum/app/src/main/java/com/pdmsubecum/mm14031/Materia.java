package com.pdmsubecum.mm14031;

import android.content.ContentValues;

public class Materia {
    private String codigoMateria;
    private String nombreMateria;
    private String UV;
    private int idCiclo;

    public Materia() {

    }

    public Materia(String codigoMateria,String nombreMateria, String UV, int idCiclo) {
        this.codigoMateria = codigoMateria;
        this.nombreMateria = nombreMateria;
        this.UV = UV;
        this.idCiclo = idCiclo;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getUV() {
        return UV;
    }

    public void setUV(String UV) {
        this.UV = UV;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("codigoMateria", codigoMateria);
        contentValues.put("nombreMateria", nombreMateria);
        contentValues.put("UV",UV);
        contentValues.put("idCiclo",idCiclo);
        return contentValues;
    }
}
