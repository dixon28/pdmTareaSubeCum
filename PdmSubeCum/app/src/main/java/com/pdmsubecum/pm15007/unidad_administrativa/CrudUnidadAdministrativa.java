package com.pdmsubecum.pm15007.unidad_administrativa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pdmsubecum.R;

public class CrudUnidadAdministrativa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_unidad_administrativa);
        this.setTitle(R.string.crud_unidad_administrativa);
    }
}
