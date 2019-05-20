package com.pdmsubecum.mm14031;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pdmsubecum.R;

public class HorarioMenuActivity extends ListActivity {

    String[] menu = {"Insertar Horario", "Eliminar Horario", "Consultar Horario", "Actualizar Horario"};
    String[] activities = {"HorarioInsertarActivity","HorarioEliminarActivity","HorarioConsultarActivity","HorarioActualizarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);

        String nombreValue = activities[position];

        l.getChildAt(position).setBackgroundColor(Color.rgb(128,128,255));

        try {
            Class<?> clase = Class.forName("com.pdmsubecum.mm14031."+ nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
