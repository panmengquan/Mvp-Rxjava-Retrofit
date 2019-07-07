package com.app.mvpdemo.base;

import com.app.mvpdemo.mvp.bean.LoginDataBean;

public interface LoginView extends BaseView {
    void onSuccess(LoginDataBean loginDataBean);
}
