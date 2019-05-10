package com.pdmsubecum.rl08017;

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

public class RL08017 extends AppCompatActivity  implements AdapterView.OnItemClickListener{

    ListView lista;

    List<String> tablasCrud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rl08017);
        this.setTitle(R.string.crud_rl08017);

        lista = findViewById(R.id.menu_rl08017);

        //agregando los item de la tabla
        tablasCrud = new ArrayList<>();
        tablasCrud.add("primera tabla");
        tablasCrud.add("segunda tabla");

        ArrayAdapter adapter = new ArrayAdapter(
                this, android.R.layout.simple_list_item_1,tablasCrud
        );


        lista.setAdapter(adapter);

        //agregandole el evento click a los items de la list
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //obteniendo la fila clickeada
        String nombreTablaClick = tablasCrud.get(position);

        //hacer llamar a activities segun click
        Toast.makeText(this, "Click a tabla: "+nombreTablaClick, Toast.LENGTH_SHORT).show();
    }
}
