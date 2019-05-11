package com.pdmsubecum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.pdmsubecum.am15005.AM15005;
import com.pdmsubecum.mm14031.MM14031;
import com.pdmsubecum.pm15007.PM15007;
import com.pdmsubecum.rl08017.RL08017;
import com.pdmsubecum.ts14004.TS14004;

public class Carnets extends AppCompatActivity implements IntegranteFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnets);
        getSupportActionBar().hide();

    }

    @Override
    public void onListFragmentInteraction(Integrante item) {
       // Toast.makeText(this, "Elemento: "+item.getCarnet(), Toast.LENGTH_SHORT).show();

        Intent intent;
        switch (item.getCarnet()){
            case "AM15005":
                intent = new Intent(this, AM15005.class);
                startActivity(intent);
                break;
            case "MM14031":
                intent = new Intent(this, MM14031.class);
                startActivity(intent);
                break;
            case "PM15007":
                intent = new Intent(this, PM15007.class);
                startActivity(intent);
                break;
            case "RL08017":
                intent = new Intent(this, RL08017.class);
                startActivity(intent);
                break;
            case "TS14004":
                intent = new Intent(this, TS14004.class);
                startActivity(intent);
                break;
        }
    }
}
