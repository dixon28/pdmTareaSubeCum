package com.pdmsubecum.mm14031;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

public class GrupoEliminarActivity extends Activity {

    DataBase helper;
    EditText editIdGrupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo_eliminar);
        helper = new DataBase(this);
        editIdGrupo = (EditText) findViewById(R.id.editIdGrupo);
    }

    public boolean verificarDatos(){

        if(editIdGrupo.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el ID del grupo.",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void eliminarGrupo(View v){

        if(verificarDatos()){
            String mensaje ;
            Grupo grupo = new Grupo();
            grupo.setIdGrupo(Integer.parseInt(editIdGrupo.getText().toString()));

            helper.abrir();
            mensaje = helper.eliminarGrupo(grupo);
            helper.cerrar();

            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
        }
    }

}
