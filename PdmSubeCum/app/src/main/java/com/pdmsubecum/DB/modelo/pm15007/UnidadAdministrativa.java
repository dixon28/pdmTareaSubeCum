package com.pdmsubecum.DB.modelo.pm15007;

import android.content.ContentValues;

/**
 * Created by rodri on 12/05/2019.
 */

public class UnidadAdministrativa {
    private int id_unidad_administrativa;
    private String descripcion;

    public UnidadAdministrativa(int id_unidad_administrativa, String descripcion) {
        this.id_unidad_administrativa = id_unidad_administrativa;
        this.descripcion = descripcion;
    }

    public UnidadAdministrativa(){}

    public int getId_unidad_administrativa() {
        return id_unidad_administrativa;
    }

    public void setId_unidad_administrativa(int id_unidad_administrativa) {
        this.id_unidad_administrativa = id_unidad_administrativa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("id_unidad_administrativa", id_unidad_administrativa);
        contentValues.put("descripcion", descripcion);
        return contentValues;
    }

}
