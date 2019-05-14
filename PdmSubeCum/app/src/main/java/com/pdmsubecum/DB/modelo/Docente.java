package com.pdmsubecum.DB.modelo;

public class Docente {
    private int idDocente;
    private int idUnidadAdministrativa;
    private String nombre;
    private String apellido;
    private String email;

    public Docente (){

    }

    public Docente(int idDocente, int idUnidadAdministrativa, String nombre, String apellido, String email) {
        this.idDocente = idDocente;
        this.idUnidadAdministrativa = idUnidadAdministrativa;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;

    }

    public int getIdDocente() {
        return idDocente;
    }

    public int getIdUnidadAdministrativa() {
        return idUnidadAdministrativa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }


    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public void setIdUnidadAdministrativa(int idUnidadAdministrativa) {
        this.idUnidadAdministrativa = idUnidadAdministrativa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
