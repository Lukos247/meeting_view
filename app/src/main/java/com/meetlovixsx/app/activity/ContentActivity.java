package com.meetlovixsx.app.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.meetlovixsx.app.R;

import im.delight.android.webview.AdvancedWebView;

public class ContentActivity extends AppCompatActivity implements AdvancedWebView.Listener {

    AdvancedWebView content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        content = findViewById(R.id.content);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(content, true);
        } else CookieManager.getInstance().setAcceptCookie(true);

        content.setCookiesEnabled(true);
        content.getSettings().setJavaScriptEnabled(true);
        content.getSettings().setAllowContentAccess(true);
        content.getSettings().setDomStorageEnabled(true);
        content.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        content.setDesktopMode(false);

        content.setListener(this, this);
        if (savedInstanceState != null) {
            content.restoreState(savedInstanceState);
            if(content.getVisibility()!=View.VISIBLE) content.setVisibility(View.VISIBLE);
        } else content.loadUrl(getIntent().getStringExtra("url"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        content.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onBackPressed() {
        if (!content.onBackPressed())
            content.onBackPressed();
        else {
            super.onBackPressed();
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        }
    }

   

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        content.saveState(outState);
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {

    }

    @Override
    public void onPageFinished(String url) {
        content.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {

        startActivity(new Intent(this, LineActivity.class));
        this.finish();
        overridePendingTransition(0,0);
    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {

    }

    @Override
    public void onExternalPageRequest(String url) {

    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        content.onResume();
        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        Log.i("DEV",content.getUrl());
        getSharedPreferences("PREFS",0).edit().putString("url",content.getUrl()).apply();
        content.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        content.onDestroy();
        // ...
        super.onDestroy();
    }
}
