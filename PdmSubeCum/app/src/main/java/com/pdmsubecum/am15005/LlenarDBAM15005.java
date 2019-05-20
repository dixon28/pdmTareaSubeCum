package com.pdmsubecum.am15005;

import android.content.Context;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Autor;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.DB.modelo.am15005.TiposDeDocumento;
import com.pdmsubecum.DB.modelo.am15005.TiposDeEquipo;

import java.util.ArrayList;

public class LlenarDBAM15005 {

    private ArrayList<Autor> autors =new ArrayList<Autor>();
    private ArrayList<TiposDeDocumento> tiposD= new ArrayList<TiposDeDocumento>();
    private ArrayList<TiposDeEquipo> tiposE= new ArrayList<TiposDeEquipo>();
    private ArrayList<Marca> marcas=new ArrayList<Marca>();


    public DataBase dataBase;

    public LlenarDBAM15005(Context context) {
        dataBase = new DataBase(context);
        crearMarcas();
        CrearAutor();
        CrearTiposDeDocumento();
        CrearTiposEquipos();
    }

    public void  crearMarcas(){

        marcas.add(new Marca(1,"toshiba"));
        marcas.add(new Marca(2,"hp"));
        marcas.add(new Marca(3,"cisco"));
        marcas.add(new Marca(4,"epson"));
        marcas.add(new Marca(5,"canon"));

        dataBase.llenarMarca(marcas);


    }

    public void CrearTiposEquipos(){

        tiposE.add(new TiposDeEquipo(1,"laptop"));
        tiposE.add(new TiposDeEquipo(2,"proyector"));
        tiposE.add(new TiposDeEquipo(3,"Router"));
        tiposE.add(new TiposDeEquipo(4,"Switch"));
        tiposE.add(new TiposDeEquipo(5,"impresora"));


        dataBase.llenarTiposEquipo(tiposE);





    }

    public void CrearTiposDeDocumento(){

        tiposD.add(new TiposDeDocumento(1,"Revista"));
        tiposD.add(new TiposDeDocumento(2,"Libro"));
        tiposD.add(new TiposDeDocumento(3,"Enciclopedia"));
        tiposD.add(new TiposDeDocumento(4,"Paper"));
        tiposD.add(new TiposDeDocumento(5,"Tesis"));


        dataBase.llenarTiposDeDocumento(tiposD);





    }

    public void CrearAutor(){
        autors.add(new Autor(1,"William","Starllings"));
        autors.add(new Autor(2,"Stuart","Tanenbaum"));
        autors.add(new Autor(3,"Mark","Cannice"));
        autors.add(new Autor(4,"Harry","Perros"));
        autors.add(new Autor(4,"Rusell","Ackoff"));

        dataBase.llenarAutor(autors);


    }



}
