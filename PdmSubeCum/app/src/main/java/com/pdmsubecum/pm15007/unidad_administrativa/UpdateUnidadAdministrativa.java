package com.pdmsubecum.pm15007.unidad_administrativa;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.pm15007.UnidadAdministrativa;
import com.pdmsubecum.R;

public class UpdateUnidadAdministrativa extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout til_id_unidad_administrativa, til_nombre, til_descripcion;

    Button btn_limpiar, btn_update_unidad_administrativa;

    DataBase dataBase;

    UnidadAdministrativa unidadAdministrativa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_unidad_administrativa);
        this.setTitle(R.string.unidad_administrativa);

        dataBase = new DataBase(this);

        til_id_unidad_administrativa = findViewById(R.id.til_id_unidad_administrativa);
        til_nombre = findViewById(R.id.til_nombre);
        til_descripcion = findViewById(R.id.til_descripcion);

        btn_limpiar = findViewById(R.id.btn_clean_unidad_administrativa);
        btn_update_unidad_administrativa = findViewById(R.id.btn_update_unidad_administrativa);

        btn_limpiar.setOnClickListener(this);
        btn_update_unidad_administrativa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_clean_unidad_administrativa:
                limpiar();
                break;
            case R.id.btn_update_unidad_administrativa:
                if(til_id_unidad_administrativa.getEditText().getText().toString().isEmpty() ||
                        til_nombre.getEditText().getText().toString().isEmpty() ||
                        til_descripcion.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(this, getString(R.string.please_fill), Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        unidadAdministrativa = new UnidadAdministrativa();
                        unidadAdministrativa.setId_unidad_administrativa(Integer.parseInt(
                                til_id_unidad_administrativa.getEditText().getText().toString()));
                        unidadAdministrativa.setNombre(til_nombre.getEditText().getText().toString());
                        unidadAdministrativa.setDescripcion(til_descripcion.getEditText().getText().toString());

                    }catch (Exception e){
                        Toast.makeText(this,getString(R.string.bad_fields),Toast.LENGTH_SHORT).show();
                    }
                    dataBase.abrir();
                    if(dataBase.getUnidadAdministrativa(unidadAdministrativa.getId_unidad_administrativa()) != null){
                        dataBase.actualizar(unidadAdministrativa);
                        dataBase.cerrar();
                        Toast.makeText(this,getString(R.string.unidad_administrativa)+" "+getString(R.string.updated),Toast.LENGTH_SHORT).show();
                        limpiar();
                    }else{
                        Toast.makeText(this,getString(R.string.unidad_administrativa)+" "+getString(R.string.not_exists),Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                }
                break;
        }
    }

    public void limpiar(){
        til_id_unidad_administrativa.getEditText().setText("");
        til_nombre.getEditText().setText("");
        til_descripcion.getEditText().setText("");
    }

}
