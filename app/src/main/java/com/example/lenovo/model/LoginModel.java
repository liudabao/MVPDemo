package com.example.lenovo.model;

/**
 * Created by lenovo on 2016/6/8.
 */
public interface LoginModel {
    public void login(String user, String password, OnLoginListener listener);
}
