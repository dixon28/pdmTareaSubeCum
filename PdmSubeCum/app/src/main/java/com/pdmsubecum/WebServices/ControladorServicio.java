package com.pdmsubecum.WebServices;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.pdmsubecum.DB.modelo.am15005.Equipo;
import com.pdmsubecum.DB.modelo.am15005.Marca;
import com.pdmsubecum.mm14031.Materia;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ControladorServicio {

    public static String obtenerRespuestaPeticion(String url, Context ctx) {

        String respuesta = " ";

        // Estableciendo tiempo de espera del servicio
        HttpParams parametros = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(parametros, 3000);
        HttpConnectionParams.setSoTimeout(parametros, 5000);

        // Creando objetos de conexion
        HttpClient cliente = new DefaultHttpClient(parametros);
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpRespuesta = cliente.execute(httpGet);
            StatusLine estado = httpRespuesta.getStatusLine();
            int codigoEstado = estado.getStatusCode();
            if (codigoEstado == 200) {
                HttpEntity entidad = httpRespuesta.getEntity();
                respuesta = EntityUtils.toString(entidad);
            }
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en la conexion", Toast.LENGTH_LONG)
                    .show();
            // Desplegando el error en el LogCat
            Log.v("Error de Conexion", e.toString());
        }
        return respuesta;
    }

    public static String obtenerRespuestaPost(String url, JSONObject obj,
                                              Context ctx) {
        String respuesta = " ";
        try {
            HttpParams parametros = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(parametros, 3000);
            HttpConnectionParams.setSoTimeout(parametros, 5000);
            HttpClient cliente = new DefaultHttpClient(parametros);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("content-type", "application/json");
            StringEntity nuevaEntidad = new StringEntity(obj.toString());
            httpPost.setEntity(nuevaEntidad);
            Log.v("Peticion",url);
            Log.v("POST", httpPost.toString());
            HttpResponse httpRespuesta = cliente.execute(httpPost);
            StatusLine estado = httpRespuesta.getStatusLine();

            int codigoEstado = estado.getStatusCode();
            if (codigoEstado == 200) {
                respuesta = Integer.toString(codigoEstado);
                Log.v("respuesta",respuesta);
            }
            else{
                Log.v("respuesta",Integer.toString(codigoEstado));
            }
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en la conexion", Toast.LENGTH_LONG)
                    .show();
            // Desplegando el error en el LogCat
            Log.v("Error de Conexion", e.toString());
        }
        return respuesta;
    }

    public static List<Marca> obtenerMarcasLocal(String json, Context ctx) {

        List<Marca> listaMarcas = new ArrayList<Marca>();

        try {
            JSONArray marcasJSON = new JSONArray(json);
            for (int i = 0; i < marcasJSON.length(); i++) {
                JSONObject obj = marcasJSON.getJSONObject(i);
                Marca marca = new Marca();
                marca.setIdmarca(Integer.parseInt(obj.getString("idmarca")));
                marca.setDescripcionmarca(obj.getString("descripcionmarca"));
                listaMarcas.add(marca);
            }
            return listaMarcas;
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en parseo de JSON" + e.getMessage(), Toast.LENGTH_LONG)
                    .show();
            return null;
        }

    }

    public static List<Marca> obtenerMarcasExterno(String json, Context ctx) {

        List<Marca> listaMarcas = new ArrayList<Marca>();

        try {
            JSONArray marcasJSON = new JSONArray(json);
            for (int i = 0; i < marcasJSON.length(); i++) {
                JSONObject obj = marcasJSON.getJSONObject(i);
                Marca marca = new Marca();
                String id = obj.getString("IDMARCA");
                Log.d("IDMARCA","MARCA" + id);
                marca.setIdmarca(Integer.parseInt(obj.getString("IDMARCA")));
                marca.setDescripcionmarca(obj.getString("DESCRIPCIONMARCA"));
                listaMarcas.add(marca);
            }
            return listaMarcas;
        } catch (JSONException e) {
            Toast.makeText(ctx, "Error en parseo de JSON" + e.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public static void insertarDocumentoLocal(String url, JSONObject obj, Context ctx) {
        String respuesta = obtenerRespuestaPost(url, obj, ctx);
        try {
            if(respuesta.equals("200"))
                Toast.makeText(ctx, "Insercion Correcta", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(ctx, "Error registro duplicado", Toast.LENGTH_LONG).show();
            Log.v("",respuesta);
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en la respuesta JSON", Toast.LENGTH_LONG).show();
        }
    }

    public static void insertarDocumentoExterno(String peticion, Context ctx) {

        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado = new JSONObject(json);
            Toast.makeText(ctx, "Registro ingresado"+ resultado.getJSONArray("resultado").toString(), Toast.LENGTH_LONG)
                    .show();
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1)
                Toast.makeText(ctx, "Registro ingresado", Toast.LENGTH_LONG)
                        .show();
            else
                Toast.makeText(ctx, "Error registro duplicado",
                        Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public static List<Equipo> obtenerEquiposLocal(String json, Context ctx) {

        List<Equipo> listaEquipos = new ArrayList<Equipo>();

        try {
            JSONArray equiposJSON = new JSONArray(json);
            for (int i = 0; i < equiposJSON.length(); i++) {
                JSONObject obj = equiposJSON.getJSONObject(i);
                Equipo equipo = new Equipo();
                equipo.setIdequipo(Integer.parseInt(obj.getString("idequipo")));
                equipo.setModelo(obj.getString("modelo"));
                equipo.setSerie(obj.getString("serie"));
                equipo.setCaracteristicas(obj.getString("caracteristicas"));
                listaEquipos.add(equipo);
            }
            return listaEquipos;
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en parseo de JSON" + e.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }

    }

    public static List<Equipo> obtenerEquiposExterno(String json, Context ctx) {

        List<Equipo> listaEquipos = new ArrayList<Equipo>();

        try {
            JSONArray equiposJSON = new JSONArray(json);
            for (int i = 0; i < equiposJSON.length(); i++) {
                JSONObject obj = equiposJSON.getJSONObject(i);
                Equipo equipo = new Equipo();
                equipo.setIdequipo(Integer.parseInt(obj.getString("IDEQUIPO")));
                equipo.setModelo(obj.getString("MODELO"));
                equipo.setSerie(obj.getString("SERIE"));
                equipo.setCaracteristicas(obj.getString("CARACTERISTICAS"));
                listaEquipos.add(equipo);
            }
            return listaEquipos;
        } catch (JSONException e) {
            Toast.makeText(ctx, "Error en parseo de JSON" + e.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public static void insertarEntidadExterno(String peticion, Context ctx) {

        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado = new JSONObject(json);
            String result = resultado.getString("resultado");
            Toast.makeText(ctx, "Registro ingresado"+ result, Toast.LENGTH_LONG).show();
            int respuesta = Integer.parseInt(result);
            if (respuesta == 1)
                Toast.makeText(ctx, "Registro ingresado", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(ctx, "Error registro duplicado",
                        Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            Toast.makeText(ctx, "Registro ingresado", Toast.LENGTH_LONG).show();
        }
    }
}
