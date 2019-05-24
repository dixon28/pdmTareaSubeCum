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

public class AsignacionEquipoActualizarActivity extends AppCompatActivity {

    DataBase helper;
    EditText edt_CodAsignaEquipo;
    EditText edt_CodDocente;
    EditText edt_fechaAsignaEquipo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_equipo_actualizar);
        helper = new DataBase(this);
        edt_CodAsignaEquipo = (EditText) findViewById(R.id.edt_CodAsignaEquipo);
        edt_CodDocente = (EditText) findViewById(R.id.edt_CodDocente);
        edt_fechaAsignaEquipo = (EditText) findViewById(R.id.edt_fechaAsignaEquipo);

    }
    public void actualizarEquipoAsignacion(View v) {
        try {
            AsignacionEquipo asignacionEquipo = new AsignacionEquipo();
            asignacionEquipo.setIdAsignacionEquipo(parseInt(edt_CodAsignaEquipo.getText().toString()));
            asignacionEquipo.setIdDocente(parseInt(edt_CodDocente.getText().toString()));
            asignacionEquipo.setFechaAsignacionEquipo(edt_fechaAsignaEquipo.getText().toString());

            helper.abrir();
            String estado = helper.actualizar(asignacionEquipo);
            helper.cerrar();

            Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this,"Por favor rellene todos los campos ", Toast.LENGTH_SHORT).show();
        }
        }



    public void limpiarTexto(View v) {

        edt_CodAsignaEquipo.setText("");
        edt_CodDocente.setText("");
        edt_fechaAsignaEquipo.setText("");

    }
}
