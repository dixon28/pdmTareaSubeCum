package com.pdmsubecum.DB.modelo.pm15007;

import android.content.ContentValues;

/**
 * Created by rodri on 12/05/2019.
 */

public class TipoMovimientoEquipo {
    private int id_tipo_movimiento_equipo;
    private String descripcion;

    public TipoMovimientoEquipo(){}

    public TipoMovimientoEquipo(int id_tipo_movimiento_equipo, String descripcion) {
        this.id_tipo_movimiento_equipo = id_tipo_movimiento_equipo;
        this.descripcion = descripcion;
    }

    public int getId_tipo_movimiento_equipo() {
        return id_tipo_movimiento_equipo;
    }

    public void setId_tipo_movimiento_equipo(int id_tipo_movimiento_equipo) {
        this.id_tipo_movimiento_equipo = id_tipo_movimiento_equipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("id_tipo_movimiento_equipo", id_tipo_movimiento_equipo);
        contentValues.put("descripcion", descripcion);
        return contentValues;
    }
}
