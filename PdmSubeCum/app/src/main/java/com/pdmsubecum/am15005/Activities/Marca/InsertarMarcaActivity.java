package com.pdmsubecum.am15005.Activities.Marca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DBHelper;
import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.R;


public class InsertarMarcaActivity extends AppCompatActivity {

    DBHelper helper;
    DataBase db;
    EditText editIdMarca;
    EditText editDescripcionMarca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_marca);
        helper=new DBHelper(this);
        editIdMarca=findViewById(R.id.id_de_marca);
        editDescripcionMarca=findViewById(R.id.editDescripcion_marca);
        db= new DataBase(this);
    }

    public void insertarMarca(View v) {

        String Idmarca= editIdMarca.getText().toString();

        int id=Integer.parseInt(Idmarca);
        

      String descripcion=editDescripcionMarca.getText().toString();
       String regInsertados;
        Marca marca= new Marca();
        marca.setIdmarca(id);
        marca.setDescripcionmarca(descripcion);

        if (db.verificarIntegridadAM15005(marca,1)){

            Toast.makeText(this,"Ya existe un registro con el id "+Idmarca , Toast.LENGTH_SHORT).show();
        }
        else {

            db.abrir();
            db.insertar(marca);
            db.cerrar();
            Toast.makeText(this,Idmarca , Toast.LENGTH_SHORT).show();
        }


    }
    public void limpiarTexto(View v) {
        editIdMarca.setText("");
        editDescripcionMarca.setText("");
    }
}
