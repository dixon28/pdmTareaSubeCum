package com.pdmsubecum.mm14031;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

public class GrupoActualizarActivity extends Activity {

    DataBase helper;
    EditText editIdGrupo;
    EditText editCodigoMateria;
    EditText editIdDocente;
    EditText editIdHorario;
    EditText editDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo_actualizar);
        helper = new DataBase(this);
        editIdGrupo = (EditText) findViewById(R.id.editIdGrupo);
        editCodigoMateria = (EditText) findViewById(R.id.editCodigoMateria);
        editIdDocente = (EditText) findViewById(R.id.editIdDocente);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
    }

    public boolean verificarDatos(){

        if(editIdGrupo.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el ID del grupo.",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(editCodigoMateria.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el código de materia.",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editIdDocente.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el ID del docente.",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editIdHorario.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el ID del horario.",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editDescripcion.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar la descripción.",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void actualizarGrupo(View v){

        if (verificarDatos()){
            Grupo grupo = new Grupo();
            grupo.setIdGrupo(Integer.parseInt(editIdGrupo.getText().toString()));
            grupo.setCodigoMateria(editCodigoMateria.getText().toString());
            grupo.setIdDocente(Integer.parseInt(editIdDocente.getText().toString()));
            grupo.setDescripcion(editDescripcion.getText().toString());

            HorarioDetalle horarioDetalle = new HorarioDetalle();
            horarioDetalle.setIdGrupo(Integer.parseInt(editIdGrupo.getText().toString()));
            horarioDetalle.setIdHoraio(Integer.parseInt(editIdHorario.getText().toString()));

            helper.abrir();
            String mensaje = helper.actualizarGrupo(grupo,horarioDetalle);
            helper.cerrar();

            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
        }

    }

    public void limpiarTexto(View v){
        editIdGrupo.setText("");
        editCodigoMateria.setText("");
        editIdDocente.setText("");
        editDescripcion.setText("");
        editIdHorario.setText("");
    }
}
