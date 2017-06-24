package com.abhimanyusharma.papswap;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Papswap extends AppCompatActivity {

    private WebView mWebView;
//ProgressDialog pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papswap);
       // pg.show();
        mWebView = (WebView) findViewById(R.id.activity_main_webview);

        Toast.makeText(Papswap.this, "Loading Content..", Toast.LENGTH_LONG).show();
        if (isConnectedToInternet()) {
            // Run AsyncTask
            // Force links and redirects to open in the WebView instead of in a browser
            mWebView.setWebViewClient(new WebViewClient());

            // Enable Javascript
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            // Use remote resource
            mWebView.loadUrl("www.papswap.com/");

//            pg.dismiss();
//            pg.cancel();

            // Stop local links and redirects from opening in browser instead of WebView
            ///////////////mWebView.setWebViewClient(new MyAppWebViewClient());

            // Use local resource
            // mWebView.loadUrl("file:///android_asset/www/index.html");
        } else {
            // Here I've been added intent to open up data settings
            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
            Toast.makeText(Papswap.this, "Can't Open App. No Internet. Please Connect Internet And Try Again.", Toast.LENGTH_LONG).show();
            finish();
        }
    }
    public boolean isConnectedToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }

    // Prevent the back-button from closing the app
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
