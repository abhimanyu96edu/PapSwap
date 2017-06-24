package com.abhimanyusharma.papswap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;


public class SplashActivity extends AppCompatActivity {
    ProgressBar pb;
    //private static final int SPLASH_ACTIVITY_TIMEOUT = 3500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.showContextMenu();   //check this warning
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent i = new Intent(SplashActivity.this, Papswap.class);
                    startActivity(i);

                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
