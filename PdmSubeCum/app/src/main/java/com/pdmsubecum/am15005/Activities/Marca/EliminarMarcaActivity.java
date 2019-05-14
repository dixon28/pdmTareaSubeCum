package com.pdmsubecum.am15005.Activities.Marca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.R;

public class EliminarMarcaActivity extends AppCompatActivity {

    EditText editMarca;
    DataBase controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_marca);
        controlhelper=new DataBase (this);
        editMarca =(EditText)findViewById(R.id.elimMarca);
    }


    public void eliminarMarca(View v){
        String regEliminadas;
       int id= Integer.parseInt(editMarca.getText().toString());
      Marca marca =new Marca();
      marca.setIdmarca(id);
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(marca);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
