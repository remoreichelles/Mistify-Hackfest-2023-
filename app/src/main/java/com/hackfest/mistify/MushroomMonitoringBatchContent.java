package com.hackfest.mistify;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MushroomMonitoringBatchContent extends AppCompatActivity {

    Toolbar topNavBar;

    ProgressBar progressBar;

    String batchno = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mushroom_monitoring_batch_content);


        topNavBar = findViewById(R.id.main_toolbar);
        progressBar = findViewById(R.id.progress_bar);
        getDataToDisplay();
        topNavBar.setOnClickListener(view -> {
            back();
        });
    }


    private void getDataToDisplay(){

        double pbValue = 89;
        progressBar.setProgress( (int)pbValue);

        String title = "";
        if(pbValue > 100 && pbValue <150){
            title = "Please consider buying new batch of fruiting bags early as preparation for your next cultivation.";
            showAlertDialog(title);
        }else if(pbValue >= 150){
            title = "Please consider replacing batch "+ batchno +" of fruiting bags. It has already reached their maximum potential harvest.";
            showAlertDialog(title);
        }
    }

    private void showAlertDialog(String title) {

        AlertDialog dialog = new AlertDialog.Builder(MushroomMonitoringBatchContent.this)
                .setTitle("Biological Efficiency")

                .setMessage(title).setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create();
        dialog.show();
    }

    private void back(){
        Intent mmIntent = new Intent(MushroomMonitoringBatchContent.this, YieldReport.class);
        startActivity(mmIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        back();
    }
}