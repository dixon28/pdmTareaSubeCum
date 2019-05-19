package com.pdmsubecum.mm14031;

import android.content.ContentValues;

public class Ciclo {

    private int idCiclo;
    private String numero;
    private int year;

    public Ciclo() {
    }

    public Ciclo(int idCiclo, String numero, int year) {
        this.idCiclo = idCiclo;
        this.numero = numero;
        this.year = year;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("idCiclo", idCiclo);
        contentValues.put("numero", numero);
        contentValues.put("year",year);
        return contentValues;
    }
}
