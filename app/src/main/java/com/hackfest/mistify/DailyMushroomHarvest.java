package com.hackfest.mistify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

public class DailyMushroomHarvest extends AppCompatActivity {

    Toolbar topNavBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_mushroom_harvest);

        topNavBar = findViewById(R.id.main_toolbar);
        topNavBar.setOnClickListener(view -> {back();});

    }

    private void back(){
        Intent mmIntent = new Intent(DailyMushroomHarvest.this, YieldReport.class);
        startActivity(mmIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        back();
    }
}