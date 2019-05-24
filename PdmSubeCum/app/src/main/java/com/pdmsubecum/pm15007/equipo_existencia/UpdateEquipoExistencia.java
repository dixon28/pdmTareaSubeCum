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

import java.util.List;

public class UpdateEquipoExistencia extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout til_id_equipo_existencia, til_id_equipo, til_id_docente, til_id_unidad_administrativa,til_actual;

    Button btn_limpiar, btn_update;
    EquipoExistencia equipoExistencia;

    DataBase dataBase;

    List<String> integridad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_equipo_existencia);
        this.setTitle(R.string.equipo_existencia);

        dataBase = new DataBase(this);

        til_id_equipo_existencia = findViewById(R.id.til_id_equipo_existencia);
        til_id_equipo = findViewById(R.id.til_id_equipo);
        til_id_docente = findViewById(R.id.til_id_docente);
        til_id_unidad_administrativa = findViewById(R.id.til_id_unidad_administrativa);
        til_actual = findViewById(R.id.til_actual);

        

        btn_limpiar = findViewById(R.id.btn_clean_equipo_existencia);
        btn_update = findViewById(R.id.btn_update_equipo_existencia);

        btn_limpiar.setOnClickListener(this);
        btn_update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_clean_equipo_existencia:
                limpiar();
                break;
            case R.id.btn_update_equipo_existencia:
                if(til_id_equipo.getEditText().getText().toString().isEmpty() ||
                        til_id_docente.getEditText().getText().toString().isEmpty() ||
                        til_id_unidad_administrativa.getEditText().getText().toString().isEmpty() ||
                        til_actual.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(this,"Por Favor rellene todos los campos",Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        equipoExistencia = new EquipoExistencia();
                        equipoExistencia.setId_equipo_existencia(Integer.parseInt(
                                til_id_equipo_existencia.getEditText().getText().toString()));
                        equipoExistencia.setId_equipo(Integer.parseInt(til_id_equipo.getEditText().getText().toString()));
                        equipoExistencia.setId_docente(Integer.parseInt(til_id_docente.getEditText().getText().toString()));
                        equipoExistencia.setId_unidad_administrativa(Integer.parseInt(
                                til_id_unidad_administrativa.getEditText().getText().toString()));
                        equipoExistencia.setActual(Integer.parseInt(til_actual.getEditText().getText().toString()));
                    }catch (Exception e){
                        Toast.makeText(this,"Uno o mas Campos no son del tipo solicitado",Toast.LENGTH_SHORT).show();
                    }
                    dataBase.abrir();
                    integridad = dataBase.verificarEquipoExistencia(equipoExistencia);
                    //verificando si las foraneas existen
                    if(Boolean.valueOf(integridad.get(1))){
                        if(dataBase.getEquipoExistencia(equipoExistencia.getId_equipo_existencia()) != null){
                            dataBase.actualizar(equipoExistencia);
                            dataBase.cerrar();
                            Toast.makeText(this,"Equipo Existencia ha sido actualizado",Toast.LENGTH_SHORT).show();
                            limpiar();
                        }else{
                            Toast.makeText(this,"No Existe Equipo Existencia con el ID ingresado",Toast.LENGTH_SHORT).show();
                            limpiar();
                        }
                    }else{
                        Toast.makeText(this,integridad.get(0),Toast.LENGTH_SHORT).show();
                    }


                }
                break;
        }

    }
    public void limpiar(){
        til_id_equipo_existencia.getEditText().setText("");
        til_id_equipo.getEditText().setText("");
        til_id_docente.getEditText().setText("");
        til_id_unidad_administrativa.getEditText().setText("");
        til_actual.getEditText().setText("");
    }
}
