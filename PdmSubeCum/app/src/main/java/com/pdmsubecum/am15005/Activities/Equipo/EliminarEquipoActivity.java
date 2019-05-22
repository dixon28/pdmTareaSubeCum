package com.pdmsubecum.am15005.Activities.Equipo;

import android.app.Notification;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_equipo);

        controlhelper=new DataBase(this);
        editeq=(EditText)findViewById(R.id.elimequipo);
    }



    public void eliminarEquipo(View v){
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
