package com.pdmsubecum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        llenarBaseDatos();

        this.edt_usuario = findViewById(R.id.edt_usuario);
        this.edt_password = findViewById(R.id.edt_password);

        this.btnLogin = findViewById(R.id.login_btn_login);
        this.btnLogin.setOnClickListener(this);
    }

    public void llenarBaseDatos(){
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("am15005","am15005"));
        usuarios.add(new Usuario("mm14031","mm14031"));
        usuarios.add(new Usuario("pm15007","pm15007"));
        usuarios.add(new Usuario("rl08017","rl08017"));
        usuarios.add(new Usuario("ts14004","ts14004"));
        usuarios.add(new Usuario("admin","admin"));

        dataBase = new DataBase(this);
        dataBase.llenarUsuario(usuarios);
        dataBase.cerrar();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.login_btn_login:
                dataBase.abrir();
                Usuario user = dataBase.getUsuario(this.edt_usuario.getText().toString());
                dataBase.cerrar();
                if (user != null){

                    if(user.getPassword().equals(this.edt_password.getText().toString())){
                        intent = new Intent(Login.this, Carnets.class);
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
