package com.pdmsubecum.pm15007.unidad_administrativa;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.pm15007.UnidadAdministrativa;
import com.pdmsubecum.R;

public class DeleteUnidadAdministrativa extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout til_id_unidad_administrativa;

    Button btn_limpiar, btn_delete_unidad_administrativa;

    DataBase dataBase;

    UnidadAdministrativa unidadAdministrativa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_unidad_administrativa);
        this.setTitle(R.string.unidad_administrativa);

        dataBase = new DataBase(this);

        til_id_unidad_administrativa = findViewById(R.id.til_id_unidad_administrativa);

        btn_limpiar = findViewById(R.id.btn_clean_unidad_administrativa);
        btn_delete_unidad_administrativa = findViewById(R.id.btn_delete_unidad_administrativa);

        btn_limpiar.setOnClickListener(this);
        btn_delete_unidad_administrativa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_clean_unidad_administrativa:
                limpiar();
                break;
            case R.id.btn_delete_unidad_administrativa:
                if(til_id_unidad_administrativa.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(this, "Por favor indique el ID", Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        int id = Integer.parseInt(til_id_unidad_administrativa.getEditText().getText().toString());
                        dataBase.abrir();
                        unidadAdministrativa = dataBase.getUnidadAdministrativa(id);
                        dataBase.cerrar();
                    }catch (Exception e){
                        Toast.makeText(this,"El valor ingresado no es un numero", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                    if(unidadAdministrativa != null){
                        dataBase.abrir();
                        dataBase.eliminar(unidadAdministrativa);
                        dataBase.cerrar();
                        Toast.makeText(this,"Unidad Administrativa ha sido Eliminado", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }else{
                        Toast.makeText(this,"No existe Unidad Administrativa con ese ID", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }

    }
    public void limpiar() {
        til_id_unidad_administrativa.getEditText().setText("");
    }
}
