package com.pdmsubecum.rl08017;

public class DocumentoExistencia {

    public int getIdDocumentoExistencia() {
        return idDocumentoExistencia;
    }

    public void setIdDocumentoExistencia(int idDocumentoExistencia) {
        this.idDocumentoExistencia = idDocumentoExistencia;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getIdUnidadAdministrativa() {
        return idUnidadAdministrativa;
    }

    public void setIdUnidadAdministrativa(int idUnidadAdministrativa) {
        this.idUnidadAdministrativa = idUnidadAdministrativa;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public DocumentoExistencia(int idDocumentoExistencia, String isbn, int idUnidadAdministrativa, int idDocente, int actual) {
        this.idDocumentoExistencia = idDocumentoExistencia;
        this.isbn = isbn;
        this.idUnidadAdministrativa = idUnidadAdministrativa;
        this.idDocente = idDocente;
        this.actual = actual;
    }

    public DocumentoExistencia() {
    }

    int idDocumentoExistencia;
    String isbn;
    int idUnidadAdministrativa;
    int idDocente;
    int actual;


}
