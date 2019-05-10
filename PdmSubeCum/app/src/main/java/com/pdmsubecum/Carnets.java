package com.pdmsubecum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.pdmsubecum.am15005.AM15005;

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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_am15005:
                Intent intent = new Intent(this, AM15005.class);
                startActivity(intent);
                break;
        }
    }
}
