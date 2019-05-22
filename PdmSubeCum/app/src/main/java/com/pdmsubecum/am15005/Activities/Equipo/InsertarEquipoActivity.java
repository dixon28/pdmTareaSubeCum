package com.pdmsubecum.am15005.Activities.Equipo;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.pdmsubecum.DB.DBHelper;
import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Equipo;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.DB.modelo.am15005.TiposDeEquipo;
import com.pdmsubecum.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class InsertarEquipoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    EditText fechaingreso;
    Calendar calendario = Calendar.getInstance();

    Spinner spinner3;

    int anyo;
    int mes;
    int dia;

    String auxfecha;



    Spinner spinner;
    Spinner spinner2;

    ArrayList<Marca> marcas= new ArrayList<Marca>();

    ArrayList<String> lismarcas= new ArrayList<>();

    ArrayList<String> listequipos= new ArrayList<>();

    ArrayList<TiposDeEquipo> eq= new ArrayList<TiposDeEquipo>();
    ArrayList<String> disponible= new ArrayList<>();

    String [] ides;
    String [] marcs;
    String [] tequipos;
    String [] disponibles={"si","no"};
    String [] ides_tequipos;
    String [] ides_disponible={"0","1"};

    int i;
    String id_guardado_Marca;
    String id_guardado_tequipo;
    String id_guardado_disponible;
    String nombreMarca;
    String nombreEquipo;

   int conteo;
   int conteo2;
    DataBase db;
    private ArrayAdapter comboAdapter;
    private ArrayAdapter comboAdaptertequipos;
    private ArrayAdapter comboAdapterteDisponible;
    private String nombreDisponible;
    private EditText edtmarca;
    private EditText edtTipoEquipo;
    private EditText edtEquipoDis;
    private EditText edtEq;
    private EditText serie;
    private EditText modelo;
    private EditText carac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_equipo);
        this.setTitle("AM15005");
        spinner= findViewById(R.id.sp_marcas);
        spinner2=findViewById(R.id.sp_tipos_equipos);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3=findViewById(R.id.sp_equipodisponible);
        spinner3.setOnItemSelectedListener(this);

        edtmarca=findViewById(R.id.EdtIdMarca);
        edtTipoEquipo=findViewById(R.id.EdtIdTiposEquipo);
        edtEquipoDis=findViewById(R.id.Edtequipodisponible);
        edtEq=findViewById(R.id.editequipo);
        modelo=findViewById(R.id.editmodelo);
        serie=findViewById(R.id.editserie);
        carac=findViewById(R.id.editcaracteristicas);
        db=new DataBase(this);

        marcas=db.llenarspinner();
        eq=db.llenarSpinerEquipos();

        conteo=Integer.parseInt(String.valueOf(db.getItemsMarca()));
        //conteo2=Integer.parseInt(String.valueOf(db.getItems))


        marcs=new String[conteo];
        ides=new String[conteo];
        tequipos= new String[eq.size()];
        ides_tequipos=new String[eq.size()];






        for (Marca marca:marcas)
        {

                marcs[i]=String.valueOf(marca.getIdmarca())+" - "+marca.getDescripcionmarca();
                ides[i]=String.valueOf(marca.getIdmarca());


               i++;

        }

        i=0;

        for (TiposDeEquipo e:eq)
        {

            tequipos[i]=String.valueOf(e.getIdTiposDeEquipo())+" - "+e.getDescripcionTipEquipo();
            ides_tequipos[i]=String.valueOf(e.getIdTiposDeEquipo());


            i++;

        }


        disponible.add(disponibles[0]);
        disponible.add(disponibles[1]);

        Collections.addAll(lismarcas,marcs);
        Collections.addAll(listequipos,tequipos);






        comboAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,lismarcas );
        comboAdaptertequipos = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,listequipos );
        comboAdapterteDisponible=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,disponible);
        //Cargo el spinner con los datos
       spinner.setAdapter(comboAdapter);
       spinner2.setAdapter(comboAdaptertequipos);
       spinner3.setAdapter(comboAdapterteDisponible);


        fechaingreso = findViewById(R.id.editfechaingreso);
        fechaingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(InsertarEquipoActivity.this, date, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });










    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {


             anyo=year;
             mes=monthOfYear+1;
             dia=dayOfMonth;
            // TODO Auto-generated method stub
            calendario.set(Calendar.YEAR, year);
            calendario.set(Calendar.MONTH, monthOfYear);
            calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
       //     actualizarInput();

            if ((dia<10)||(mes<10))
            {

                if (dia<10){

                    fechaingreso.setText(anyo+"-"+mes+"-"+"0"+dia);

                }
                if (mes<10){



                    fechaingreso.setText(anyo+"-"+"0"+mes+"-"+dia);
                }
                if ((dia<10)&&(mes<10))
                {

                    fechaingreso.setText(anyo+"-"+"0"+mes+"-"+"0"+dia);




                }



            }

//            if (mes<10)
  //          {

    //            fechaingreso.setText(dia+"/"+"0"+mes+"/"+anyo);

      //      }


            else {

                fechaingreso.setText(anyo + "-" + mes + "-" + dia);
            }
        }

    };




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()){
            case R.id.sp_marcas:
                //Almaceno el nombre de la fruta seleccionada
                       nombreMarca = marcs[position];
                       id_guardado_Marca=ides[position];

                       edtmarca.setText(id_guardado_Marca);


                Toast.makeText(this, "Nombre marca: " + nombreMarca, Toast.LENGTH_SHORT).show();

              break;

            case R.id.sp_tipos_equipos:
                nombreEquipo =tequipos[position];
                id_guardado_tequipo=ides_tequipos[position];
                edtTipoEquipo.setText(id_guardado_tequipo);

                Toast.makeText(this,"nombre del tipo de equipo :"+nombreEquipo,Toast.LENGTH_SHORT).show();
                break;


            case R.id.sp_equipodisponible:
                nombreDisponible=disponibles[position];
                id_guardado_disponible=ides_disponible[position];
                edtEquipoDis.setText(nombreDisponible);

                Toast.makeText(this,"disponible :"+nombreDisponible,Toast.LENGTH_SHORT).show();
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void insertarEquipo(View view) {
        String formatoDeFecha = "DD-MM-YYYY"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha);
        boolean disp;
        Equipo equipo = new Equipo();
        String fe=fechaingreso.getText().toString();

        Log.d("fecha",fe);





        String id=edtEq.getText().toString();


        equipo.setIdmarca(Integer.parseInt(edtmarca.getText().toString()));
        equipo.setIdtiposdeequipo(Integer.parseInt(edtTipoEquipo.getText().toString()));
        equipo.setIdequipo(Integer.parseInt(edtEq.getText().toString()));
        equipo.setCaracteristicas(carac.getText().toString());
        equipo.setModelo(modelo.getText().toString());
        equipo.setSerie(serie.getText().toString());
        equipo.setFechaingreso(fe);



        if(Objects.equals("si",edtEquipoDis.getText().toString())){


        disp=true;

            Log.d("disponible","true");

            equipo.setEquipodisponible(disp);
        }
        else
        {

            Log.d("disponible","false");

            disp=false;
            equipo.setEquipodisponible(disp);
        }






        if (db.verificarIntegridadAM15005(equipo,2)){

            Toast.makeText(this,"Ya existe un registro con el id "+id , Toast.LENGTH_SHORT).show();
        }
        else {


            db.abrir();
            db.insertar(equipo);
//        db.ingresarFecha(fe,equipo.getIdequipo());
            db.cerrar();
            Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
        }




    }

    public void limpiarTexto(View view) {
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
