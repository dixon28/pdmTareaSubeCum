package com.pdmsubecum.pm15007.tipo_movimiento_equipo;

import android.support.design.widget.TextInputLayout;
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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_clean_tipo_movimiento_equipo:
                limpiar();
                break;
            case R.id.btn_delete_tipo_movimiento_equipo:
                if (til_id_tipo_movimiento_equipo.getEditText().getText().toString().isEmpty()) {
                    Toast.makeText(this, "Por favor rellene todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int id = Integer.parseInt(til_id_tipo_movimiento_equipo.getEditText().getText().toString());
                        dataBase.abrir();
                        tipoMovimientoEquipo = dataBase.getTipoMovimientoEquipo(id);
                        dataBase.cerrar();
                    } catch (Exception e) {
                        Toast.makeText(this,"El valor ingresado no es un numero", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                    if(tipoMovimientoEquipo != null){
                        dataBase.abrir();
                        dataBase.eliminar(tipoMovimientoEquipo);
                        dataBase.cerrar();
                        Toast.makeText(this,"Tipo Movimiento Equipo ha sido Eliminado", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }else{
                        Toast.makeText(this,"No existe Tipo Movimiento Equipo con ese ID", Toast.LENGTH_SHORT).show();
                    }
                }
        }

    }
    public void limpiar(){
        til_id_tipo_movimiento_equipo.getEditText().setText("");
    }
}
