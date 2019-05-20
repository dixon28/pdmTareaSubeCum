package com.pdmsubecum.DB.modelo.am15005;

import android.content.ContentValues;

public class TiposDeDocumento {
   private int idTiposDeDocumentos;
   private String descripcionTipoDeDocumento;

   public TiposDeDocumento() {
   }

   public TiposDeDocumento(int idTiposDeDocumentos, String descripcionTipoDeDocumento) {
      this.idTiposDeDocumentos = idTiposDeDocumentos;
      this.descripcionTipoDeDocumento = descripcionTipoDeDocumento;
   }

   public int getIdTiposDeDocumentos() {
      return idTiposDeDocumentos;
   }

   public void setIdTiposDeDocumentos(int idTiposDeDocumentos) {
      this.idTiposDeDocumentos = idTiposDeDocumentos;
   }

   public String getDescripcionTipoDeDocumento() {
      return descripcionTipoDeDocumento;
   }

   public void setDescripcionTipoDeDocumento(String descripcionTipoDeDocumento) {
      this.descripcionTipoDeDocumento = descripcionTipoDeDocumento;
   }

   public ContentValues toValues(){
      ContentValues contentValues = new ContentValues(2);
      contentValues.put("idtiposdedocumento", idTiposDeDocumentos);
      contentValues.put("descripciontipodedocumento",descripcionTipoDeDocumento);
      return contentValues;
   }
}
