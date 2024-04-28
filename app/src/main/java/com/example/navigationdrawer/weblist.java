package com.example.navigationdrawer;

import static com.example.navigationdrawer.R.id.web;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class weblist extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weblist);

        webView = (WebView) findViewById(web);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.funktionevents.co.uk/stag-do/blog/a-z-date-night-ideas");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}