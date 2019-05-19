package com.pdmsubecum.mm14031;

import android.content.ContentValues;
import android.util.EventLogTags;

public class Grupo {

    private int idGrupo;
    private String codigoMateria;
    private int idDocente;
    private String descripcion;

    public Grupo() {
    }

    public Grupo(int idGrupo, String codigoMateria, int idDocente, String descripcion) {
        this.idGrupo = idGrupo;
        this.codigoMateria = codigoMateria;
        this.idDocente = idDocente;
        this.descripcion = descripcion;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("idGrupo", idGrupo);
        contentValues.put("codigoMateria", codigoMateria);
        contentValues.put("idDocente",idDocente);
        contentValues.put("descripcion", descripcion);
        return contentValues;
    }
}
