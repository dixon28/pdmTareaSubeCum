package com.pdmsubecum.rl08017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

public class DocumentoExisInsertarActivity extends AppCompatActivity {

    DataBase helper;
    EditText editID;
    EditText editIsbn;
    EditText editIdDocente;
    EditText editUnidadAdm;
    EditText editActual;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_exis_insertar);
        helper = new DataBase(this);
        editID = (EditText) findViewById(R.id.editID);
        editIsbn = (EditText) findViewById(R.id.editIsbn);
        editIdDocente = (EditText) findViewById(R.id.editIdDocente);
        editUnidadAdm = (EditText) findViewById(R.id.editUnidadAdm);
        editActual = (EditText) findViewById(R.id.editActual);
    }
    public void insertar(View v) {
        try{
            int id=Integer.parseInt(editID.getText().toString());
            String isbn=editIsbn.getText().toString();
            int docente=Integer.parseInt(editIdDocente.getText().toString());
            int unidad=Integer.parseInt(editUnidadAdm.getText().toString());
            int actual=Integer.parseInt(editActual.getText().toString());
            String regInsertados;
            DocumentoExistencia docExis=new DocumentoExistencia();
            docExis.setIdDocumentoExistencia(id);
            docExis.setIsbn(isbn);
            docExis.setIdDocente(docente);
            docExis.setIdUnidadAdministrativa(unidad);
            docExis.setActual(actual);
            helper.abrir();
            regInsertados=helper.insertar(docExis);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){
            Toast.makeText(this,"datos incompletos o incorrectos",Toast.LENGTH_SHORT).show();
        }

    }
    public void limpiarTexto(View v) {
        editID.setText("");
        editIsbn.setText("");
        editIdDocente.setText("");
        editUnidadAdm.setText("");
        editActual.setText("");
    }
}
