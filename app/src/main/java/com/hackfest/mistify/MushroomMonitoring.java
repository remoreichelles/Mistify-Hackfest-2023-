package com.hackfest.mistify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MushroomMonitoring extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    //    bottom nav
    private BottomNavigationView bottomNavigationView;

    ListView listViewMonitoring;
    ArrayList<String> arrayList = new ArrayList<>();


    Button fbAddBatch;

    TextView txtNoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mushroom_monitoring);


        txtNoData = findViewById(R.id.txtNoData);

        //        navigation view
        navigationView = findViewById(R.id.modalNav);
        drawerLayout = findViewById(R.id.drawer_Layout);
        toolbar = findViewById(R.id.main_toolbar);

        bottomNavigationView = findViewById(R.id.bottom_navigation);


        fbAddBatch = findViewById(R.id.fbAddBatch);


        listViewMonitoring = findViewById(R.id.lv_mushroomMonitoring);

        ListAdapter listAdapter = new ListAdapter(getApplicationContext(), arrayList);
        listViewMonitoring.setAdapter(listAdapter);

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");

        listAdapter.notifyDataSetChanged();

        listViewMonitoring.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.v("ListView", "position: " + i  );
                String getItem = arrayList.get(i).toString();
                Log.v("ListView", "getItem: " + getItem  );

                Intent intent = new Intent(MushroomMonitoring.this,YieldReport.class);
                intent.putExtra("batchno", getItem );
                startActivity(intent);
            }
        });


        //  nav header
        //  toolbar
        setDrawerLayout();

        //botton nav bar
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
        bottomNavigationView.setSelectedItemId(R.id.navYieldReports);
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
        startActivity(new Intent(MushroomMonitoring.this, UserLogin.class));
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