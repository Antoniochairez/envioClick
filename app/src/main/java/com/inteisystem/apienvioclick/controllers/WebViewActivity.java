package com.inteisystem.apienvioclick.controllers;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.inteisystem.apienvioclick.R;
import com.inteisystem.apienvioclick.commons.Common;
import com.inteisystem.apienvioclick.helpers.constants;


public class WebViewActivity extends AppCompatActivity {

    WebView visorWeb;
    WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        init();
        showWebView();

    }

    public void init(){
        Common.showLoading(this);
        visorWeb = findViewById(R.id.webViewPage);
        webSettings = visorWeb.getSettings();

    }

    public void showWebView(){

        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(true);
        visorWeb.loadUrl(constants.GET_URL_DEFINITIONS);

        visorWeb.setWebViewClient( new WebViewClient(){

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

            public void onPageFinished(WebView view, String url) {
                Common.hideLoading();
            }

        });

    }

    //Impedir que el botón Atrás cierre la aplicación
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (visorWeb.canGoBack()) {
                        visorWeb.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }


}