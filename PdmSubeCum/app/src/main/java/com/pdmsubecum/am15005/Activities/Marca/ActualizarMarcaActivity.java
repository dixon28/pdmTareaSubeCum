package com.pdmsubecum.am15005.Activities.Marca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.R;

import java.sql.SQLException;

public class ActualizarMarcaActivity extends AppCompatActivity {

    DataBase helper;
    EditText idmarca;
    EditText conidmarca;
    EditText desmarca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_marca);
        helper=new DataBase(this);
        idmarca=findViewById(R.id.consultidMarca);
        conidmarca=findViewById(R.id.conIdMarca);
        desmarca=findViewById(R.id.conDesMarca);
    }



    public void consultarMar(View v) {
        String id;
        helper.abrir();
        Marca marca =
                helper.consultarM(idmarca.getText().toString());
        helper.cerrar();
        id=Integer.toString(marca.getIdmarca());
        if(marca == null)
            Toast.makeText(this, "Marca con id  " +
                    idmarca.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            conidmarca.setText(id);
            desmarca.setText(marca.getDescripcionmarca());

        }
    }
    public void limpiarTexto(View v){
        conidmarca.setText("");
        desmarca.setText("");
    }

    public void ActualizarMar(View v) {
        int id = Integer.parseInt(idmarca.getText().toString());
        Marca marca = new Marca();
        marca.setIdmarca(Integer.parseInt(conidmarca.getText().toString()));
        marca.setDescripcionmarca(desmarca.getText().toString());
        if (helper.verificarIntegridadAM15005(marca, 1)) {

            Toast.makeText(this, "Ya existe un registro con el id " + conidmarca.getText().toString(), Toast.LENGTH_SHORT).show();
        } else {
            helper.abrir();

            int estado = helper.actualizar(marca, id);
            helper.cerrar();

            if (estado == 0) {
                Toast.makeText(this, "Error no se pudo actualizar el registro", Toast.LENGTH_SHORT).show();

            }
            Toast.makeText(this, String.valueOf(estado) + " un registro se ha actualizado", Toast.LENGTH_SHORT).show();
        }
    }
}
