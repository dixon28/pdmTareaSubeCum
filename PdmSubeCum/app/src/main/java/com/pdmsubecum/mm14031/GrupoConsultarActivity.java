package com.pdmsubecum.mm14031;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

public class GrupoConsultarActivity extends Activity {

    DataBase helper;
    EditText editIdGrupo;
    EditText editDescripcion;
    EditText editCodigoMateria;
    EditText editIdDocente;
    EditText editIdHorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo_consultar);
        helper = new DataBase(this);

        editIdGrupo = (EditText) findViewById(R.id.editIdGrupo);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
        editCodigoMateria = (EditText) findViewById(R.id.editCodigoMateria);
        editIdDocente = (EditText) findViewById(R.id.editIdDocente);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
    }

    public boolean verificarDatos(){

        if(editIdGrupo.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el ID del grupo.",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void consultarGrupo(View v){

        if (verificarDatos()){

            String descripcionHorario = "";
            int idGrupo = Integer.parseInt(editIdGrupo.getText().toString());
            helper.abrir();
            Grupo grupo = helper.consultarGrupo(idGrupo);
            helper.cerrar();

            helper.abrir();
            HorarioDetalle horarioDetalle = helper.consultarHorarioDetallePorIdGrupo(idGrupo);
            helper.cerrar();

            if (horarioDetalle != null){
                int idHorario = horarioDetalle.getIdHoraio();
                helper.abrir();
                Horario horario = helper.consultarHorario(idHorario);
                helper.cerrar();

                if (horario != null){
                    descripcionHorario = horario.getHora().toString();
                }else{
                    descripcionHorario = null;
                }
            }

            if(grupo == null){
                Toast.makeText(this,"Grupo con ID: " + editIdGrupo.getText().toString() +
                        " No existe",Toast.LENGTH_SHORT).show();
            }else{
                editDescripcion.setText(grupo.getDescripcion());
                editCodigoMateria.setText(grupo.getCodigoMateria());
                editIdDocente.setText(String.valueOf(grupo.getIdDocente()));

                if (descripcionHorario != null){
                    editIdHorario.setText(descripcionHorario);
                }else{
                    editIdHorario.setText("Horario no asignado");
                }
            }
        }

    }

    public void limpiarTexto(View v){
        editIdGrupo.setText("");
        editDescripcion.setText("");
        editCodigoMateria.setText("");
        editIdDocente.setText("");
        editIdHorario.setText("");
    }

}
