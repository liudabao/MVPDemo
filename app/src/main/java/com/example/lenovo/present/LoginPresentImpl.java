package com.example.lenovo.present;

import com.example.lenovo.model.LoginModel;
import com.example.lenovo.model.OnLoginListener;
import com.example.lenovo.view.LoginView;

/**
 * Created by lenovo on 2016/6/8.
 */
public class LoginPresentImpl implements LoginPresent ,OnLoginListener{
    LoginView mLoginView;
    LoginModel mLoginModel;

    public LoginPresentImpl(LoginView loginView) {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void validate(String username, String password) {

    }

    @Override
    public void onNetFail() {
        
    }

    @Override
    public void onInputFail() {

    }

    @Override
    public void onSuccess() {

    }
}
