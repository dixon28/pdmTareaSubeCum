package com.pdmsubecum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pdmsubecum.DB.DataBase;
import com.pdmsubecum.DB.modelo.Usuario;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Button btnLogin;
    EditText edt_usuario, edt_password;
    DataBase dataBase;
    ArrayList<Usuario> usuarios;
    LlenarDB llenarDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        this.llenarDB = new LlenarDB(this);
        dataBase = new DataBase(this);

        this.edt_usuario = findViewById(R.id.edt_usuario);
        this.edt_password = findViewById(R.id.edt_password);

        this.btnLogin = findViewById(R.id.login_btn_login);
        this.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.login_btn_login:
                dataBase.abrir();
                Usuario user = dataBase.getUsuario(this.edt_usuario.getText().toString().toLowerCase());
                dataBase.cerrar();
                if (user != null){
                    if(user.getPassword().equals(this.edt_password.getText().toString())){
                        intent = new Intent(Login.this, Carnets.class);
                        intent.putExtra("usuario",user.getUsuario());
                        startActivity(intent);
                    }else{
                        Toast.makeText(this, "Password incorrecto" , Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "El Usuario no existe", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
