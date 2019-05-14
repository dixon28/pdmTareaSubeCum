package com.pdmsubecum.am15005.fragmentos;

import android.content.Context;
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


public class TipoFragment extends Fragment {

    ListView lista;

    List<String> tablasCrud;



    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tipo, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        ListView listView = (ListView)getView().findViewById(R.id.menu_am15005_2);
        tablasCrud = new ArrayList<>();
        tablasCrud.add("insertar");
        tablasCrud.add("actualizar tabla");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1
                ,tablasCrud);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nombreTablaClick = tablasCrud.get(position);
                Toast.makeText(getActivity().getApplicationContext(),"Click a tabla"+nombreTablaClick,Toast.LENGTH_SHORT).show();

            }
        });

    }

}
