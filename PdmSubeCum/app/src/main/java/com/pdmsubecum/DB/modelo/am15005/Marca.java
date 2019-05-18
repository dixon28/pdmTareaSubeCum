package com.pdmsubecum.DB.modelo.am15005;

import android.content.ContentValues;

public class Marca {

    private int idmarca;
    private String descripcionmarca;

    public Marca() {
    }

    public Marca(int idmarca, String descripcionmarca) {
        this.idmarca = idmarca;
        this.descripcionmarca = descripcionmarca;
    }


    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public String getDescripcionmarca() {
        return descripcionmarca;
    }

    public void setDescripcionmarca(String descripcionmarca) {
        this.descripcionmarca = descripcionmarca;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("idmarca", idmarca);
        contentValues.put("descripcionmarca", descripcionmarca);
        return contentValues;
    }
}
