package com.pdmsubecum.WebServices;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.pdmsubecum.R;

public class ExistenciaWSActivity extends AppCompatActivity {

    EditText editDocumento;
    EditText editEquipo;
    TextView txt_Existencia;
    private String urlPublicoUES = "https://eisi.fia.ues.edu.sv/GPO01/WS/";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existencia_ws);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editDocumento = (EditText) findViewById(R.id.editNombreDoc);
        editEquipo = (EditText) findViewById(R.id.editModelo);
        txt_Existencia = (TextView) findViewById(R.id.textView_existencia);
    }

    public void consultarExistenciaDocumento(View v) {

        try {
            List<String> result = new ArrayList<String>();
            String nombredoc = editDocumento.getText().toString();

            String url = urlPublicoUES + "ws_documento_existencia.php" + "?nombredoc=" + nombredoc;

            String existenciaJSON = ControladorServicio.obtenerRespuestaPeticion(url, this);
            String resultado = ControladorServicio.obtenerExistenciaDocumentoJSON(existenciaJSON,this);
            txt_Existencia.setText(resultado);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void consultarExistenciaEquipo(View v) {

        try {
            List<String> result = new ArrayList<String>();
            String modelo = editEquipo.getText().toString();
            String url = urlPublicoUES + "ws_equipo_existencia.php" + "?modelo=" + modelo;

            String existenciaJSON = ControladorServicio.obtenerRespuestaPeticion(url, this);
            String resultado = ControladorServicio.obtenerExistenciaEquipoJSON(existenciaJSON,this);
            txt_Existencia.setText(resultado);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
