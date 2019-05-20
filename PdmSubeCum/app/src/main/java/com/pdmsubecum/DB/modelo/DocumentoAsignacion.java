package com.pdmsubecum.DB.modelo;


public class DocumentoAsignacion {

    private int idDocumentoAsignacion;
    private int idDocente;
    private String motivo;
    private String fechaAsignacionDoc;


    public DocumentoAsignacion() {
    }

    public DocumentoAsignacion(int idDocumentoAsignacion, int idDocente, String motivo, String fechaAsignacionDoc) {
        this.idDocumentoAsignacion = idDocumentoAsignacion;
        this.idDocente = idDocente;
        this.motivo = motivo;
        this.fechaAsignacionDoc = fechaAsignacionDoc;
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

    public String getFechaAsignacionDoc() {
        return fechaAsignacionDoc;
    }

    public void setFechaAsignacionDoc(String fechaAsignacionDoc) {
        this.fechaAsignacionDoc = fechaAsignacionDoc;
    }
}