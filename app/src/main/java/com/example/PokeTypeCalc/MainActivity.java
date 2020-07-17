package com.example.PokeTypeCalc;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.SharedPreferences;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawer;

    private AdView mAdView;
    int color = 0;
    FrameLayout frm;
    LinearLayout bar;


    public final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences colory = getSharedPreferences(PREFS_NAME, 0);
        color = colory.getInt("color", color);


        //


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frm = findViewById(R.id.fragment_contain);
        //bar = findViewById(R.id.bar_top);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                    new attackFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_attack);

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
            }

            if (color == 0){
                frm.setBackgroundResource(R.color.colorAccent);
                //bar.setBackgroundResource(R.color.colorAccent);
            }
            if (color == 1){
                frm.setBackgroundResource(R.color.colorGreat);
                //bar.setBackgroundResource(R.color.colorGreat);
            }
            if (color == 2){
                frm.setBackgroundResource(R.color.colorUltra);
                //bar.setBackgroundResource(R.color.colorUltra);
            }
            if (color == 3){
                frm.setBackgroundResource(R.color.colorMaster);
                //bar.setBackgroundResource(R.color.colorMaster);
            }
            if (color == 4){
                frm.setBackgroundResource(R.color.colorPremiere);
                //bar.setBackgroundResource(R.color.colorPremiere);
            }
            if (color == 5){
                frm.setBackgroundResource(R.color.colorHeavy);
                //bar.setBackgroundResource(R.color.colorHeavy);
            }

        }
    }


    //keep
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.nav_attack:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                        new attackFragment()).commit();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                        new AboutFragment()).commit();
                break;
            case R.id.nav_type:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                        new TypeFragment()).commit();
                break;
            case R.id.nav_help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                        new helpFragment()).commit();
                break;
            case R.id.nav_color:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                        new colorFragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void saveColor(){
        SharedPreferences colory = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = colory.edit();
        editor.putInt("color", color);
        editor.commit();
    }


}


