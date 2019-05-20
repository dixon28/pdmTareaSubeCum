package com.pdmsubecum.rl08017;

import android.app.Activity;
import android.os.Bundle;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocumentoExisActualizarActivity extends Activity {

    DataBase helper;
    EditText editID;
    EditText editIsbn;
    EditText editIdDocente;
    EditText editUnidadAdm;
    EditText editActual;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_exis_actualizar);
        helper = new DataBase(this);
        editID = (EditText) findViewById(R.id.editID);
        editIsbn = (EditText) findViewById(R.id.editIsbn);
        editIdDocente = (EditText) findViewById(R.id.editIdDocente);
        editUnidadAdm = (EditText) findViewById(R.id.editUnidadAdm);
        editActual = (EditText) findViewById(R.id.editActual);
    }
    public void actualizar(View v) {
        DocumentoExistencia tipo = new DocumentoExistencia();
        tipo.setIdDocumentoExistencia(Integer.parseInt(editID.getText().toString()));
        tipo.setIsbn(editIsbn.getText().toString());
        tipo.setIdDocente(Integer.parseInt(editIdDocente.getText().toString()));
        tipo.setIdUnidadAdministrativa(Integer.parseInt(editUnidadAdm.getText().toString()));
        tipo.setActual(Integer.parseInt(editActual.getText().toString()));
        helper.abrir();
        String estado = helper.actualizar(tipo);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editID.setText("");
        editIsbn.setText("");
        editIdDocente.setText("");
        editUnidadAdm.setText("");
        editActual.setText("");
    }
}
