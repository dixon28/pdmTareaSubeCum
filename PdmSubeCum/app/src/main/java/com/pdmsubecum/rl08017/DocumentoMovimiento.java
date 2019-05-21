package com.pdmsubecum.rl08017;

public class DocumentoMovimiento {

    public int getIdDocMov() {
        return idDocMov;
    }

    public void setIdDocMov(int idDocMov) {
        this.idDocMov = idDocMov;
    }

    public int getIdUnidadAdmOrigen() {
        return idUnidadAdmOrigen;
    }

    public void setIdUnidadAdmOrigen(int idUnidadAdmOrigen) {
        this.idUnidadAdmOrigen = idUnidadAdmOrigen;
    }

    public int getIdUnidadAdmDestino() {
        return idUnidadAdmDestino;
    }

    public void setIdUnidadAdmDestino(int idUnidadAdmDestino) {
        this.idUnidadAdmDestino = idUnidadAdmDestino;
    }

    public int getIdTipoMovDoc() {
        return idTipoMovDoc;
    }

    public void setIdTipoMovDoc(int idTipoMovDoc) {
        this.idTipoMovDoc = idTipoMovDoc;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public DocumentoMovimiento() {
    }

    public DocumentoMovimiento(int idDocMov, int idUnidadAdmOrigen, int idUnidadAdmDestino, int idTipoMovDoc, String comentario, String fecha, int idMovDocDetalle, String isbn) {
        this.idDocMov = idDocMov;
        this.idUnidadAdmOrigen = idUnidadAdmOrigen;
        this.idUnidadAdmDestino = idUnidadAdmDestino;
        this.idTipoMovDoc = idTipoMovDoc;
        this.comentario = comentario;
        this.fecha = fecha;
        this.idMovDocDetalle = idMovDocDetalle;
        this.isbn = isbn;
    }

    private int idDocMov;
    private int idUnidadAdmOrigen;
    private int idUnidadAdmDestino;
    private int idTipoMovDoc;
    private String comentario;
    private String fecha;
    private int idMovDocDetalle;
    private String isbn;

    public int getIdMovDocDetalle() {
        return idMovDocDetalle;
    }

    public void setIdMovDocDetalle(int idMovDocDetalle) {
        this.idMovDocDetalle = idMovDocDetalle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }





}
