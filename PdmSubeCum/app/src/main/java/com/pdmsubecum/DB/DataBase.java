package com.pdmsubecum.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.pdmsubecum.DB.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodri on 10/05/2019.
 */

public class DataBase {
    Context context;
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper sqLiteOpenHelper;

    public DataBase(Context context){
        this.context = context;
        sqLiteOpenHelper = new DBHelper(context);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void abrir(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }
    public void cerrar(){
        sqLiteOpenHelper.close();
    }

    public long getItemsUsuario(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_USUARIO);
    }

    public void insertar(Usuario usuario){
        ContentValues contentValues = usuario.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_USUARIO, null, contentValues);
    }


    public void llenarUsuario(List<Usuario> usuarios){
        long items = getItemsUsuario();
        if(items == 0){
            for (Usuario usuario: usuarios){
                try {
                    insertar(usuario);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }


    public  List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_USUARIO, ConstantesDB.CAMPOS_ALUMNO,null,
                null,null,null,null);
        while(cursor.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setUsuario(cursor.getString(0));
            usuario.setPassword(cursor.getString(1));
            usuarios.add(usuario);
        }
        return usuarios;
    }
    public Usuario getUsuario(String user){
        String[] id = {user};
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_USUARIO, ConstantesDB.CAMPOS_ALUMNO,"usuario = ?",
                id,null,null,null);
        if(cursor.moveToFirst()){
            Usuario usuario = new Usuario();
            usuario.setUsuario(cursor.getString(0));
            usuario.setPassword(cursor.getString(1));
            return usuario;
        }else{
            return null;
        }

    }
}
