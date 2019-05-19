package com.pdmsubecum.mm14031;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

public class HorarioActualizarActivity extends Activity {

    DataBase helper;
    EditText editIdHorario;
    EditText editIdDia;
    EditText editIdAula;
    EditText editHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_actualizar);
        helper = new DataBase(this);

        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editIdDia = (EditText) findViewById(R.id.editIdDia);
        editIdAula = (EditText) findViewById(R.id.editIdAula);
        editHora = (EditText) findViewById(R.id.editHora);
    }

    public boolean verificarDatos(){

        if(editIdHorario.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el ID del horario.",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editHora.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar la hora.",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editIdAula.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el ID del aula.",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editIdDia.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el ID del dia.",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void actualizarHorario(View v){

        if(verificarDatos()){
            Horario horario = new Horario();
            horario.setIdHorario(Integer.parseInt(editIdHorario.getText().toString()));
            horario.setIdDia(Integer.parseInt(editIdDia.getText().toString()));
            horario.setIdAula(Integer.parseInt(editIdAula.getText().toString()));
            horario.setHora(editHora.getText().toString());

            helper.abrir();
            String mensaje = helper.actualizarHorario(horario);
            helper.cerrar();

            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarTexto(View v){
        editIdHorario.setText("");
        editIdDia.setText("");
        editIdAula.setText("");
        editHora.setText("");
    }

}
