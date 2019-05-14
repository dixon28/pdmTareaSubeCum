package com.pdmsubecum.DB;

/**
 * Created by rodri on 10/05/2019.
 */

public class ConstantesDB {

    //----------------------------------------------------
    // nombre base de datos
    //----------------------------------------------------
    public static  final String DATABASE ="inventario.s3db";



    //-----------------------------------------------------
    // nombre de las tablas
    // ----------------------------------------------------
    public static  final String TABLA_USUARIO ="usuario";
    public static  final String TABLA_ROL_USUARIO ="rol_usuario";

    //PM15007
    public static final String TABLA_UNIDAD_ADMINISTRATIVA = "unidad_administrativa";
    public static final String TABLA_EQUIPO_MOVIMIENTO = "equipo_movimiento";
    public static final String TABLA_TIPO_MOVIMIENTO_EQUIPO = "tipo_movimiento_equipo";
    public static final String TABLA_EQUIPO_MOVIMIENTO_DETALLE = "equipo_movimiento_detalle";
    public static final String TABLA_EQUIPO_EXISTENCIA = "equipo_existencia";



    //-----------------------------------------------------
    // queries para crear las tablas
    // ----------------------------------------------------
    public static final String SQL_CREATE_TABLE_USUARIO="CREATE TABLE " +TABLA_USUARIO +
            "( usuario VARCHAR(20) NOT NULL PRIMARY KEY," +
            "password VARCHAR(30) NOT NULL )";

    public static final String SQL_CREATE_TABLE_ROL_USUARIO="CREATE TABLE " +TABLA_ROL_USUARIO +
            "( nombre_rol VARCHAR(20) NOT NULL, usuario VARCHAR(20) NOT NULL, PRIMARY KEY(nombre_rol,usuario))";



    //PM15007
    public static final String SQL_CREATE_TABLE_UNIDAD_ADMINISTRATIVA = "CREATE TABLE "+TABLA_UNIDAD_ADMINISTRATIVA +
            "(id_unidad_administrativa INTEGER NOT NULL PRIMARY KEY, "+
            "descripcion VARCHAR(100))";
    public static final String SQL_CREATE_TABLE_EQUIPO_MOVIMIENTO = "CREATE TABLE "+TABLA_EQUIPO_MOVIMIENTO +
            "(id_equipo_movimiento INTEGER NOT NULL PRIMARY KEY, " +
            "id_tipo_movimiento_equipo INTEGER NOT NULL, " +
            "id_u_administrativa_origen INTEGER NOT NULL, "+
            "id_u_administrativa_destino INTEGER NOT NULL, "+
            "comentario VARCHAR(100) NOT NULL, "+
            "fecha_movimiento TEXT NOT NULL)";
    public static final String SQL_CREATE_TABLE_TIPO_MOVIMIENTO_EQUIPO = "CREATE TABLE " +TABLA_TIPO_MOVIMIENTO_EQUIPO +
            "(id_tipo_movimiento_equipo INTEGER NOT NULL PRIMARY KEY, "+
            "descripcion VARCHAR(50) NOT NULL)";
    public static final String SQL_CREATE_TABLE_EQUIPO_MOVIMIENTO_DETALLE = "CREATE TABLE "+TABLA_EQUIPO_MOVIMIENTO_DETALLE +
            "(id_equipo_movimiento_detalle INTEGER NOT NULL PRIMARY KEY, "+
            "id_equipo INTEGER NOT NULL, "+
            "id_equipo_movimiento INTEGER NOT NULL)";
    public static final String SQL_CREATE_TABLE_EQUIPO_EXISTENCIA = "CREATE TABLE "+TABLA_EQUIPO_EXISTENCIA +
            "(id_equipo_existencia INTEGER NOT NULL PRIMARY KEY, "+
            "id_equipo INTEGER NOT NULL, "+
            "id_docente INTEGER NOT NULL, "+
            "id_unidad_administrativa INTEGER NOT NULL, "+
            "actual INTEGER NOT NULL)";


    //-----------------------------------------------------
    // query para borrar toda la DB
    // ----------------------------------------------------
    public static  final String SQL_DELETE_USUARIO = "DROP TABLE "+TABLA_USUARIO;
    public static  final String SQL_DELETE_ROL_USUARIO = "DROP TABLE "+TABLA_ROL_USUARIO;

    //PM15007
    public static final String SQL_DELETE_UNIDAD_ADMINISTRATIVA = "DROP TABLE "+TABLA_UNIDAD_ADMINISTRATIVA;
    public static final String SQL_DELETE_EQUIPO_MOVIMIENTO = "DROP TABLE "+ TABLA_EQUIPO_MOVIMIENTO;
    public static final String SQL_DELETE_TIPO_MOVIMIENTO_EQUIPO = "DROP TABLE "+TABLA_TIPO_MOVIMIENTO_EQUIPO;
    public static final String SQL_DELETE_EQUIPO_MOVIMIENTO_DETALLE ="DROP TABLE "+TABLA_EQUIPO_MOVIMIENTO_DETALLE;
    public static final String SQL_DELETE_EQUIPO_EXISTENCIA = "DROP TABLE "+TABLA_EQUIPO_EXISTENCIA;



    //-----------------------------------------------------
    // campos de las tablas
    // ----------------------------------------------------
    public static final String[] CAMPOS_USUARIO = {"usuario","password"};
    public static final String[] CAMPOS_ROL_USUARIO = {"nombre_rol","usuario"};

    //PM15007
    public static final String[] CAMPOS_EQUIPO_EXISTENCIA = {"id_equipo_existencia","id_equipo", "id_docente",
            "id_unidad_administrativa","actual"};
    public static final String[] CAMPOS_EQUIPO_MOVIMIENTO = {"id_equipo_movimiento","id_tipo_movimiento_equipo",
            "id_u_administrativa_origen","id_u_administrativa_destino", "comentario", "fecha_movimiento"};
    public static final String[] CAMPOS_EQUIPO_MOVIMIENTO_DETALLE = {"id_equipo_movimiento_detalle",
            "id_equipo", "id_equipo_movimiento"};
    public static final String[] CAMPOS_TIPO_MOVIMIENTO_EQUIPO = {"id_tipo_movimiento_equipo","descripcion"};
    public static final String[] CAMPOS_UNIDAD_ADMINISTRATIVA ={"id_unidad_administrativa", "descripcion"};


//AM15005
    //Tablas
    public static final String TABLA_MARCA="marca";
    public static  final String TABLA_TIPOS_DE_EQUIPO="tipos_de_equipo";
    public static final String TABLA_EQUIPO="equipo";


    //Consultas para crear tablas
    public static final String SQL_CREATE_TABLE_MARCA="CREATE TABLE "+TABLA_MARCA +"(IDMARCA INTEGER not null,"+
            "DESCRIPCIONMARCA VARCHAR2(50),"+
            "constraint PK_MARCA primary key (IDMARCA))";



    //Borrar Tablas
    public static  final String SQL_DELETE_MARCA = "DROP TABLE "+TABLA_MARCA;








}
