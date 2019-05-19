package com.pdmsubecum.mm14031;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

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

        if (verificarDatos()){
            String mensaje ;
            Materia materia = new Materia();
            materia.setCodigoMateria(editCodigoMateria.getText().toString());

            helper.abrir();
            mensaje = helper.eliminarMateria(materia);
            helper.cerrar();

            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
        }
    }

}
