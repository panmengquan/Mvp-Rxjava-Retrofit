package com.app.mvpdemo;


import com.app.mvpdemo.mvp.bean.LoginDataBean;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {
    @POST("login?")
    Observable<LoginDataBean> login(@Query("number") String username);
}

