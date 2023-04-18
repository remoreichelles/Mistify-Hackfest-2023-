package com.hackfest.mistify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl_logo = findViewById(R.id.rl_logo);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginPage = new Intent(MainActivity.this, UserLogin.class);

                if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                    startActivity(loginPage,options.toBundle());
                }

//                finish();
            }
        },5000);
    }
}