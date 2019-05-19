package com.pdmsubecum.DB.modelo.am15005;

import android.content.ContentValues;

public class Documento {

private String isbn;
private int idtiposdedocumento;
private String nombredoc ;
private  String idioma;
private String        descripciondoc;
private String        disponibledoc;


    public Documento() {

    }

    public Documento(String isbn, int idtiposdedocumento, String nombredoc, String idioma, String descripciondoc, String disponibledoc) {
        this.isbn = isbn;
        this.idtiposdedocumento = idtiposdedocumento;
        this.nombredoc = nombredoc;
        this.idioma = idioma;
        this.descripciondoc = descripciondoc;
        this.disponibledoc = disponibledoc;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getIdtiposdedocumento() {
        return idtiposdedocumento;
    }

    public void setIdtiposdedocumento(int idtiposdedocumento) {
        this.idtiposdedocumento = idtiposdedocumento;
    }

    public String getNombredoc() {
        return nombredoc;
    }

    public void setNombredoc(String nombredoc) {
        this.nombredoc = nombredoc;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDescripciondoc() {
        return descripciondoc;
    }

    public void setDescripciondoc(String descripciondoc) {
        this.descripciondoc = descripciondoc;
    }

    public String getDisponibledoc() {
        return disponibledoc;
    }

    public void setDisponibledoc(String disponibledoc) {
        this.disponibledoc = disponibledoc;
    }


    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("isbn", isbn);
        contentValues.put("idtiposdedocumentos",idtiposdedocumento);
        contentValues.put("nombredoc",nombredoc);
        contentValues.put("idioma",idioma);
        contentValues.put("descripciondoc",descripciondoc);
        contentValues.put("disponible",disponibledoc);
        return contentValues;
    }
}
