package com.pdmsubecum.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.pdmsubecum.DB.modelo.RolUsuario;
import com.pdmsubecum.DB.modelo.Usuario;
import com.pdmsubecum.mm14031.Aula;
import com.pdmsubecum.mm14031.Ciclo;
import com.pdmsubecum.mm14031.Dia;
import com.pdmsubecum.mm14031.Grupo;
import com.pdmsubecum.mm14031.Horario;
import com.pdmsubecum.mm14031.HorarioDetalle;
import com.pdmsubecum.mm14031.HorarioEliminarActivity;
import com.pdmsubecum.mm14031.Materia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodri on 10/05/2019.
 */

public class DataBase {
    Context context;
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper sqLiteOpenHelper;

    public DataBase(Context context){
        this.context = context;
        sqLiteOpenHelper = new DBHelper(context);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void abrir(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }
    public void cerrar(){
        sqLiteOpenHelper.close();
    }


    /* ------------------------------------------------------
     -------------   CONTADORES DE TABLAS -------------------
     -------------------------------------------------------*/

    public long getItemsUsuario(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_USUARIO);
    }
    public long getItemsRol(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_ROL_USUARIO);
    }


    //Tablas MM

    public long getItemsAula(){
        return  DatabaseUtils.queryNumEntries(sqLiteDatabase,ConstantesDB.TABLA_AULA);
    }

    public long getItemsDia(){
        return  DatabaseUtils.queryNumEntries(sqLiteDatabase,ConstantesDB.TABLA_DIA);
    }

    public long getItemsCiclo(){
        return  DatabaseUtils.queryNumEntries(sqLiteDatabase,ConstantesDB.TABLA_CICLO);
    }

    public long getItemsMateria(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_MATERIA);
    }
    public long getItemsHorario(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_HORARIO);
    }
    public long getItemsGrupo(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_GRUPO);
    }

    public long getItemsHorarioDetalle(){
        return  DatabaseUtils.queryNumEntries(sqLiteDatabase,ConstantesDB.TABLA_HORARIODETALLE);
    }

    //Fin Tablas MM

    /* ------------------------------------------------------
     -------------   INSERCIONES EN TABLAS -------------------
     -------------------------------------------------------*/
    public void insertar(Usuario usuario){
        ContentValues contentValues = usuario.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_USUARIO, null, contentValues);
    }

    public void insertar(RolUsuario rolUsuario){
        ContentValues contentValues = rolUsuario.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_ROL_USUARIO, null,contentValues);
    }

    //INSERT TABLAS MM

    public void insertar(Aula aula){
        ContentValues contentValues = aula.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_AULA,null,contentValues);
    }

    public void insertar(Dia dia){
        ContentValues contentValues = dia.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_DIA,null,contentValues);
    }

    public void insertar(Ciclo ciclo){
        ContentValues contentValues = ciclo.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_CICLO,null,contentValues);

    }

    public void insertar(Materia materia){
        ContentValues contentValues = materia.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_MATERIA,null,contentValues);
    }

    public void insertar(Grupo grupo){
        ContentValues contentValues = grupo.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_GRUPO,null,contentValues);
    }
    public void insertar(Horario horario){
        ContentValues contentValues = horario.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_HORARIO,null,contentValues);
    }

    public void insertar(HorarioDetalle horarioDetalle){
        ContentValues contentValues = horarioDetalle.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_HORARIODETALLE,null,contentValues);
    }

    //FIN INSERT TABLAS MM

    /* ------------------------------------------------------
     -------------   CONSULTAS DE TABLAS -------------------
     -------------------------------------------------------*/
    public  List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_USUARIO, ConstantesDB.CAMPOS_USUARIO,null,
                null,null,null,null);
        while(cursor.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setUsuario(cursor.getString(0));
            usuario.setPassword(cursor.getString(1));
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public Usuario getUsuario(String user){
        String[] id = {user};
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_USUARIO, ConstantesDB.CAMPOS_USUARIO,"usuario = ?",
                id,null,null,null);
        if(cursor.moveToFirst()){
            Usuario usuario = new Usuario();
            usuario.setUsuario(cursor.getString(0));
            usuario.setPassword(cursor.getString(1));
            return usuario;
        }else{
            return null;
        }

    }
    public RolUsuario getRolUsuario(String user){
        String[] id = {user};
            Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_ROL_USUARIO, ConstantesDB.CAMPOS_ROL_USUARIO,"usuario = ?",
                id,null,null,null);
        if(cursor.moveToFirst()){
            RolUsuario rolUsuario = new RolUsuario();
            rolUsuario.setNombre_rol(cursor.getString(0));
            rolUsuario.setUsuario(cursor.getString(1));
            return rolUsuario;
        }else{
            return null;
        }
    }

    /* ------------------------------------------------------
     -------------   QUEMADO DE DATOS -----------------------
     -------------------------------------------------------*/
    public void llenarUsuario(List<Usuario> usuarios){
        long items = getItemsUsuario();
        if(items == 0){
            for (Usuario usuario: usuarios){
                try {
                    insertar(usuario);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void llenarRolUsuario(List<RolUsuario> roles){
        long itemsRol = getItemsRol();
        long items = itemsRol;
        if(items == 0){
            for (RolUsuario rolUsuario: roles){
                try {
                    insertar(rolUsuario);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //LLENADO TABLAS MM

    public void llenarAula(List<Aula> aulas){
        long items = getItemsAula();
        if (items == 0){
            for (Aula aula: aulas){
                try {
                    insertar(aula);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void llenarDia(List<Dia> dias){
        long items = getItemsDia();
        if (items == 0){
            for (Dia dia: dias){
                try {
                    insertar(dia);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void llenarCiclo(List<Ciclo> ciclos){
        long items = getItemsCiclo();
        if (items == 0){
            for (Ciclo ciclo: ciclos){
                try {
                    insertar(ciclo);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void llenarMateria(List<Materia> materias){
        long items = getItemsMateria();
        if (items == 0){
            for (Materia materia: materias){
                try {
                    insertar(materia);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void llenarHorario(List<Horario> horarios){
        long items = getItemsHorario();
        if (items == 0){
            for (Horario horario: horarios){
                try {
                    insertar(horario);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void llenarGrupo(List<Grupo> grupos){
        long items = getItemsGrupo();
        if (items == 0){
            for (Grupo grupo: grupos){
                try {
                    insertar(grupo);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void llenarHorarioDetalle(List<HorarioDetalle> horarioDetalles){
        long items = getItemsHorarioDetalle();
        if (items == 0){
            for (HorarioDetalle horarioDetalle : horarioDetalles){
                try {
                    insertar(horarioDetalle);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }


    // FIN LLENADO TABLAS MM

    private boolean aulaExiste(Aula aula) throws SQLException{

        String[] idAula = {String.valueOf(aula.getIdAula())};
        abrir();
        Cursor c = sqLiteDatabase.query("aula",null,"idAula = ?",idAula,
                null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

    public Aula consultarAula(int idAula){

        String[] columnas = {"idAula,descripcion"};
        String[] codAula ={String.valueOf(idAula)};
        Cursor c = sqLiteDatabase.query("aula",columnas,"idAula = ?",codAula,
                null,null,null);
        if (c.moveToFirst()){
            Aula aula = new Aula();
            aula.setIdAula(c.getInt(0));
            aula.setDescripcion(c.getString(1));
            return aula;
        }else{
            return null;
        }
    }

    private boolean diaExiste(Dia dia) throws SQLException{

        String[] idDia = {String.valueOf(dia.getIdDia())};
        Cursor c = sqLiteDatabase.query("dia",null,"idDia = ?",idDia,
                null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

    public Dia consultarDia(int idDia){

        String[] columnas = {"idDia,descripcion"};
        String[] codDia ={String.valueOf(idDia)};
        Cursor c = sqLiteDatabase.query("dia",columnas,"idDia = ?",codDia,
                null,null,null);
        if (c.moveToFirst()){
            Dia dia = new Dia();
            dia.setIdDia(c.getInt(0));
            dia.setDescripcion(c.getString(1));

            return dia;
        }else{
            return null;
        }
    }

    private boolean cicloExiste(Ciclo ciclo) throws SQLException{

        String[] idCiclo = {String.valueOf(ciclo.getIdCiclo())};
        abrir();
        Cursor c = sqLiteDatabase.query("ciclo",null,"idCiclo = ?",idCiclo,
                null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

    public Ciclo consultarCiclo(int idCiclo){

        String[] columnas = {"idCiclo,numero,year"};
        String[] codCiclo ={String.valueOf(idCiclo)};
        Cursor c = sqLiteDatabase.query("ciclo",columnas,"idCiclo = ?",codCiclo,
                null,null,null);
        if (c.moveToFirst()){
            Ciclo ciclo = new Ciclo();
            ciclo.setIdCiclo(c.getInt(0));
            ciclo.setNumero(c.getString(1));
            ciclo.setYear(c.getInt(2));
            return ciclo;
        }else{
            return null;
        }
    }


    public String insertarMateria(Materia materia){

        String mensaje = "Registro No: ";
        long contador = 0 ;

        if (materiaExiste(materia)==false){
            Ciclo ciclo = new Ciclo();
            ciclo.setIdCiclo(materia.getIdCiclo());

            if (cicloExiste(ciclo)){

                ContentValues contentValues = materia.toValues();
                contador= sqLiteDatabase.insert(ConstantesDB.TABLA_MATERIA,null,contentValues);

                if(contador == -1 || contador == 0){
                    mensaje = "Error al insertar el registro. Registro duplicado";
                }else{
                    mensaje = "Registro insertado correctamente";
                }

            }else {
                mensaje = "El ciclo: " + materia.getIdCiclo() + " No Existe.";
            }

        }else{
            mensaje = "Materia con Codigo: " + materia.getCodigoMateria() + " ya Existe.";
        }

        return  mensaje;
    }

    public String actualizarMateria(Materia materia){

        String mensaje;

        if (materiaExiste(materia)){
            Ciclo ciclo = new Ciclo();
            ciclo.setIdCiclo(materia.getIdCiclo());

            if (cicloExiste(ciclo)){
                String[] codigo = {materia.getCodigoMateria()};
                ContentValues contentValues = materia.toValues();
                sqLiteDatabase.update("materia",contentValues,"codigoMateria = ?",codigo);
                mensaje = "Registro actualizado correctamente";

            }else {
                mensaje = "El ciclo: " + materia.getIdCiclo() + " No Existe.";
            }


        }else{
            mensaje = "Materia con Codigo: " + materia.getCodigoMateria() + " no existe";
        }

        return mensaje;
    }

    public String eliminarMateria(Materia materia){

        int contador = 0;

        if (materiaExiste(materia)){
            String[] codigoMateria = {materia.getCodigoMateria()};

            contador = sqLiteDatabase.delete("materia","codigoMateria = ?",codigoMateria);

            if (contador != 0){
                return "Registro eliminado correctamente";
            }else{
                return "Registro No fue eliminado";
            }

        }else{
            return "Materia con codigo: " + materia.getCodigoMateria() + " no existe";
        }

    }

    public Materia consultarMateria(String codigoMateria){

        String[] columnas = {"codigoMateria,nombreMateria,UV,idCiclo"};
        String[] codMateria ={codigoMateria};
        Cursor c = sqLiteDatabase.query("materia",columnas,"codigoMateria = ?",codMateria,
                null,null,null);
        if (c.moveToFirst()){
            Materia materia = new Materia();
            materia.setCodigoMateria(c.getString(0));
            materia.setNombreMateria(c.getString(1));
            materia.setUV(c.getString(2));
            materia.setIdCiclo(c.getInt(3));
            return materia;
        }else{
            return null;
        }
    }

    private boolean materiaExiste(Materia materia) throws SQLException{

        String[] codigoMateria = {materia.getCodigoMateria()};

        abrir();
        Cursor c = sqLiteDatabase.query("materia",null,"codigoMateria = ?",codigoMateria,
                null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }

    }

    public String insertarHorario(Horario horario){

        String mensaje = "Registro No: ";
        long contador = 0 ;

        if (horarioExiste(horario) == false){
            Aula aula = new Aula();
            aula.setIdAula(horario.getIdAula());

            if (aulaExiste(aula)){
                Dia dia = new Dia();
                dia.setIdDia(horario.getIdDia());
                if(diaExiste(dia)){

                    ContentValues contentValues = horario.toValues();
                    contador= sqLiteDatabase.insert(ConstantesDB.TABLA_HORARIO,null,contentValues);

                    if(contador == -1 || contador == 0){
                        mensaje = "Error al insertar el registro. Registro duplicado";
                    }else{
                        mensaje = "Registro insertado correctamente";
                    }

                }else{
                    mensaje = "Dia con ID: " + dia.getIdDia() + " No existe";
                }
            }else{
                mensaje = "Aula con ID: " + aula.getIdAula() + " No Existe.";
            }

        }else{
            mensaje = "Horario con ID: " + horario.getIdHorario() + " ya Existe.";
        }

        return  mensaje;
    }

    public String actualizarHorario(Horario horario){

        String mensaje;
        if (horarioExiste(horario)){
            Aula aula = new Aula();
            aula.setIdAula(horario.getIdAula());
            if (aulaExiste(aula)){
                Dia dia = new Dia();
                dia.setIdDia(horario.getIdDia());
                if(diaExiste(dia)){
                    String[] codigo = {String.valueOf(horario.getIdHorario())};
                    ContentValues contentValues = horario.toValues();
                    sqLiteDatabase.update("horario",contentValues,"idHorario = ?",codigo);
                    mensaje = "Registro actualizado correctamente";

                }else{
                    mensaje = "Dia con ID: " + dia.getIdDia() + " No existe";
                }
            }else{
                mensaje = "Aula con ID: " + aula.getIdAula() + " No Existe.";
            }
        }else{
            mensaje ="Horario con ID: " + horario.getIdHorario() + " no existe";
        }

        return mensaje;
    }

    public String eliminarHorario(Horario horario){

        if (horarioExiste(horario)){
            int contador = 0;
            String[] idHorario = {String.valueOf(horario.getIdHorario())};

            contador = sqLiteDatabase.delete("horario","idHorario = ?",idHorario);

            if (contador != 0){
                return "Registro eliminado correctamente";
            }else{
                return "Registro No fue eliminado";
            }

        }else{
            return "Horario con ID: " + horario.getIdHorario() + " no existe";
        }

    }

    public Horario consultarHorario(int idHorario){

        String[] columnas = {"idHorario,idDia,idAula,hora"};
        String[] codHorario ={String.valueOf(idHorario)};
        Cursor c = sqLiteDatabase.query("horario",columnas,"idHorario = ?",codHorario,
                null,null,null);
        if (c.moveToFirst()){
            Horario horario = new Horario();
            horario.setIdHorario(c.getInt(0));
            horario.setIdDia(c.getInt(1));
            horario.setIdAula(c.getInt(2));
            horario.setHora(c.getString(3));
            return horario;
        }else{
            return null;
        }

    }

    private boolean horarioExiste(Horario horario) throws SQLException{

        String[] idHorario = {String.valueOf(horario.getIdHorario())};

        Cursor c = sqLiteDatabase.query("Horario",null,"idhorario = ?",
                idHorario,null,null,null);
        Log.d("HORARIO EXISTE","HORARIO RETURN CURSOR");
        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }

    }

    public String insertarGrupo(Grupo grupo, HorarioDetalle horarioDetalle){

        String mensaje = "Registro No: ";
        long contador = 0 ;
        Materia materia = new Materia();
        materia.setCodigoMateria(grupo.getCodigoMateria());

        if (grupoExiste(grupo)== false){
            if (materiaExiste(materia)){
                Horario horario = new Horario();
                horario.setIdHorario(horarioDetalle.getIdHoraio());

                if(horarioExiste(horario)){
                    ContentValues contentValues = grupo.toValues();
                    contador= sqLiteDatabase.insert(ConstantesDB.TABLA_GRUPO,null,contentValues);

                    if(contador == -1 || contador == 0){
                        mensaje = "Error al insertar el registro. Registro duplicado";
                    }else{
                       if(insertarHorarioDetalle(horarioDetalle)){
                           mensaje = "Registro insertado correctamente";
                       }
                    }

                }else{
                    mensaje = "Horario con ID: " + horarioDetalle.getIdHoraio() + " no existe.";
                }

            }else{
                mensaje = "Materia con Codigo: " + materia.getCodigoMateria() + " no existe";
            }
        }else{
            mensaje = "Grupo con ID: " + grupo.getIdGrupo() + " ya Existe.";
        }

        return  mensaje;
    }

    public boolean insertarHorarioDetalle(HorarioDetalle horarioDetalle){
        long contador = 0 ;

        ContentValues contentValues = horarioDetalle.toValues();
        contador= sqLiteDatabase.insert(ConstantesDB.TABLA_HORARIODETALLE,null,contentValues);

        return true;
    }

    public boolean actualizarHorarioDetalle(HorarioDetalle horarioDetalle){
        String[] idGrupo = {String.valueOf(horarioDetalle.getIdGrupo())};
        ContentValues contentValues = horarioDetalle.toValues();
        sqLiteDatabase.update("horarioDetalle",contentValues,"idGrupo=?",idGrupo);
        return true;
    }


    public HorarioDetalle consultarHorarioDetallePorIdGrupo(int idGrupo){

        String[] columnas = {"idGrupo,idHorario"};
        String[] codigoGrupo ={String.valueOf(idGrupo)};
        Cursor c = sqLiteDatabase.query("horarioDetalle",columnas,"idGrupo = ?",codigoGrupo,
                null,null,null);
        if (c.moveToFirst()){
            HorarioDetalle horarioDetalle = new HorarioDetalle();
            horarioDetalle.setIdGrupo(c.getInt(0));
            horarioDetalle.setIdHoraio(c.getInt(1));
            return horarioDetalle;
        }else{
            return null;
        }

    }

    public String actualizarGrupo(Grupo grupo, HorarioDetalle horarioDetalle){

        String mensaje;
        if (grupoExiste(grupo)){
            Materia materia = new Materia();
            materia.setCodigoMateria(grupo.getCodigoMateria());

            if(materiaExiste(materia)){
                Horario  horario = new Horario();
                horario.setIdHorario(horarioDetalle.getIdHoraio());

                if (horarioExiste(horario)){
                    String[] codigo = {String.valueOf(grupo.getIdGrupo())};
                    ContentValues contentValues = grupo.toValues();
                    sqLiteDatabase.update("grupo",contentValues,"idGrupo = ?",codigo);

                    if(actualizarHorarioDetalle(horarioDetalle)){
                        mensaje = "Registro actualizado correctamente";
                    }else{
                        mensaje = "Grupo actualizado correctamente";
                    }

                }else{
                    mensaje = "Horario con ID: " + horarioDetalle.getIdHoraio() + " no existe";
                }

            }else{
                mensaje = "Materia con Codigo: " + grupo.getCodigoMateria() + " no existe.";
            }

        }else{
            mensaje = "Grupo con ID: " + grupo.getIdGrupo() + " no existe";
        }

        return mensaje;

    }

    public String eliminarGrupo(Grupo grupo){

        int contador = 0;

        if (grupoExiste(grupo)){
            String[] idGrupo = {String.valueOf(grupo.getIdGrupo())};

            contador = sqLiteDatabase.delete("grupo","idGrupo = ?",idGrupo);

            if (contador != 0){
                return "Registro eliminado correctamente";
            }else{
                return "Registro No fue eliminado";
            }

        }else{
            return "Grupo con ID: " + grupo.getIdGrupo() + " no existe";
        }
    }

    public Grupo consultarGrupo(int idGrupo ){

        String[] columnas = {"idGrupo,codigoMateria,idDocente,descripcion"};
        int[] codGrupo ={idGrupo};
        Cursor c = sqLiteDatabase.query("grupo",columnas,"idGrupo = ?",new String[]{String.valueOf(idGrupo)},
                null,null,null);
        if (c.moveToFirst()){
            Grupo grupo = new Grupo();
            grupo.setIdGrupo(c.getInt(0));
            grupo.setCodigoMateria(c.getString(1));
            grupo.setIdDocente(c.getInt(2));
            grupo.setDescripcion(c.getString(3));
            return grupo;
        }else{
            return null;
        }
    }

    private boolean grupoExiste(Grupo grupo) throws SQLException{

        String[] idGrupo = {String.valueOf(grupo.getIdGrupo())};

        Cursor c = sqLiteDatabase.query("grupo",null,"idGrupo = ?",
                idGrupo,null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }

    }

}
