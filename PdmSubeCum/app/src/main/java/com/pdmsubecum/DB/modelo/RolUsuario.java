package com.pdmsubecum.DB.modelo;

import android.content.ContentValues;

/**
 * Created by rodri on 10/05/2019.
 */

public class RolUsuario {

    private String nombre_rol;
    private String usuario;

    public RolUsuario(){}

    public RolUsuario(String nombre_rol, String usuario) {
        this.nombre_rol = nombre_rol;
        this.usuario = usuario;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("nombre_rol", nombre_rol);
        contentValues.put("usuario", usuario);
        return contentValues;
    }
}
