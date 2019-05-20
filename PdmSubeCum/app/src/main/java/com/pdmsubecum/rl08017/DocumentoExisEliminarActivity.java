package com.pdmsubecum.rl08017;

import android.app.Activity;
import android.os.Bundle;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocumentoExisEliminarActivity extends Activity {

    EditText idDoc;
    DataBase controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_exis_eliminar);
        controlhelper=new DataBase (this);
        idDoc=(EditText)findViewById(R.id.idDoc);
    }
    public void eliminar(View v){
        String regEliminadas;
        DocumentoExistencia tipo=new DocumentoExistencia();
        tipo.setIdDocumentoExistencia(Integer.parseInt(idDoc.getText().toString()));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(tipo);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
