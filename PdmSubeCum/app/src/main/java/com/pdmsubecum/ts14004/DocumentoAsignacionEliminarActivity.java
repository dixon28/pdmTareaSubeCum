package com.pdmsubecum.ts14004;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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


    public void eliminarDocumentoAsignacion(View v){

            AlertDialog.Builder dialogo = new AlertDialog.Builder(DocumentoAsignacionEliminarActivity.this);
             dialogo.setIcon(R.mipmap.ic_launcher).
            setMessage("Importante").
                    setMessage("El identificador está asociado a otras registros\n\n ¿Desea eliminar en cascada?").
                    setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            aceptar();
                            Toast.makeText(DocumentoAsignacionEliminarActivity.this, "Eliminado Satisfactoriamente", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dialogo.create();

            dialogo.show();

    }

    public void aceptar() {
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
