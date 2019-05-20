package com.pdmsubecum.DB;

/**
 * Created by rodri on 10/05/2019.
 */

public class ConstantesDB {

    //----------------------------------------------------
    // nombre base de datos
    //----------------------------------------------------
    public static final String DATABASE = "inventario.s3db";


    //-----------------------------------------------------
    // nombre de las tablas
    // ----------------------------------------------------
    public static final String TABLA_USUARIO = "usuario";
    public static final String TABLA_ROL_USUARIO = "rol_usuario";
    //-------------Raul------------------------------------------------------------------------
    public static final String TABLA_Docente = "docente";
    public static final String TABLA_AsignacionEquipo = "AsignacionEquipo";
    public static final String TABLA_DocumentoAsignacion = "DocumentoAsignacion";
    public static final String TABLA_DocumentoAsignacionDetalle = "DocumentoAsignacionDetalle";
    public static final String TABLA_AsignacionEquipoDetalle = "AsignacionEquipoDetalle";
    //-----------------------------------------------------------------------------------------

    //PM15007
    public static final String TABLA_UNIDAD_ADMINISTRATIVA = "unidad_administrativa";
    public static final String TABLA_EQUIPO_MOVIMIENTO = "equipo_movimiento";
    public static final String TABLA_TIPO_MOVIMIENTO_EQUIPO = "tipo_movimiento_equipo";
    public static final String TABLA_EQUIPO_MOVIMIENTO_DETALLE = "equipo_movimiento_detalle";
    public static final String TABLA_EQUIPO_EXISTENCIA = "equipo_existencia";






    //-----------------------------------------------------
    // queries para crear las tablas
    // ----------------------------------------------------
    public static final String SQL_CREATE_TABLE_USUARIO = "CREATE TABLE " + TABLA_USUARIO +
            "( usuario VARCHAR(20) NOT NULL PRIMARY KEY," +
            "password VARCHAR(30) NOT NULL )";

    public static final String SQL_CREATE_TABLE_ROL_USUARIO = "CREATE TABLE " + TABLA_ROL_USUARIO +
            "( nombre_rol VARCHAR(20) NOT NULL, usuario VARCHAR(20) NOT NULL, PRIMARY KEY(nombre_rol,usuario))";

   //-------------------------------Raul------------------------------------------------------------------------------------
    public static final String SQL_CREATE_TABLE_Docente = "CREATE TABLE " + TABLA_Docente +

            "(  idDocente               INTEGER              not null primary key,\n" +
           "   idUnidadAdministrativa   INTEGER, \n" +
           "   nombre                   VARCHAR2(50)         not null,\n" +
           "   apellido                  VARCHAR2(50)         not null,\n" +
           "   email                    VARCHAR2(50)         not null)";
    public static final String SQL_CREATE_TABLE_AsignacionEquipo = "CREATE TABLE " + TABLA_AsignacionEquipo +
            "( idAsignacionEquipo     INTEGER              not null primary key,\n" +
            "   idDocente             INTEGER,\n" +
            "   fechaAsignacionEquipo DATE                 not null)";


    public static final String SQL_CREATE_TABLE_DocumentoAsignacion = "CREATE TABLE " + TABLA_DocumentoAsignacion +
            "(  idDocumentoAsignacion INTEGER              not null primary key,\n" +
            "   idDocente            INTEGER,\n" +
            "   motivo               VARCHAR2(120)        not null,\n" +
            "   fechaAsignacionDoc   VARCHAR2(50)         not null)" ;
    public static final String SQL_CREATE_TABLE_DocumentoAsignacionDetalle = "CREATE TABLE " + TABLA_DocumentoAsignacionDetalle +

            "(  idDocumentoAsignacionDetalle INTEGER              not null primary key,\n" +
            "   isbn                         VARCHAR2(25),\n" +
            "  idDocumentoAsignacion         INTEGER)";

    public static final String SQL_CREATE_TABLE_AsignacionEquipoDetalle = "CREATE TABLE " + TABLA_AsignacionEquipoDetalle +
            "(idAsignacionEquipoDetalle INTEGER              not null primary key,\n" +
            "   idEquipo            INTEGER,\n" +
            "   idAsignacionEquipo   INTEGER)";
    //------------------------------------------------------------------------------------------------------------------------------
    //Consultas para crear tablas

    //PM15007
    public static final String SQL_CREATE_TABLE_UNIDAD_ADMINISTRATIVA = "CREATE TABLE "+TABLA_UNIDAD_ADMINISTRATIVA +
            "(id_unidad_administrativa INTEGER NOT NULL PRIMARY KEY, "+
            "nombre VARCHAR(30) NOT NULL, "+
            "descripcion VARCHAR(100) NOT NULL)";
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

    public static final String SQL_DELETE_USUARIO = "DROP TABLE " + TABLA_USUARIO;
    public static final String SQL_DELETE_ROL_USUARIO = "DROP TABLE " + TABLA_ROL_USUARIO;
    //-----------------Raul-------------------------------------------------------------------------------------------------------
    public static final String SQL_DELETE_Docente = "DROP TABLE " + TABLA_Docente;
    public static final String SQL_DELETE_AsignacionEquipo = "DROP TABLE " + TABLA_AsignacionEquipo;
    public static final String SQL_DELETE_DocumentoAsignacion = "DROP TABLE " + TABLA_DocumentoAsignacion;
    public static final String SQL_DELETE_DocumentoAsignacionDetalle = "DROP TABLE " + TABLA_DocumentoAsignacionDetalle;
    public static final String SQL_DELETE_AsignacionEquipoDetalle = "DROP TABLE " + TABLA_AsignacionEquipoDetalle;
    //------------------------------------------------------------------------------------------------------------------------------

    //Borrar Tablas

    //PM15007
    public static final String SQL_DELETE_UNIDAD_ADMINISTRATIVA = "DROP TABLE "+TABLA_UNIDAD_ADMINISTRATIVA;
    public static final String SQL_DELETE_EQUIPO_MOVIMIENTO = "DROP TABLE "+ TABLA_EQUIPO_MOVIMIENTO;
    public static final String SQL_DELETE_TIPO_MOVIMIENTO_EQUIPO = "DROP TABLE "+TABLA_TIPO_MOVIMIENTO_EQUIPO;
    public static final String SQL_DELETE_EQUIPO_MOVIMIENTO_DETALLE ="DROP TABLE "+TABLA_EQUIPO_MOVIMIENTO_DETALLE;
    public static final String SQL_DELETE_EQUIPO_EXISTENCIA = "DROP TABLE "+TABLA_EQUIPO_EXISTENCIA;

    //-----------------------------------------------------
    // campos de las tablas
    // ----------------------------------------------------
    public static final String[] CAMPOS_USUARIO = {"usuario", "password"};
    public static final String[] CAMPOS_ROL_USUARIO = {"nombre_rol", "usuario"};

    //---------------  RAUL  ------------------------------------
    public static final String[] campos_Docente = {"idDocente", "idUnidadAdministrativa","nombre","apellido","email"};
    public static final String[] campos_AsignacionEquipo = {"idAsignacionEquipo", "idDocente", "fechaAsignacion"};
    public static final String[] campos_DocumentoAsignacion= {"idDocumentoAsignacion", "idDocente", "motivo","FechaAsignacionDoc"};
    public static final String[] campos_DocumentoAsignacionDetalle= {"idDocumentoAsignacionDetalle", "isbn", "idDocumentoAsignacion"};
    public static final String[] campos_AsignacionEquipoDetalle= {"idAsignacionEquipoDetalle", "idEquipo", "idAsignacionEquipo"};

    //PM15007
    public static final String[] CAMPOS_EQUIPO_EXISTENCIA = {"id_equipo_existencia","id_equipo", "id_docente",
            "id_unidad_administrativa","actual"};
    public static final String[] CAMPOS_EQUIPO_MOVIMIENTO = {"id_equipo_movimiento","id_tipo_movimiento_equipo",
            "id_u_administrativa_origen","id_u_administrativa_destino", "comentario", "fecha_movimiento"};
    public static final String[] CAMPOS_EQUIPO_MOVIMIENTO_DETALLE = {"id_equipo_movimiento_detalle",
            "id_equipo", "id_equipo_movimiento"};
    public static final String[] CAMPOS_TIPO_MOVIMIENTO_EQUIPO = {"id_tipo_movimiento_equipo","descripcion"};
    public static final String[] CAMPOS_UNIDAD_ADMINISTRATIVA ={"id_unidad_administrativa", "nombre", "descripcion"};

//AM15005
    //Tablas
    public static final String TABLA_AUTOR="autor";
    public static final String TABLA_MARCA="marca";
    public static  final String TABLA_TIPOS_DE_EQUIPO="tipos_de_equipo";
    public static final String TABLA_TIPOS_DE_DOCUMENTO="tipos_de_documento";
    public static final String TABLA_AUTOR_DETALLE="autordetalle";
    public static final String TABLA_DOCUMENTO="documento";
    public static final String TABLA_EQUIPO="equipo";



    //Consultas para crear tablas
    public static final String SQL_CREATE_TABLE_MARCA="CREATE TABLE "+TABLA_MARCA +"(IDMARCA INTEGER              not null,"+
            "DESCRIPCIONMARCA     VARCHAR2(50),"+ "constraint PK_MARCA primary key (IDMARCA))";

    public static final String SQL_CREATE_TABLE_AUTOR="CREATE TABLE "+TABLA_AUTOR +"(IDAUTOR              INTEGER              not null,"+
                    "NOMBREAUTOR          VARCHAR2(50)         not null,"+ "APELLIDOSAUTOR       VARCHAR2(50),"+ "constraint PK_AUTOR primary key (IDAUTOR))";

    public static final String SQL_CREATE_TABLE_TIPOS_EQUIPO= "CREATE TABLE "+TABLA_TIPOS_DE_EQUIPO
  +          "(IDTIPOSDEEQUIPO      INTEGER              not null,"+ "DESCRIPCIONTIPEQUIPO VARCHAR2(50)         not null,"+
   " constraint PK_TIPOSDEEQUIPO primary key (IDTIPOSDEEQUIPO))";
    public static final String SQL_CREATE_TABLE_TIPOS_DOCUMENTO= "CREATE TABLE "+TABLA_TIPOS_DE_DOCUMENTO+ "(IDTIPOSDEDOCUMENTO   INTEGER not null,"+"DESCRIPCIONTIPODEDOCUMENTO VARCHAR2(50),"+
    "constraint PK_TIPOSDEDOCUMENTO primary key (IDTIPOSDEDOCUMENTO) )";

    public static final String SQL_CREATE_TABLE_AUTORDETALLE="CREATE TABLE "+TABLA_AUTOR_DETALLE+ "(ISBN                 VARCHAR2(25),"+"IDAUTOR              INTEGER)";




    public static final String SQL_CREATE_TABLE_DOCUMENTO="CREATE TABLE "+ TABLA_DOCUMENTO+
            "( ISBN                 VARCHAR2(25)         not null,"+
    "IDTIPOSDEDOCUMENTO   INTEGER,"+
    "NOMBREDOC            VARCHAR2(50)         not null,"+
    "IDIOMA               VARCHAR2(50)         not null,"+
    "DESCRIPCIONDOC       VARCHAR2(50)         not null,"+
    "DISPONIBLEDOC        VARCHAR2(50)         not null,"+
    "constraint PK_DOCUMENTO primary key (ISBN))";


    public static final String SQL_CREATE_TABLE_EQUIPO="CREATE TABLE "+ TABLA_EQUIPO +
            "("+"    IDEQUIPO             INTEGER              not null,"+
                 "   IDTIPOSDEEQUIPO      INTEGER,"+
                  "  IDMARCA              INTEGER,"+
                   " SERIE                VARCHAR2(25),"+
   " CARACTERISTICAS      VARCHAR2(250)        not null,"+
   " MODELO               VARCHAR2(50),"+
    "FECHAINGRESO         DATE                 not null,"+
    "EQUIPODISPONIBLE     SMALLINT,"+
    "constraint PK_EQUIPO primary key (IDEQUIPO))";











    //Borrar Tablas
    public static  final String SQL_DELETE_MARCA = "DROP TABLE "+TABLA_MARCA;
    public static  final String SQL_DELETE_AUTOR = "DROP TABLE "+TABLA_AUTOR;
    public static  final String SQL_DELETE_TIPOS_EQUIPO = "DROP TABLE "+TABLA_TIPOS_DE_EQUIPO;
    public static  final String SQL_DELETE_TIPOS_DOCUMENTO = "DROP TABLE "+TABLA_TIPOS_DE_DOCUMENTO;
    public static  final String SQL_DELETE_AUTORDETALLE="DROP TABLE "+ TABLA_AUTOR_DETALLE;
    public static  final String SQL_DELETE_DOCUMENTO="DROP TABLE "+ TABLA_DOCUMENTO;
    public static  final String SQL_DELETE_EQUIPO="DROP TABLE "+ TABLA_EQUIPO;


    //campos marca
    public static final String[] CAMPOS_MARCA={"idmarca","descripcionmarca"};
    public static final String[] CAMPOS_AUTOR={"idautor","nombreautor","apellidosautor"};
    public static final String[] CAMPOS_TIPOS_EQUIPO={"idtiposdeequipo","descripciontipequipo"};
    public static final String[] CAMPOS_TIPOS_DOCUMENTO={"tiposdedocumento","descripciontipodedocumento"};
    public static final String[] CAMPOS_AUTORDETALLE={"isbn","idautor"};
    public static final String[] CAMPOS_EQUIPO={"idequipo","idtiposdeequipo","idmarca","serie","caracteristicas", "modelo","fechaingreso","equipodisponible"};
    public static final String[] CAMPOS_DOCUMENTO={"isbn" ,"idtiposdedocumento",
     "nombredoc" ,      "idioma",
      "descripciondoc",
      "disponibledoc"};


    //rl08017

    //nombre de tablas
    public static final String TABLA_TIPO_MOV_DOCUMENTO="tipo_movimiento_para_documento";
    public static final String TABLA_DOCUMENTO_MOVIMIENTO="movimiento_documento";
    public static final String TABLA_DOCUMENTO_MOVIMIENTO_DETALLE="movimiento_documento_detalle";
    public static final String TABLA_DOCUMENTO_EXISTENCIA="documento_existencia";

    // queries para crear las tablas
    // ----------------------------------------------------
    public static final String SQL_CREATE_TABLE_TIPO_MOV_DOCUMENTO = "CREATE TABLE " + TABLA_TIPO_MOV_DOCUMENTO +
            "( id_tipo_de_movimiento_para_documento  INTEGER NOT NULL PRIMARY KEY," +
            "descripcion VARCHAR(50) NOT NULL )";

    public static final String SQL_CREATE_TABLE_DOCUMENTO_MOVIMIENTO = "CREATE TABLE "+ TABLA_DOCUMENTO_MOVIMIENTO +
            "(id_documento_movimiento INTEGER NOT NULL PRIMARY KEY, " +
            "id_tipo_movimiento_documento INTEGER NOT NULL, " +
            "id_unidad_admin_origen INTEGER NOT NULL, "+
            "id_unidad_admin_destino INTEGER NOT NULL, "+
            "comentario VARCHAR(100) NOT NULL, "+
            "fecha_movimiento TEXT NOT NULL)";

    public static final String SQL_CREATE_TABLE_DOCUMENTO_MOVIMIENTO_DETALLE = "CREATE TABLE "+TABLA_DOCUMENTO_MOVIMIENTO_DETALLE +
            "(id_documento_movimiento_detalle INTEGER NOT NULL PRIMARY KEY, "+
            "isbn VARCHAR(25) NOT NULL, "+
            "id_documento_movimiento INTEGER NOT NULL)";
    public static final String SQL_CREATE_TABLE_DOCUMENTO_EXISTENCIA = "CREATE TABLE "+TABLA_DOCUMENTO_EXISTENCIA +
            "(id_documento_existencia INTEGER NOT NULL PRIMARY KEY, "+
            "isbn VARCHAR(25) NOT NULL, "+
            "id_docente INTEGER NOT NULL, "+
            "id_unidad_admin INTEGER NOT NULL, "+
            "actual INTEGER NOT NULL)";

    // query para borrar la DB

    public static final String SQL_DELETE_TIPO_MOV_DOCUMENTO = "DROP TABLE "+ TABLA_TIPO_MOV_DOCUMENTO;
    public static final String SQL_DELETE_DOCUMENTO_MOVIMIENTO = "DROP TABLE "+TABLA_DOCUMENTO_MOVIMIENTO;
    public static final String SQL_DELETE_DOCUMENTO_MOVIMIENTO_DETALLE ="DROP TABLE "+TABLA_DOCUMENTO_MOVIMIENTO_DETALLE;
    public static final String SQL_DELETE_DOCUMENTO_EXISTENCIA = "DROP TABLE "+TABLA_DOCUMENTO_EXISTENCIA;

    // campos de las tablas

    public static final String[] CAMPOS_TIPO_MOV_DOCUMENTO = {"id_tipo_de_movimiento_para_documento","descripcion"};
    public static final String[] CAMPOS_DOCUMENTO_MOVIMIENTO = {"id_documento_movimiento","id_tipo_movimiento_documento",
            "id_unidad_admin_origen","id_unidad_admin_destino", "comentario", "fecha_movimiento"};
    public static final String[] CAMPOS_DOCUMENTO_MOVIMIENTO_DETALLE = {"id_documento_movimiento_detalle",
            "isbn", "id_documento_movimiento"};
    public static final String[] CAMPOS_DOCUMENTO_EXISTENCIA = {"id_documento_existencia","isbn", "id_docente",
            "id_unidad_admin","actual"};

}
