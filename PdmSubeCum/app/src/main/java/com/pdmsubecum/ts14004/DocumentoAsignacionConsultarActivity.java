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

import static java.lang.Integer.parseInt;

public class DocumentoAsignacionConsultarActivity extends AppCompatActivity {

    DataBase helper;
    EditText edt_CodDocuAsignacion;
    EditText edt_CodDocente;
    EditText edt_Motivo;
    EditText edt_fechaDocuAsignacion;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_asignacion_consultar);
        helper = new DataBase(this);
        edt_CodDocuAsignacion= (EditText) findViewById(R.id.edt_CodDocuAsignacion);
        edt_CodDocente = (EditText) findViewById(R.id.edt_CodDocente);
        edt_Motivo = (EditText) findViewById(R.id.edt_Motivo);
        edt_fechaDocuAsignacion = (EditText) findViewById(R.id.edt_fechaDocuAsignacion);

    }
    public void consultarDocumentoAsignacion(View v) {

        helper.abrir();
        DocumentoAsignacion documentoAsignacion = helper.consultarDocumentoAsignacion(parseInt(edt_CodDocuAsignacion.getText().toString()));
        helper.cerrar();
        if (documentoAsignacion == null)
            Toast.makeText(this, "Asignacion de Equipo con Codigo " + parseInt(edt_CodDocuAsignacion.getText().toString()) + " no encontrado", Toast.LENGTH_LONG).show();
        else {
            edt_CodDocente.setText(String.valueOf(documentoAsignacion.getIdDocente()));
            edt_Motivo.setText(documentoAsignacion.getMotivo());
            edt_fechaDocuAsignacion.setText(documentoAsignacion.getFechaAsignacionDoc());


        }
    }


    public void limpiarTexto(View v) {

        edt_CodDocuAsignacion.setText("");
        edt_CodDocente.setText("");
        edt_Motivo.setText("");
        edt_fechaDocuAsignacion.setText("");

    }
}
