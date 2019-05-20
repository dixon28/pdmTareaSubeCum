package com.pdmsubecum.rl08017;

import android.content.ContentValues;

public class TiposDeMovimientoParaDocumento {

    private int idTiposDeMovimientoParaDocumento;
    private String descripcionMovimientoDoc;

    public TiposDeMovimientoParaDocumento(int idTiposDeMovimientoParaDocumento, String descripcionMovimientoDoc) {
        this.idTiposDeMovimientoParaDocumento = idTiposDeMovimientoParaDocumento;
        this.descripcionMovimientoDoc = descripcionMovimientoDoc;
    }

    public TiposDeMovimientoParaDocumento() {

    }

    public int getIdTiposDeMovimientoParaDocumento() {
        return idTiposDeMovimientoParaDocumento;
    }

    public void setIdTiposDeMovimientoParaDocumento(int idTiposDeMovimientoParaDocumento) {
        this.idTiposDeMovimientoParaDocumento = idTiposDeMovimientoParaDocumento;
    }

    public String getDescripcionMovimientoDoc() {
        return descripcionMovimientoDoc;
    }

    public void setDescripcionMovimientoDoc(String descripcionMovimientoDoc) {
        this.descripcionMovimientoDoc = descripcionMovimientoDoc;
    }


    public TiposDeMovimientoParaDocumento(int idTiposDeMovimientoParaDocumento) {
        this.idTiposDeMovimientoParaDocumento = idTiposDeMovimientoParaDocumento;
    }

}
