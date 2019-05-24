package com.pdmsubecum.am15005.fragmentos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.pdmsubecum.R;

import java.util.ArrayList;
import java.util.List;


public class MarcaFragment extends Fragment {

    ListView lista;


    List<String> tablasCrud;
    private EquipoFragment equipoFragment;
    String[] menu={"Actualizar Registro","Consultar Registro","Eliminar Registro",
            "Ingresar Registro"};
    String[]
            activities={"ActualizarMarcaActivity","ConsultarMarcaActivity","EliminarMarcaActivity","InsertarMarcaActivity"};

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_marca, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        ListView listView = (ListView)getView().findViewById(R.id.menu_am15005_3);
        tablasCrud = new ArrayList<>();
        tablasCrud.add(menu[0]);
        tablasCrud.add(menu[1]);
        tablasCrud.add(menu[2]);
        tablasCrud.add(menu[3]);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1
                ,menu);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nombreValue=activities[position];
                String nombreTablaClick = tablasCrud.get(position);
                Toast.makeText(getActivity().getApplicationContext(),"Click a tabla"+nombreTablaClick,Toast.LENGTH_SHORT).show();
                try{
                    Class<?> clase=Class.forName("com.pdmsubecum.am15005.Activities.Marca."+nombreValue);
                    Intent inte = new Intent(getActivity().getApplicationContext(),clase);
                    getActivity().getApplicationContext().startActivity(inte);
                }catch(ClassNotFoundException e){

                    e.printStackTrace();
                }
            }





        });

    }



}
