package com.pdmsubecum.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rodri on 10/05/2019.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;


    public DBHelper(Context context) {
        super(context, ConstantesDB.DATABASE,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_USUARIO);
        db.execSQL(ConstantesDB.SQL_CREATE_TABLE_ROL_USUARIO);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ConstantesDB.SQL_DELETE_USUARIO);
        db.execSQL(ConstantesDB.SQL_DELETE_ROL_USUARIO);

        onCreate(db);
    }
}
