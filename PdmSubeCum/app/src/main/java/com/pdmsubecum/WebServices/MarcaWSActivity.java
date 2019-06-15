package com.pdmsubecum.WebServices;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.R;
import com.pdmsubecum.mm14031.Materia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@SuppressLint("NewApi")
public class MarcaWSActivity extends AppCompatActivity {

    DataBase db;
    static List<Marca> listaMarcas;
    static List<String> nombreMarcas;
    EditText fechaTxt;
    ListView listViewMarcas;
    private String urlPublicoUES = "https://eisi.fia.ues.edu.sv/GPO01/WS/";

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
        fechaTxt = (EditText) findViewById(R.id.editText_fecha);
        listViewMarcas = (ListView) findViewById(R.id.listView1);
    }

    public void servicioPHP(View v) {

        String[] fecha = fechaTxt.getText().toString().split("/");
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
