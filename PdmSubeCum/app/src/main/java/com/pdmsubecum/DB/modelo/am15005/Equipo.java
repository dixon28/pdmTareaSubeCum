package com.pdmsubecum.DB.modelo.am15005;

import android.content.ContentValues;

import com.pdmsubecum.DB.DataBase;

import java.util.Date;

public class Equipo {

 private int   idequipo;
 private int   idtiposdeequipo;
 private int idmarca;
 private String serie;
 private String caracteristicas;
 private  String modelo;
 private Date fechaingreso;
 private boolean equipodisponible;


    public Equipo() {
    }

    public Equipo(int idequipo, int idtiposdeequipo, int idmarca, String serie, String caracteristicas, String modelo, Date fechaingreso, boolean equipodisponible) {
        this.idequipo = idequipo;
        this.idtiposdeequipo = idtiposdeequipo;
        this.idmarca = idmarca;
        this.serie = serie;
        this.caracteristicas = caracteristicas;
        this.modelo = modelo;
        this.fechaingreso = fechaingreso;
        this.equipodisponible = equipodisponible;
    }


    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }

    public int getIdtiposdeequipo() {
        return idtiposdeequipo;
    }

    public void setIdtiposdeequipo(int idtiposdeequipo) {
        this.idtiposdeequipo = idtiposdeequipo;
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public boolean isEquipodisponible() {
        return equipodisponible;
    }

    public void setEquipodisponible(boolean equipodisponible) {
        this.equipodisponible = equipodisponible;
    }


    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(8);
        contentValues.put("idequipo",idequipo);
        contentValues.put("idmarca",idmarca);
        contentValues.put("idtiposdeequipo",idtiposdeequipo);
        contentValues.put("serie",serie);
        contentValues.put("caracteristicas",caracteristicas);
        contentValues.put("modelo",modelo);
        contentValues.put("fechaingreso",String.valueOf(fechaingreso));
        contentValues.put("fechaingreso",equipodisponible);
        return contentValues;
    }




}
