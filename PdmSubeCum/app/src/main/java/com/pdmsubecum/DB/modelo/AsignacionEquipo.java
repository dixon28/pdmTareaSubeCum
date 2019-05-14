package com.pdmsubecum.DB.modelo;

import java.util.Date;

public class AsignacionEquipo {

    private int idAsignacionEquipo;
    private int idDocente;
    private Date fechaAsignacionEquipo;
    private int actualEquipo;

    public AsignacionEquipo() {
    }

    public AsignacionEquipo(int idAsignacionEquipo, int idDocente, Date fechaAsignacionEquipo, int actualEquipo) {
        this.idAsignacionEquipo = idAsignacionEquipo;
        this.idDocente = idDocente;
        this.fechaAsignacionEquipo = fechaAsignacionEquipo;
        this.actualEquipo = actualEquipo;
    }

    public int getIdAsignacionEquipo() {
        return idAsignacionEquipo;
    }

    public void setIdAsignacionEquipo(int idAsignacionEquipo) {
        this.idAsignacionEquipo = idAsignacionEquipo;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public Date getFechaAsignacionEquipo() {
        return fechaAsignacionEquipo;
    }

    public void setFechaAsignacionEquipo(Date fechaAsignacionEquipo) {
        this.fechaAsignacionEquipo = fechaAsignacionEquipo;
    }

    public int getActualEquipo() {
        return actualEquipo;
    }

    public void setActualEquipo(int actualEquipo) {
        this.actualEquipo = actualEquipo;
    }
}