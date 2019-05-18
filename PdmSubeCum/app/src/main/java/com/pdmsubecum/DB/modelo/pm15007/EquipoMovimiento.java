package com.pdmsubecum.DB.modelo.pm15007;

import android.content.ContentValues;

/**
 * Created by rodri on 12/05/2019.
 */

public class EquipoMovimiento {
    private int id_equipo_movimiento;
    private int id_tipo_movimiento_equipo;
    private int id_u_administrativa_origen;
    private int id_u_administrativa_destino;
    private String comentario;
    private String fecha_movimiento;

    public EquipoMovimiento(){}

    public EquipoMovimiento(int id_equipo_movimiento, int id_tipo_movimiento_equipo, int id_u_administrativa_origen, int id_u_administrativa_destino, String comentario, String fecha_movimiento) {
        this.id_equipo_movimiento = id_equipo_movimiento;
        this.id_tipo_movimiento_equipo = id_tipo_movimiento_equipo;
        this.id_u_administrativa_origen = id_u_administrativa_origen;
        this.id_u_administrativa_destino = id_u_administrativa_destino;
        this.comentario = comentario;
        this.fecha_movimiento = fecha_movimiento;
    }

    public int getId_equipo_movimiento() {
        return id_equipo_movimiento;
    }

    public void setId_equipo_movimiento(int id_equipo_movimiento) {
        this.id_equipo_movimiento = id_equipo_movimiento;
    }

    public int getId_tipo_movimiento_equipo() {
        return id_tipo_movimiento_equipo;
    }

    public void setId_tipo_movimiento_equipo(int id_tipo_movimiento_equipo) {
        this.id_tipo_movimiento_equipo = id_tipo_movimiento_equipo;
    }

    public int getId_u_administrativa_origen() {
        return id_u_administrativa_origen;
    }

    public void setId_u_administrativa_origen(int id_u_administrativa_origen) {
        this.id_u_administrativa_origen = id_u_administrativa_origen;
    }

    public int getId_u_administrativa_destino() {
        return id_u_administrativa_destino;
    }

    public void setId_u_administrativa_destino(int id_u_administrativa_destino) {
        this.id_u_administrativa_destino = id_u_administrativa_destino;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha_movimiento() {
        return fecha_movimiento;
    }

    public void setFecha_movimiento(String fecha_movimiento) {
        this.fecha_movimiento = fecha_movimiento;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(6);
        contentValues.put("id_equipo_movimiento", id_equipo_movimiento);
        contentValues.put("id_tipo_movimiento_equipo", id_tipo_movimiento_equipo);
        contentValues.put("id_u_administrativa_origen", id_u_administrativa_origen);
        contentValues.put("id_u_administrativa_destino", id_u_administrativa_destino);
        contentValues.put("comentario", comentario);
        contentValues.put("fecha_movimiento", fecha_movimiento);
        return contentValues;
}
}
