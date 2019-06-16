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

    DataBase db;
    static List<Marca> listaMarcas;
    static List<String> nombreMarcas;
    ListView listViewMarcas;
    private String urlPublicoUES = "https://eisi.fia.ues.edu.sv/GPO01/WS/";
    EditText editIdMarca;
    EditText editMarca;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marca_ws);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        db = new DataBase(this);
        listaMarcas = new ArrayList<Marca>();
        nombreMarcas = new ArrayList<String>();
        listViewMarcas = (ListView) findViewById(R.id.listView1);
        editIdMarca = (EditText) findViewById(R.id.editIdMarca);
        editMarca = (EditText) findViewById(R.id.editMarca);
    }

    public void insertarMarca(View v) {

        int idMarca = Integer.parseInt(editIdMarca.getText().toString());
        String descripcion = editMarca.getText().toString();

        String url = "";
        JSONObject datosMarca = new JSONObject();
        JSONObject marca = new JSONObject();

        switch(v.getId()) {
            case R.id.button_IngresarMarca:
                url = urlPublicoUES + "ws_marca_insertar.php" + "?idmarca=" + idMarca + "&descripcion=" + descripcion;
                ControladorServicio.insertarEntidadExterno(url,this);
                break;
        }
    }

    public void servicioPHP(View v) {

        nombreMarcas.clear();
        String url = "";
        switch(v.getId()) {
            case R.id.button_Servicio:
                url = urlPublicoUES + "ws_marca_consulta.php";
                break;
        }

        String marcasExternas = ControladorServicio.obtenerRespuestaPeticion(url, this);
        try {
            listaMarcas.addAll(ControladorServicio.obtenerMarcasExterno(marcasExternas,this));
            actualizarListView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardar(View v) {
        db.abrir();
        for(int i=0; i < listaMarcas.size();i++){
            Log.v("guardar",db.insertarMarca(listaMarcas.get(i)));
        }
        db.cerrar();
        Toast.makeText(this, "Guardado con exito", Toast.LENGTH_LONG).show();
        listaMarcas.removeAll(listaMarcas);
        actualizarListView();
    }

    private void actualizarListView() {
        listViewMarcas.setAdapter(null);
        String dato = "";
        nombreMarcas.clear();
        for (int i = 0; i < listaMarcas.size(); i++) {
            dato = listaMarcas.get(i).getIdmarca()+ " " + listaMarcas.get(i).getDescripcionmarca();
            nombreMarcas.add(dato);
        }
        eliminarElementosDuplicados();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nombreMarcas);
        listViewMarcas.setAdapter(adaptador);
    }

    private void eliminarElementosDuplicados() {
        HashSet<Marca> conjuntoMarca = new HashSet<Marca>();
        conjuntoMarca.addAll(listaMarcas);

        listaMarcas.clear();
        listaMarcas.addAll(conjuntoMarca);

        HashSet<String> conjuntoNombre = new HashSet<String>();
        conjuntoNombre.addAll(nombreMarcas);
        nombreMarcas.clear();
        nombreMarcas.addAll(conjuntoNombre);
    }
}
