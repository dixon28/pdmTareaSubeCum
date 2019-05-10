package com.pdmsubecum.DB.modelo;

import android.content.ContentValues;

/**
 * Created by rodri on 10/05/2019.
 */

public class Usuario {
    private String usuario;
    private String password;

    public Usuario(){
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("usuario",usuario);
        contentValues.put("password", password);
        return  contentValues;
    }
}
