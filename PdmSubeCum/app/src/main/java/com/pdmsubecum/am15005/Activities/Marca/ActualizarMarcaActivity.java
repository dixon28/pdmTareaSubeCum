package com.pdmsubecum.am15005.Activities.Marca;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_marca);
        helper=new DataBase(this);
        idmarca=findViewById(R.id.consultidMarca);
        conidmarca=findViewById(R.id.conIdMarca);
        desmarca=findViewById(R.id.conDesMarca);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.mensaje_actualizar)+getString(R.string.equipo))
                .setTitle(R.string.titulo_dialogo_update);

        builder.setPositiveButton(R.string.confirmar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { ActualizarMar();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                cancelar();
            }
        });

        dialog = builder.create();
    }



    public void consultarMar(View v) {
        String id;
        helper.abrir();
        Marca marca =
                helper.consultarM(idmarca.getText().toString());
        helper.cerrar();

        if(marca == null)
            Toast.makeText(this,R.string.rellenarid,Toast.LENGTH_SHORT).show();
        else{
            id=Integer.toString(marca.getIdmarca());

            conidmarca.setText(id);
            desmarca.setText(marca.getDescripcionmarca());
            idmarca.setEnabled(false);

        }
    }
    public void limpiarTexto(View v){
        conidmarca.setText("");
        desmarca.setText("");
    }

    public void ActualizarMar() {
        try {


            int id = Integer.parseInt(idmarca.getText().toString());
            Marca marca = new Marca();
            marca.setIdmarca(Integer.parseInt(conidmarca.getText().toString()));
            marca.setDescripcionmarca(desmarca.getText().toString());
                helper.abrir();

                int estado = helper.actualizar(marca, id);
                helper.cerrar();

                if (estado == 0) {
                    Toast.makeText(this, getString(R.string.noactualizado), Toast.LENGTH_SHORT).show();

                }
                Toast.makeText(this, getString(R.string.actualizado), Toast.LENGTH_SHORT).show();


        }catch (Exception e)
        {

            Toast.makeText(this,getString(R.string.nulo),Toast.LENGTH_SHORT).show();




        }
    }

    public void cancelar(){
        Toast.makeText(this,R.string.cancelar,Toast.LENGTH_SHORT).show();
    }


    public  void actualizar( View view) {


        switch (view.getId()) {

            case R.id.botonActualizar:
                if (conidmarca.getText().toString().isEmpty()||desmarca.getText().toString().isEmpty()) {
                    Toast.makeText(this, getString(R.string.nulo), Toast.LENGTH_SHORT).show();
                } else {

                    helper.abrir();
                    Marca marca = helper.consultarM(idmarca.getText().toString());
                    helper.cerrar();

                    if (marca == null) {

                        Toast.makeText(this, R.string.nulo, Toast.LENGTH_SHORT).show();

                    } else {
                        // Create the AlertDialog
                        dialog.show();
                    }
                }


        }
    }

}
