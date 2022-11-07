package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class BuyKitActivity extends AppCompatActivity {
    private WebView webView;

    private Player data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_information);

        webView = findViewById(R.id.webView);

        // Get the data
        Intent intent = getIntent();

        // (Person) from private Person data = null;
        data = (Player) intent.getExtras().getSerializable("data");
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl(data.getKiturl());
    }
}
