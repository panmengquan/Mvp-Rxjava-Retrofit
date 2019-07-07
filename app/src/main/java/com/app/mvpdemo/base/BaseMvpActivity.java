package com.app.mvpdemo.base;

public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter<V>> extends BaseActivity {
    private P presenter;

    @Override
    protected void initPresenter() {
        //实例化Presenter
        presenter = createPresenter();
        //绑定
        if (presenter != null){
            presenter.attachView((V) this);
        }
    }
    protected abstract P createPresenter();
    protected P getPresenter(){
        return presenter;
    }

    @Override
    protected void onDestroy() {
        if (presenter != null){
            presenter.detachView();
        }
        super.onDestroy();
    }
}
