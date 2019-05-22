package com.pdmsubecum.rl08017;

import android.app.ListActivity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;

public class RL08017 extends ListActivity {
    String[] menu={"Tabla Tipos Movimiento Documento","Tabla Documento Movimiento","Tabla Documento Existencia "};
    String[] activities={"TiposDeMovimientoParaDocumentoMenuActivity","DocumentoMovimientoMenuActivity","DocumentoExistenciaMenuActivity"};
    DataBase sqLiteOpenHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
        sqLiteOpenHelper = new DataBase(this);

        try{
            String tost2 = sqLiteOpenHelper.llenarBDInicio();
            sqLiteOpenHelper.cerrar();
            Toast.makeText(this, "Creada", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e){

            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);
        if(position!=3){
            String nombreValue=activities[position];
            try{
                Class<?> clase=Class.forName("com.pdmsubecum.rl08017."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
//CODIGO PARA LLENAR BASE DE DATOS
        }
    }
}