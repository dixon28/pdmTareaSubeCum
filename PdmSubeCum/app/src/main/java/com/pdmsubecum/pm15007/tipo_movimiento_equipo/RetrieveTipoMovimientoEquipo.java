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

public class RetrieveTipoMovimientoEquipo extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout til_id_tipo_movimiento_equipo, til_descripcion;

    Button btn_clean_tipo_movimiento_equipo, btn_retrieve_tipo_movimiento_equipo;

    DataBase dataBase;

    TipoMovimientoEquipo tipoMovimientoEquipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_tipo_movimiento_equipo);

        this.setTitle(R.string.tipo_movimiento_equipo);

        dataBase = new DataBase(this);

        til_id_tipo_movimiento_equipo = findViewById(R.id.til_id_tipo_movimiento_equipo);
        til_descripcion = findViewById(R.id.til_descripcion);

        btn_clean_tipo_movimiento_equipo = findViewById(R.id.btn_clean_tipo_movimiento_equipo);

        btn_retrieve_tipo_movimiento_equipo = findViewById(R.id.btn_retrieve_tipo_movimiento_equipo);

        btn_clean_tipo_movimiento_equipo.setOnClickListener(this);
        btn_retrieve_tipo_movimiento_equipo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_clean_tipo_movimiento_equipo:
                limpiar();
                break;
            case R.id.btn_retrieve_tipo_movimiento_equipo:
                if(til_id_tipo_movimiento_equipo.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(this,getString(R.string.please_id),Toast.LENGTH_SHORT).show();
                }else{
                    try {
                        tipoMovimientoEquipo = new TipoMovimientoEquipo();
                        int id = Integer.parseInt(til_id_tipo_movimiento_equipo.getEditText().getText().toString());
                        dataBase.abrir();
                        tipoMovimientoEquipo = dataBase.getTipoMovimientoEquipo(id);
                        dataBase.cerrar();
                    }catch (Exception e){
                        Toast.makeText(this,getString(R.string.not_number),Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                    if(tipoMovimientoEquipo != null){
                        til_descripcion.getEditText().setText(tipoMovimientoEquipo.getDescripcion());
                        Toast.makeText(this,getString(R.string.showRecord),Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this,getString(R.string.tipo_movimiento_equipo)+" "+getString(R.string.not_exists),Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                }
                break;
        }

    }

    public void limpiar(){
        til_id_tipo_movimiento_equipo.getEditText().setText("");
        til_descripcion.getEditText().setText("");
    }
}
