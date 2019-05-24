package com.pdmsubecum.ts14004;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.Docente;
import com.pdmsubecum.R;

import static java.lang.Integer.parseInt;


public class DocenteActualizarActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_docente_actualizar);
        helper = new DataBase(this);
        edt_CodDocente = (EditText) findViewById(R.id.edt_CodDocente);
        edt_CodUnidad = (EditText) findViewById(R.id.edt_CodUnidad);
        edt_Nombre = (EditText) findViewById(R.id.edt_Nombre);
        edt_apellido = (EditText) findViewById(R.id.edt_apellido);
        edt_email = (EditText) findViewById(R.id.edt_email);
    }

    public void actualizarDocente(View v) {
        if(edt_CodUnidad.getText().toString().isEmpty() || edt_CodUnidad.getText().toString().isEmpty()||edt_Nombre.getText().toString().isEmpty()||edt_apellido.getText().toString().isEmpty()||edt_email.getText().toString().isEmpty()){
            Toast.makeText(this,"Por favor rellene todos los campos ", Toast.LENGTH_SHORT).show();
        }else {
            try {
                Docente docente = new Docente();
                docente.setIdDocente(parseInt(edt_CodDocente.getText().toString()));
                docente.setIdUnidadAdministrativa(parseInt(edt_CodUnidad.getText().toString()));
                docente.setNombre(edt_Nombre.getText().toString());
                docente.setApellido(edt_apellido.getText().toString());
                docente.setEmail(edt_email.getText().toString());

                helper.abrir();
                String estado = helper.actualizar(docente);
                helper.cerrar();

                Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Por favor rellene todos los campos ", Toast.LENGTH_SHORT).show();
            }
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


