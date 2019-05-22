package com.pdmsubecum.rl08017;

import android.app.Activity;
import android.os.Bundle;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocumentoMovConsultarActivity extends Activity {


    DataBase helper;
    EditText editocMov;
    EditText editUnOrigen;
    EditText editUniDestino;
    EditText editTipo;
    EditText editdescTipoM;
    EditText editfecha;
    EditText editisbnDoc;
    EditText editidMovDetalle;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_documento_mov_consultar);
        helper = new DataBase(this);
        editocMov = (EditText) findViewById(R.id.editocMov);
        editUnOrigen = (EditText) findViewById(R.id.editUnOrigen);
        editUniDestino = (EditText) findViewById(R.id.editUniDestino);
        editTipo = (EditText) findViewById(R.id.editTipo);
        editdescTipoM = (EditText) findViewById(R.id.editdescTipoM);
        editfecha = (EditText) findViewById(R.id.editfecha);
        editisbnDoc = (EditText) findViewById(R.id.editisbnDoc);
        editidMovDetalle = (EditText) findViewById(R.id.editidMovDetalle);
    }
    public void consultar(View v) {

        try{
            helper.abrir();
            DocumentoMovimiento tipo = helper.consultarDocMov(editocMov.getText().toString());
            helper.cerrar();
            if(tipo == null)
                Toast.makeText(this, "Tipo de movimiento " + editocMov.getText().toString() +
                        " no encontrado", Toast.LENGTH_LONG).show();
            else{

                editocMov.setText(String.valueOf(tipo.getIdDocMov()));
                editUnOrigen.setText(String.valueOf(tipo.getIdUnidadAdmOrigen()));
                editUniDestino.setText(String.valueOf(tipo.getIdUnidadAdmDestino()));
                editTipo.setText(String.valueOf(tipo.getIdTipoMovDoc()));
                editdescTipoM.setText(tipo.getComentario());
                editfecha.setText(tipo.getFecha());
                editisbnDoc.setText(String.valueOf(tipo.getIsbn()));
                editidMovDetalle.setText(tipo.getIdMovDocDetalle());
            }

        }
        catch (Exception e){
            Toast.makeText(this,"datos incompletos o incorrectos",Toast.LENGTH_SHORT).show();
        }

    }
    public void limpiarTexto(View v){
        editocMov.setText("");
        editUnOrigen.setText("");
        editUniDestino.setText("");
        editTipo.setText("");
        editdescTipoM.setText("");
        editfecha.setText("");
        editisbnDoc.setText("");
        editidMovDetalle.setText("");
    }
}
