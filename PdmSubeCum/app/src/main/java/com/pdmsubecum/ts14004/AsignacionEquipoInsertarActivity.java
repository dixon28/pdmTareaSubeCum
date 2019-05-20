package com.pdmsubecum.ts14004;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.AsignacionEquipo;

import com.pdmsubecum.R;

public class AsignacionEquipoInsertarActivity extends AppCompatActivity {

    DataBase helper;
    EditText edt_CodAsignaEquipo;
    EditText edt_CodDocente;
    EditText edt_fechaAsignaEquipo;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_equipo_insertar);
        helper = new DataBase(this);
        edt_CodAsignaEquipo = (EditText) findViewById(R.id.edt_CodAsignaEquipo);
        edt_CodDocente = (EditText) findViewById(R.id.edt_CodDocente);
        edt_fechaAsignaEquipo = (EditText) findViewById(R.id.edt_fechaAsignaEquipo);

    }

    public void insertarAsignacionEquipo(View v) {
        int idAsignacionEquipo = Integer.parseInt(edt_CodAsignaEquipo.getText().toString());
        int idDocente = Integer.parseInt(edt_CodDocente.getText().toString());
        String fechaAsignacionEquipo = edt_fechaAsignaEquipo.getText().toString();
        String regInsertados;
        AsignacionEquipo asignaEquipo = new AsignacionEquipo();
        asignaEquipo.setIdAsignacionEquipo(idAsignacionEquipo);
        asignaEquipo.setIdDocente(idDocente);
        asignaEquipo.setFechaAsignacionEquipo(fechaAsignacionEquipo);


        helper.abrir();
        regInsertados = helper.insertar(asignaEquipo);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {

        edt_CodAsignaEquipo.setText("");
        edt_CodDocente.setText("");
        edt_fechaAsignaEquipo.setText("");

    }
}


