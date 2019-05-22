package com.pdmsubecum.rl08017;

import android.app.Activity;
import android.os.Bundle;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TiMovDocumentoConsultarActivity extends Activity {

    DataBase helper;
    EditText editTipo;
    EditText editDescripcion;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_ti_mov_documento_consultar);
        helper = new DataBase(this);
        editTipo = (EditText) findViewById(R.id.editTipo);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
    }
    public void consultarAlumno(View v) {

        try{
            helper.abrir();
            TiposDeMovimientoParaDocumento tipo = helper.consultarTipoMov(editTipo.getText().toString());
            helper.cerrar();
            if(tipo == null)
                Toast.makeText(this, "Tipo de movimiento " + editTipo.getText().toString() +
                        " no encontrado", Toast.LENGTH_LONG).show();
            else{

                editTipo.setText(String.valueOf(tipo.getIdTiposDeMovimientoParaDocumento()));
                editDescripcion.setText(tipo.getDescripcionMovimientoDoc());
            }

        }
        catch (Exception e){
            Toast.makeText(this,"datos incompletos o incorrectos",Toast.LENGTH_SHORT).show();
        }

    }
    public void limpiarTexto(View v){
        editTipo.setText("");
        editDescripcion.setText("");
    }

}
