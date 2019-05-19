package com.pdmsubecum.mm14031;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

public class MateriaActualizarActivity extends Activity {

    DataBase helper;
    EditText editCodigoMateria;
    EditText editNombreMateria;
    EditText editUV ;
    EditText editIdCiclo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_actualizar);
        helper = new DataBase(this);

        editCodigoMateria = (EditText) findViewById(R.id.editCodigoMateria);
        editNombreMateria = (EditText) findViewById(R.id.editNombreMateria);
        editUV = (EditText) findViewById(R.id.editUV);
        editIdCiclo = (EditText) findViewById(R.id.editIdCiclo);
    }

    public boolean verificarDatos(){

        if(editCodigoMateria.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el código de materia.",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editNombreMateria.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el nombre.",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editUV.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar las unidades valorativas.",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editIdCiclo.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el ID del ciclo.",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void actualizarMateria(View v){

        if (verificarDatos()){
            Materia materia = new Materia();
            materia.setCodigoMateria(editCodigoMateria.getText().toString());
            materia.setNombreMateria(editNombreMateria.getText().toString());
            materia.setUV(editUV.getText().toString());
            materia.setIdCiclo(Integer.parseInt(editIdCiclo.getText().toString()));

            helper.abrir();
            String mensaje = helper.actualizarMateria(materia);
            helper.cerrar();

            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarTexto(View v){
        editCodigoMateria.setText("");
        editNombreMateria.setText("");
        editUV.setText("");
        editIdCiclo.setText("");
    }

}
