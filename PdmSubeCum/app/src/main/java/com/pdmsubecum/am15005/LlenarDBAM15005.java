package com.pdmsubecum.am15005;

import android.content.Context;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Autor;
import com.pdmsubecum.DB.modelo.am15005.TiposDeDocumento;
import com.pdmsubecum.DB.modelo.am15005.TiposDeEquipo;

import java.util.ArrayList;

public class LlenarDBAM15005 {

    private ArrayList<Autor> autors =new ArrayList<Autor>();
    private ArrayList<TiposDeDocumento> tiposD= new ArrayList<TiposDeDocumento>();
    private ArrayList<TiposDeEquipo> tiposE= new ArrayList<TiposDeEquipo>();
    public DataBase dataBase;

    public LlenarDBAM15005(Context context) {
        dataBase = new DataBase(context);
    }


}
