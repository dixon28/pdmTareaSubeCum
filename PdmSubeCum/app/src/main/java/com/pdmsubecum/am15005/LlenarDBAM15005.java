package com.pdmsubecum.am15005;

import android.content.Context;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Autor;
import com.pdmsubecum.DB.modelo.am15005.AutorDetalle;
import com.pdmsubecum.DB.modelo.am15005.Documento;
import com.pdmsubecum.DB.modelo.am15005.Equipo;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.DB.modelo.am15005.TiposDeDocumento;
import com.pdmsubecum.DB.modelo.am15005.TiposDeEquipo;

import java.util.ArrayList;

public class LlenarDBAM15005 {

    private ArrayList<Autor> autors =new ArrayList<Autor>();
    private ArrayList<TiposDeDocumento> tiposD= new ArrayList<TiposDeDocumento>();
    private ArrayList<TiposDeEquipo> tiposE= new ArrayList<TiposDeEquipo>();
    private ArrayList<Marca> marcas=new ArrayList<Marca>();
    private ArrayList<Equipo> equipos= new ArrayList<>();
    private ArrayList<AutorDetalle> autorDetalles= new ArrayList<>();
    private ArrayList<Documento> documentos= new ArrayList<>();


    public DataBase dataBase;

    public LlenarDBAM15005(Context context) {
        dataBase = new DataBase(context);
        crearMarcas();
        CrearAutor();
        CrearTiposDeDocumento();
        CrearTiposEquipos();
        crearEquipos();
        crearAutorDetalle();
        crearDocumento();
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
        autors.add(new Autor(5,"Rusell","Ackoff"));

        dataBase.llenarAutor(autors);


    }
    public void crearEquipos(){


        equipos.add(new Equipo(1,1,1,"plata","nuevas actualizaciones","eq1","2019-01-21",true));
        equipos.add(new Equipo(2,3,2,"diamante","equipo nuevo","eq2","2019-02-22",false));
        equipos.add(new Equipo(3,5,4,"oro","moderno","eq3","2019-03-19",true));
        equipos.add(new Equipo(4,4,3,"platino","no debe utilizarse por altas horas","eq4","2019-05-31",false));
        equipos.add(new Equipo(5,2,5,"gx-3","donativo de equipo nuevo","eq5","2019-04-02",true));


        dataBase.llenarEquipos(equipos);




    }


    public void crearAutorDetalle(){

        autorDetalles.add(new AutorDetalle("00000001",1));
        autorDetalles.add(new AutorDetalle("00000002",2));
        autorDetalles.add(new AutorDetalle("00000003",3));
        autorDetalles.add(new AutorDetalle("00000004",4));
        autorDetalles.add(new AutorDetalle("00000005",5));

        dataBase.llenarAutorDetalle(autorDetalles);


    }

    public void crearDocumento(){
        documentos.add(new Documento("00000001",1,"manual","ingles","manual para buenas practicas de programacion",true));
        documentos.add(new Documento("00000002",2,"programacion en c","esp","libro paa programacion",false));
        documentos.add(new Documento("00000003",3,"Teoria de sistemas","ingles","libro para la asignatura de teoria de sistemas",true));
        documentos.add(new Documento("00000004",4,"Administracion","frances","Libro de administracion",false));
        documentos.add(new Documento("00000005",5,"redes de computadora","esp","libro para la asignatura de comunicaciones",true));

        dataBase.llenarDocumento(documentos);
    }





}
