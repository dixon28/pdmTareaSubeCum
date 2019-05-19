package com.pdmsubecum.DB.modelo.am15005;

import android.content.ContentValues;

public class TiposDeEquipo {
    private int idTiposDeEquipo;
    private String descripcionTipEquipo;

    public TiposDeEquipo() {
    }

    public TiposDeEquipo(int idTiposDeEquipo, String descripcionTipEquipo) {
        this.idTiposDeEquipo = idTiposDeEquipo;
        this.descripcionTipEquipo = descripcionTipEquipo;
    }

    public int getIdTiposDeEquipo() {
        return idTiposDeEquipo;
    }

    public void setIdTiposDeEquipo(int idTiposDeEquipo) {
        this.idTiposDeEquipo = idTiposDeEquipo;
    }

    public String getDescripcionTipEquipo() {
        return descripcionTipEquipo;
    }

    public void setDescripcionTipEquipo(String descripcionTipEquipo) {
        this.descripcionTipEquipo = descripcionTipEquipo;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("idtiposdeequipo", idTiposDeEquipo);
        contentValues.put("descripciontipequipo", descripcionTipEquipo);
        return contentValues;
    }
}
