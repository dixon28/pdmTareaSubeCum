package com.pdmsubecum.pm15007.equipo_existencia;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.pm15007.EquipoExistencia;
import com.pdmsubecum.R;

public class DeleteEquipoExistencia extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout til_id_equipo_existencia;

    Button btn_clean, btn_delete;

    DataBase dataBase;
    EquipoExistencia equipoExistencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_equipo_existencia);
        this.setTitle(R.string.equipo_existencia);

        dataBase = new DataBase(this);

        til_id_equipo_existencia = findViewById(R.id.til_id_equipo_existencia);

        btn_clean= findViewById(R.id.btn_clean_equipo_existencia);
        btn_delete = findViewById(R.id.btn_delete_equipo_existencia);

        btn_clean.setOnClickListener(this);
        btn_delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_clean_equipo_existencia:
                limpiar();
                break;
            case R.id.btn_delete_equipo_existencia:
                if(til_id_equipo_existencia.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(this,"Por favor rellene el ID ", Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        int id = Integer.parseInt(til_id_equipo_existencia.getEditText().getText().toString());
                        dataBase.abrir();
                        equipoExistencia = dataBase.getEquipoExistencia(id);
                        dataBase.cerrar();
                    } catch (Exception e){
                        Toast.makeText(this,"El valor ingresado no es un numero", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                    if(equipoExistencia != null){
                        dataBase.abrir();
                        dataBase.eliminar(equipoExistencia);
                        dataBase.cerrar();
                        Toast.makeText(this,"Equipo Existencia ha sido Eliminado", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }else{
                        Toast.makeText(this,"No existe Equipo existencia con ese ID", Toast.LENGTH_SHORT).show();
                    }

                }
                break;
        }
    }
    public void limpiar(){
        til_id_equipo_existencia.getEditText().setText("");
    }
}