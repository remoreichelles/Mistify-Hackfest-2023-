package com.hackfest.mistify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class YieldOverview extends AppCompatActivity {

    Toolbar topNavBar;

    LineChart graphView;
    LineDataSet lineDataSet = new LineDataSet(null, null);
    ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
    LineData lineData;


    ArrayList<Entry> datavals = new ArrayList<Entry>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yield_overview);

        topNavBar = findViewById(R.id.main_toolbar);
        graphView= findViewById(R.id.graph);

        datavals.clear();
        topNavBar.setOnClickListener(view -> { back(); });
        //        graph vlaues

        for(int i = 1; i <= 30 ; i ++){

            if(i == 5){
                datavals.add(new Entry(i, 605));
            }else if(i == 7){
                datavals.add(new Entry(i, 333));
            }else if(i == 10){
                datavals.add(new Entry(i, 1000));
            }else if(i == 20){
                datavals.add(new Entry(i, 800));
            }else if(i == 22){
                datavals.add(new Entry(i, 976));
            }else if(i == 24){
                datavals.add(new Entry(i, 589));
            }else{
                datavals.add(new Entry(i, 0));
            }
        }
        showChart(datavals);
    }


    private void showChart(ArrayList<Entry> datavals) {
        Log.v("datavals", "datavals: " + datavals  );
        lineDataSet.setValues(datavals);
        lineDataSet.setLabel("Harvest in grams");
        lineDataSet.setValueTextSize(8);
        iLineDataSets.clear();
        iLineDataSets.add(lineDataSet);
        lineData = new LineData(iLineDataSets);

        XAxis xAxis = graphView.getXAxis();
        YAxis yAxisLeft = graphView.getAxisLeft();
        YAxis yAxisRight = graphView.getAxisRight();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        yAxisRight.setEnabled(false);
        yAxisLeft.setValueFormatter(new MyYAxisFormatter());

        graphView.setDrawBorders(true);
        graphView.setTouchEnabled(false);
        graphView.getDescription().setEnabled(false);
        graphView.setBorderColor(R.color.primaryColor);
        graphView.clear();
        graphView.setData(lineData);
        graphView.invalidate();

    }

    private class MyYAxisFormatter extends ValueFormatter {
        @Override
        public String getFormattedValue(float value) {
            return Math.round(value)+"g";
        }
    }

    private void back(){
        Intent mmIntent = new Intent(YieldOverview.this, YieldReport.class);
        startActivity(mmIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        back();
    }
}