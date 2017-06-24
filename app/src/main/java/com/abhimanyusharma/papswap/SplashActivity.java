package com.abhimanyusharma.papswap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ProgressBar;


public class SplashActivity extends ActionBarActivity {
    //ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //pb = (ProgressBar) findViewById(R.id.progressBar);
        //pb.showContextMenu();   //check this warning
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent i = new Intent(SplashActivity.this, FullscreenActivity.class);
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
