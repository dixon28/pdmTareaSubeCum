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

public class RetrieveEquipoExistencia extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout til_id_equipo_existencia_r, til_id_equipo_r, til_id_docente_r, til_id_unidad_administrativa_r,til_actual_r;

    Button btn_limpiar, btn_crear;
    EquipoExistencia equipoExistencia;

    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_equipo_existencia);
        this.setTitle(R.string.equipo_existencia);

        dataBase = new DataBase(this);

        til_id_equipo_existencia_r = findViewById(R.id.til_id_equipo_existencia_r);
        til_id_equipo_r = findViewById(R.id.til_id_equipo_r);
        til_id_docente_r = findViewById(R.id.til_id_docente_r);
        til_id_unidad_administrativa_r = findViewById(R.id.til_id_unidad_administrativa_r);
        til_actual_r = findViewById(R.id.til_actual_r);



        btn_limpiar = findViewById(R.id.btn_clean_equipo_existencia_r);
        btn_crear = findViewById(R.id.btn_retrieve_equipo_existencia);

        btn_limpiar.setOnClickListener(this);
        btn_crear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_clean_equipo_existencia_r:
                limpiar();
                break;
            case R.id.btn_retrieve_equipo_existencia:
                if(til_id_equipo_existencia_r.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(this,getString(R.string.please_id),Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        equipoExistencia = new EquipoExistencia();
                        dataBase.abrir();
                        int id = Integer.parseInt(til_id_equipo_existencia_r.getEditText().getText().toString());
                        equipoExistencia = dataBase.getEquipoExistencia(id);
                        dataBase.cerrar();
                    }catch (Exception e){
                        Toast.makeText(this,getString(R.string.not_number),Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                   if(equipoExistencia != null){
                       til_id_equipo_r.getEditText().setText(String.valueOf(equipoExistencia.getId_equipo()));
                       til_id_docente_r.getEditText().setText(String.valueOf(equipoExistencia.getId_docente()));
                       til_id_unidad_administrativa_r.getEditText().setText(String.valueOf(equipoExistencia.getId_unidad_administrativa()));
                       til_actual_r.getEditText().setText(String.valueOf(equipoExistencia.getActual()));
                       Toast.makeText(this,getString(R.string.showRecord),Toast.LENGTH_SHORT).show();
                   }else{
                       Toast.makeText(this,getString(R.string.equipo_existencia)+" "+getString(R.string.not_exists),Toast.LENGTH_SHORT).show();
                       limpiar();
                   }

                }
                break;
        }
    }
    public void limpiar(){
        til_id_equipo_existencia_r.getEditText().setText("");
        til_id_equipo_r.getEditText().setText("");
        til_id_docente_r.getEditText().setText("");
        til_id_unidad_administrativa_r.getEditText().setText("");
        til_actual_r.getEditText().setText("");
    }
}
