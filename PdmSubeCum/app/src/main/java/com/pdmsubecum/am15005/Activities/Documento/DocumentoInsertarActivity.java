package com.pdmsubecum.am15005.Activities.Documento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Documento;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.DB.modelo.am15005.TiposDeDocumento;
import com.pdmsubecum.DB.modelo.am15005.TiposDeEquipo;
import com.pdmsubecum.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class DocumentoInsertarActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



    Spinner spinner;
    Spinner spinner2;

    ArrayList<TiposDeDocumento> tiposdocumento= new ArrayList<TiposDeDocumento>();



    ArrayList<String> listipodedoc= new ArrayList<>();

    DataBase db;



    ArrayList<String> disponible= new ArrayList<>();

    String [] ides;
    String [] tiposdoc;
    String [] disponibles={"si","no"};
    String [] ides_tdoc;
    String [] ides_disponible={"0","1"};
    private ArrayAdapter comboAdapterteDisponible;
    private String nombreDisponible;
    private String nombreTipoDco;
    private String id_guardado_disponible;

    EditText edtdisponible;
    int i=0;
    int conteo=0;

    private ArrayAdapter comboAdapter;
    private EditText edtTipoDoc;
    private EditText isbn;
    private EditText nombredoc;
    private EditText idioma;
    private EditText descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_insertar);

        edtTipoDoc=findViewById(R.id.EdtIdTiposDoc);
        isbn=findViewById(R.id.editisbndeldoc);
        idioma=findViewById(R.id.editIdioma);
        descripcion=findViewById(R.id.editDescricionDoc);
        nombredoc=findViewById(R.id.editnombredoc);


        spinner=findViewById(R.id.sp_tipos_doc);
        spinner2=findViewById(R.id.sp_documentodisponible);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        edtdisponible=findViewById(R.id.EdtDocdisponible);

        db=new DataBase(this);

        conteo=Integer.parseInt(String.valueOf(db.getItemsTiposDocumento()));

        tiposdocumento=db.llenarspinnerDoc();

        tiposdoc=new String[conteo];
        ides= new String[conteo];

        for (TiposDeDocumento tdoc:tiposdocumento)
        {

            tiposdoc[i]=String.valueOf(tdoc.getIdTiposDeDocumentos())+" - "+tdoc.getDescripcionTipoDeDocumento();
            ides[i]=String.valueOf(tdoc.getIdTiposDeDocumentos());


            i++;

        }

        Collections.addAll(listipodedoc,tiposdoc);




        disponible.add(disponibles[0]);
        disponible.add(disponibles[1]);


        comboAdapterteDisponible=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,disponible);
        spinner2.setAdapter(comboAdapterteDisponible);


        comboAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,listipodedoc);
        spinner.setAdapter(comboAdapter);








    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()){

            case R.id.sp_tipos_doc:
                nombreTipoDco=ides[position];
                edtTipoDoc.setText(nombreTipoDco);
                break;


            case R.id.sp_documentodisponible:
                nombreDisponible=disponibles[position];

                edtdisponible.setText(nombreDisponible);
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void insertarDocumento(View view) {

        try {


        Documento documento= new Documento();
        boolean disp;

        documento.setIdtiposdedocumento(Integer.parseInt(edtTipoDoc.getText().toString()));
        documento.setIsbn(isbn.getText().toString());
        documento.setDescripciondoc(descripcion.getText().toString());
        documento.setIdioma(idioma.getText().toString());
        documento.setNombredoc(nombredoc.getText().toString());

        if(Objects.equals("si",edtdisponible.getText().toString())){


            disp=true;

            Log.d("disponible","true");

            documento.setDisponibledoc(disp);
        }
        else
        {

            Log.d("disponible","false");

            disp=false;
            documento.setDisponibledoc(disp);
        }

        if (db.verificarIntegridadAM15005(documento,3)){

            Toast.makeText(this,"Ya existe un registro con el isbn "+isbn , Toast.LENGTH_SHORT).show();
        }
        else {

            db.abrir();
            db.insertar(documento);
//        db.ingresarFecha(fe,equipo.getIdequipo());
            db.cerrar();
            Toast.makeText(this, documento.getIsbn(), Toast.LENGTH_SHORT).show();
        }
        }catch (Exception e)
        {

            Toast.makeText(this,getString(R.string.nulo),Toast.LENGTH_SHORT).show();




        }

    }


    public void limpiarTexto(View view) {

        isbn.setText("");
        nombredoc.setText("");
        descripcion.setText("");
        idioma.setText("");

    }
}
