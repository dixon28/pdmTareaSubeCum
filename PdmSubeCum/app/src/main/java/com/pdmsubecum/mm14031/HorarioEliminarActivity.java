package com.pdmsubecum.mm14031;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

public class HorarioEliminarActivity extends Activity {

    DataBase helper;
    EditText editIdHorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_eliminar);
        helper = new DataBase(this);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
    }

    public boolean verificarDatos(){

        if(editIdHorario.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el ID del horario.",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void eliminarHorario(View v){

        if(verificarDatos()){
            String mensaje ;
            Horario horario = new Horario();
            horario.setIdHorario(Integer.parseInt(editIdHorario.getText().toString()));

            helper.abrir();
            mensaje = helper.eliminarHorario(horario);
            helper.cerrar();

            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
        }
    }
}
