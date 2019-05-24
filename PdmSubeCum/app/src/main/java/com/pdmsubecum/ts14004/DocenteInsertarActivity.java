package com.pdmsubecum.ts14004;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.Docente;
import com.pdmsubecum.R;

public class DocenteInsertarActivity extends AppCompatActivity  {

    DataBase helper;
    EditText edt_CodDocente;
    EditText edt_CodUnidad;
    EditText edt_Nombre;
    EditText edt_apellido;
    EditText edt_email;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_insertar);
        helper = new DataBase(this);
        edt_CodDocente = (EditText) findViewById(R.id.edt_CodDocente);
        edt_CodUnidad = (EditText) findViewById(R.id.edt_CodUnidad);
        edt_Nombre = (EditText) findViewById(R.id.edt_Nombre);
        edt_apellido = (EditText) findViewById(R.id.edt_apellido);
        edt_email = (EditText) findViewById(R.id.edt_email);
    }

    public void insertarDocente(View v) {
        try{
        int idDocente = Integer.parseInt(edt_CodDocente.getText().toString());
        int idUnidadAdministrativa = Integer.parseInt(edt_CodUnidad.getText().toString());
        String nombre = edt_Nombre.getText().toString();
        String apellido = edt_apellido.getText().toString();
        String email = edt_email.getText().toString();
        String regInsertados;
        Docente docente = new Docente();
        docente.setIdDocente(idDocente);
        docente.setIdUnidadAdministrativa(idUnidadAdministrativa);
        docente.setNombre(nombre);
        docente.setApellido(apellido);
        docente.setEmail(email);

        helper.abrir();
        regInsertados = helper.insertar(docente);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this,"Por favor rellene todos los campos ", Toast.LENGTH_SHORT).show();
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
