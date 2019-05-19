package com.pdmsubecum.mm14031;

import android.content.ContentValues;

public class HorarioDetalle {

    private int idGrupo;
    private int idHoraio;

    public HorarioDetalle() {
    }

    public HorarioDetalle(int idGrupo, int idHoraio) {
        this.idGrupo = idGrupo;
        this.idHoraio = idHoraio;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdHoraio() {
        return idHoraio;
    }

    public void setIdHoraio(int idHoraio) {
        this.idHoraio = idHoraio;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("idGrupo", idGrupo);
        contentValues.put("idHorario", idHoraio);
        return contentValues;
    }
}
