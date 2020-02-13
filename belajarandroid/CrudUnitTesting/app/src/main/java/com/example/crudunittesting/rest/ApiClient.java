package com.example.crudunittesting.rest;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL="http://54.254.180.214:9803";
    public static String API_KEY = "xxx123";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){

        if (retrofit==null) {
            OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("token", API_KEY)
                            .build();
                    return chain.proceed(request);
                }
            }).build();
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
