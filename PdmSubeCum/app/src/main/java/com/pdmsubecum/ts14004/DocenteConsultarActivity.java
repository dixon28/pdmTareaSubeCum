package com.pdmsubecum.ts14004;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.Docente;
import com.pdmsubecum.R;

import static java.lang.Integer.parseInt;

public class DocenteConsultarActivity extends AppCompatActivity {

    DataBase helper;
    EditText edt_CodDocente;
    EditText edt_CodUnidad;
    EditText edt_Nombre;
    EditText edt_apellido;
    EditText edt_email;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_consultar);
        helper = new DataBase(this);
        edt_CodDocente = (EditText) findViewById(R.id.edt_CodDocente);
        edt_CodUnidad = (EditText) findViewById(R.id.edt_CodUnidad);
        edt_Nombre = (EditText) findViewById(R.id.edt_Nombre);
        edt_apellido = (EditText) findViewById(R.id.edt_apellido);
        edt_email = (EditText) findViewById(R.id.edt_email);
    }

    public void consultarDocente(View v) {
        try{
        helper.abrir();
        Docente docente = helper.consultarDocente(parseInt(edt_CodDocente.getText().toString()));
        helper.cerrar();
        if (docente == null)
            Toast.makeText(this, "Docente con Codigo " + parseInt(edt_CodDocente.getText().toString()) + " no encontrado", Toast.LENGTH_LONG).show();
        else {
            edt_CodUnidad.setText(String.valueOf(docente.getIdUnidadAdministrativa()));
            edt_Nombre.setText(docente.getNombre());
            edt_apellido.setText(docente.getApellido());
            edt_email.setText(docente.getEmail());

        }
        }catch (Exception e){
            Toast.makeText(this,"Por favor ingrese el ID  ", Toast.LENGTH_SHORT).show();
        }
    }



    public void limpiarTexto(View v) {
        edt_CodDocente.setText("");
        edt_CodUnidad.setText("");
        edt_Nombre.setText("");
        edt_apellido.setText("");
        edt_email.setText("");

    }
}