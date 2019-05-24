package com.pdmsubecum.mm14031;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;
import com.pdmsubecum.ts14004.AsignacionEquipoEliminarActivity;

public class MateriaEliminarActivity extends Activity {

    DataBase helper;
    EditText editCodigoMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_eliminar);
        helper = new DataBase(this);
        editCodigoMateria = (EditText) findViewById(R.id.editCodigoMateria);
    }

    public boolean verificarDatos(){

        if(editCodigoMateria.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el código de materia.",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void eliminarMateria(View v){

        Log.d("BUSCAR","LLEGO AQUI");
        if (verificarDatos()){
            String mensaje ;
            Boolean grupoRelacionExiste;
            String codMateria = editCodigoMateria.getText().toString();

            helper.abrir();
            grupoRelacionExiste = helper.grupoRelacionExiste(codMateria);
            helper.cerrar();

            if (grupoRelacionExiste){
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MateriaEliminarActivity.this);
                dialogo.setIcon(R.mipmap.ic_launcher).
                        setMessage("Importante").
                        setMessage("La Materia está relacionada con otros registros.\n\n ¿Desea eliminar en cascada?").
                        setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                eliminar();
                                Toast.makeText(MateriaEliminarActivity.this, "Eliminado Satisfactoriamente", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialogo.create();
                dialogo.show();

            }else{
               Materia materia = new Materia();
               materia.setCodigoMateria(codMateria);

               helper.abrir();
               mensaje = helper.eliminarMateria(materia);
               helper.cerrar();

               Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void eliminar(){
        String mensaje;
        String codMateria = editCodigoMateria.getText().toString();
        Materia materia = new Materia();
        materia.setCodigoMateria(codMateria);
        helper.abrir();
        mensaje = helper.eliminarMateria(materia);
        helper.cerrar();
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }

}
