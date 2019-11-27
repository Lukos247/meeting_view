package com.meetlovixsx.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.meetlovixsx.app.api.Api;
import com.meetlovixsx.app.api.Ver3;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity implements Callback<Ver3> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Api().getVer3().enqueue(this);
    }

    private void onEventLoad(String u){
        new Api().getUrl(u).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful() && response.body()!=null && response.body().startsWith("http")) {
                    onEventShow(response.body());
                } else onEventLine();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                onEventLine();
            }
        });
    }


    private void onEventShow(String u){
        startActivity(new Intent(this,ContentActivity.class).putExtra("url",u));
        this.finish();
        overridePendingTransition(0,0);
    }


    private void onEventLine(){
        startActivity(new Intent(this, LineActivity.class));
        this.finish();
    }

    @Override
    public void onResponse(Call<Ver3> call, Response<Ver3> response) {
        String lang = Locale.getDefault().getLanguage();
        if(response.isSuccessful() && response.body()!=null && response.body().isGeo(lang)) {
            onEventLoad(response.body().getUrl());
        } else onEventLine();
    }

    @Override
    public void onFailure(Call<Ver3> call, Throwable t) {
        Log.i("DEV",t.getLocalizedMessage());
        onEventLine();
    }
}
