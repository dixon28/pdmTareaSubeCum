package com.pdmsubecum.ts14004;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.Docente;
import com.pdmsubecum.R;

public class DocenteEliminarActivity extends AppCompatActivity {

    EditText edt_CodDocente;
    DataBase controlhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_eliminar);
        controlhelper = new DataBase(this);
        edt_CodDocente = (EditText) findViewById(R.id.edt_CodDocente);
    }

    public void eliminarDocente(View v) {
        String regEliminadas;
        Docente docente = new Docente();
        docente.setIdDocente(Integer.parseInt(edt_CodDocente.getText().toString()));
        controlhelper.abrir();
        regEliminadas = controlhelper.eliminar(docente);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        edt_CodDocente.setText("");
    }
}

