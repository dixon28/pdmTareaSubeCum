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
import com.pdmsubecum.DB.modelo.am15005.Equipo;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.R;
import com.pdmsubecum.mm14031.Materia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@SuppressLint("NewApi")
public class EquipoWSActivity extends AppCompatActivity {

    DataBase db;
    static List<Equipo> listaEquipo;
    static List<String> nombreEquipo;
    ListView listViewEquipos;
    EditText fechaTxt;
    private String urlPublicoUES = "https://eisi.fia.ues.edu.sv/GPO01/WS/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo_ws);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        db = new DataBase(this);
        listaEquipo = new ArrayList<Equipo>();
        nombreEquipo = new ArrayList<String>();
        fechaTxt = (EditText) findViewById(R.id.editText_fecha);
        listViewEquipos = (ListView) findViewById(R.id.listView1);
    }

    public void servicioPHP(View v) {

        nombreEquipo.clear();
        String[] fecha = fechaTxt.getText().toString().split("/");
        String url = "";
        switch(v.getId()) {
            case R.id.button_Servicio:
                url = urlPublicoUES + "ws_equipo_consultaPorFecha.php" + "?day=" + fecha[0] +
                        "&month="+ fecha[1] + "&year=" + fecha[2];;
                break;
        }
        String equiposExternas = ControladorServicio.obtenerRespuestaPeticion(url, this);
        try {
            listaEquipo.addAll(ControladorServicio.obtenerEquiposExterno(equiposExternas,this));
            actualizarListView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardar(View v) {

        int numSincro = 0;

        db.abrir();
        for(int i=0; i < listaEquipo.size();i++){
            if (db.sincronizarEquipo(listaEquipo.get(i)) == true){
                numSincro = numSincro + 1;
            }
        }
        db.cerrar();

        if (numSincro > 0){
            Toast.makeText(this, "Equipos Agregados: " + numSincro, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "No equipos nuevos que agregar", Toast.LENGTH_LONG).show();
        }
        listaEquipo.removeAll(listaEquipo);
        actualizarListView();
    }

    private void actualizarListView() {
        listViewEquipos.setAdapter(null);
        String dato = "";
        nombreEquipo.clear();
        for (int i = 0; i < listaEquipo.size(); i++) {
            dato = "ID: "+ listaEquipo.get(i).getIdequipo()+ " MODELO: " + listaEquipo.get(i).getModelo() + " SERIE: "
                    + listaEquipo.get(i).getSerie();
            nombreEquipo.add(dato);
        }
        eliminarElementosDuplicados();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nombreEquipo);
        listViewEquipos.setAdapter(adaptador);
    }

    private void eliminarElementosDuplicados() {
        HashSet<Equipo> conjuntoEquipo = new HashSet<Equipo>();
        conjuntoEquipo.addAll(listaEquipo);

        listaEquipo.clear();
        listaEquipo.addAll(conjuntoEquipo);

        HashSet<String> conjuntoNombre = new HashSet<String>();
        conjuntoNombre.addAll(nombreEquipo);
        nombreEquipo.clear();
        nombreEquipo.addAll(conjuntoNombre);
    }


}
