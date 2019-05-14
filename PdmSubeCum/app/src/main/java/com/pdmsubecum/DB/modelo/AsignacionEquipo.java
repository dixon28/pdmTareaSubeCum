package com.pdmsubecum.DB.modelo;

public class AsignacionEquipo {

    private int idAsignacionEquipo;
    private int idDocente;
    private String fechaAsignacionEquipo;
    private int actualEquipo;

    public AsignacionEquipo() {
    }

    public AsignacionEquipo(int idAsignacionEquipo, int idDocente, String fechaAsignacionEquipo, int actualEquipo) {
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

    public String getFechaAsignacionEquipo() {
        return fechaAsignacionEquipo;
    }

    public void setFechaAsignacionEquipo(String fechaAsignacionEquipo) {
        this.fechaAsignacionEquipo = fechaAsignacionEquipo;
    }

    public int getActualEquipo() {
        return actualEquipo;
    }

    public void setActualEquipo(int actualEquipo) {
        this.actualEquipo = actualEquipo;
    }
}