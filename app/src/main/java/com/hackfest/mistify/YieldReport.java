package com.hackfest.mistify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class YieldReport extends AppCompatActivity  implements View.OnClickListener{

    Toolbar topNavBar;
    RelativeLayout btnYieldOverview, btnMushroomDetails, btnDailyHarvest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yield_report);

        topNavBar = findViewById(R.id.main_toolbar);
        btnYieldOverview = findViewById(R.id.rl_yieldOverview);
        btnMushroomDetails = findViewById(R.id.rl_mushroomDetails);
        btnDailyHarvest = findViewById(R.id.rl_dailyHarvest);

        btnYieldOverview.setOnClickListener(this);
        btnMushroomDetails.setOnClickListener(this);
        btnDailyHarvest.setOnClickListener(this);
        topNavBar.setOnClickListener(this);
    }

    private void back() {
        Intent mmIntent = new Intent(YieldReport.this, MushroomMonitoring.class);
        startActivity(mmIntent);
        finish();
    }


    //what will happened when the back button is pressed?
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        back();
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.main_toolbar ){
            back();
        } else if (view.getId() ==  R.id.rl_yieldOverview) {
            Intent yo = new Intent(YieldReport.this, YieldOverview.class);
            startActivity(yo);
            finish();

        }else if (view.getId() == R.id.rl_mushroomDetails) {
            Intent mmbc = new Intent(YieldReport.this, MushroomMonitoringBatchContent.class);
            startActivity(mmbc);
            finish();

        }else if (view.getId() == R.id.rl_dailyHarvest) {
            Intent dmh = new Intent(YieldReport.this, DailyMushroomHarvest.class);
            startActivity(dmh);
            finish();
        }


    }
}