package com.pdmsubecum.DB.modelo;

import java.util.Date;

public class DocumentoAsignacion {

    private int idDocumentoAsignacion;
    private int idDocente;
    private String motivo;
    private Date FechaAsignacionDoc;
    private int actualDoc;

    public DocumentoAsignacion() {
    }

    public DocumentoAsignacion(int idDocumentoAsignacion, int idDocente, String motivo, Date fechaAsignacionDoc, int actualDoc) {
        this.idDocumentoAsignacion = idDocumentoAsignacion;
        this.idDocente = idDocente;
        this.motivo = motivo;
        FechaAsignacionDoc = fechaAsignacionDoc;
        this.actualDoc = actualDoc;
    }

    public int getIdDocumentoAsignacion() {
        return idDocumentoAsignacion;
    }

    public void setIdDocumentoAsignacion(int idDocumentoAsignacion) {
        this.idDocumentoAsignacion = idDocumentoAsignacion;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaAsignacionDoc() {
        return FechaAsignacionDoc;
    }

    public void setFechaAsignacionDoc(Date fechaAsignacionDoc) {
        FechaAsignacionDoc = fechaAsignacionDoc;
    }

    public int getActualDoc() {
        return actualDoc;
    }

    public void setActualDoc(int actualDoc) {
        this.actualDoc = actualDoc;
    }
}