package com.pdmsubecum.WebServices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pdmsubecum.R;

public class WS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ws);
    }

    public void lanzarActividad(View v){

        Intent i = null;
        switch(v.getId()){

            case R.id.button_equipo:
                i = new Intent(this,EquipoWSActivity.class);
                break;
            case R.id.button_existencia:
                i = new Intent(this,ExistenciaWSActivity.class);
                break;
            case R.id.button_equipoAsignacion:
                i = new Intent(this,EquipoAsignacionWSActivity.class);
                break;
            case R.id.button_documentoAsignacion:
                i = new Intent(this,DocumentoAsignacionWSActivity.class);
        }

        if(i!=null){
            startActivity(i);
        }

    }
}
