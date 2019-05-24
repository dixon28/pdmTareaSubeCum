package com.pdmsubecum.am15005.Activities.Equipo;

import android.app.Notification;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Equipo;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.R;

public class EliminarEquipoActivity extends AppCompatActivity {

    private EditText editeq;
    private DataBase controlhelper;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_equipo);

        controlhelper=new DataBase(this);
        editeq=(EditText)findViewById(R.id.elimequipo);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.mensaje_eliminar)+ ""+ getString(R.string.equipo_existencia)

                +""+ getString(R.string.asignacionEquipoDetalle)+""+ getString(R.string.EquipoMovimientoDetalle))
                .setTitle(R.string.titulo_dialogo);

        builder.setPositiveButton(R.string.confirmar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                eliminarEquipo();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                cancelar();
            }
        });

        dialog = builder.create();
    }


    public void cancelar(){
        Toast.makeText(this, R.string.cancelar,Toast.LENGTH_SHORT).show();
    }


    public  void eliminar( View view)
    {
        switch (view.getId()){

            case R.id.eliminarEquipo:
                if(editeq.getText().toString().isEmpty()){
                    Toast.makeText(this,R.string.rellenarid, Toast.LENGTH_SHORT).show();
                }

                else{
                    // Create the AlertDialog

                    controlhelper.abrir();
                    Equipo equipo =controlhelper.consultarE(editeq.getText().toString());
                    controlhelper.cerrar();
                    if (equipo==null)
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




    public void eliminarEquipo(){
        String regEliminadas;
        int id= Integer.parseInt(editeq.getText().toString());
        Equipo equipo = new Equipo();
        equipo.setIdequipo(id);
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(equipo);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
