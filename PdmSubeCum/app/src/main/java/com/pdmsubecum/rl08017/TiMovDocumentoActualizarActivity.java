package com.pdmsubecum.rl08017;

import android.app.Activity;
import android.os.Bundle;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TiMovDocumentoActualizarActivity extends Activity {

    DataBase helper;
    EditText editTipo;
    EditText editDescripcion;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ti_mov_documento_actualizar);
        helper = new DataBase(this);
        editTipo = (EditText) findViewById(R.id.editTipo);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
    }
    public void actualizar(View v) {
        try{
            TiposDeMovimientoParaDocumento tipo = new TiposDeMovimientoParaDocumento();
            tipo.setIdTiposDeMovimientoParaDocumento(Integer.parseInt(editTipo.getText().toString()));
            tipo.setDescripcionMovimientoDoc(editDescripcion.getText().toString());
            helper.abrir();
            String estado = helper.actualizar(tipo);
            helper.cerrar();
            Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){
            Toast.makeText(this,"datos incompletos o incorrectos",Toast.LENGTH_SHORT).show();
        }

    }
    public void limpiarTexto(View v) {
        editTipo.setText("");
        editDescripcion.setText("");
    }

}
