package com.pdmsubecum.am15005;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import com.pdmsubecum.R;
import com.pdmsubecum.am15005.fragmentos.EquipoFragment;
import com.pdmsubecum.am15005.fragmentos.MarcaFragment;
import com.pdmsubecum.am15005.fragmentos.TipoFragment;

import static android.app.PendingIntent.getActivity;

public class AM15005 extends AppCompatActivity {
    ListView lista;

    List<String> tablasCrud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_am15005);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case  R.id.navigation_marca:
                        MarcaFragment homeFragment= new MarcaFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, homeFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                        break;

                    case R.id.navigation_equipo:
                        EquipoFragment searchFragment= new EquipoFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, searchFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                        break;
                    case R.id.navigation_tipo:
                        TipoFragment tipo= new TipoFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, tipo).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                        break;

                    case R.id.navigation_mas:
                        Intent intent= new Intent(getApplicationContext(), DocActivity.class);
                        startActivity(intent);

                        break;








                }


                return true;

            }
        });



    }

    public void goDoc(View view) {
        Intent intent= new Intent(this, DocActivity.class);
        startActivity(intent);


    }
}
