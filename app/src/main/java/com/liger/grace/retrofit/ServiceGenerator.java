package com.liger.grace.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Liger on 2017/5/11 01:43.
 * <p>
 * retrofit 网络请求前的准备工作
 */

public class ServiceGenerator {

    private static final String BASE_URL = "https://api.github.com/";

    private static Retrofit.Builder mBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit mRetrofit = mBuilder.build();

/*
    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);
*/

    private static OkHttpClient.Builder mHttpClient = new OkHttpClient.Builder();

    public static <T> T createService(Class<T> serviceClass) {
       /* if (!mHttpClient.interceptors().contains(logging)) {
            mHttpClient.addInterceptor(logging);
            mBuilder.client(mHttpClient.build());
            mRetrofit = mBuilder.build();

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        }*/
        return mRetrofit.create(serviceClass);
    }
}
