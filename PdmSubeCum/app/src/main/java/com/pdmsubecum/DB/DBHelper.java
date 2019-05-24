package com.pdmsubecum.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by rodri on 10/05/2019.
 */

public class DBHelper extends SQLiteOpenHelper {




    public static final int DB_VERSION = 20;




    public DBHelper(Context context) {
        super(context, ConstantesDB.DATABASE,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_USUARIO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_ROL_USUARIO);
        //-----------------Raul----------------------------------------
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_Docente);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_AsignacionEquipo);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_DocumentoAsignacion);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_AsignacionEquipoDetalle);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_DocumentoAsignacionDetalle);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_ELIMINARDOCENTE);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_ELIMINARASIGNACIONEQUIPO);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_ELIMINARDOCUMENTOASIGNACION);

        //pm15007
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_EQUIPO_EXISTENCIA);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_EQUIPO_MOVIMIENTO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_EQUIPO_MOVIMIENTO_DETALLE);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_TIPO_MOVIMIENTO_EQUIPO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_UNIDAD_ADMINISTRATIVA);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_DELETE_TIPO_MOVIMIENTO_EQUIPO1);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_DELETE_TIPO_MOVIMIENTO_EQUIPO2);


        //am15005
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_MARCA);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_AUTOR);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_TIPOS_DOCUMENTO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_TIPOS_EQUIPO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_AUTORDETALLE);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_DOCUMENTO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_EQUIPO);

        //Triggers

        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_MARCA);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_DOCUMENTO);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_DOCUMENTO2);

        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_EQUIPO);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_EQUIPO2);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_EQUIPO3);




        //

        //Tablas MM
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_DIA);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_AULA);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_CICLO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_MATERIA);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_HORARIO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_GRUPO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_HORARIODETALLE);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_MATERIAELIMINAR);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_GRUPOELIMINAR);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_HORARIOELIMINAR);
        //Fin Tablas MM

        //rl08017
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_TIPO_MOV_DOCUMENTO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_DOCUMENTO_MOVIMIENTO_DETALLE);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_DOCUMENTO_MOVIMIENTO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_DOCUMENTO_EXISTENCIA);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_ELIMINATIPOMOVDOC);



        //Tiggers am15005

        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_DOCUMENTO4);
        db.execSQL(ConstantesDB.SQL_CREATE_TRIGGER_DOCUMENTO3);
        db.execSQL(ConstantesDB.SQL_UPDATE_TRIGGER_MARCA);
        db.execSQL(ConstantesDB.SQL_UPDATE_TRIGGER_DOCUMENTO);
        db.execSQL(ConstantesDB.SQL_UPDATE_TRIGGER_DOCUMENTO2);
        db.execSQL(ConstantesDB.SQL_UPDATE_TRIGGER_EQUIPOUPDATE);
        db.execSQL(ConstantesDB.SQL_UPDATE_TRIGGER_EQUIPOUPDATE3);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL(ConstantesDB.SQL_DELETE_USUARIO);
        db.execSQL(ConstantesDB.SQL_DELETE_ROL_USUARIO);

        //TS14004
        db.execSQL(ConstantesDB.SQL_DELETE_Docente);
        db.execSQL(ConstantesDB.SQL_DELETE_AsignacionEquipo);
        db.execSQL(ConstantesDB.SQL_DELETE_DocumentoAsignacion);
        db.execSQL(ConstantesDB.SQL_DELETE_AsignacionEquipoDetalle);
        db.execSQL(ConstantesDB.SQL_DELETE_DocumentoAsignacionDetalle);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_ELIMINARDOCENTE);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_ELIMINARASIGNACIONEQUIPO);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_ELIMINARDOCUMENTOASIGNACION);


        //pm15007
        db.execSQL(ConstantesDB.SQL_DELETE_EQUIPO_EXISTENCIA);
        db.execSQL(ConstantesDB.SQL_DELETE_EQUIPO_MOVIMIENTO);
        db.execSQL(ConstantesDB.SQL_DELETE_EQUIPO_MOVIMIENTO_DETALLE);
        db.execSQL(ConstantesDB.SQL_DELETE_TIPO_MOVIMIENTO_EQUIPO);
        db.execSQL(ConstantesDB.SQL_DELETE_UNIDAD_ADMINISTRATIVA);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_DELETE_TIPO_MOVIMIENTO_EQUIPO1);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_DELETE_TIPO_MOVIMIENTO_EQUIPO2);

        //am15005
        db.execSQL(ConstantesDB.SQL_DELETE_MARCA);
        db.execSQL(ConstantesDB.SQL_DELETE_AUTOR);
        db.execSQL(ConstantesDB.SQL_DELETE_TIPOS_DOCUMENTO);
        db.execSQL(ConstantesDB.SQL_DELETE_TIPOS_EQUIPO);
        db.execSQL(ConstantesDB.SQL_DELETE_AUTORDETALLE);
        db.execSQL(ConstantesDB.SQL_DELETE_DOCUMENTO);
        db.execSQL(ConstantesDB.SQL_DELETE_EQUIPO);

        //triggers

        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_MARCA);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_DOCUMENTO);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_EQUIPO);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_DOCUMENTO2);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_EQUIPO2);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_DOCUMENTO3);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_EQUIPO3);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_DOCUMENTO4);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_MARCAUPDATE);

        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_EQUIPOUPDATE);

        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_DOCUMENTOUPDATE2);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_DOCUMENTOUPDATE);

        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_EQUIPOUPDATE3);


        //


        //Tablas MM
        db.execSQL(ConstantesDB.SQL_DELETE_DIA);
        db.execSQL(ConstantesDB.SQL_DELETE_AULA);
        db.execSQL(ConstantesDB.SQL_DELETE_CICLO);
        db.execSQL(ConstantesDB.SQL_DELETE_HORARIODETALLE);
        db.execSQL(ConstantesDB.SQL_DELETE_MATERIA);
        db.execSQL(ConstantesDB.SQL_DELETE_HORARIO);
        db.execSQL(ConstantesDB.SQL_DELETE_GRUPO);

        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_MATERIAELIMINAR);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_GRUPOELIMINAR);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_HORARIOELIMINAR);
        //Fin tRablas MM


        //rl08017
        db.execSQL(ConstantesDB.SQL_DELETE_TIPO_MOV_DOCUMENTO);
        db.execSQL(ConstantesDB.SQL_DELETE_DOCUMENTO_MOVIMIENTO);
        db.execSQL(ConstantesDB.SQL_DELETE_DOCUMENTO_MOVIMIENTO_DETALLE);
        db.execSQL(ConstantesDB.SQL_DELETE_DOCUMENTO_EXISTENCIA);
        db.execSQL(ConstantesDB.SQL_DELETE_TRIGGER_ELIMINATIPOMOVDOC);

        onCreate(db);
    }
}
