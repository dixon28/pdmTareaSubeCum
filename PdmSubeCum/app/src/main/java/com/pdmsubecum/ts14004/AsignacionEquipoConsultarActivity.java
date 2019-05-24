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

import static java.lang.Integer.parseInt;

public class AsignacionEquipoConsultarActivity extends AppCompatActivity {


    DataBase helper;
    EditText edt_CodAsignaEquipo;
    EditText edt_CodDocente;
    EditText edt_fechaAsignaEquipo;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_equipo_consultar);
        helper = new DataBase(this);
        edt_CodAsignaEquipo = (EditText) findViewById(R.id.edt_CodAsignaEquipo);
        edt_CodDocente = (EditText) findViewById(R.id.edt_CodDocente);
        edt_fechaAsignaEquipo = (EditText) findViewById(R.id.edt_fechaAsignaEquipo);

    }

    public void consultarAsignacionEquipo(View v) {
        try {
        helper.abrir();
        AsignacionEquipo asignacionEquipo = helper.consultarAsignacionEquipo(parseInt(edt_CodAsignaEquipo.getText().toString()));
        helper.cerrar();
        if (asignacionEquipo == null)
            Toast.makeText(this, "Asignacon de Equipo con Codigo " + parseInt(edt_CodAsignaEquipo.getText().toString()) + " no encontrado", Toast.LENGTH_LONG).show();
        else {
            edt_CodDocente.setText(String.valueOf(asignacionEquipo.getIdDocente()));
            edt_fechaAsignaEquipo.setText(asignacionEquipo.getFechaAsignacionEquipo());
        }
        }catch (Exception e){
            Toast.makeText(this,"Por favor Ingrese el ID ", Toast.LENGTH_SHORT).show();
        }
    }



    public void limpiarTexto(View v) {

        edt_CodAsignaEquipo.setText("");
        edt_CodDocente.setText("");
        edt_fechaAsignaEquipo.setText("");

    }
}
