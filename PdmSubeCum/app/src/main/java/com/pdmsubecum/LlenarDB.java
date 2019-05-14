package com.pdmsubecum;

import android.content.Context;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.RolUsuario;
import com.pdmsubecum.DB.modelo.Usuario;

import java.util.ArrayList;

/**
 * Created by rodri on 10/05/2019.
 */

public class LlenarDB {
    public ArrayList<Usuario> usuarios;
    public ArrayList<RolUsuario> roles;

    public DataBase dataBase;

    public LlenarDB(Context context){
        dataBase = new DataBase(context);
        crearUsuarios();
    }

    public void crearUsuarios(){
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("am15005","am15005"));
        usuarios.add(new Usuario("mm14031","mm14031"));
        usuarios.add(new Usuario("pm15007","pm15007"));
        usuarios.add(new Usuario("rl08017","rl08017"));
        usuarios.add(new Usuario("ts14004","ts14004"));
        usuarios.add(new Usuario("admin","admin"));

        dataBase.llenarUsuario(usuarios);
        crearRolesUsuarios();
        dataBase.cerrar();
    }
    public void crearRolesUsuarios(){
        roles = new ArrayList<>();
        roles.add(new RolUsuario("usuario","am15005"));
        roles.add(new RolUsuario("usuario","mm14031"));
        roles.add(new RolUsuario("admin","pm15007"));
        roles.add(new RolUsuario("usuario","rl08017"));
        roles.add(new RolUsuario("usuario","ts14004"));
        roles.add(new RolUsuario("admin","admin"));

        dataBase.llenarRolUsuario(roles);
    }



}
