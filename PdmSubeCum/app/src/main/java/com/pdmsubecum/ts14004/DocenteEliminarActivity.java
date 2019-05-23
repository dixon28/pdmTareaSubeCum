package com.pdmsubecum.ts14004;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.Docente;
import com.pdmsubecum.R;

public class DocenteEliminarActivity extends AppCompatActivity {


    EditText edt_CodDocente;
    DataBase controlhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_eliminar);
        controlhelper = new DataBase(this);
        edt_CodDocente = (EditText) findViewById(R.id.edt_CodDocente);
    }

                public void eliminarDocente(View v){
                AlertDialog.Builder dialogo = new AlertDialog.Builder(DocenteEliminarActivity.this);
               // dialogo.setIcon(R.mipmap.ic_launcher).
                        dialogo.setMessage("Importante").
                        setMessage("El identificador está asociado a otras registros\n\n ¿Desea eliminar en cascada?").
                        setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                aceptar();
                                Toast.makeText(DocenteEliminarActivity.this, "Eliminado Satisfactoriamente", Toast.LENGTH_SHORT).show();
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



    public void aceptar(){
        String regEliminadas;
        Docente docente = new Docente();
        docente.setIdDocente(Integer.parseInt(edt_CodDocente.getText().toString()));
        controlhelper.abrir();
        regEliminadas = controlhelper.eliminar(docente);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        edt_CodDocente.setText("");
    }
}

