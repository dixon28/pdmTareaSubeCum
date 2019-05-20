package com.pdmsubecum.rl08017;

import android.app.Activity;
import android.os.Bundle;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocumentoExisConsultarActivity extends Activity {

    DataBase helper;
    EditText editID;
    EditText editID2;
    EditText editIsbn;
    EditText editIdDocente;
    EditText editUnidadAdm;
    EditText editActual;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_documento_exis_consultar);
        helper = new DataBase(this);
        editID = (EditText) findViewById(R.id.editID);
        editID2 = (EditText) findViewById(R.id.editID2);
        editIsbn = (EditText) findViewById(R.id.editIsbn);
        editIdDocente = (EditText) findViewById(R.id.editIdDocente);
        editUnidadAdm = (EditText) findViewById(R.id.editUnidadAdm);
        editActual = (EditText) findViewById(R.id.editActual);
    }
    public void consultar(View v) {
        helper.abrir();
        DocumentoExistencia tipo = helper.consultarDocExistencia(editID.getText().toString());
        helper.cerrar();
        if(tipo == null)
            Toast.makeText(this, "Tipo de movimiento " + editID.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{

            editID2.setText(String.valueOf(tipo.getIdDocumentoExistencia()));
            editIsbn.setText(tipo.getIsbn());
            editIdDocente.setText(String.valueOf(tipo.getIdDocente()));
            editUnidadAdm.setText(String.valueOf(tipo.getIdUnidadAdministrativa()));
            editActual.setText(String.valueOf(tipo.getActual()));
        }
    }
    public void limpiarTexto(View v){
        editID.setText("");
        editIsbn.setText("");
        editIdDocente.setText("");
        editUnidadAdm.setText("");
        editActual.setText("");
    }
}
