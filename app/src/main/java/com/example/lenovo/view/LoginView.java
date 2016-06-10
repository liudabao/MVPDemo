package com.example.lenovo.view;

/**
 * Created by lenovo on 2016/6/8.
 */
public interface LoginView {

    public void showProgerss();
    public void disProgress();
    public void loginUserIdEmpty();
    public void loginPasswordEmpty();
    public void loginIdOrPsdError();
    public void loginNetError();
    public void loginSuccess();

}
