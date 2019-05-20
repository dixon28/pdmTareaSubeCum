package com.pdmsubecum.mm14031;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.R;

public class MateriaConsultarActivity extends Activity {

    DataBase helper;
    EditText editRCodigoMateria;
    EditText editRNombreMateria;
    EditText editRUV;
    EditText editRIdCiclo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_consultar);

        helper = new DataBase(this);

        editRCodigoMateria = (EditText) findViewById(R.id.editRCodigoMateria);
        editRNombreMateria = (EditText) findViewById(R.id.editRNombreMateria);
        editRUV = (EditText) findViewById(R.id.editRUV);
        editRIdCiclo = (EditText) findViewById(R.id.editRIdCiclo);
    }

    public boolean verificarDatos(){

        if(editRCodigoMateria.getText().toString().matches("")){
            Toast.makeText(this,"Debe digitar el código de materia.",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void consultarMateria(View v){

        if (verificarDatos()){
            helper.abrir();
            Materia materia = helper.consultarMateria(editRCodigoMateria.getText().toString());
            helper.cerrar();

            if(materia == null){
                Toast.makeText(this,"Materia con codigo: " + editRCodigoMateria.getText().toString() +
                        " No existe",Toast.LENGTH_SHORT).show();
            }else{
                int idCiclo = materia.getIdCiclo();
                helper.abrir();
                Ciclo ciclo = helper.consultarCiclo(idCiclo);
                helper.cerrar();

                editRNombreMateria.setText(materia.getNombreMateria());
                editRUV.setText(materia.getUV());

                if (ciclo != null){
                    editRIdCiclo.setText(ciclo.getNumero().toString());
                }else{
                    editRIdCiclo.setText(String.valueOf(materia.getIdCiclo()));
                }
            }
        }
    }

    public void limpiarTexto(View v){
        editRCodigoMateria.setText("");
        editRNombreMateria.setText("");
        editRUV.setText("");
        editRIdCiclo.setText("");
    }
}
