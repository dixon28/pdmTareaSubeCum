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

public class RetrieveUnidadAdministrativa extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout til_id_unidad_administrativa, til_nombre, til_descripcion;

    Button btn_limpiar, btn_create_unidad_administrativa;

    DataBase dataBase;

    UnidadAdministrativa unidadAdministrativa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_unidad_administrativa);
        this.setTitle(R.string.unidad_administrativa);

        dataBase = new DataBase(this);

        til_id_unidad_administrativa = findViewById(R.id.til_id_unidad_administrativa);
        til_nombre = findViewById(R.id.til_nombre);
        til_descripcion = findViewById(R.id.til_descripcion);

        btn_limpiar = findViewById(R.id.btn_clean_unidad_administrativa);
        btn_create_unidad_administrativa = findViewById(R.id.btn_retrieve_unidad_administrativa);

        btn_limpiar.setOnClickListener(this);
        btn_create_unidad_administrativa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_clean_unidad_administrativa:
                limpiar();
                break;
            case R.id.btn_retrieve_unidad_administrativa:
                if(til_id_unidad_administrativa.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(this, "Por favor rellene el ID", Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        unidadAdministrativa = new UnidadAdministrativa();
                        dataBase.abrir();
                        int id = Integer.parseInt(til_id_unidad_administrativa.getEditText().getText().toString());
                        unidadAdministrativa = dataBase.getUnidadAdministrativa(id);
                        dataBase.cerrar();

                    }catch (Exception e){
                        Toast.makeText(this,"El ID debe ser un tipo entero",Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                    if(unidadAdministrativa != null){
                        til_nombre.getEditText().setText(unidadAdministrativa.getNombre());
                        til_descripcion.getEditText().setText(unidadAdministrativa.getDescripcion());
                        Toast.makeText(this,"Se muestran los datos del registro",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this,"No Existe Unidad Administrativa con el ID ingresado",Toast.LENGTH_SHORT).show();
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
