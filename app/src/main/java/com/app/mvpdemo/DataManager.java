package com.app.mvpdemo;

import com.app.mvpdemo.mvp.bean.LoginDataBean;

import io.reactivex.Observable;

public class DataManager {
    private RetrofitService mRetrofitService;
    private DataManager(){
        this.mRetrofitService = RetrofitHelper.getInstance().getServer();
    }
    private volatile static DataManager instance;
    public static DataManager getInstance() {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null) {
                    instance = new DataManager();
                }
            }
        }
        return instance;
    }

    public Observable<LoginDataBean> login(String number){
        return mRetrofitService.login(number);
    }

}
