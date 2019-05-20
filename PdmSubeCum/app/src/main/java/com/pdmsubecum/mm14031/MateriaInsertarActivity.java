package com.pdmsubecum.mm14031;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

public class MateriaInsertarActivity extends Activity {

    DataBase helper;
    EditText editCodigo;
    EditText editNombre;
    EditText editUV;
    EditText editIdCiclo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_insertar);
        helper = new DataBase(this);
        editCodigo = (EditText) findViewById(R.id.editCodigo);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editUV = (EditText) findViewById(R.id.editUV);
        editIdCiclo = (EditText) findViewById(R.id.editIdCiclo);
    }

    public boolean verificarDatos(){

        if(editCodigo.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el código de materia.",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editNombre.getText().toString().matches("")){
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

    public void insertarMateria(View v){

        if (verificarDatos()){
            String mensaje;
            String codigoMateria = editCodigo.getText().toString();
            String nombreMateria = editNombre.getText().toString();
            String UV = editUV.getText().toString();
            int idCiclo = Integer.parseInt(editIdCiclo.getText().toString());

            Materia  materia = new Materia(codigoMateria,nombreMateria,UV,idCiclo);
            helper.abrir();
            mensaje = helper.insertarMateria(materia);
            helper.cerrar();

            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarTexto(View v){
        editCodigo.setText("");
        editNombre.setText("");
        editUV.setText("");
        editIdCiclo.setText("");
    }
}
