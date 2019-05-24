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

public class DocenteEliminarActivity extends AppCompatActivity  {


    EditText edt_CodDocente;
    DataBase controlhelper;
   // DataBase dataBase;
    AlertDialog dialog;
   // Button eliminarDocente;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_eliminar);
        controlhelper = new DataBase(this);
        edt_CodDocente = (EditText) findViewById(R.id.edt_CodDocente);

    }

               public void eliminarDocente(View v){
                    try {
                        Docente docente1 = new Docente();
                        docente1.setIdDocente(Integer.parseInt(edt_CodDocente.getText().toString()));
                        boolean existe;
                        controlhelper.abrir();
                        if (controlhelper.verificarIntegridadTS14004(docente1, 1)) {
                            existe = true;
                        } else {
                            existe = false;
                        }
                        controlhelper.cerrar();

                        if (existe) {
                            AlertDialog.Builder dialogo = new AlertDialog.Builder(DocenteEliminarActivity.this);
                            dialogo.setIcon(R.mipmap.ic_launcher).
                                    setMessage("Importante").
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
                                    Toast.makeText(DocenteEliminarActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }
                            });

                            dialogo.show();

                        } else {
                            Toast.makeText(this, "Registro No Existe", Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){
                   Toast.makeText(this,"Por favor rellene el ID ", Toast.LENGTH_SHORT).show();}


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

