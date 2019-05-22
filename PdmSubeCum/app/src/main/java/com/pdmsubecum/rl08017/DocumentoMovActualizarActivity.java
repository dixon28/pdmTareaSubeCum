package com.pdmsubecum.rl08017;

import android.app.Activity;
import android.os.Bundle;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocumentoMovActualizarActivity extends Activity {


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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_mov_actualizar);
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
    public void actualizar(View v) {
        try{
            DocumentoMovimiento tipo = new DocumentoMovimiento();
            tipo.setIdDocMov(Integer.parseInt(editocMov.getText().toString()));
            tipo.setIdUnidadAdmOrigen(Integer.parseInt(editUnOrigen.getText().toString()));
            tipo.setIdUnidadAdmDestino(Integer.parseInt(editUniDestino.getText().toString()));
            tipo.setIdTipoMovDoc(Integer.parseInt(editTipo.getText().toString()));
            tipo.setComentario(editdescTipoM.getText().toString());
            tipo.setFecha(editfecha.getText().toString());
            tipo.setIdMovDocDetalle(Integer.parseInt(editidMovDetalle.getText().toString()));
            tipo.setIsbn(editisbnDoc.getText().toString());
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
