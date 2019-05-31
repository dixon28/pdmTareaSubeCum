package com.pdmsubecum.am15005.Activities.Equipo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Equipo;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.R;

public class ConsultarEquipoActivity extends AppCompatActivity {
    EditText fechaingreso;
    DataBase helper;
    EditText idequipo;
    private EditText edtmarca;
    private EditText edtTipoEquipo;
    private EditText edtEquipoDis;
    private EditText edtEq;
    private EditText serie;
    private EditText modelo;
    private EditText carac;
    private EditText conid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_equipo);

        edtmarca=findViewById(R.id.EdtIdMarca);
        edtTipoEquipo=findViewById(R.id.EdtIdTiposEquipo);
        edtEquipoDis=findViewById(R.id.Edtequipodisponible);
        edtEq=findViewById(R.id.editequipo);
        modelo=findViewById(R.id.editmodelo);
        serie=findViewById(R.id.editserie);
        carac=findViewById(R.id.editcaracteristicas);
        fechaingreso = findViewById(R.id.editfechaingreso);
        conid=findViewById(R.id.consultidEquipo);
        helper=new DataBase(this);

    }

    public void ConsultarEquipo(View view) {


        String id;
        helper.abrir();
        Equipo equipo = helper.consultarE(conid.getText().toString());
        helper.cerrar();
       // id=Integer.toString(equipo.getIdequipo());
        if(equipo == null)
            Toast.makeText(this, getText(R.string.rellenarid), Toast.LENGTH_LONG).show();
        else{
            edtmarca.setText(String.valueOf(equipo.getIdmarca()));
            edtTipoEquipo.setText(String.valueOf(equipo.getIdtiposdeequipo()));
            if (equipo.isEquipodisponible()) {
                edtEquipoDis.setText("si");
            }
            else {

                edtEquipoDis.setText("no");

            }
            edtEq.setText(String.valueOf(equipo.getIdequipo()));
            modelo.setText(equipo.getModelo());
            serie.setText(equipo.getSerie());
            carac.setText(equipo.getCaracteristicas());
            fechaingreso.setText(equipo.getFechaingreso());

        }
    }

    public void LimpiarTexto(View view) {

        edtmarca.setText("");
        edtEq.setText("");
        edtTipoEquipo.setText("");
        edtEquipoDis.setText("");
        serie.setText("");
        modelo.setText("");
        carac.setText("");
        fechaingreso.setText("");
    }
}
