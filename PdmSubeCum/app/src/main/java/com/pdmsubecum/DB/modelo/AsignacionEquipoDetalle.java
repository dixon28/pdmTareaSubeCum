package com.pdmsubecum.DB.modelo;

public class AsignacionEquipoDetalle {
    private int idAsignacionEquipoDetalle;
    private int idEquipo;
    private int idAsignacionEquipo;

    public AsignacionEquipoDetalle() {
    }

    public AsignacionEquipoDetalle(int idAsignacionEquipoDetalle, int idEquipo, int idAsignacionEquipo) {
        this.idAsignacionEquipoDetalle = idAsignacionEquipoDetalle;
        this.idEquipo = idEquipo;
        this.idAsignacionEquipo = idAsignacionEquipo;
    }

    public int getIdAsignacionEquipoDetalle() {
        return idAsignacionEquipoDetalle;
    }

    public void setIdAsignacionEquipoDetalle(int idAsignacionEquipoDetalle) {
        this.idAsignacionEquipoDetalle = idAsignacionEquipoDetalle;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdAsignacionEquipo() {
        return idAsignacionEquipo;
    }

    public void setIdAsignacionEquipo(int idAsignacionEquipo) {
        this.idAsignacionEquipo = idAsignacionEquipo;
    }
}
