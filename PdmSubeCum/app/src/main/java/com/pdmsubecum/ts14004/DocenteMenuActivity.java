package com.pdmsubecum.ts14004;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pdmsubecum.R;

public class DocenteMenuActivity extends ListActivity {
    String[] menu = {"Insertar Registro", "Eliminar Registro", "Consultar Registro", "Actualizar Registro"};
    String[] activities = {"DocenteInsertarActivity", "DocenteEliminarActivity", "DocenteConsultarActivity", "DocenteActualizarActivity"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String nombreValue = activities[position];

        try {
            Class<?> clase = Class.forName("com.pdmsubecum.ts14004." + nombreValue);
            Intent inte = new Intent(this, clase);
            this.startActivity(inte);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
