package com.pdmsubecum.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rodri on 10/05/2019.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 2;


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

        //pm15007
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_EQUIPO_EXISTENCIA);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_EQUIPO_MOVIMIENTO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_EQUIPO_MOVIMIENTO_DETALLE);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_TIPO_MOVIMIENTO_EQUIPO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_UNIDAD_ADMINISTRATIVA);


        //am15005
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_MARCA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ConstantesDB.SQL_DELETE_USUARIO);
        db.execSQL(ConstantesDB.SQL_DELETE_ROL_USUARIO);
        db.execSQL(ConstantesDB.SQL_DELETE_Docente);
        db.execSQL(ConstantesDB.SQL_DELETE_AsignacionEquipo);
        db.execSQL(ConstantesDB.SQL_DELETE_DocumentoAsignacion);
        db.execSQL(ConstantesDB.SQL_DELETE_AsignacionEquipoDetalle);
        db.execSQL(ConstantesDB.SQL_DELETE_DocumentoAsignacionDetalle);


        //pm15007
        db.execSQL(ConstantesDB.SQL_DELETE_EQUIPO_EXISTENCIA);
        db.execSQL(ConstantesDB.SQL_DELETE_EQUIPO_MOVIMIENTO);
        db.execSQL(ConstantesDB.SQL_DELETE_EQUIPO_MOVIMIENTO_DETALLE);
        db.execSQL(ConstantesDB.SQL_DELETE_TIPO_MOVIMIENTO_EQUIPO);
        db.execSQL(ConstantesDB.SQL_DELETE_UNIDAD_ADMINISTRATIVA);

        //am15005
        db.execSQL(ConstantesDB.SQL_DELETE_MARCA);

        onCreate(db);
    }
}
