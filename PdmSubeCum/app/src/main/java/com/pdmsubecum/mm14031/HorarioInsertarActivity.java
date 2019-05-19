package com.pdmsubecum.mm14031;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

public class HorarioInsertarActivity extends Activity {

    DataBase helper;
    EditText editIdHorario;
    EditText editHora;
    EditText editIdAula;
    EditText editIdDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_insertar);
        helper = new DataBase(this);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editHora = (EditText) findViewById(R.id.editHora);
        editIdAula = (EditText) findViewById(R.id.editIdAula);
        editIdDia = (EditText) findViewById(R.id.editIdDia);
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

    public void insertarHorario(View v){

        if(verificarDatos()){
            String mensaje;
            int idHorario = Integer.parseInt(editIdHorario.getText().toString());
            int idDia = Integer.parseInt(editIdDia.getText().toString());
            int idAula = Integer.parseInt(editIdAula.getText().toString());
            String hora = editHora.getText().toString();

            Horario horario = new Horario(idHorario,idDia,idAula,hora);
            helper.abrir();
            mensaje = helper.insertarHorario(horario);
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
