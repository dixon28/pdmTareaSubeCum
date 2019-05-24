package com.pdmsubecum.am15005.Activities.Marca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.R;

public class ConsultarMarcaActivity extends AppCompatActivity {

    DataBase helper;
    EditText idmarca;
    EditText conidmarca;
    EditText desmarca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_marca);
        helper=new DataBase(this);
        idmarca=findViewById(R.id.consultidMarca);
        conidmarca=findViewById(R.id.conIdMarca);
        desmarca=findViewById(R.id.conDesMarca);

    }




    public void consultarMar(View v) {
        String id;
        helper.abrir();
        Marca marca =
                helper.consultarM(idmarca.getText().toString());
        helper.cerrar();
       // id=Integer.toString(marca.getIdmarca());
        if(marca == null)
            Toast.makeText(this, "Marca con id  " +
                    idmarca.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            conidmarca.setText(idmarca.getText().toString());
            desmarca.setText(marca.getDescripcionmarca());

        }
    }
    public void limpiarTexto(View v){
        conidmarca.setText("");
        desmarca.setText("");
    }
}
