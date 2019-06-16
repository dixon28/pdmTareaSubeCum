package com.pdmsubecum.WebServices;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@SuppressLint("NewApi")
public class DocumentoAsignacionWSActivity extends AppCompatActivity {

    TextView textView3;
    private String urlPublicoUES = "https://eisi.fia.ues.edu.sv/GPO01/WS/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_asignacion_ws);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        textView3= (TextView) findViewById(R.id.textView3);
    }



    public void consultarMaximaAsignacion(View v) {

        try {
            List<String> result = new ArrayList<String>();
            String url = urlPublicoUES + "ws_docuAsignaciones_maxCount.php";

            String existenciaJSON = ControladorServicio.obtenerRespuestaPeticion(url, this);
            String resultado = ControladorServicio.obtenerCantidadAsignacionesJSON(existenciaJSON,this);
            textView3.setText(resultado);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
