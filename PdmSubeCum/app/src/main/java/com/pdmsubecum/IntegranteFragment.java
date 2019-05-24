package com.pdmsubecum;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.RolUsuario;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class IntegranteFragment extends Fragment {

    RecyclerView recyclerView;
    List<Integrante> integranteList;
    String usuario;
    DataBase dataBase;

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public IntegranteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuario = getActivity().getIntent().getExtras().getString("usuario");
        dataBase = new DataBase(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_integrante_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            integranteList = new ArrayList<>();
            //lista de integrantes
            RolUsuario rolUsuario = dataBase.getRolUsuario(usuario);
            switch (rolUsuario.getNombre_rol()){
                case "admin":
                    integranteList.add(new Integrante("Edilson Argueta Medina","AM15005","Documento/Equipo/Marca", R.drawable.f1));
                    integranteList.add(new Integrante("Nelson Miranda Miranda","MM14031","Tablas: Materia, Horario y Grupo",R.drawable.mm14031));
                    integranteList.add(new Integrante("Rodrigo Presa Mariona","PM15007",
                            "UnidadAdministrativa / EquipoExistencia / TipoMovimientoEquipo",R.drawable.pm15007));
                    integranteList.add(new Integrante("Joel Ramos Lopez","RL08017","TipoMovDoc/DocumentoMov/DocumentoMovDetalle",R.drawable.joel));
                    integranteList.add(new Integrante("Raul Trigueros Santamaria","TS14004","Docente/AsignacionEquipo/DocumentoAsignacion",R.drawable.ts14004));
                    break;
                case "usuario":
                    switch (rolUsuario.getUsuario()){
                        case "am15005":
                            integranteList.add(new Integrante("Edilson Argueta Medina","AM15005","Autor/AutorDetalle/Documento/Equipo/Marca/TiposEquipo/TiposDocumento", R.drawable.man1));
                            break;
                        case "mm14031":
                            integranteList.add(new Integrante("Nelson Miranda Miranda","MM14031","Tablas: Materia, Horario y Grupo",R.drawable.mm14031));
                            break;
                        case "pm15007":
                            integranteList.add(new Integrante("Rodrigo Presa Mariona","PM15007",
                                    "UnidadAdministrativa / EquipoExistencia / TipoMovimientoEquipo",R.drawable.man1));
                            break;
                        case "rl08017":
                            integranteList.add(new Integrante("Joel Ramos Lopez","RL08017","TipoMovDoc/DocumentoMov/DocumentoMovDetalle",R.drawable.joel));
                            break;
                        case "ts14004":
                            integranteList.add(new Integrante("Raul Trigueros Santamaria","TS14004",
                                    "Docente/AsignacionEquipo/DocumentoAsignacion",R.drawable.ts14004));
                            break;
                    }
                    break;
            }
            recyclerView.setAdapter(new MyIntegranteRecyclerViewAdapter(integranteList, mListener));
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Integrante item);
    }
}
