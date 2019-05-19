package com.pdmsubecum.mm14031;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

public class HorarioConsultarActivity extends Activity {

    DataBase helper;
    EditText editIdHorario;
    EditText editIdDia;
    EditText editIdAula;
    EditText editHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_consultar);
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

        return true;
    }

    public void consultarHorario(View v){

        if(verificarDatos()){
            int idHorario = Integer.parseInt(editIdHorario.getText().toString());
            helper.abrir();
            Horario horario = helper.consultarHorario(idHorario);
            helper.cerrar();

            if(horario == null){
                Toast.makeText(this,"Horario con ID: " + editIdHorario.getText().toString() +
                        "No encontrado",Toast.LENGTH_SHORT).show();
            }else{
                int idDia = horario.getIdDia();
                int idAula = horario.getIdAula();

                helper.abrir();
                Dia dia = helper.consultarDia(idDia);
                Aula aula = helper.consultarAula(idAula);
                helper.cerrar();

                if (dia != null){
                    editIdDia.setText(dia.getDescripcion().toString());
                }else{
                    editIdDia.setText(String.valueOf(horario.getIdDia()));
                }

                if (aula != null){
                    editIdAula.setText(aula.getDescripcion().toString());
                }else{
                    editIdAula.setText(String.valueOf(horario.getIdAula()));
                }

                editHora.setText(horario.getHora());
            }
        }
    }

    public void limpiarTexto(View v){
        editIdHorario.setText("");
        editIdDia.setText("");
        editIdAula.setText("");
        editHora.setText("");
    }
}
