package com.pdmsubecum.rl08017;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocumentoMovEliminarActivity extends Activity {

    EditText EditDocMov;
    DataBase controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_mov_eliminar);
        controlhelper=new DataBase (this);
        EditDocMov=(EditText)findViewById(R.id.EditDocMov);
    }
    public void eliminar(View v){
        try{
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Importante");
            dialogo1.setMessage("¿ Desea eliminar los datos asociados a este registro ?");
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    aceptar();
                }
            });
            dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    cancelar();
                }
            });
            dialogo1.show();

        }
        catch (Exception e){
            Toast.makeText(this,"datos incompletos o incorrectos",Toast.LENGTH_SHORT).show();
        }

    }

    public void aceptar() {
        String regEliminadas;
        DocumentoMovimiento tipo=new DocumentoMovimiento();
        tipo.setIdDocMov(Integer.parseInt(EditDocMov.getText().toString()));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(tipo);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

    public void cancelar() {
        finish();
    }
}
