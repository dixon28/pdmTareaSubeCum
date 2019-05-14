package com.pdmsubecum.pm15007.equipo_movimiento_detalle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pdmsubecum.R;

public class CrudEquipoMovimientoDetalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_movimiento_detalle);
        this.setTitle(R.string.crud_equipo_movimiento_detalle);
    }
}
