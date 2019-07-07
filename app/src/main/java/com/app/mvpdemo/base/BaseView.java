package com.app.mvpdemo.base;

public interface BaseView {
    // 显示进度框
    void showProgressDialog();
    // 关闭进度框
    void hideProgressDialog();
    // 出错信息的回调
    void onError(String result);

}