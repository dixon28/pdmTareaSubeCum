package com.pdmsubecum.ts14004;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.AsignacionEquipo;
import com.pdmsubecum.DB.modelo.DocumentoAsignacion;
import com.pdmsubecum.R;

public class DocumentoAsignacionEliminarActivity extends AppCompatActivity {

    EditText edt_CodDocuAsignacion;
    DataBase controlhelper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_asignacion_eliminar);
        controlhelper = new DataBase(this);
        edt_CodDocuAsignacion = (EditText) findViewById(R.id.edt_CodDocuAsignacion);
    }

    public void eliminarDocumentoAsignacion(View v) {
        String regEliminadas;
        DocumentoAsignacion documentoAsignacion = new DocumentoAsignacion();
        documentoAsignacion.setIdDocumentoAsignacion(Integer.parseInt(edt_CodDocuAsignacion.getText().toString()));
        controlhelper.abrir();
        regEliminadas = controlhelper.eliminar(documentoAsignacion);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }


    public void limpiarTexto(View v) {

        edt_CodDocuAsignacion.setText("");


    }
}
