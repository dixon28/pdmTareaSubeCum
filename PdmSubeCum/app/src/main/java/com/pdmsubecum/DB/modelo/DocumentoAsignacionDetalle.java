package com.pdmsubecum.DB.modelo;

public class DocumentoAsignacionDetalle {

    private int idDocumentoAsignacionDetalle;
    private String isbn;
    private int idDocumentoAsignacion;

    public DocumentoAsignacionDetalle() {
    }

    public DocumentoAsignacionDetalle(int idDocumentoAsignacionDetalle, String isbn, int idDocumentoAsignacion) {
        this.idDocumentoAsignacionDetalle = idDocumentoAsignacionDetalle;
        this.isbn = isbn;
        this.idDocumentoAsignacion = idDocumentoAsignacion;
    }

    public int getIdDocumentoAsignacionDetalle() {
        return idDocumentoAsignacionDetalle;
    }

    public void setIdDocumentoAsignacionDetalle(int idDocumentoAsignacionDetalle) {
        this.idDocumentoAsignacionDetalle = idDocumentoAsignacionDetalle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getIdDocumentoAsignacion() {
        return idDocumentoAsignacion;
    }

    public void setIdDocumentoAsignacion(int idDocumentoAsignacion) {
        this.idDocumentoAsignacion = idDocumentoAsignacion;
    }
}
