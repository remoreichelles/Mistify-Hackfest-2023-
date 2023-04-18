package com.hackfest.mistify;

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
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class DailyActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        //        navigation view
        navigationView = findViewById(R.id.modalNav);
        drawerLayout = findViewById(R.id.drawer_Layout);
        toolbar = findViewById(R.id.main_toolbar);

        //        bottom nav
        bottomNavigationView = findViewById(R.id.bottom_navigation);


        //        nav header
//        toolbar
        setDrawerLayout();

        //bottom nav bar
        getBottomNavigationView();
    }


    private void setDrawerLayout() {
        setSupportActionBar(toolbar);

// drawlayout for navigation drawer
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.openNavDrawer,
                R.string.closeNavDrawer
        );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        updateNavHeader();
    }

    private void getBottomNavigationView() {
        // bottom nav bar
        bottomNavigationView.setSelectedItemId(R.id.navDailyActivity);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId() == R.id.navHome){
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                overridePendingTransition(0, 0);
            }else if(item.getItemId() == R.id.navDailyActivity){
                startActivity(new Intent(getApplicationContext(), DailyActivity.class));
                overridePendingTransition(0, 0);
                finish();
            } else if (item.getItemId() == R.id.navYieldReports) {
                startActivity(new Intent(getApplicationContext(), MushroomMonitoring.class));
                overridePendingTransition(0, 0);
                finish();

            }
            return false;


        });
    }

    //    nav header
    void updateNavHeader() {
        navigationView = findViewById(R.id.modalNav);
        View headerView = navigationView.getHeaderView(0);
        TextView txtUsersName = headerView.findViewById(R.id.txtUsersName);
        txtUsersName.setText("Hello, Elite Devs!");

    }

    void signOut() {
        startActivity(new Intent(DailyActivity.this, UserLogin.class));
        finish();
    }

    //    modal navigation
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.signout){
            signOut();

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    //what will happened when the back button is pressed?
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}