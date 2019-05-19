package com.pdmsubecum.DB.modelo.am15005;

import android.content.ContentValues;

public class AutorDetalle {

    private String isbn;
    private int idautor;

    public AutorDetalle() {
    }

    public AutorDetalle(String isbn, int idautor) {
        this.isbn = isbn;
        this.idautor = idautor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }


    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("isbn", isbn);
        contentValues.put("idautor", idautor);
        return contentValues;
    }
}
