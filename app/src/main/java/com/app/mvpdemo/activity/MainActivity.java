package com.app.mvpdemo.activity;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.mvpdemo.R;
import com.app.mvpdemo.base.BaseMvpActivity;
import com.app.mvpdemo.base.LoginView;
import com.app.mvpdemo.mvp.bean.LoginDataBean;
import com.app.mvpdemo.mvp.presenter.BookPresenter;

public class MainActivity extends BaseMvpActivity<LoginView, BookPresenter> implements LoginView, View.OnClickListener {
    private ProgressDialog progressDialog;
    private Button button;
    private TextView text;
    @Override
    protected BookPresenter createPresenter() {
        return new BookPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        button = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.text);
        button.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在拼命加载中...");
    }

    @Override
    public void onSuccess(LoginDataBean loginDataBean) {
        text.setText(loginDataBean.getCode());
    }

    @Override
    public void showProgressDialog() {
        if(!progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    @Override
    public void hideProgressDialog() {
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    @Override
    public void onError( String msg) {
               Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        getPresenter().startLogin("201900512");
    }
}
