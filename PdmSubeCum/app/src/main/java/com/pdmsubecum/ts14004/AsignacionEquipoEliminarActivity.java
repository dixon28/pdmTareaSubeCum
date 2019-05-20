package com.pdmsubecum.ts14004;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.AsignacionEquipo;
import com.pdmsubecum.DB.modelo.Docente;
import com.pdmsubecum.R;

public class AsignacionEquipoEliminarActivity extends AppCompatActivity {

    EditText edt_CodAsignaEquipo;
    DataBase controlhelper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_equipo_eliminar);
        controlhelper = new DataBase(this);
        edt_CodAsignaEquipo = (EditText) findViewById(R.id.edt_CodAsignaEquipo);
    }

    public void eliminarAsignacionEquipo(View v) {
        String regEliminadas;
        AsignacionEquipo asignacionEquipo = new AsignacionEquipo();
        asignacionEquipo.setIdAsignacionEquipo(Integer.parseInt(edt_CodAsignaEquipo.getText().toString()));
        controlhelper.abrir();
        regEliminadas = controlhelper.eliminar(asignacionEquipo);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }


    public void limpiarTexto(View v) {

        edt_CodAsignaEquipo.setText("");


    }
}
