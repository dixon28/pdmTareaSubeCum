package com.pdmsubecum.am15005.Activities.Equipo;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Equipo;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.DB.modelo.am15005.TiposDeEquipo;
import com.pdmsubecum.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Objects;

public class ActualizarEquipoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Calendar calendario = Calendar.getInstance();

    Spinner spinner3;

    int anyo;
    int mes;
    int dia;

    String auxfecha;
    private ArrayAdapter comboAdapter;
    private ArrayAdapter comboAdaptertequipos;
    private ArrayAdapter comboAdapterteDisponible;
    int conteo;

    private String nombreDisponible;


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
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_equipo);

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
        spinner= findViewById(R.id.sp_marcas);
        spinner2=findViewById(R.id.sp_tipos_equipos);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3=findViewById(R.id.sp_equipodisponible);
        spinner3.setOnItemSelectedListener(this);


        marcas=helper.llenarspinner();
        eq=helper.llenarSpinerEquipos();

        conteo=Integer.parseInt(String.valueOf(helper.getItemsMarca()));
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


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.mensaje_actualizar) +" "+ getString(R.string.equipo_existencia)+" "+ getString(R.string.asignacionEquipoDetalle)+" "+ getString(R.string.EquipoMovimientoDetalle))
                .setTitle(R.string.titulo_dialogo_update);

        builder.setPositiveButton(R.string.confirmar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActualizarEquipo();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                cancelar();
            }
        });

        dialog = builder.create();

        fechaingreso = findViewById(R.id.editfechaingreso);
        fechaingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(ActualizarEquipoActivity.this, date, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH)).show();
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

    public void ConsultarEquipo(View view) {
        try {


            String id;
            helper.abrir();

            Log.d("Llego Aqui","Comenzo");
            Equipo equipo = helper.consultarE(conid.getText().toString());
            helper.cerrar();
            Log.d("Llego Aqui","Terminar");
            id = Integer.toString(equipo.getIdequipo());
            if (equipo == null)
                Toast.makeText(this, getString(R.string.rellenarid), Toast.LENGTH_LONG).show();
            else {
                edtmarca.setText(String.valueOf(equipo.getIdmarca()));
                edtTipoEquipo.setText(String.valueOf(equipo.getIdtiposdeequipo()));
                if (equipo.isEquipodisponible()) {
                    edtEquipoDis.setText("si");
                } else {

                    edtEquipoDis.setText("no");

                }
                edtEq.setText(String.valueOf(equipo.getIdequipo()));
                modelo.setText(equipo.getModelo());
                serie.setText(equipo.getSerie());
                carac.setText(equipo.getCaracteristicas());
                fechaingreso.setText(equipo.getFechaingreso());

                conid.setEnabled(false);


            }
        }catch (Exception e)
            {

                Toast.makeText(this,getString(R.string.nulo),Toast.LENGTH_SHORT).show();




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

        conid.setEnabled(true);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()){
            case R.id.sp_marcas:
                //Almaceno el nombre de la fruta seleccionada
                nombreMarca = marcs[position];
                id_guardado_Marca=ides[position];

                edtmarca.setText(id_guardado_Marca);



                break;

            case R.id.sp_tipos_equipos:
                nombreEquipo =tequipos[position];
                id_guardado_tequipo=ides_tequipos[position];
                edtTipoEquipo.setText(id_guardado_tequipo);


                break;


            case R.id.sp_equipodisponible:
                nombreDisponible=disponibles[position];
                id_guardado_disponible=ides_disponible[position];
                edtEquipoDis.setText(nombreDisponible);


                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void ActualizarEquipo() {
        try {


        String formatoDeFecha = "DD-MM-YYYY"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha);
        boolean disp;
        Equipo equipo = new Equipo();
        String fe = fechaingreso.getText().toString();

        Log.d("fecha", fe);


        String id = edtEq.getText().toString();


        equipo.setIdmarca(Integer.parseInt(edtmarca.getText().toString()));
        equipo.setIdtiposdeequipo(Integer.parseInt(edtTipoEquipo.getText().toString()));
        equipo.setIdequipo(Integer.parseInt(edtEq.getText().toString()));
        equipo.setCaracteristicas(carac.getText().toString());
        equipo.setModelo(modelo.getText().toString());
        equipo.setSerie(serie.getText().toString());
        equipo.setFechaingreso(fe);


        if (Objects.equals("si", edtEquipoDis.getText().toString())) {


            disp = true;

            Log.d("disponible", "true");

            equipo.setEquipodisponible(disp);
        } else {

            Log.d("disponible", "false");

            disp = false;
            equipo.setEquipodisponible(disp);
        }


        //if (helper.verificarIntegridadAM15005(equipo, 2)) {

          //  Toast.makeText(this, getString(R.string.verificarintegridad) + edtEq.getText().toString(), Toast.LENGTH_SHORT).show();
        //} else {


            helper.abrir();
            int s = helper.actualizarEquipo(equipo, Integer.parseInt(conid.getText().toString()));
//        db.ingresarFecha(fe,equipo.getIdequipo());
            helper.cerrar();

            conid.setText(String.valueOf(equipo.getIdequipo()));
            Toast.makeText(this,getString(R.string.actualizado) +String.valueOf(s), Toast.LENGTH_SHORT).show();



        }catch (Exception e)
        {

            Toast.makeText(this,getString(R.string.nulo),Toast.LENGTH_SHORT).show();




        }
    }

    public void cancelar(){
        Toast.makeText(this,R.string.cancelar,Toast.LENGTH_SHORT).show();
    }


    public  void ActualizarEquipo( View view)
    {

        switch (view.getId()){

            case R.id.actualizaEquipo:
                if(edtEq.getText().toString().isEmpty()||serie.getText().toString().isEmpty()||modelo.getText().toString().isEmpty()||carac.getText().toString().isEmpty()){
                    Toast.makeText(this,getString(R.string.nulo), Toast.LENGTH_SHORT).show();
                }

                else{
                    // Create the AlertDialog

                        // Create the AlertDialog
                        dialog.show();

                }
                break;


        }




    }


}
