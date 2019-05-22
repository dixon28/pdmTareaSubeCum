package com.pdmsubecum.ts14004;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

import java.util.ArrayList;
import java.util.List;

public class TS14004 extends ListActivity {
    String[] menu = {"Tabla Docente", "Tabla AsignacionEquipo", "Tabla DocumentoAsignacion"};
    String[] activities = {"DocenteMenuActivity", "AsignacionEquipoMenuActivity", "DocumentoAsignacionMenuActivity"};
    DataBase sqLiteOpenHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
        sqLiteOpenHelper = new DataBase(this);

        String tost = sqLiteOpenHelper.llenarBase();
        sqLiteOpenHelper.cerrar();
        Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

            String nombreValue = activities[position];
            try {
                Class<?> clase = Class.forName("com.pdmsubecum.ts14004." + nombreValue);
                Intent inte = new Intent(this, clase);
                this.startActivity(inte);


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

    }

}