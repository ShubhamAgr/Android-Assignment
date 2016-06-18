package com.example.shubham.assignment_dipper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shubham on 6/4/16.
 */
public class MyServiceGenerator {
    public static final String Server_URL = "http://jsonblob.com/";
    OkHttpClient okHttpClient = new OkHttpClient();
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS);
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(Server_URL).addConverterFactory(GsonConverterFactory.create());
    public static <S> S createService(Class<S> serviceClass){
        Retrofit retrofit = retrofitBuilder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

}
