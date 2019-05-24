package com.pdmsubecum.pm15007;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.pdmsubecum.R;
import com.pdmsubecum.pm15007.equipo_existencia.CrudEquipoExistencia;
import com.pdmsubecum.pm15007.equipo_movimiento.CrudEquipoMovimiento;
import com.pdmsubecum.pm15007.equipo_movimiento_detalle.CrudEquipoMovimientoDetalle;
import com.pdmsubecum.pm15007.tipo_movimiento_equipo.CrudTipoMovimientoEquipo;
import com.pdmsubecum.pm15007.unidad_administrativa.CrudUnidadAdministrativa;

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
        tablasCrud.add(getString(R.string.unidad_administrativa));
        tablasCrud.add(getString(R.string.tipo_movimiento_equipo));
        tablasCrud.add(getString(R.string.equipo_existencia));

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

        Intent intent;
        switch (position){
            case 0:
                intent = new Intent(this, CrudUnidadAdministrativa.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this, CrudTipoMovimientoEquipo.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, CrudEquipoExistencia.class);
                startActivity(intent);
                break;
        }
    }
}
