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

import com.pdmsubecum.DB.modelo.AsignacionEquipo;
import com.pdmsubecum.DB.modelo.Docente;
import com.pdmsubecum.DB.modelo.DocumentoAsignacion;
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
import com.pdmsubecum.DB.modelo.am15005.Autor;
import com.pdmsubecum.DB.modelo.am15005.AutorDetalle;
import com.pdmsubecum.DB.modelo.am15005.Documento;
import com.pdmsubecum.DB.modelo.am15005.Equipo;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.DB.modelo.am15005.TiposDeDocumento;
import com.pdmsubecum.DB.modelo.am15005.TiposDeEquipo;
import com.pdmsubecum.DB.modelo.pm15007.EquipoExistencia;
import com.pdmsubecum.DB.modelo.pm15007.EquipoMovimiento;
import com.pdmsubecum.DB.modelo.pm15007.EquipoMovimientoDetalle;
import com.pdmsubecum.DB.modelo.pm15007.TipoMovimientoEquipo;
import com.pdmsubecum.DB.modelo.pm15007.UnidadAdministrativa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static com.pdmsubecum.DB.ConstantesDB.campos_AsignacionEquipo;
import static com.pdmsubecum.DB.ConstantesDB.campos_Docente;
import static com.pdmsubecum.DB.ConstantesDB.campos_DocumentoAsignacion;
import static java.lang.Integer.parseInt;

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

    public void cerrar() {
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

    //PM15007
    public long getItemsEquipoExistencia() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_EQUIPO_EXISTENCIA);
    }

    public long getItemsEquipoMovimiento() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_EQUIPO_MOVIMIENTO);
    }

    public long getItemsEquipoMovimientoDetalle() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_EQUIPO_MOVIMIENTO_DETALLE);
    }

    public long getItemsTipoMovimientoEquipo() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_TIPO_MOVIMIENTO_EQUIPO);
    }

    public long getItemsUnidadAdministrativa() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_UNIDAD_ADMINISTRATIVA);
    }

    //TS14004
    public long getItemsDocente() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_Docente);
    }

    public long getItemsAsignacionEquipo() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_AsignacionEquipo);
    }

    public long getItemsDocumentoAsignacion() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_DocumentoAsignacion);
    }

    public long getItemsDocumentoAsignacionDetalle() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_DocumentoAsignacionDetalle);
    }

    public long getItemsAsignacionEquipoDetalle() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_AsignacionEquipoDetalle);
    }


    //AM15005
    public long getItemsMarca() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_MARCA);
    }


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
    //pm15007

    public long insertar(EquipoExistencia equipoExistencia) {
        ContentValues contentValues = equipoExistencia.toValues();
        return sqLiteDatabase.insert(ConstantesDB.TABLA_EQUIPO_EXISTENCIA, null, contentValues);
    }

    public void insertar(EquipoMovimiento equipoMovimiento) {
        ContentValues contentValues = equipoMovimiento.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_EQUIPO_MOVIMIENTO, null, contentValues);
    }

    public void insertar(EquipoMovimientoDetalle equipoMovimientoDetalle) {
        ContentValues contentValues = equipoMovimientoDetalle.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_EQUIPO_MOVIMIENTO_DETALLE, null, contentValues);
    }

    public void insertar(TipoMovimientoEquipo tipoMovimientoEquipo) {
        ContentValues contentValues = tipoMovimientoEquipo.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_TIPO_MOVIMIENTO_EQUIPO, null, contentValues);
    }

    public void insertar(UnidadAdministrativa unidadAdministrativa) {
        ContentValues contentValues = unidadAdministrativa.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_UNIDAD_ADMINISTRATIVA, null, contentValues);
    }


    //am15005

    public void insertar(Marca marca) {
        ContentValues a = marca.toValues();
        a.put("idmarca", marca.getIdmarca());
        a.put("descripcionmarca", marca.getDescripcionmarca());
        sqLiteDatabase.insert("marca", null, a);

    }

    public void insertar(Autor autor) {
        ContentValues a = autor.toValues();
        a.put("idautor", autor.getIdautor());
        a.put("nombreautor", autor.getNombreAutor());
        a.put("apellidosautor", autor.getApellidosAutor());
        sqLiteDatabase.insert("autor", null, a);

    }

    public void insertar(TiposDeEquipo tequipo) {
        ContentValues a = tequipo.toValues();
        a.put("idtiposdeequipo", tequipo.getIdTiposDeEquipo());
        a.put("descripciontipequipo", tequipo.getDescripcionTipEquipo());
        sqLiteDatabase.insert("tiposdeequipo", null, a);

    }

    public void insertar(TiposDeDocumento tdoc) {
        ContentValues contentValues = tdoc.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_TIPOS_DE_DOCUMENTO, null, contentValues);

    }

    public void insertar(AutorDetalle autorDetalle) {
        ContentValues contentValues = autorDetalle.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_AUTOR_DETALLE, null, contentValues);

    }

    public void insertar(Documento documento) {
        ContentValues contentValues = documento.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_DOCUMENTO, null, contentValues);

    }

    public void insertar(Equipo equipo) {
        ContentValues contentValues = equipo.toValues();
        sqLiteDatabase.insert(ConstantesDB.TABLA_EQUIPO, null, contentValues);

    }


    //consultar marca

    public Marca consultarM(String idmarca) {


        String[] id = {idmarca};
        Cursor cursor = sqLiteDatabase.query("marca", ConstantesDB.CAMPOS_MARCA, "idmarca = ?", id, null,
                null, null);
        if (cursor.moveToFirst()) {


            Marca marca = new Marca();
            marca.setIdmarca(parseInt(cursor.getString(0)));
            marca.setDescripcionmarca(cursor.getString(1));

            return marca;
        } else {
            return null;
        }
    }


    public int actualizar(Marca marca, int idmarca) {
        int status;

        try {
            ContentValues contentValues = marca.toValues();
            contentValues.put("idmarca", marca.getIdmarca());
            contentValues.put("descripcionmarca", marca.getDescripcionmarca());
            String[] id = {String.valueOf(idmarca)};
            status = sqLiteDatabase.update(ConstantesDB.TABLA_MARCA, contentValues, "idmarca = ? ", id);
            return status;
        } catch (SQLException e) {
            e.printStackTrace();
            status = 0;
            return status;

        }
    }
    //eliminar Marca

    public String eliminar(Marca marca) {
        String conteo;

        String where = "idmarca='" + marca.getIdmarca() + "'";
        sqLiteDatabase.delete("marca", where, null);
        conteo = String.valueOf(getItemsMarca());
        return conteo;


    }


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
        } else {
            return null;
        }
    }


    //PM15007
    public EquipoExistencia getEquipoExistencia(int id_equipo_existencia) {
        String[] id = {String.valueOf(id_equipo_existencia)};
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_EQUIPO_EXISTENCIA, ConstantesDB.CAMPOS_EQUIPO_EXISTENCIA,
                "id_equipo_existencia = ?", id, null, null, null);
        if (cursor.moveToNext()) {
            EquipoExistencia equipoExistencia = new EquipoExistencia();
            equipoExistencia.setId_equipo_existencia(cursor.getInt(0));
            equipoExistencia.setId_equipo(cursor.getInt(1));
            equipoExistencia.setId_docente(cursor.getInt(2));
            equipoExistencia.setId_unidad_administrativa(cursor.getInt(3));
            equipoExistencia.setActual(cursor.getInt(4));
            return equipoExistencia;
        } else {
            return null;
        }
    }

    public EquipoMovimiento getEquipoMovimiento(int id_equipo_movimiento) {
        String[] id = {String.valueOf(id_equipo_movimiento)};
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_EQUIPO_MOVIMIENTO, ConstantesDB.CAMPOS_EQUIPO_MOVIMIENTO,
                "id_equipo_movimiento = ?", id, null, null, null);
        if (cursor.moveToNext()) {
            EquipoMovimiento equipoMovimiento = new EquipoMovimiento();
            equipoMovimiento.setId_equipo_movimiento(cursor.getInt(0));
            equipoMovimiento.setId_tipo_movimiento_equipo(cursor.getInt(1));
            equipoMovimiento.setId_u_administrativa_origen(cursor.getInt(2));
            equipoMovimiento.setId_u_administrativa_destino(cursor.getInt(3));
            equipoMovimiento.setComentario(cursor.getString(4));
            equipoMovimiento.setFecha_movimiento(cursor.getString(5));
            return equipoMovimiento;
        } else {
            return null;
        }
    }

    public EquipoMovimientoDetalle getEquipoMovimientoDetalle(int id_equipo_movimiento_detalle) {
        String[] id = {String.valueOf(id_equipo_movimiento_detalle)};
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_EQUIPO_MOVIMIENTO_DETALLE, ConstantesDB.CAMPOS_EQUIPO_MOVIMIENTO_DETALLE,
                "id_equipo_movimiento_detalle = ?", id, null, null, null);
        if (cursor.moveToNext()) {
            EquipoMovimientoDetalle equipoMovimientoDetalle = new EquipoMovimientoDetalle();
            equipoMovimientoDetalle.setId_equipo_movimiento_detalle(cursor.getInt(0));
            equipoMovimientoDetalle.setId_equipo(cursor.getInt(1));
            equipoMovimientoDetalle.setId_equipo_movimiento(cursor.getInt(2));
            return equipoMovimientoDetalle;
        } else {
            return null;
        }
    }

    public TipoMovimientoEquipo getTipoMovimientoEquipo(int id_tipo_movimiento_equipo) {
        String[] id = {String.valueOf(id_tipo_movimiento_equipo)};
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_TIPO_MOVIMIENTO_EQUIPO, ConstantesDB.CAMPOS_TIPO_MOVIMIENTO_EQUIPO,
                "id_tipo_movimiento_equipo = ? ", id, null, null, null);
        if (cursor.moveToNext()) {
            TipoMovimientoEquipo tipoMovimientoEquipo = new TipoMovimientoEquipo();
            tipoMovimientoEquipo.setId_tipo_movimiento_equipo(cursor.getInt(0));
            tipoMovimientoEquipo.setDescripcion(cursor.getString(1));
            return tipoMovimientoEquipo;
        } else {
            return null;
        }
    }

    public UnidadAdministrativa getUnidadAdministrativa(int id_unidad_administrativa) {
        String[] id = {String.valueOf(id_unidad_administrativa)};
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_UNIDAD_ADMINISTRATIVA, ConstantesDB.CAMPOS_UNIDAD_ADMINISTRATIVA,
                "id_unidad_administrativa = ? ", id, null, null, null);
        if (cursor.moveToNext()) {
            UnidadAdministrativa unidadAdministrativa = new UnidadAdministrativa();
            unidadAdministrativa.setId_unidad_administrativa(cursor.getInt(0));
            unidadAdministrativa.setNombre(cursor.getString(1));
            unidadAdministrativa.setDescripcion(cursor.getString(2));
            return unidadAdministrativa;
        } else {
            return null;
        }
    }

    public int getLastIdEquipoExistencia() {
        if (getItemsEquipoExistencia() == 0) {
            return 0;
        } else {
            Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_EQUIPO_EXISTENCIA, ConstantesDB.CAMPOS_EQUIPO_EXISTENCIA,
                    null, null, null, null, null);
            cursor.moveToLast();
            return cursor.getInt(0);
        }

    }

    public int getLastIdUnidadAdministrativa() {
        if (getItemsUnidadAdministrativa() == 0) {
            return 0;
        } else {
            Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_UNIDAD_ADMINISTRATIVA, ConstantesDB.CAMPOS_UNIDAD_ADMINISTRATIVA,
                    null, null, null, null, null);
            cursor.moveToLast();
            return cursor.getInt(0);
        }
    }


    /* ------------------------------------------------------
     -------------   ACTUALIZACION DE DATOS -----------------
     -------------------------------------------------------*/


    //pm15007
    public int actualizar(EquipoExistencia equipoExistencia) {
        ContentValues contentValues = equipoExistencia.toValues();
        String[] id = {String.valueOf(equipoExistencia.getId_equipo_existencia())};
        return sqLiteDatabase.update(ConstantesDB.TABLA_EQUIPO_EXISTENCIA, contentValues, "id_equipo_existencia = ? ", id);
    }

    public int actualizar(EquipoMovimiento equipoMovimiento) {
        ContentValues contentValues = equipoMovimiento.toValues();
        String[] id = {String.valueOf(equipoMovimiento.getId_equipo_movimiento())};
        return sqLiteDatabase.update(ConstantesDB.TABLA_EQUIPO_MOVIMIENTO, contentValues, "id_equipo_movimiento = ? ", id);
    }

    public int actualizar(EquipoMovimientoDetalle equipoMovimientoDetalle) {
        ContentValues contentValues = equipoMovimientoDetalle.toValues();
        String[] id = {String.valueOf(equipoMovimientoDetalle.getId_equipo_movimiento_detalle())};
        return sqLiteDatabase.update(ConstantesDB.TABLA_EQUIPO_MOVIMIENTO_DETALLE, contentValues, "id_equipo_movimiento_detalle = ? ", id);
    }

    public int actualizar(TipoMovimientoEquipo tipoMovimientoEquipo) {
        ContentValues contentValues = tipoMovimientoEquipo.toValues();
        String[] id = {String.valueOf(tipoMovimientoEquipo.getId_tipo_movimiento_equipo())};
        return sqLiteDatabase.update(ConstantesDB.TABLA_TIPO_MOVIMIENTO_EQUIPO, contentValues, "id_tipo_movimiento_equipo = ? ", id);
    }

    public int actualizar(UnidadAdministrativa unidadAdministrativa) {
        ContentValues contentValues = unidadAdministrativa.toValues();
        String[] id = {String.valueOf(unidadAdministrativa.getId_unidad_administrativa())};
        return sqLiteDatabase.update(ConstantesDB.TABLA_UNIDAD_ADMINISTRATIVA, contentValues, "id_unidad_administrativa = ? ", id);
    }


    /* ------------------------------------------------------
     -------------   ELIMINACION DE DATOS -----------------
     -------------------------------------------------------*/

    //PM15007
    public int eliminar(EquipoExistencia equipoExistencia) {
        String[] id = {String.valueOf(equipoExistencia.getId_equipo_existencia())};
        return sqLiteDatabase.delete(ConstantesDB.TABLA_EQUIPO_EXISTENCIA, "id_equipo_existencia = ? ", id);
    }

    public int eliminar(EquipoMovimiento equipoMovimiento) {
        String[] id = {String.valueOf(equipoMovimiento.getId_equipo_movimiento())};
        return sqLiteDatabase.delete(ConstantesDB.TABLA_EQUIPO_MOVIMIENTO, "id_equipo_movimiento = ? ", id);
    }

    public int eliminar(EquipoMovimientoDetalle equipoMovimientoDetalle) {
        String[] id = {String.valueOf(equipoMovimientoDetalle.getId_equipo_movimiento_detalle())};
        return sqLiteDatabase.delete(ConstantesDB.TABLA_EQUIPO_MOVIMIENTO_DETALLE, "id_equipo_movimiento_detalle = ? ", id);
    }

    public int eliminar(TipoMovimientoEquipo tipoMovimientoEquipo) {
        String[] id = {String.valueOf(tipoMovimientoEquipo.getId_tipo_movimiento_equipo())};
        return sqLiteDatabase.delete(ConstantesDB.TABLA_TIPO_MOVIMIENTO_EQUIPO, "id_tipo_movimiento_equipo = ? ", id);
    }

    public int eliminar(UnidadAdministrativa unidadAdministrativa) {
        String[] id = {String.valueOf(unidadAdministrativa.getId_unidad_administrativa())};
        return sqLiteDatabase.delete(ConstantesDB.TABLA_UNIDAD_ADMINISTRATIVA, "id_unidad_administrativa = ? ", id);
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
        long items = getItemsRol();
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
    //TS14004---------------------------------------------------------------------------
    public String llenarBase() {
        final int[] VDidDocente = {8888881, 8888882, 8888883, 8888884};
        final int[] VDidUnidadAdministrativa = {1111111, 1111110, 1111100, 1111000};
        final String[] VDnombre = {"Rodrigo", "Nelson", "Joel", "Dixon"};
        final String[] VDapellido = {"Orantes", "Ortiz", "Gonzales", "Coto"};
        final String[] VDemail = {"presa@gmail.com", "Miranda@gmail.com", "Ramos@gmail.com", "Argueta@gmail.com"};


        final int[] VAidAsignacionEquipo = {2222222, 2222220, 2222200, 2222000};
        final int[] VAidDocente = {8888881, 8888882, 8888883, 8888884};
        final String[] VAfechaAsignacionEquipo = {"2019-05-01", "2019-05-19", "2019-05-21", "2019-05-25"};


        final int[] VDOidDocumentoAsignacion = {3222222, 3222220, 3222200, 3222000};
        final int[] VDOidDocente = {8888881, 8888882, 8888883, 8888884};
        final String[] VDOmotivo = {"Apoyo en clase", "Apoyo en clase", "Tarea de investigacion", "Lectura"};
        final String[] VDOfechaAsignacionDoc = {"2019-05-16", "2019-05-17", "2019-05-18", "2019-05-19"};

        abrir();
        if (getItemsDocente() == 0) {
            Docente docente = new Docente();
            for (int i = 0; i < 4; i++) {
                docente.setIdDocente(VDidDocente[i]);
                docente.setIdUnidadAdministrativa(VDidUnidadAdministrativa[i]);
                docente.setNombre(VDnombre[i]);
                docente.setApellido(VDapellido[i]);
                docente.setEmail(VDemail[i]);
                insertar(docente);
            }
        }
        if (getItemsAsignacionEquipo() == 0) {
            AsignacionEquipo asignacionEquipo = new AsignacionEquipo();
            for (int i = 0; i < 3; i++) {
                asignacionEquipo.setIdAsignacionEquipo(VAidAsignacionEquipo[i]);
                asignacionEquipo.setIdDocente(VAidDocente[i]);
                asignacionEquipo.setFechaAsignacionEquipo(VAfechaAsignacionEquipo[i]);

                 insertar(asignacionEquipo);
            }
        }
        if (getItemsDocumentoAsignacion() == 0) {
            DocumentoAsignacion documentoAsignacion = new DocumentoAsignacion();
            for (int i = 0; i < 4; i++) {
                documentoAsignacion.setIdDocumentoAsignacion(VDOidDocumentoAsignacion[i]);
                documentoAsignacion.setIdDocente(VDOidDocente[i]);
                documentoAsignacion.setMotivo(VDOmotivo[i]);
                documentoAsignacion.setFechaAsignacionDoc(VDOfechaAsignacionDoc[i]);

                 insertar(documentoAsignacion);
            }
        }

        cerrar();
        return "Guardo Correctamente";
    }

    //******************************************INICIO CRUD DE TS14004*****************************************************************
    //METODOS INSERTAR <--TS14004-->
    public String insertar(Docente docente) {
        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;

        ContentValues doce = new ContentValues();
        doce.put("idDocente", docente.getIdDocente());
        doce.put("idUnidadAdministrativa", docente.getIdUnidadAdministrativa());
        doce.put("nombre", docente.getNombre());
        doce.put("apellido", docente.getApellido());
        doce.put("email", docente.getEmail());
        contador = sqLiteDatabase.insert(ConstantesDB.TABLA_Docente, null, doce);
        if (contador == -1 || contador == 0) {
            regInsertados = "Error al Insertar el registro, Registro, Registro duplicado. Verificar Insercion";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String insertar(AsignacionEquipo asignacionEquipo) {
        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;

        ContentValues asignaEquipo = new ContentValues();
        asignaEquipo.put("idAsignacionEquipo", asignacionEquipo.getIdAsignacionEquipo());
        asignaEquipo.put("idDocente", asignacionEquipo.getIdDocente());
        asignaEquipo.put("fechaAsignacionEquipo", asignacionEquipo.getFechaAsignacionEquipo());
        contador = sqLiteDatabase.insert(ConstantesDB.TABLA_AsignacionEquipo, null, asignaEquipo);
        if (contador == -1 || contador == 0) {
            regInsertados = "Error al Insertar el registro, Registro, Registro duplicado. Verificar Insercion";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }


    public String insertar(DocumentoAsignacion documentoAsignacion){
        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;

        ContentValues documentoAsignado = new ContentValues();
        documentoAsignado.put("idDocumentoAsignacion", documentoAsignacion.getIdDocumentoAsignacion());
        documentoAsignado.put("idDocente", documentoAsignacion.getIdDocente());
        documentoAsignado.put("motivo", documentoAsignacion.getMotivo());
        documentoAsignado.put("fechaAsignacionDoc", documentoAsignacion.getFechaAsignacionDoc());
        contador = sqLiteDatabase.insert(ConstantesDB.TABLA_DocumentoAsignacion, null, documentoAsignado);
        if (contador == -1 || contador == 0) {
            regInsertados = "Error al Insertar el registro, Registro, Registro duplicado. Verificar Insercion";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    //METODOS CONSULTAR <--TS14004-->

    public Docente consultarDocente(int idDocente) {
        String[] id = {String.valueOf(idDocente)};
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_Docente, campos_Docente, "idDocente = ?", id, null, null, null);
        if (cursor.moveToFirst()) {
            Docente docente = new Docente();
            docente.setIdDocente(cursor.getInt(0));
            docente.setIdUnidadAdministrativa(cursor.getInt(1));
            docente.setNombre(cursor.getString(2));
            docente.setApellido(cursor.getString(3));
            docente.setEmail(cursor.getString(4));

            return docente;
        } else {
            return null;
        }
    }

    public AsignacionEquipo consultarAsignacionEquipo(int idAsignacionEquipo) {
        String[] id = {String.valueOf(idAsignacionEquipo)};
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_AsignacionEquipo, campos_AsignacionEquipo, "idAsignacionEquipo = ?", id, null, null, null);
        if (cursor.moveToFirst()) {
            AsignacionEquipo asignacionEquipo = new AsignacionEquipo();
            asignacionEquipo.setIdAsignacionEquipo(cursor.getInt(0));
            asignacionEquipo.setIdDocente(cursor.getInt(1));
            asignacionEquipo.setFechaAsignacionEquipo(cursor.getString(2));

            return asignacionEquipo;
        } else {
            return null;
        }
    }

    public DocumentoAsignacion consultarDocumentoAsignacion(int idDocumentoAsignacion) {
        String[] id = {String.valueOf(idDocumentoAsignacion)};
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_DocumentoAsignacion, campos_DocumentoAsignacion, "idDocumentoAsignacion = ?", id, null, null, null);
        if (cursor.moveToFirst()) {
           DocumentoAsignacion documentoAsignacion = new DocumentoAsignacion();
            documentoAsignacion.setIdDocumentoAsignacion(cursor.getInt(0));
            documentoAsignacion.setIdDocente(cursor.getInt(1));
            documentoAsignacion.setMotivo(cursor.getString(2));
            documentoAsignacion.setFechaAsignacionDoc(cursor.getString(3));

            return documentoAsignacion;
        } else {
            return null;
        }
    }


    //METODOS ACTUALIZAR <--TS14004-->

    public String actualizar(Docente docente) {
        //if (verificarIntegridad(alumno, 5)) {

        String[] id = {String.valueOf(docente.getIdDocente())};
        ContentValues cv = new ContentValues();
        cv.put("idUnidadAdministrativa", docente.getIdUnidadAdministrativa());
        cv.put("nombre", docente.getNombre());
        cv.put("apellido", docente.getApellido());
        cv.put("email", docente.getEmail());
        sqLiteDatabase.update(ConstantesDB.TABLA_Docente, cv, "idDocente = ?", id);
        return "Registro Actualizado Correctamente";
        // } else {
        //  return "Registro con carnet " + alumno.getCarnet() + " no existe";
        //}

    }
    public String actualizar(AsignacionEquipo asignacionEquipo) {
        //if (verificarIntegridad(alumno, 5)) {

        String[] id = {String.valueOf(asignacionEquipo.getIdAsignacionEquipo())};
        ContentValues cv = new ContentValues();
        cv.put("idDocente", asignacionEquipo.getIdDocente());
        cv.put("fechaAsignacionEquipo", asignacionEquipo.getFechaAsignacionEquipo());
        sqLiteDatabase.update(ConstantesDB.TABLA_AsignacionEquipo, cv, "idAsignacionEquipo = ?", id);
        return "Registro Actualizado Correctamente";
        // } else {
        //  return "Registro con carnet " + alumno.getCarnet() + " no existe";
        //}
    }

    public String actualizar(DocumentoAsignacion documentoAsignacion) {
        //if (verificarIntegridad(alumno, 5)) {

        String[] id = {String.valueOf(documentoAsignacion.getIdDocumentoAsignacion())};
        ContentValues cv = new ContentValues();
        cv.put("idDocente", documentoAsignacion.getIdDocente());
        cv.put("motivo", documentoAsignacion.getMotivo());
        cv.put("fechaAsignacionDoc", documentoAsignacion.getFechaAsignacionDoc());
        sqLiteDatabase.update(ConstantesDB.TABLA_DocumentoAsignacion, cv, "idDocumentoAsignacion = ?", id);
        return "Registro Actualizado Correctamente";
        // } else {
        //  return "Registro con carnet " + alumno.getCarnet() + " no existe";
        //}
    }


    //METODOS ELIMINAR <--TS14004-->
    public String eliminar(Docente docente) {
        String regAfectados = "filas afectadas= ";
        int contador = 0;
        /*if (verificarIntegridad(alumno, 3)) {
            contador += db.delete("nota", "carnet='" + alumno.getCarnet() + "'", null);
        }*/
        contador += sqLiteDatabase.delete(ConstantesDB.TABLA_Docente, "idDocente='" + docente.getIdDocente() + "'", null);
        regAfectados += contador;
        return regAfectados;
    }

    public String eliminar(AsignacionEquipo asignacionEquipo) {
        String regAfectados = "filas afectadas= ";
        int contador = 0;
        /*if (verificarIntegridad(alumno, 3)) {
            contador += db.delete("nota", "carnet='" + alumno.getCarnet() + "'", null);
        }*/
        contador += sqLiteDatabase.delete(ConstantesDB.TABLA_AsignacionEquipo, "idAsignacionEquipo='" + asignacionEquipo.getIdAsignacionEquipo() + "'", null);
        regAfectados += contador;
        return regAfectados;
    }

    public String eliminar(DocumentoAsignacion documentoAsignacion) {
        String regAfectados = "filas afectadas= ";
        int contador = 0;
        /*if (verificarIntegridad(alumno, 3)) {
            contador += db.delete("nota", "carnet='" + alumno.getCarnet() + "'", null);
        }*/
        contador += sqLiteDatabase.delete(ConstantesDB.TABLA_DocumentoAsignacion, "idDocumentoAsignacion='" + documentoAsignacion.getIdDocumentoAsignacion() + "'", null);
        regAfectados += contador;
        return regAfectados;
    }

}
//***************************************************FIN CRUD DE TS14004**********************************************************************