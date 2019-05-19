package com.pdmsubecum.DB.modelo.pm15007;

import android.content.ContentValues;

/**
 * Created by rodri on 12/05/2019.
 */

public class EquipoExistencia {
    private int id_equipo_existencia;
    private int id_equipo;
    private int id_docente;
    private int id_unidad_administrativa;
    private int actual;

    public EquipoExistencia(){}

    public EquipoExistencia(int id_equipo_existencia, int id_equipo, int id_docente, int id_unidad_administrativa, int actual) {
        this.id_equipo_existencia = id_equipo_existencia;
        this.id_equipo = id_equipo;
        this.id_docente = id_docente;
        this.id_unidad_administrativa = id_unidad_administrativa;
        this.actual = actual;
    }

    public int getId_equipo_existencia() {
        return id_equipo_existencia;
    }

    public void setId_equipo_existencia(int id_equipo_existencia) {
        this.id_equipo_existencia = id_equipo_existencia;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public int getId_unidad_administrativa() {
        return id_unidad_administrativa;
    }

    public void setId_unidad_administrativa(int id_unidad_administrativa) {
        this.id_unidad_administrativa = id_unidad_administrativa;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(5);
        contentValues.put("id_equipo_existencia", id_equipo_existencia);
        contentValues.put("id_equipo",id_equipo);
        contentValues.put("id_docente", id_docente);
        contentValues.put("id_unidad_administrativa", id_unidad_administrativa);
        contentValues.put("actual", actual);
        return contentValues;
    }

}
