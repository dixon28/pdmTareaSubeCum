package com.pdmsubecum.rl08017;

import android.app.Activity;
import android.os.Bundle;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocumentoMovEliminarActivity extends Activity {

    EditText EditDocMov;
    DataBase controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_mov_eliminar);
        controlhelper=new DataBase (this);
        EditDocMov=(EditText)findViewById(R.id.EditDocMov);
    }
    public void eliminar(View v){
        String regEliminadas;
        DocumentoMovimiento tipo=new DocumentoMovimiento();
        tipo.setIdDocMov(Integer.parseInt(EditDocMov.getText().toString()));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(tipo);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
