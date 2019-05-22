package com.pdmsubecum.rl08017;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

public class TiMovDocumentoInsertarActivity extends Activity {
    DataBase helper;
    EditText editID;
    EditText editDescricion;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ti_mov_documento_insertar);
        helper = new DataBase(this);
        editID = (EditText) findViewById(R.id.editID);
        editDescricion = (EditText) findViewById(R.id.editDescricion);
    }
    public void insertarTipoMovimiento(View v) {
        try{
            int carnet=Integer.parseInt(editID.getText().toString());
            String nombre=editDescricion.getText().toString();
            String regInsertados;
            TiposDeMovimientoParaDocumento movdoc=new TiposDeMovimientoParaDocumento();
            movdoc.setIdTiposDeMovimientoParaDocumento(carnet);
            movdoc.setDescripcionMovimientoDoc(nombre);
            helper.abrir();
            regInsertados=helper.insertar(movdoc);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){
        Toast.makeText(this,"datos incompletos o incorrectos",Toast.LENGTH_SHORT).show();
        }

    }
    public void limpiarTexto(View v) {
        editID.setText("");
        editDescricion.setText("");
    }
}
