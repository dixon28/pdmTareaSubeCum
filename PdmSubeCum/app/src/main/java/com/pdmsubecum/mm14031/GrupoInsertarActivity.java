package com.pdmsubecum.mm14031;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

public class GrupoInsertarActivity extends Activity {

    DataBase helper;
    EditText editIdGrupo;
    EditText editDescripcion;
    EditText editCodigoMateria;
    EditText editIdHorario;
    EditText editIdDocente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo_insertar);
        helper = new DataBase(this);
        editIdGrupo = (EditText) findViewById(R.id.editIdGrupo);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
        editCodigoMateria = (EditText) findViewById(R.id.editCodigoMateria);
        editIdHorario = (EditText)findViewById(R.id.editIdHorario);
        editIdDocente = (EditText) findViewById(R.id.editIdDocente);
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

    public void insertarGrupo(View v){

        if(verificarDatos()){
            String mensaje;
            int idGrupo = Integer.parseInt(editIdGrupo.getText().toString());
            String descripcion = editDescripcion.getText().toString();
            String codigoMateria = editCodigoMateria.getText().toString();
            int idHorario = Integer.parseInt(editIdHorario.getText().toString());
            int idDocente = Integer.parseInt(editIdDocente.getText().toString());

            Grupo grupo = new Grupo(idGrupo,codigoMateria,idDocente,descripcion);
            HorarioDetalle horarioDetalle  = new HorarioDetalle(idGrupo,idHorario);

            helper.abrir();
            mensaje = helper.insertarGrupo(grupo,horarioDetalle);
            helper.cerrar();

            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
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
