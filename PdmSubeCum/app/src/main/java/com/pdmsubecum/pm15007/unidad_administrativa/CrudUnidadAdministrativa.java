package com.pdmsubecum.pm15007.unidad_administrativa;

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

public class CrudUnidadAdministrativa extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    List<String> crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_unidad_administrativa);
        this.setTitle(R.string.crud_unidad_administrativa);

        lista = findViewById(R.id.menu_unidad_administrativa);

        crud = new ArrayList<>();
        crud.add(getString(R.string.crud_create));
        crud.add(getString(R.string.crud_retrieve));
        crud.add(getString(R.string.crud_update));
        crud.add(getString(R.string.crud_delete));

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,crud);

        lista.setAdapter(arrayAdapter);


        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //obteniendo la fila clickeada
        String nombreTablaClick = crud.get(position);

        //hacer llamar a activities segun click
        Toast.makeText(this, "Click a tabla: "+nombreTablaClick, Toast.LENGTH_SHORT).show();

        Intent intent;
        switch (position){
            case 0:
                intent = new Intent(this, CreateUnidadAdministrativa.class);
                startActivity(intent);
                break;
            case 1:
                startActivity(new Intent(this, RetrieveUnidadAdministrativa.class));
                break;
        }
    }
}
