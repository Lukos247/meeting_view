package com.meetlovixsx.app.api;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ver3 {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("geo")
    @Expose
    private List<String> geo = null;

    public String getUrl() {
        if(url==null) return "";
        return url;
    }

    public boolean isEnabled(String locale) {
        boolean flag = (this.flag.equalsIgnoreCase("1") || this.flag.equalsIgnoreCase("true"));
        return flag && isGeo(locale) && getUrl().length()>0;
    }

    public boolean isGeo(String locale) {

        Log.i("DEV","GEO 1");
        if(geo==null || geo.size()<1) return false;
        Log.i("DEV","GEO 2");
        for (String s:
             geo) {

            Log.i("DEV",s);

        }
        Log.i("DEV",locale.toLowerCase());
        return geo.contains(locale.toUpperCase()) || geo.contains(locale.toLowerCase());
    }

}
