package com.pdmsubecum.am15005.Activities.Documento;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.am15005.Documento;
import com.pdmsubecum.DB.modelo.am15005.Equipo;
import com.pdmsubecum.R;





public class DocumentoEliminarActivity extends AppCompatActivity {

    EditText conid;
    DataBase controlhelper;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_eliminar);

        conid = findViewById(R.id.elimDoc);
        controlhelper = new DataBase(this);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.mensaje_eliminar)+" " + getString(R.string.mensaje_eliminar) +" "+ getString(R.string.autorDetalle)+" "+ getString(R.string.DocumentoAsignacionDetalle)+" "+ getString(R.string.DocumentoMovimientoDetalle))
                .setTitle(R.string.titulo_dialogo);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                eliminarDoc();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                cancelar();
            }
        });

        dialog = builder.create();
    }


    public void eliminarDoc() {
        String regRestantes;
        Documento documento = new Documento();
        documento.setIsbn(conid.getText().toString());
        controlhelper.abrir();
        regRestantes = controlhelper.eliminar(documento);
        controlhelper.cerrar();
        Toast.makeText(this, regRestantes, Toast.LENGTH_SHORT).show();


    }

    public void cancelar() {
        Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
    }


    public void eliminar(View view) {
        switch (view.getId()) {

            case R.id.eliminarDocumento:
                if (conid.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Por favor rellene el ISBN ", Toast.LENGTH_SHORT).show();
                } else {
                    controlhelper.abrir();
                    Documento documento =controlhelper.consultarD(conid.getText().toString());
                    controlhelper.cerrar();
                    if (documento==null)
                    {

                        Toast.makeText(this,R.string.verificarISBN,Toast.LENGTH_SHORT);

                    }else {
                        controlhelper.abrir();
                        Documento documento2 =controlhelper.consultarD(conid.getText().toString());
                        controlhelper.cerrar();
                        if (documento2==null)
                        {

                            Toast.makeText(this,R.string.verificar,Toast.LENGTH_SHORT);

                        }else {
                            // Create the AlertDialog
                            dialog.show();
                        }
                    }
                }
                break;


        }
    }

}
