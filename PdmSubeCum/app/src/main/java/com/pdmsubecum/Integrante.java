package com.pdmsubecum;

/**
 * Created by rodri on 10/05/2019.
 */

public class Integrante {
    private String nombre;
    private String carnet;
    private String tablas;
    private int imagen;

    public  Integrante(){}

    public Integrante(String nombre, String carnet, String tablas, int imagen) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.tablas = tablas;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getTablas() {
        return tablas;
    }

    public void setTablas(String tablas) {
        this.tablas = tablas;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
