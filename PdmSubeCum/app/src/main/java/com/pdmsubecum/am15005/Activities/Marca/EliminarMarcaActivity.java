package com.pdmsubecum.am15005.Activities.Marca;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Equipo;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.R;

public class EliminarMarcaActivity extends AppCompatActivity {

    EditText editMarca;
    DataBase controlhelper;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_marca);
        controlhelper=new DataBase (this);
        editMarca =(EditText)findViewById(R.id.elimMarca);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.mensaje_eliminar)+getString(R.string.equipo))
                .setTitle(R.string.titulo_dialogo);

        builder.setPositiveButton(R.string.confirmar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                eliminarMarca();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                cancelar();
            }
        });

        dialog = builder.create();
    }


    public void eliminarMarca(){
        String regEliminadas;
       int id= Integer.parseInt(editMarca.getText().toString());
      Marca marca =new Marca();
      marca.setIdmarca(id);
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(marca);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

    public void cancelar(){
        Toast.makeText(this,R.string.cancelar,Toast.LENGTH_SHORT).show();
    }

    public  void eliminar( View view)
    {
        switch (view.getId()){

            case R.id.eliminar:
                if(editMarca.getText().toString().isEmpty()){
                    Toast.makeText(this,R.string.rellenarid, Toast.LENGTH_SHORT).show();
                }else{
                    controlhelper.abrir();
                    Marca marca =controlhelper.consultarM(editMarca.getText().toString());
                    controlhelper.cerrar();


                    if (marca==null)
                    {

                        Toast.makeText(this,R.string.verificar,Toast.LENGTH_SHORT).show();

                    }else {
                        // Create the AlertDialog
                        dialog.show();
                    }
                }
                break;


        }




    }


}
