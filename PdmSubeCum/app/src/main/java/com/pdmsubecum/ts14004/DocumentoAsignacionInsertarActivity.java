package com.pdmsubecum.ts14004;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.DocumentoAsignacion;
import com.pdmsubecum.R;

public class DocumentoAsignacionInsertarActivity extends AppCompatActivity {

    DataBase helper;
    EditText edt_CodDocuAsignacion;
    EditText edt_CodDocente;
    EditText edt_Motivo;
    EditText edt_fechaDocuAsignacion;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_asignacion_insertar);
        helper = new DataBase(this);
        edt_CodDocuAsignacion= (EditText) findViewById(R.id.edt_CodDocuAsignacion);
        edt_CodDocente = (EditText) findViewById(R.id.edt_CodDocente);
        edt_Motivo = (EditText) findViewById(R.id.edt_Motivo);
        edt_fechaDocuAsignacion = (EditText) findViewById(R.id.edt_fechaDocuAsignacion);

    }

    public void insertarDocumentoAsignacion(View v) {
        int idDocumentoAsignacion = Integer.parseInt(edt_CodDocuAsignacion.getText().toString());
        int idDocente = Integer.parseInt(edt_CodDocente.getText().toString());
        String motivo = edt_Motivo.getText().toString();
        String fechaAsignacionDoc = edt_fechaDocuAsignacion.getText().toString();
        String regInsertados;
        DocumentoAsignacion documentoAsignacion = new DocumentoAsignacion();
        documentoAsignacion.setIdDocumentoAsignacion(idDocumentoAsignacion);
        documentoAsignacion.setIdDocente(idDocente);
        documentoAsignacion.setMotivo(motivo);
        documentoAsignacion.setFechaAsignacionDoc(fechaAsignacionDoc);


        helper.abrir();
        regInsertados = helper.insertar(documentoAsignacion);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {

        edt_CodDocuAsignacion.setText("");
        edt_CodDocente.setText("");
        edt_Motivo.setText("");
        edt_fechaDocuAsignacion.setText("");

    }
}

