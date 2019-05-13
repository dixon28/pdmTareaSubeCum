package com.pdmsubecum.DB.modelo.pm15007;

import android.content.ContentValues;

/**
 * Created by rodri on 12/05/2019.
 */

public class EquipoMovimientoDetalle {
    private int id_equipo_movimiento_detalle;
    private int id_equipo;
    private int id_equipo_movimiento;

    public EquipoMovimientoDetalle(){}

    public EquipoMovimientoDetalle(int id_equipo_movimiento_detalle, int id_equipo, int id_equipo_movimiento) {
        this.id_equipo_movimiento_detalle = id_equipo_movimiento_detalle;
        this.id_equipo = id_equipo;
        this.id_equipo_movimiento = id_equipo_movimiento;
    }

    public int getId_equipo_movimiento_detalle() {
        return id_equipo_movimiento_detalle;
    }

    public void setId_equipo_movimiento_detalle(int id_equipo_movimiento_detalle) {
        this.id_equipo_movimiento_detalle = id_equipo_movimiento_detalle;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public int getId_equipo_movimiento() {
        return id_equipo_movimiento;
    }

    public void setId_equipo_movimiento(int id_equipo_movimiento) {
        this.id_equipo_movimiento = id_equipo_movimiento;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("id_equipo_movimiento_detalle", id_equipo_movimiento_detalle);
        contentValues.put("id_equipo", id_equipo);
        contentValues.put("id_equipo_movimiento", id_equipo_movimiento);
        return contentValues;
    }
}
