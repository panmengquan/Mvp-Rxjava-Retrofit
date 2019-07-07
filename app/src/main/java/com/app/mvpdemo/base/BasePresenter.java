package com.app.mvpdemo.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract  class BasePresenter<V extends BaseView> {
    private CompositeDisposable mCompositeDisposable;
    private V baseView;
    public void attachView(V baseView) {
        this.baseView = baseView;
    }
    public void detachView(){
        baseView = null;
        // 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }
    public V getMvpView(){
        return baseView;
    }
    public void addDisposable(Disposable subscription) {
        //csb 如果解绑了的话添加 sb 需要新的实例否则绑定时无效的
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }
}
