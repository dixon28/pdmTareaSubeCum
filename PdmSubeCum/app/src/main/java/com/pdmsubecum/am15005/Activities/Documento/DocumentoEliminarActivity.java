package com.pdmsubecum.am15005.Activities.Documento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Documento;
import com.pdmsubecum.DB.modelo.am15005.Equipo;
import com.pdmsubecum.R;





public class DocumentoEliminarActivity extends AppCompatActivity {

    EditText conid;
    DataBase controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_eliminar);

        conid = findViewById(R.id.elimDoc);
        controlhelper=new DataBase(this);
    }


    public void eliminarDoc(View v){
        String regRestantes;
        Documento documento=new Documento();
        documento.setIsbn(conid.getText().toString());
        controlhelper.abrir();
        regRestantes=controlhelper.eliminar(documento);
        controlhelper.cerrar();
        Toast.makeText(this, regRestantes, Toast.LENGTH_SHORT).show();
    }
}
