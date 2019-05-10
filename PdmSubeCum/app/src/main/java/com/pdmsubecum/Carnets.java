package com.pdmsubecum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.pdmsubecum.am15005.AM15005;
import com.pdmsubecum.mm14031.MM14031;
import com.pdmsubecum.pm15007.PM15007;
import com.pdmsubecum.rl08017.RL08017;
import com.pdmsubecum.ts14004.TS14004;

public class Carnets extends AppCompatActivity implements View.OnClickListener{
    Button am15005, mm14031,pm15007,rl08017,ts14004;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnets);
        getSupportActionBar().hide();

        am15005 = findViewById(R.id.btn_am15005);
        am15005.setOnClickListener(this);

        mm14031 = findViewById(R.id.btn_mm14031);
        mm14031.setOnClickListener(this);

        pm15007 = findViewById(R.id.btn_pm15007);
        pm15007.setOnClickListener(this);

        rl08017 = findViewById(R.id.btn_rl08017);
        rl08017.setOnClickListener(this);

        ts14004 = findViewById(R.id.btn_ts14004);
        ts14004.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_am15005:
                intent = new Intent(this, AM15005.class);
                startActivity(intent);
                break;
            case R.id.btn_mm14031:
                intent = new Intent(this, MM14031.class);
                startActivity(intent);
                break;
            case R.id.btn_pm15007:
                intent = new Intent(this, PM15007.class);
                startActivity(intent);
                break;
            case R.id.btn_rl08017:
                intent = new Intent(this, RL08017.class);
                startActivity(intent);
                break;
            case R.id.btn_ts14004:
                intent = new Intent(this, TS14004.class);
                startActivity(intent);
                break;
        }
    }
}
