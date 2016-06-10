package com.example.lenovo.model;

/**
 * Created by lenovo on 2016/6/8.
 */
public interface OnLoginListener {

    public void  onNetError();
    public void  onIdOrPswError();
    public void  onSuccess();
}
