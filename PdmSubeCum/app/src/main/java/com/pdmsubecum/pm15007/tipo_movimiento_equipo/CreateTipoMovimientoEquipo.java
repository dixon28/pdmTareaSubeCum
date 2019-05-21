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

public class CreateTipoMovimientoEquipo extends AppCompatActivity implements View.OnClickListener
{
    TextInputLayout til_id_tipo_movimiento_equipo, til_descripcion;

    Button btn_clean_tipo_movimiento_equipo, btn_create_tipo_movimiento_equipo;

    DataBase dataBase;

    TipoMovimientoEquipo tipoMovimientoEquipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tipo_movimiento_equipo);
        this.setTitle(R.string.tipo_movimiento_equipo);

        dataBase = new DataBase(this);

        til_id_tipo_movimiento_equipo = findViewById(R.id.til_id_tipo_movimiento_equipo);
        til_descripcion = findViewById(R.id.til_descripcion);

        btn_clean_tipo_movimiento_equipo = findViewById(R.id.btn_clean_tipo_movimiento_equipo);

        btn_create_tipo_movimiento_equipo = findViewById(R.id.btn_create_tipo_movimiento_equipo);

        btn_clean_tipo_movimiento_equipo.setOnClickListener(this);
        btn_create_tipo_movimiento_equipo.setOnClickListener(this);

        til_id_tipo_movimiento_equipo.getEditText().setText(String.valueOf(dataBase.getLastIdTipoMovimientoEquipo() + 1));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_clean_tipo_movimiento_equipo:
                limpiar();
                break;
            case R.id.btn_create_tipo_movimiento_equipo:
                if(til_id_tipo_movimiento_equipo.getEditText().getText().toString().isEmpty() ||
                til_descripcion.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(this,"Por favor rellene todos los campos",Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        tipoMovimientoEquipo = new TipoMovimientoEquipo();
                        tipoMovimientoEquipo.setId_tipo_movimiento_equipo(Integer.parseInt(til_id_tipo_movimiento_equipo.
                                getEditText().getText().toString()));
                        tipoMovimientoEquipo.setDescripcion(til_descripcion.getEditText().getText().toString());
                    }catch (Exception e){
                        Toast.makeText(this,"Los datos deben ser del tipo indicado",Toast.LENGTH_SHORT).show();
                    }

                    dataBase.abrir();
                    dataBase.insertar(tipoMovimientoEquipo);
                    dataBase.cerrar();
                    Toast.makeText(this,"Tipo Movimiento Equipo ha sido creada",Toast.LENGTH_SHORT).show();
                    limpiar();
                    til_id_tipo_movimiento_equipo.getEditText().setText(String.valueOf(Integer.parseInt(
                            til_id_tipo_movimiento_equipo.getEditText().getText().toString()) +1 ));
                }
                break;
        }

    }
    public void limpiar(){
        //til_id_tipo_movimiento_equipo.getEditText().setText("");
        til_descripcion.getEditText().setText("");
    }
}
