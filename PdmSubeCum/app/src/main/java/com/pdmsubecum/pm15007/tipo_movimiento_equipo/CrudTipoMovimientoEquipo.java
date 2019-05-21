package com.pdmsubecum.pm15007.tipo_movimiento_equipo;

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

public class CrudTipoMovimientoEquipo extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    List<String> crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_tipo_movimiento_equipo);
        this.setTitle(R.string.crud_tipo_movimiento_equipo);

        lista = findViewById(R.id.menu_tipo_movimiento);

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
       switch (position){
           case 0:
               startActivity(new Intent(this, CreateTipoMovimientoEquipo.class));
               break;
           case 1:
               startActivity(new Intent(this, RetrieveTipoMovimientoEquipo.class));
               break;
           case 2:
               startActivity(new Intent(this, UpdateTipoMovimientoEquipo.class));
               break;
           case 3:
               startActivity(new Intent(this, DeleteTipoMovimientoEquipo.class));
               break;
       }
    }
}
