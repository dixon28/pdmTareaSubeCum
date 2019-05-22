package com.pdmsubecum.rl08017;

import android.app.Activity;
import android.os.Bundle;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TiMovDocumentoEliminarActivity extends Activity {

    EditText editTipo;
    DataBase controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ti_mov_documento_eliminar);
        controlhelper=new DataBase (this);
        editTipo=(EditText)findViewById(R.id.editTipo);
    }
    public void eliminar(View v){
        try{
            String regEliminadas;
            TiposDeMovimientoParaDocumento tipo=new TiposDeMovimientoParaDocumento();
            tipo.setIdTiposDeMovimientoParaDocumento(Integer.parseInt(editTipo.getText().toString()));
            controlhelper.abrir();
            regEliminadas=controlhelper.eliminar(tipo);
            controlhelper.cerrar();
            Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){
            Toast.makeText(this,"datos incompletos o incorrectos",Toast.LENGTH_SHORT).show();
        }

    }
}
