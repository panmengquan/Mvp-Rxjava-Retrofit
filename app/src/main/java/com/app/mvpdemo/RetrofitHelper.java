package com.app.mvpdemo;

import com.app.mvpdemo.constant.UrlConstant;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private Retrofit mRetrofit = null;
    OkHttpClient client = new OkHttpClient();

    private RetrofitHelper(){
        initRetrofit();
    }
    private volatile static RetrofitHelper instance = null;
    public static RetrofitHelper getInstance(){
        if (instance == null){
            synchronized (RetrofitHelper.class) {
                if(instance == null){
                    instance = new RetrofitHelper();
                }
            }
        }
        return instance;
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(UrlConstant.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    public RetrofitService getServer(){
        return mRetrofit.create(RetrofitService.class);
    }
}
