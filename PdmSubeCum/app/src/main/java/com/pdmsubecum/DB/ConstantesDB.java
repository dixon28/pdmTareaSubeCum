package com.pdmsubecum.DB;

/**
 * Created by rodri on 10/05/2019.
 */

public class ConstantesDB {

    //nombre base de datos
    public static  final String DATABASE ="inventario.s3db";

    //nombre de las tablas
    public static  final String TABLA_USUARIO ="usuario";
    public static  final String TABLA_ROL_USUARIO ="rol_usuario";

    //querys para crear las tablas

    public static final String SQL_CREATE_TABLE_USUARIO="CREATE TABLE " +TABLA_USUARIO +
            "( usuario VARCHAR(20) NOT NULL PRIMARY KEY," +
            "password VARCHAR(30) NOT NULL )";

    public static final String SQL_CREATE_TABLE_ROL_USUARIO="CREATE TABLE " +TABLA_ROL_USUARIO +
            "( nombre_rol VARCHAR(20) NOT NULL, usuario VARCHAR(20) NOT NULL, PRIMARY KEY(nombre_rol,usuario))";




    //query para borrar toda la DB
    public static  final String SQL_DELETE_USUARIO = "DROP TABLE "+TABLA_USUARIO;
    public static  final String SQL_DELETE_ROL_USUARIO = "DROP TABLE "+TABLA_ROL_USUARIO;


    //campos de las tablas
    public static final String[] CAMPOS_ALUMNO = {"usuario","password"};




}
