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
import com.pdmsubecum.DB.modelo.AsignacionEquipoDetalle;
import com.pdmsubecum.DB.modelo.Docente;
import com.pdmsubecum.DB.modelo.DocumentoAsignacion;
import com.pdmsubecum.DB.modelo.DocumentoAsignacionDetalle;
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
import com.pdmsubecum.rl08017.DocumentoExistencia;
import com.pdmsubecum.rl08017.DocumentoMovimiento;
import com.pdmsubecum.rl08017.TiposDeMovimientoParaDocumento;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static com.pdmsubecum.DB.ConstantesDB.CAMPOS_DOCUMENTO_EXISTENCIA;
import static com.pdmsubecum.DB.ConstantesDB.CAMPOS_DOCUMENTO_MOVIMIENTO;
import static com.pdmsubecum.DB.ConstantesDB.CAMPOS_DOCUMENTO_MOVIMIENTO_DETALLE;
import static com.pdmsubecum.DB.ConstantesDB.CAMPOS_TIPO_MOV_DOCUMENTO;
import static com.pdmsubecum.DB.ConstantesDB.TABLA_EQUIPO;
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

    public long getItemsAutor() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_AUTOR);
    }

    public long getItemsAutorDetalle() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_AUTOR_DETALLE);
    }

    public long getItemsTiposEquipo() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_TIPOS_DE_EQUIPO);


    }

    public long getItemsTiposDocumento() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_TIPOS_DE_DOCUMENTO);
    }
    public long getItemsDocumento() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_DOCUMENTO);
    }
    public long getItemsEquipo() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, ConstantesDB.TABLA_EQUIPO);
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
        sqLiteDatabase.insert("autor", null, a);

    }

    public void insertar(TiposDeEquipo tequipo) {
        ContentValues a = tequipo.toValues();
        a.put("idtiposdeequipo", tequipo.getIdTiposDeEquipo());
        a.put("descripciontipequipo", tequipo.getDescripcionTipEquipo());
        sqLiteDatabase.insert(ConstantesDB.TABLA_TIPOS_DE_EQUIPO, null, a);

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


    public Equipo consultarE(String idequipo) {


        String[] id = {idequipo};
        Cursor cursor = sqLiteDatabase.query("equipo", ConstantesDB.CAMPOS_EQUIPO, "idequipo = ?", id, null,
                null, null);
        if (cursor.moveToFirst()) {


            Equipo equipo= new Equipo();
            equipo.setIdequipo(Integer.parseInt(cursor.getString(0)));
            equipo.setIdtiposdeequipo(Integer.parseInt(cursor.getString(1)));
            equipo.setIdmarca(Integer.parseInt(cursor.getString(2)));
            equipo.setSerie(cursor.getString(3));
            equipo.setCaracteristicas(cursor.getString(4));
            equipo.setModelo(cursor.getString(5));

            equipo.setFechaingreso(cursor.getString(6));

            if (Integer.parseInt(cursor.getString(7))==1) {
                equipo.setEquipodisponible(true);
            }
            else {

                equipo.setEquipodisponible(false);
            }

            return equipo;
        } else {
            return null;
        }
    }

    public Documento consultarD(String isbn) {


        String[] id = {isbn};
        Cursor cursor = sqLiteDatabase.query("documento", ConstantesDB.CAMPOS_DOCUMENTO, "isbn = ?", id, null,
                null, null);
        if (cursor.moveToFirst()) {

            Documento documento= new Documento();

            documento.setIsbn(cursor.getString(0));
            documento.setIdtiposdedocumento(Integer.parseInt(cursor.getString(1)));
            documento.setNombredoc(cursor.getString(2));
            documento.setIdioma(cursor.getString(3));
            documento.setDescripciondoc(cursor.getString(4));




            if (Integer.parseInt(cursor.getString(5))==1) {
                documento.setDisponibledoc(true);
            }
            else {

                documento.setDisponibledoc(false);
            }

            return documento;
        } else {
            return null;
        }
    }


    public ArrayList<Marca> llenarspinner() {


        ArrayList<Marca> marcas = new ArrayList<Marca>();

       //Cursor cursor = sqLiteDatabase.query("marca", ConstantesDB.CAMPOS_MARCA, null, null, null,null, null);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from marca",null);

        while (cursor.moveToNext()) {



                Marca marca = new Marca();
                marca.setIdmarca(parseInt(cursor.getString(0)));
                marca.setDescripcionmarca(cursor.getString(1));
                marcas.add(marca);


        }

        return  marcas;
    }


    public ArrayList<TiposDeDocumento> llenarspinnerDoc() {


        ArrayList<TiposDeDocumento> tiposDeDocumentos = new ArrayList<>();

        //Cursor cursor = sqLiteDatabase.query("marca", ConstantesDB.CAMPOS_MARCA, null, null, null,null, null);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+ConstantesDB.TABLA_TIPOS_DE_DOCUMENTO,null);

        while (cursor.moveToNext()) {



            TiposDeDocumento tiposDeDocumento= new TiposDeDocumento();
            tiposDeDocumento.setIdTiposDeDocumentos(parseInt(cursor.getString(0)));
            tiposDeDocumento.setDescripcionTipoDeDocumento(cursor.getString(1));
            tiposDeDocumentos.add(tiposDeDocumento);


        }

        return  tiposDeDocumentos;
    }


    public ArrayList<TiposDeEquipo> llenarSpinerEquipos() {


        ArrayList<TiposDeEquipo> tiposDeEquip = new ArrayList<TiposDeEquipo>();

        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_TIPOS_DE_EQUIPO, ConstantesDB.CAMPOS_TIPOS_EQUIPO, null, null, null,null, null);
        //Cursor cursor = sqLiteDatabase.rawQuery("select * from" + ConstantesDB.TABLA_TIPOS_DE_EQUIPO,null);

        while (cursor.moveToNext()) {



            TiposDeEquipo tiposDeEquipo = new TiposDeEquipo();
            tiposDeEquipo.setIdTiposDeEquipo(parseInt(cursor.getString(0)));
            tiposDeEquipo.setDescripcionTipEquipo(cursor.getString(1));
            tiposDeEquip.add(tiposDeEquipo);


        }

        return  tiposDeEquip;
    }


    public void ingresarFecha(String fecha ,int idf){

        String[] id = {String.valueOf(idf)};


      //  status = sqLiteDatabase.update(ConstantesDB.TABLA_MARCA, contentValues, "idmarca = ? ", id)

        Log.d("fecha",fecha);

          sqLiteDatabase.rawQuery("update equipo set fechaingreso=" + fecha + " where idequipo=" + idf, null);



      //  sqLiteDatabase.update(ConstantesDB.TABLA_MARCA, contentValues, "idequipo = ? ", id);


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


    public String eliminar(Equipo equipo) {
        String conteo;

        String where = "idequipo='" + equipo.getIdequipo() + "'";
        sqLiteDatabase.delete("equipo", where, null);
        conteo = String.valueOf(getItemsMarca());
        return conteo;
    }

    public String eliminar(Documento doc) {
        String conteo;

        String where = "isbn='" + doc.getIsbn() + "'";
        sqLiteDatabase.delete(ConstantesDB.TABLA_DOCUMENTO, where, null);
        conteo = String.valueOf(getItemsDocumento());
        return conteo;
    }

    public int actualizarEquipo(Equipo equipo, int ideq) {

        ContentValues contentValues = equipo.toValues();
        String[] id = {String.valueOf(ideq)};
        Log.d("ide", String.valueOf(id));
        Log.d("values",String.valueOf(contentValues));


        return sqLiteDatabase.update(ConstantesDB.TABLA_EQUIPO, contentValues, "idequipo = ?",id);
    }

    public int actualizar(Documento documento, String idoc) {

        ContentValues contentValues = documento.toValues();
        String[] id = {String.valueOf(idoc)};
        Log.d("ide", String.valueOf(id));
        Log.d("values",String.valueOf(contentValues));


        return sqLiteDatabase.update(ConstantesDB.TABLA_DOCUMENTO, contentValues, "isbn = ?",id);
    }

    public boolean verificarIntegridadAM15005(Object dato, int relacion) throws
            SQLException{
        switch(relacion) {
            case 1: {

              Marca  marca = (Marca) dato;
                String[] id1 = {String.valueOf(marca.getIdmarca())};

                abrir();
                Cursor cursor1 = sqLiteDatabase.query(ConstantesDB.TABLA_MARCA, null, "idmarca = ?", id1, null,
                        null, null);
                if(cursor1.moveToFirst()){
//Se encontro Marca
                    return true;
                }
                return false;

        }
            case 2: {

                Equipo  equipo = (Equipo) dato;
                String[] id1 = {String.valueOf(equipo.getIdequipo())};

                abrir();
                Cursor cursor1 = sqLiteDatabase.query(TABLA_EQUIPO, null, "idequipo = ?", id1, null,
                        null, null);
                if(cursor1.moveToFirst()){
//Se encontro equipo
                    return true;
                }
                return false;

            }
            case 3: {

                Documento documento = (Documento) dato;
                String[] id1 = {String.valueOf(documento.getIsbn())};

                abrir();
                Cursor cursor1 = sqLiteDatabase.query(ConstantesDB.TABLA_DOCUMENTO, null, "isbn = ?", id1, null,
                        null, null);
                if(cursor1.moveToFirst()){
//Se encontro Documento
                    return true;
                }
                return false;

            }

            default:
                return false;

        }


    }




                //    insertar Datos
    public void llenarMarca(List<Marca> marcas) {
        long items = getItemsMarca();
        if (items == 0) {
            for (Marca marca : marcas) {
                try {
                    insertar(marca);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void llenarAutor(List<Autor> autors) {
        long items = getItemsAutor();
        if (items == 0) {
            for (Autor autor: autors) {
                try {
                    insertar(autor);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void llenarDocumento(ArrayList<Documento> documentos) {

        long items = getItemsDocumento();
        if (items == 0) {
            for (Documento documento: documentos) {
                try {
                    insertar(documento);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void llenarEquipos(List<Equipo> equipos) {
        long items = getItemsEquipo();
        if (items == 0) {
            for (Equipo equipo: equipos) {
                try {
                    insertar(equipo);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void llenarAutorDetalle(ArrayList<AutorDetalle> autorDetalles) {
        long items = getItemsAutorDetalle();
        if (items == 0) {
            for (AutorDetalle autorDetalle: autorDetalles) {
                try {
                    insertar(autorDetalle);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void llenarDocumentosDetalle(ArrayList<Documento> documentos) {
        long items = getItemsDocumento();
        if (items == 0) {
            for (Documento doc: documentos) {
                try {
                    insertar(doc);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public void llenarTiposEquipo(List<TiposDeEquipo> tiposDeEquipos) {
        long items = getItemsTiposEquipo();
        if (items == 0) {
            for (TiposDeEquipo equipo: tiposDeEquipos) {
                try {
                    insertar(equipo);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void llenarTiposDeDocumento(List<TiposDeDocumento> td) {
        long items = getItemsTiposDocumento();
        if (items == 0) {
            for (TiposDeDocumento d: td) {
                try {
                    insertar(d);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
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

    public int getLastIdTipoMovimientoEquipo(){
        if(getItemsTipoMovimientoEquipo() == 0){
            return 0;
        }else{
            Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_TIPO_MOVIMIENTO_EQUIPO, ConstantesDB.CAMPOS_TIPO_MOVIMIENTO_EQUIPO,
                    null,null,null,null,null);
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
    //LLENADO DE TABLAS PM15007
    public void llenarEquipoExistencia(List<EquipoExistencia> equipoExistencias){
        long items = getItemsEquipoExistencia();
        if(items == 0){
            for (EquipoExistencia equipoExistencia: equipoExistencias){
                try {
                    insertar(equipoExistencia);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void llenarEquipoMovimiento(List<EquipoMovimiento> equipoMovimientos){
        long items = getItemsEquipoMovimiento();
        if(items == 0){
            for (EquipoMovimiento equipoMovimiento: equipoMovimientos){
                try {
                    insertar(equipoMovimiento);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void llenarEquipoMovimientoDetalle(List<EquipoMovimientoDetalle> equipoMovimientoDetalles){
        long items = getItemsEquipoMovimientoDetalle();
        if(items == 0){
            for (EquipoMovimientoDetalle equipoMovimientoDetalle: equipoMovimientoDetalles){
                try {
                    insertar(equipoMovimientoDetalle);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void llenarTipoMovimientoEquipo(List<TipoMovimientoEquipo> tipoMovimientoEquipos){
        long items = getItemsTipoMovimientoEquipo();
        if(items == 0){
            for (TipoMovimientoEquipo tipoMovimientoEquipo: tipoMovimientoEquipos){
                try {
                    insertar(tipoMovimientoEquipo);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void llenarUnidadAdministrativa(List<UnidadAdministrativa> unidadAdministrativas){
        long items = getItemsUnidadAdministrativa();
        if(items == 0){
            for (UnidadAdministrativa unidadAdministrativa: unidadAdministrativas){
                try {
                    insertar(unidadAdministrativa);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    ///////////////////////////////////////////////////////////
    ////// FIN LLENADO PM15007 //////////////////////////////
    /////////////////////////////////////////////////////////////

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


        final int[] VAidAsignacionEquipo = {2123, 2124, 2125, 2126};
        final int[] VAidDocente = {8888881, 8888882, 8888883, 8888884};
        final String[] VAfechaAsignacionEquipo = {"2019-05-01", "2019-05-19", "2019-05-21", "2019-05-25"};


        final int[] VDOidDocumentoAsignacion = {3123, 3124, 3125, 3126};
        final int[] VDOidDocente = {8888881, 8888882, 8888883, 8888884};
        final String[] VDOmotivo = {"Apoyo en clase", "Apoyo en clase", "Tarea de investigacion", "Lectura"};
        final String[] VDOfechaAsignacionDoc = {"2019-05-16", "2019-05-17", "2019-05-18", "2019-05-19"};


        final int[] VADidAsignacionEquipoDetalle = {100, 101, 102, 103};
        final int[] VADidEquipo = {200, 201, 202, 203};
        final int[] VADidAsignacionEquipo = {2123, 2124, 2125, 2126};

        final int[] VDODidDocumentoAsignacionDetalle = {300, 301, 302, 303};
        final String[] VDODisbn = {"02-2850-678-6", "07-2653-321-5", "04-2261-312-1", "05-2512-333-3"};
        final int[] VDODidDocumentoAsignacion = {3123, 3124, 3125, 3126};

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
        if (getItemsAsignacionEquipoDetalle() == 0) {
            AsignacionEquipoDetalle asignacionEquipoDetalle = new AsignacionEquipoDetalle();
            for (int i = 0; i < 3; i++) {
                asignacionEquipoDetalle.setIdAsignacionEquipoDetalle(VADidAsignacionEquipoDetalle[i]);
                asignacionEquipoDetalle.setIdEquipo(VADidEquipo[i]);
                asignacionEquipoDetalle.setIdAsignacionEquipo(VADidAsignacionEquipo[i]);

                insertar(asignacionEquipoDetalle);
            }
        }
        if (getItemsDocumentoAsignacionDetalle() == 0) {
            DocumentoAsignacionDetalle documentoAsignacionDetalle = new DocumentoAsignacionDetalle();
            for (int i = 0; i < 3; i++) {
                documentoAsignacionDetalle.setIdDocumentoAsignacionDetalle(VDODidDocumentoAsignacionDetalle[i]);
                documentoAsignacionDetalle.setIsbn(VDODisbn[i]);
                documentoAsignacionDetalle.setIdDocumentoAsignacion(VDODidDocumentoAsignacion[i]);

                insertar(documentoAsignacionDetalle);
            }
        }

        cerrar();
        return "Guardo  en la Base de Datos";
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

    public String insertar(AsignacionEquipoDetalle asignacionEquipoDetalle) {
        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;

        ContentValues asignaEquipoDetalle = new ContentValues();
        asignaEquipoDetalle.put("idAsignacionEquipoDetalle", asignacionEquipoDetalle.getIdAsignacionEquipoDetalle());
        asignaEquipoDetalle.put("idEquipo", asignacionEquipoDetalle.getIdEquipo());
        asignaEquipoDetalle.put("idAsignacionEquipo", asignacionEquipoDetalle.getIdAsignacionEquipo());
        contador = sqLiteDatabase.insert(ConstantesDB.TABLA_AsignacionEquipoDetalle, null, asignaEquipoDetalle );
        if (contador == -1 || contador == 0) {
            regInsertados = "Error al Insertar el registro, Registro, Registro duplicado. Verificar Insercion";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }
    public String insertar(DocumentoAsignacionDetalle documentoAsignacionDetalle) {
        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;

        ContentValues docuAsignaDetalle = new ContentValues();
        docuAsignaDetalle.put("idDocumentoAsignacionDetalle", documentoAsignacionDetalle.getIdDocumentoAsignacionDetalle());
        docuAsignaDetalle.put("isbn", documentoAsignacionDetalle.getIsbn());
        docuAsignaDetalle.put("idDocumentoAsignacion", documentoAsignacionDetalle.getIdDocumentoAsignacion());
        contador = sqLiteDatabase.insert(ConstantesDB.TABLA_DocumentoAsignacionDetalle, null, docuAsignaDetalle );
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


    //rl08017

    public String insertar(TiposDeMovimientoParaDocumento tiposDeMovimientoParaDocumento){
        try{
            String regInsertados="Registro Insertado Nº= ";
            long contador=0;
            ContentValues tipo = new ContentValues();
            tipo.put("id_tipo_de_movimiento_para_documento", tiposDeMovimientoParaDocumento.getIdTiposDeMovimientoParaDocumento());
            tipo.put("descripcion", tiposDeMovimientoParaDocumento.getDescripcionMovimientoDoc());
            contador = sqLiteDatabase.insert(ConstantesDB.TABLA_TIPO_MOV_DOCUMENTO, null, tipo);
            if(contador==-1 || contador==0)
            {
                regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
            }
            else {
                regInsertados=regInsertados+contador;
            }
            return regInsertados;

        }
        catch (SQLException e ){
            return "datos incorrectos o faltantes";
        }

    }

    public String insertar(DocumentoExistencia documentoExistencia){

        try{
            String regInsertados="Registro Insertado Nº= ";
            long contador=0;

            if (exiIsbn(documentoExistencia)){
                if (exiUnidad(documentoExistencia)){
                    if (exiDocente(documentoExistencia)){
                        ContentValues tipo = new ContentValues();
                        tipo.put("id_documento_existencia", documentoExistencia.getIdDocumentoExistencia());
                        tipo.put("isbn", documentoExistencia.getIsbn());
                        tipo.put("id_docente", documentoExistencia.getIdDocente());
                        tipo.put("id_unidad_admin", documentoExistencia.getIdUnidadAdministrativa());
                        tipo.put("actual", documentoExistencia.getActual());
                        contador = sqLiteDatabase.insert(ConstantesDB.TABLA_DOCUMENTO_EXISTENCIA, null, tipo);
                        if(contador==-1 || contador==0)
                        {
                            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
                        }
                        else {
                            regInsertados=regInsertados+contador;
                        }
                        return regInsertados;


                    }
                    else{
                        return "no existe docente";
                    }

                }
                else{
                    return "no existe unidad administrativa";
                }


            }
            else{
                return "no existe documento con ese isbn";
            }

        }
        catch (SQLException e ){
            return "datos incorrectos o faltantes";
        }

    }

    public TiposDeMovimientoParaDocumento consultarTipoMov(String idMov){
        String[] id = {idMov};
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_TIPO_MOV_DOCUMENTO, CAMPOS_TIPO_MOV_DOCUMENTO, "id_tipo_de_movimiento_para_documento = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            TiposDeMovimientoParaDocumento tipo = new TiposDeMovimientoParaDocumento();
            tipo.setIdTiposDeMovimientoParaDocumento(parseInt(cursor.getString(0)));
            tipo.setDescripcionMovimientoDoc(cursor.getString(1));
            return tipo;
        }else{ return null;
        }
    }

    public DocumentoExistencia consultarDocExistencia(String idExis){
        String[] id = {idExis};
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_DOCUMENTO_EXISTENCIA, CAMPOS_DOCUMENTO_EXISTENCIA, "id_documento_existencia = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            DocumentoExistencia tipo = new DocumentoExistencia();
            tipo.setIdDocumentoExistencia(parseInt(cursor.getString(0)));
            tipo.setIsbn(cursor.getString(1));
            tipo.setIdDocente(parseInt(cursor.getString(2)));
            tipo.setIdUnidadAdministrativa(parseInt(cursor.getString(3)));
            tipo.setActual(parseInt(cursor.getString(4)));
            return tipo;
        }else{ return null;
        }
    }

    public String actualizar(TiposDeMovimientoParaDocumento tipo){
        try{
            String[] id = {String.valueOf(tipo.getIdTiposDeMovimientoParaDocumento())};
            ContentValues cv = new ContentValues();
            cv.put("id_tipo_de_movimiento_para_documento", tipo.getIdTiposDeMovimientoParaDocumento());
            cv.put("descripcion", tipo.getDescripcionMovimientoDoc());
            sqLiteDatabase.update(ConstantesDB.TABLA_TIPO_MOV_DOCUMENTO, cv, "id_tipo_de_movimiento_para_documento = ?", id);
            return "Registro Actualizado Correctamente";
        }
        catch (SQLException e ){
            return e.toString();
        }
    }

    public String actualizar(DocumentoExistencia tipo){
        try{
            String[] id = {String.valueOf(tipo.getIdDocumentoExistencia())};
            ContentValues cv = new ContentValues();
            cv.put("id_documento_existencia", tipo.getIdDocumentoExistencia());
            cv.put("isbn", tipo.getIsbn());
            cv.put("id_docente", tipo.getIdDocente());
            cv.put("id_unidad_admin", tipo.getIdUnidadAdministrativa());
            cv.put("actual", tipo.getActual());
            sqLiteDatabase.update(ConstantesDB.TABLA_DOCUMENTO_EXISTENCIA, cv, "id_documento_existencia = ?", id);
            return "Registro Actualizado Correctamente";
        }
        catch (SQLException e ){
            return e.toString();
        }
    }

    public String eliminar(TiposDeMovimientoParaDocumento tipo){

        try{
            String regAfectados="filas afectadas= ";
            int contador=0;
            contador+=sqLiteDatabase.delete(ConstantesDB.TABLA_TIPO_MOV_DOCUMENTO, "id_tipo_de_movimiento_para_documento='"+ tipo.getIdTiposDeMovimientoParaDocumento() +"'", null);

            regAfectados+=contador;
            return regAfectados;

        }
        catch (SQLException e ){
            return "datos incorrectos o faltantes";
        }

    }

    public String eliminar(DocumentoExistencia tipo){

        try{
            String regAfectados="filas afectadas= ";
            int contador=0;
            contador+=sqLiteDatabase.delete(ConstantesDB.TABLA_DOCUMENTO_EXISTENCIA, "id_documento_existencia='"+ tipo.getIdDocumentoExistencia() +"'", null);

            regAfectados+=contador;
            return regAfectados;

        }
        catch (SQLException e ){
            return "datos incorrectos o faltantes";
        }

    }

    public String insertarMovDoc(DocumentoMovimiento doc){

        try{
            String regInsertados="Registro Insertado Nº= ";
            long contador=0;
            if (exiIdDetalle(doc)){

                return "ya existe el id del detalle";

            }
            else{
                if (movtipo(doc)){
                    if (exiUnidadO(doc)){
                        if (exiUnidadD(doc)){
                            if (exiIsbn(doc)){
                                ContentValues tipo = new ContentValues();
                                tipo.put("id_documento_movimiento", doc.getIdDocMov());
                                tipo.put("id_tipo_movimiento_documento", doc.getIdTipoMovDoc());
                                tipo.put("id_unidad_admin_origen", doc.getIdUnidadAdmOrigen());
                                tipo.put("id_unidad_admin_destino", doc.getIdUnidadAdmDestino());
                                tipo.put("comentario", doc.getComentario());
                                tipo.put("fecha_movimiento", doc.getFecha());
                                contador = sqLiteDatabase.insert(ConstantesDB.TABLA_DOCUMENTO_MOVIMIENTO, null, tipo);
                                if(contador==-1 || contador==0)
                                {
                                    regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
                                }
                                else {
                                    ContentValues tipo2 = new ContentValues();
                                    tipo2.put("id_documento_movimiento_detalle",doc.getIdMovDocDetalle());
                                    tipo2.put("isbn", doc.getIsbn());
                                    tipo2.put("id_documento_movimiento", doc.getIdDocMov());
                                    contador += sqLiteDatabase.insert(ConstantesDB.TABLA_DOCUMENTO_MOVIMIENTO_DETALLE, null, tipo2);
                                    if(contador==-1 || contador==0)
                                    {
                                        regInsertados= "erro en tabla";
                                    }
                                    else{

                                        regInsertados=regInsertados+contador;
                                    }

                                }
                            }
                            else{
                                return "no existe documento con ese isbn";
                            }

                        }
                        else{
                            return "no existe unidad de destino";
                        }


                    }
                    else{
                        return "no existe unidad de origen";
                    }
                }
                else{
                    return "no existe el tipo de mov";
                }

            }

            return regInsertados;

        }
        catch (SQLException e ){
            return "datos incorrectos o faltantes";
        }


    }

    public String eliminar(DocumentoMovimiento tipo){
        try{
            String regAfectados="filas afectadas= ";
            int contador=0;
            contador+=sqLiteDatabase.delete(ConstantesDB.TABLA_DOCUMENTO_MOVIMIENTO, "id_documento_movimiento='"+ tipo.getIdDocMov() +"'", null);
            contador+=sqLiteDatabase.delete(ConstantesDB.TABLA_DOCUMENTO_MOVIMIENTO_DETALLE, "id_documento_movimiento='"+ tipo.getIdDocMov() +"'", null);

            regAfectados+=contador;
            return regAfectados;

        }
        catch (SQLException e ){
            return "datos incorrectos o faltantes";
        }

    }


    public String llenarBDInicio() {
        // tabla tipo movimiento
        final int[] Vid = {1, 2, 3, 4, 5};
        final String[] Vdes = {"Cambio", "Traslado", "Reparado", "Compra", "Donado"};

        // tabla documento movimiento
        final int[] Vid2 = {1, 2, 3, 4, 5};
        final int[] Vtipo = {1, 2, 3, 4, 5};
        final int[] Vori = {1, 2, 3, 1, 2};
        final int[] Vdest = {1, 2, 2, 3, 1};
        final String[] Vcom = {"Cambio", "Traslado", "Reparado", "Compra", "Donado"};
        final String[] Vfecha = {"2019-04-02", "2019-04-01", "2019-04-08", "2019-04-06", "2019-04-12"};

        // tabla documento movimiento detalle
        final int[] Vid3 = {1, 2, 3, 4, 5};
        final String[] Visbn = {"00000001", "00000001", "00000001", "00000001", "00000001"};

        // tabla documento existencia
        final int[] Vid4 = {1, 2, 3, 4, 5};
        final String[] Visbn2 = {"00000001", "00000001", "00000001", "00000001", "00000001"};
        final int[] Vdocente = {8888881, 8888881, 8888881, 8888881, 8888881};
        final int[] Vunidad = {1, 2, 3, 1, 2};
        final int[] Vactual = {1, 1, 1, 1, 1};


        abrir();

        TiposDeMovimientoParaDocumento Vnu=new TiposDeMovimientoParaDocumento();
        DocumentoMovimiento Vnu1=new DocumentoMovimiento();
        DocumentoExistencia Vnu2=new DocumentoExistencia();
        for(int i=0;i<4;i++){
            Vnu.setIdTiposDeMovimientoParaDocumento(Vid[i]);
            Vnu.setDescripcionMovimientoDoc(Vdes[i]);

            Vnu1.setIdDocMov(Vid2[i]);
            Vnu1.setIdTipoMovDoc(Vtipo[i]);
            Vnu1.setIdUnidadAdmOrigen(Vori[i]);
            Vnu1.setIdUnidadAdmDestino(Vdest[i]);
            Vnu1.setComentario(Vcom[i]);
            Vnu1.setFecha(Vfecha[i]);
            Vnu1.setIdMovDocDetalle(Vid3[i]);
            Vnu1.setIsbn(Visbn[i]);


            Vnu2.setIdDocumentoExistencia(Vid4[i]);
            Vnu2.setIsbn(Visbn2[i]);
            Vnu2.setIdDocente(Vdocente[i]);
            Vnu2.setIdUnidadAdministrativa(Vunidad[i]);
            Vnu2.setActual(Vactual[i]);

            insertar(Vnu);
            insertarMovDoc(Vnu1);
            insertar(Vnu2);
        }
        return "no llena";

    }

    private boolean movtipo(DocumentoMovimiento tipo) throws SQLException{

        String[] idTipo = {String.valueOf(tipo.getIdTipoMovDoc())};

        Cursor c = sqLiteDatabase.query("tipo_movimiento_para_documento",null,"id_tipo_de_movimiento_para_documento = ?",
                idTipo,null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }



    }


    public DocumentoMovimiento consultarDocMov(String idExis){
        String[] id = {idExis};
        Cursor cursor = sqLiteDatabase.query(ConstantesDB.TABLA_DOCUMENTO_MOVIMIENTO, CAMPOS_DOCUMENTO_MOVIMIENTO, "id_documento_movimiento = ?", id, null, null, null);
        Cursor cursor2 = sqLiteDatabase.query(ConstantesDB.TABLA_DOCUMENTO_MOVIMIENTO_DETALLE, CAMPOS_DOCUMENTO_MOVIMIENTO_DETALLE, "id_documento_movimiento = ?", id, null, null, null);


        if(cursor.moveToFirst()&& cursor2.moveToFirst()){
            DocumentoMovimiento tipo = new DocumentoMovimiento();
            tipo.setIdDocMov(parseInt(cursor.getString(0)));
            tipo.setIdTipoMovDoc(parseInt(cursor.getString(1)));
            tipo.setIdUnidadAdmOrigen(parseInt(cursor.getString(2)));
            tipo.setIdUnidadAdmDestino(parseInt(cursor.getString(3)));
            tipo.setComentario(cursor.getString(4));
            tipo.setFecha(cursor.getString(5));
            tipo.setIdMovDocDetalle(parseInt(cursor2.getString(0)));
            tipo.setIsbn(cursor2.getString(1));
            return tipo;
        }else{ return null;
        }
    }


    public String actualizar(DocumentoMovimiento tipo){
        try {
            String[] id = {String.valueOf(tipo.getIdDocMov())};
            ContentValues cv = new ContentValues();
            ContentValues cv2 = new ContentValues();
            cv.put("id_documento_movimiento", tipo.getIdDocMov());
            cv.put("id_tipo_movimiento_documento", tipo.getIdTipoMovDoc());
            cv.put("id_unidad_admin_origen", tipo.getIdUnidadAdmOrigen());
            cv.put("id_unidad_admin_destino", tipo.getIdUnidadAdmDestino());
            cv.put("comentario", tipo.getComentario());
            cv.put("fecha_movimiento", tipo.getFecha());
            cv2.put("id_documento_movimiento_detalle", tipo.getIdMovDocDetalle());
            cv2.put("isbn", tipo.getIsbn());
            cv2.put("id_documento_movimiento", tipo.getIdDocMov());
            sqLiteDatabase.update(ConstantesDB.TABLA_DOCUMENTO_MOVIMIENTO, cv, "id_documento_movimiento = ?", id);
            sqLiteDatabase.update(ConstantesDB.TABLA_DOCUMENTO_MOVIMIENTO_DETALLE, cv2, "id_documento_movimiento = ?", id);
            return "Registro Actualizado Correctamente";
        }
        catch (SQLException e ){
            return e.toString();
        }
    }

    private boolean exiUnidadO(DocumentoMovimiento tipo) throws SQLException{

        String[] idTipo = {String.valueOf(tipo.getIdUnidadAdmOrigen())};

        Cursor c = sqLiteDatabase.query("unidad_administrativa",null,"id_unidad_administrativa = ?",
                idTipo,null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

    private boolean exiUnidadD(DocumentoMovimiento tipo) throws SQLException{

        String[] idTipo = {String.valueOf(tipo.getIdUnidadAdmDestino())};

        Cursor c = sqLiteDatabase.query("unidad_administrativa",null,"id_unidad_administrativa = ?",
                idTipo,null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

    private boolean exiUnidad(DocumentoExistencia tipo) throws SQLException{

        String[] idTipo = {String.valueOf(tipo.getIdUnidadAdministrativa())};

        Cursor c = sqLiteDatabase.query("unidad_administrativa",null,"id_unidad_administrativa = ?",
                idTipo,null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

    private boolean exiDocente(DocumentoExistencia tipo) throws SQLException{

        String[] idTipo = {String.valueOf(tipo.getIdDocente())};

        Cursor c = sqLiteDatabase.query("docente",null,"idDocente = ?",
                idTipo,null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }
    private boolean exiIsbn(DocumentoExistencia tipo) throws SQLException{

        String[] idTipo = {String.valueOf(tipo.getIsbn())};

        Cursor c = sqLiteDatabase.query("documento",null,"ISBN = ?",
                idTipo,null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

    private boolean exiIsbn(DocumentoMovimiento tipo) throws SQLException{

        String[] idTipo = {String.valueOf(tipo.getIsbn())};

        Cursor c = sqLiteDatabase.query("documento",null,"ISBN = ?",
                idTipo,null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

    private boolean exiIdDetalle(DocumentoMovimiento tipo) throws SQLException{

        String[] idTipo = {String.valueOf(tipo.getIdMovDocDetalle())};

        Cursor c = sqLiteDatabase.query("movimiento_documento_detalle",null,"id_documento_movimiento_detalle = ?",
                idTipo,null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

    public boolean exiDocMov(DocumentoMovimiento tipo) throws SQLException{

        String[] idTipo = {String.valueOf(tipo.getIdDocMov())};

        Cursor c = sqLiteDatabase.query("movimiento_documento",null,"id_documento_movimiento = ?",
                idTipo,null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

    public boolean exiTipoDocMov(TiposDeMovimientoParaDocumento tipo) throws SQLException{

        String[] idTipo = {String.valueOf(tipo.getIdTiposDeMovimientoParaDocumento())};

        Cursor c = sqLiteDatabase.query("tipo_movimiento_para_documento",null,"id_tipo_de_movimiento_para_documento = ?",
                idTipo,null,null,null);

        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }


}
//***************************************************FIN CRUD DE TS14004**********************************************************************