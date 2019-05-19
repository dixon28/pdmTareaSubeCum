package com.pdmsubecum.mm14031;

import android.content.ContentValues;

import java.util.Date;

public class Horario {

    private int idHorario;
    private int idDia;
    private int idAula;
    private String hora;

    public Horario() {
    }

    public Horario(int idHorario, int idDia, int idAula, String hora) {
        this.idHorario = idHorario;
        this.idDia = idDia;
        this.idAula = idAula;
        this.hora = hora;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdDia() {
        return idDia;
    }

    public void setIdDia(int idDia) {
        this.idDia = idDia;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("idhorario", idHorario);
        contentValues.put("idDia", idDia);
        contentValues.put("idAula",idAula);
        contentValues.put("hora",hora);
        return contentValues;
    }
}
