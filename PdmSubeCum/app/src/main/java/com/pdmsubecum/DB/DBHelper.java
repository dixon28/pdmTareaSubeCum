package com.pdmsubecum.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ConstantesDB.SQL_DELETE_USUARIO);
        db.execSQL(ConstantesDB.SQL_DELETE_ROL_USUARIO);

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
        onCreate(db);
    }
}
