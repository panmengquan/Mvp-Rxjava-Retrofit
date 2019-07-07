package com.app.mvpdemo.mvp.presenter;

import com.app.mvpdemo.DataManager;
import com.app.mvpdemo.base.BasePresenter;
import com.app.mvpdemo.base.LoginView;
import com.app.mvpdemo.mvp.bean.LoginDataBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class BookPresenter extends BasePresenter<LoginView> {
    private DataManager dataManager;
    private LoginDataBean loginDataBean;
    public BookPresenter() {
        dataManager = DataManager.getInstance();
    }
    public void startLogin(String name){
        if(getMvpView() != null){
            // 进行网络请求
            dataManager.login(name)
                    .subscribeOn(Schedulers.io())
                    // doOnSubscribe用于在call之前执行一些初始化操作
                    .doOnSubscribe(new Consumer<Disposable>() {
                        @Override
                        public void accept(@NonNull Disposable disposable) throws Exception {
                            //请求加入管理,统一管理订阅,防止内存泄露
                            addDisposable(disposable);
                            // 显示进度提示
                            getMvpView().showProgressDialog();
                        }
                    })

                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<LoginDataBean>() {

                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull LoginDataBean book) {
                            loginDataBean = book;
                        }

                        // 此处注意：onComplete和onError只会调用其中一个，不可能同时被触发
                        @Override
                        public void onError(@NonNull Throwable e) {
                            // 在事件处理过程中出异常时，onError() 会被触发，同时队列自动终止，不允许再有事件发出
                            e.printStackTrace();
                            getMvpView().onError("请求失败！！");
                            getMvpView().hideProgressDialog();
                        }

                        @Override
                        public void onComplete() {
                            // onComplete方法和onError方法是互斥的，
                            // RxJava 规定，当不会再有新的 onNext() 发出时，需要触发 onCompleted() 方法作为标志。
                            if (loginDataBean != null){
                                getMvpView().onSuccess(loginDataBean);
                            }
                            // 隐藏进度
                            getMvpView().hideProgressDialog();
                        }
                    });
        }
    }

}
