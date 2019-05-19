package com.pdmsubecum;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.RolUsuario;
import com.pdmsubecum.DB.modelo.Usuario;
import com.pdmsubecum.mm14031.Aula;
import com.pdmsubecum.mm14031.Ciclo;
import com.pdmsubecum.mm14031.Dia;
import com.pdmsubecum.mm14031.Grupo;
import com.pdmsubecum.mm14031.Horario;
import com.pdmsubecum.mm14031.HorarioDetalle;
import com.pdmsubecum.mm14031.Materia;

import java.util.ArrayList;

/**
 * Created by rodri on 10/05/2019.
 */

public class LlenarDB {
    public ArrayList<Usuario> usuarios;
    public ArrayList<RolUsuario> roles;


    //Tablas MM
    public ArrayList<Dia> dias;
    public ArrayList<Aula> aulas;
    public ArrayList<Ciclo> ciclos;
    public ArrayList<Materia> materias;
    public ArrayList<Horario> horarios;
    public ArrayList<Grupo> grupos;
    public ArrayList<HorarioDetalle> horarioDetalles;
    //Fin Tablas MM


    public DataBase dataBase;

    public LlenarDB(Context context){
        dataBase = new DataBase(context);
        crearUsuarios();
    }

    public void crearUsuarios(){
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("am15005", "am15005"));
        usuarios.add(new Usuario("mm14031", "mm14031"));
        usuarios.add(new Usuario("pm15007", "pm15007"));
        usuarios.add(new Usuario("rl08017", "rl08017"));
        usuarios.add(new Usuario("ts14004", "ts14004"));
        usuarios.add(new Usuario("admin", "admin"));

        dataBase.llenarUsuario(usuarios);
        crearRolesUsuarios();

        //Tablas MM

        crearAulas();
        crearDias();
        crearCiclos();
        crearMaterias();
        crearHorarios();
        crearGrupos();
        crearHorariosDetalle();

        //Fin tablas MM

        dataBase.cerrar();
    }
    public void crearRolesUsuarios(){
        roles = new ArrayList<>();
        roles.add(new RolUsuario("usuario", "am15005"));
        roles.add(new RolUsuario("usuario", "mm14031"));
        roles.add(new RolUsuario("admin", "pm15007"));
        roles.add(new RolUsuario("usuario", "rl08017"));
        roles.add(new RolUsuario("usuario", "ts14004"));
        roles.add(new RolUsuario("admin", "admin"));

        dataBase.llenarRolUsuario(roles);
    }


    //Tablas MM

    public void crearDias(){
        dias = new ArrayList<>();
        dias.add(new Dia(1,"Domingo"));
        dias.add(new Dia(2,"Lunes"));
        dias.add(new Dia(3,"Martes"));
        dias.add(new Dia(4,"Miercoles"));
        dias.add(new Dia(5,"Jueves"));
        dias.add(new Dia(6,"Viernew"));
        dias.add(new Dia(7,"Sábado"));

        dataBase.llenarDia(dias);
    }

    public void crearAulas(){
        aulas = new ArrayList<>();
        aulas.add(new Aula(1,"B11"));
        aulas.add(new Aula(2,"B21"));
        aulas.add(new Aula(3,"C11"));
        aulas.add(new Aula(4,"C21"));

        dataBase.llenarAula(aulas);
    }

    public void crearCiclos(){
        ciclos = new ArrayList<>();
        ciclos.add(new Ciclo(20181,"CICLO I 2018",2018));
        ciclos.add(new Ciclo(20182,"CICLO II 2018",2018));
        ciclos.add(new Ciclo(20191,"CICLO I 2019",2018));
        ciclos.add(new Ciclo(20192,"CICLO II 2019",2018));

        dataBase.llenarCiclo(ciclos);
    }

    public void crearMaterias(){
        materias = new ArrayList<>();
        materias.add(new Materia("IEC115","INGENERIA ECONOMICA","50",21081));
        materias.add(new Materia("MAT115","MATEMATICAS I","50",21081));
        materias.add(new Materia("FIR115","FISICA","50",21081));

        dataBase.llenarMateria(materias);
    }

    public void crearHorarios(){
        horarios = new ArrayList<>();
        horarios.add(new Horario(1,2,1,"6:20 - 8:00 am"));
        horarios.add(new Horario(2,2,1,"8:05 - 9:50 am"));
        horarios.add(new Horario(3,4,1,"6:20 - 8:00 am"));
        horarios.add(new Horario(4,4,1,"8:05 - 9:50 am"));

        dataBase.llenarHorario(horarios);
    }

    public void crearGrupos(){

        grupos = new ArrayList<>();
        grupos.add(new Grupo(1,"IEC115",1,"GRUPO I"));
        grupos.add(new Grupo(2,"IEC115",1,"GRUPO II"));
        grupos.add(new Grupo(3,"IEC115",2,"GRUPO III"));

        dataBase.llenarGrupo(grupos);
    }

    public void crearHorariosDetalle(){
        horarioDetalles = new ArrayList<>();
        horarioDetalles.add(new HorarioDetalle(1,1));
        horarioDetalles.add(new HorarioDetalle(2,2));
        horarioDetalles.add(new HorarioDetalle(3,2));

        dataBase.llenarHorarioDetalle(horarioDetalles);
    }

    //Fin Tablas MM


}
