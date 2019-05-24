package com.pdmsubecum.pm15007.tipo_movimiento_equipo;

import android.content.DialogInterface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.pm15007.TipoMovimientoEquipo;
import com.pdmsubecum.R;

public class DeleteTipoMovimientoEquipo extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout til_id_tipo_movimiento_equipo;

    Button btn_clean_tipo_movimiento_equipo, btn_delete_tipo_movimiento_equipo;

    DataBase dataBase;

    TipoMovimientoEquipo tipoMovimientoEquipo;

    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_tipo_movimiento_equipo);

        this.setTitle(R.string.tipo_movimiento_equipo);

        dataBase = new DataBase(this);

        til_id_tipo_movimiento_equipo = findViewById(R.id.til_id_tipo_movimiento_equipo);

        btn_clean_tipo_movimiento_equipo = findViewById(R.id.btn_clean_tipo_movimiento_equipo);

        btn_delete_tipo_movimiento_equipo = findViewById(R.id.btn_delete_tipo_movimiento_equipo);

        btn_clean_tipo_movimiento_equipo.setOnClickListener(this);
        btn_delete_tipo_movimiento_equipo.setOnClickListener(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.mensaje_eliminar) + getString(R.string.tipo_movimiento_equipo)+", EquipoMovimiento, EquipoMovimeintoDetalle")
                .setTitle(R.string.titulo_dialogo);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                eliminar();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                cancelar();
            }
        });

        dialog = builder.create();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_clean_tipo_movimiento_equipo:
                limpiar();
                break;
            case R.id.btn_delete_tipo_movimiento_equipo:
                if (til_id_tipo_movimiento_equipo.getEditText().getText().toString().isEmpty()) {
                    Toast.makeText(this, getString(R.string.please_id), Toast.LENGTH_SHORT).show();
                } else {
                    dialog.show();
                }
        }

    }
    public void eliminar(){
        try {
            int id = Integer.parseInt(til_id_tipo_movimiento_equipo.getEditText().getText().toString());
            dataBase.abrir();
            tipoMovimientoEquipo = dataBase.getTipoMovimientoEquipo(id);
            dataBase.cerrar();
        } catch (Exception e) {
            Toast.makeText(this,getString(R.string.not_number), Toast.LENGTH_SHORT).show();
            limpiar();
        }
        if(tipoMovimientoEquipo != null){
            dataBase.abrir();
            dataBase.eliminar(tipoMovimientoEquipo);
            dataBase.cerrar();
            Toast.makeText(this,getString(R.string.tipo_movimiento_equipo)+" "+getString(R.string.deleted), Toast.LENGTH_SHORT).show();
            limpiar();
        }else{
            Toast.makeText(this,getString(R.string.tipo_movimiento_equipo)+" "+getString(R.string.not_exists), Toast.LENGTH_SHORT).show();
        }
    }
    public void cancelar(){
        Toast.makeText(this, getString(R.string.canceled),Toast.LENGTH_SHORT).show();
    }
    public void limpiar(){
        til_id_tipo_movimiento_equipo.getEditText().setText("");
    }
}
