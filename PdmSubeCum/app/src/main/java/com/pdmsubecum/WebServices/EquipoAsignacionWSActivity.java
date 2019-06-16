package com.pdmsubecum.WebServices;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pdmsubecum.R;

import java.util.ArrayList;
import java.util.List;

public class EquipoAsignacionWSActivity extends AppCompatActivity {

    EditText editModelo;
    TextView txt_cantidad;
    private String urlPublicoUES = "https://eisi.fia.ues.edu.sv/GPO01/WS/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo_asignacion_ws);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editModelo = (EditText) findViewById(R.id.editModelo);
        txt_cantidad= (TextView) findViewById(R.id.textView_Cantidad);
    }

    public void consultarCantidadAsignado(View v) {

        try {
            List<String> result = new ArrayList<String>();
            String modelo = editModelo.getText().toString();

            String url = urlPublicoUES + "ws_equipoasignacion_consulta_modelo.php" + "?modelo=" + modelo;

            String existenciaJSON = ControladorServicio.obtenerRespuestaPeticion(url, this);
            String resultado = ControladorServicio.obtenerCantidadAsignadoJSON(existenciaJSON,this);
            txt_cantidad.setText(resultado);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void consultarMaximoAsignado(View v) {

        try {
            List<String> result = new ArrayList<String>();
            String url = urlPublicoUES + "ws_equipoasignacion_consulta_maximo.php";

            String existenciaJSON = ControladorServicio.obtenerRespuestaPeticion(url, this);
            String resultado = ControladorServicio.obtenerCantidadAsignadoJSON(existenciaJSON,this);
            txt_cantidad.setText(resultado);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
