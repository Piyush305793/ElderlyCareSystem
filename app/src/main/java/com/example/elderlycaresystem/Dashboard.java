package com.example.elderlycaresystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new Main_Page());

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_draw_open,
                R.string.navigation_draw_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new Main_Page()).commit();
            navigationView.setCheckedItem(R.id.dashboard);
        }
        View hview = navigationView.getHeaderView(0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new Main_Page()).addToBackStack(null).commit();
                break;
            case R.id.menu1:
                startActivity(new Intent(Dashboard.this, Basic_Tips.class));
                break;
            case R.id.menu2:
                startActivity(new Intent(Dashboard.this, Balanced_Diet.class));
                break;
            case R.id.menu3:
                startActivity(new Intent(Dashboard.this, Yoga_Exercise.class));
                break;
            case R.id.menu4:
                startActivity(new Intent(Dashboard.this, PreventInfection.class));
                break;
            case R.id.menu5:
                startActivity(new Intent(Dashboard.this, Diseases.class));
                break;
            case R.id.menu6:
                startActivity(new Intent(Dashboard.this, Profile.class));
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}