package com.pdmsubecum.pm15007;

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

public class PM15007 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lista;

    List<String> tablasCrud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm15007);
        this.setTitle(R.string.crud_pm15007);

        lista = findViewById(R.id.menu_pm15007);

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
