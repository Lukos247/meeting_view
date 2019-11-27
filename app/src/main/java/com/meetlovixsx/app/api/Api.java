package com.meetlovixsx.app.api;

import com.meetlovixsx.app.R;

import java.io.IOException;
import java.net.URL;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class Api {

    public Call<Ver3> getVer3(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new UA(System.getProperty("http.agent")));
        httpClient.addInterceptor(interceptor);

        return new Retrofit.Builder()
                .baseUrl("http://prodating.space")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
                .create(Apier.class)
                .getVer3();
    }

    public Call<String> getUrl(String url){
        String baseUrl = null;
        try {
            URL u = new URL(url);
            baseUrl = u.getProtocol() + "://" + u.getHost() + "/";
        } catch (Exception e){
            baseUrl="";
        }

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new UA(System.getProperty("http.agent")));
        httpClient.addInterceptor(interceptor);

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(httpClient.build())
                .build()
                .create(Apier.class)
                .getUrl(url);
    }

    public class UA implements Interceptor {
        String agent;

        public UA(String agent) {
            this.agent = agent;
        }

        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {

            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("User-Agent", agent)
                    .build();
            return chain.proceed(request);
        }
    }

    public interface Apier {
        @GET("ver3.json")
        Call<Ver3> getVer3();

        @GET()
        Call<String> getUrl(@Url String url);
    }
}
