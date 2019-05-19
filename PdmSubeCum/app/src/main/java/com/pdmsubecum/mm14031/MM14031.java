package com.pdmsubecum.mm14031;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.pdmsubecum.R;

import java.util.ArrayList;
import java.util.List;

public class MM14031 extends ListActivity {

    ListView lista;
    String[] menu = {"Tabla Materia", "Tabla Horario","Tabla Grupo"};
    String[] activities = {"MateriaMenuActivity","HorarioMenuActivity","GrupoMenuActivity"};

    List<String> tablasCrud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu));
    }

    @Override
    public void onListItemClick(ListView l,View v, int position,long id) {
        super.onListItemClick(l,v,position,id);

        String nombreTabla = activities[position];

        try {
            Class<?> clase = Class.forName("com.pdmsubecum.mm14031."+ nombreTabla);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
