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





public class DocumentoConsultarActivity extends AppCompatActivity {

    private EditText edtTipoDoc;
    private EditText isbn;
    private EditText nombredoc;
    private EditText idioma;
    private EditText descripcion;
    private EditText edtdisponible;
    private EditText connid;
    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_consultar);
        connid = findViewById(R.id.consultidDocumento);
        edtTipoDoc = findViewById(R.id.EdtIdTiposDoc);
        isbn = findViewById(R.id.editisbndeldoc);
        idioma = findViewById(R.id.editIdioma);
        descripcion = findViewById(R.id.editDescricionDoc);
        nombredoc = findViewById(R.id.editnombredoc);
        edtdisponible = findViewById(R.id.EdtDocdisponible);
        db = new DataBase(this);

    }

    public void ConsultarDocumento(View view) {

        db.abrir();
        Documento doc = db.consultarD(connid.getText().toString());
        db.cerrar();


        if (doc == null)
            Toast.makeText(this, "documento con id  " +
                    connid.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else {


            edtTipoDoc.setText(String.valueOf(doc.getIdtiposdedocumento()));
            isbn.setText(doc.getIsbn());
            idioma.setText(doc.getIdioma());
            descripcion.setText(doc.getDescripciondoc());
            nombredoc.setText(doc.getNombredoc());
            if (doc.isDisponibledoc()) {
                edtdisponible.setText("si");
            } else {

                edtdisponible.setText("no");

            }




        }
    }


    public void LimpiarTexto(View view) {
        edtTipoDoc.setText("");

        isbn.setText("");
        nombredoc.setText("");
        descripcion.setText("");
        idioma.setText("");
        edtdisponible.setText("");
    }

}