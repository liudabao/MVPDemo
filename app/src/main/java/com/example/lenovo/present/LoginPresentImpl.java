package com.example.lenovo.present;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.lenovo.model.LoginModel;
import com.example.lenovo.model.LoginModelImpl;
import com.example.lenovo.model.OnLoginListener;
import com.example.lenovo.util.OnHttpListener;
import com.example.lenovo.view.LoginView;

/**
 * Created by lenovo on 2016/6/8.
 */
public class LoginPresentImpl implements LoginPresent ,OnLoginListener{
    LoginView mLoginView;
    LoginModel mLoginModel;
    Handler handler=new Handler();

    public LoginPresentImpl(LoginView loginView) {
        mLoginModel=new LoginModelImpl();
        mLoginView=loginView;
    }

    @Override
    public void onDestroy() {

        mLoginView = null;
    }

    @Override
    public void validate(final String username, final String password) {


        if(TextUtils.isEmpty(username)){
            onUserIdEmpty();
        }
        else if(TextUtils.isEmpty(password)){
            onPasswordEmpty();
        }
        else if(mLoginView!=null){
            mLoginView.showProgerss();
        }
        mLoginModel.login(username, password, this);

    }

    @Override
    public void onNetError() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoginView.loginNetError();
                mLoginView.disProgress();
            }
        },2000);

    }

    @Override
    public void onIdOrPswError() {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoginView.loginIdOrPsdError();
                mLoginView.disProgress();
            }
        },2000);

    }

    @Override
    public void onSuccess() {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoginView.loginSuccess();
                mLoginView.disProgress();
            }
        },2000);

    }

    private void onUserIdEmpty() {
        mLoginView.loginUserIdEmpty();
        mLoginView.disProgress();
    }

    private void onPasswordEmpty() {

        mLoginView.loginPasswordEmpty();
        mLoginView.disProgress();
    }
}
