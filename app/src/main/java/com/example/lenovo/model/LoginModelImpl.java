package com.example.lenovo.model;

import android.text.TextUtils;
import android.util.Log;

import com.example.lenovo.util.HttpUtil;
import com.example.lenovo.util.OnHttpListener;

/**
 * Created by lenovo on 2016/6/8.
 */
public class LoginModelImpl implements LoginModel {
    @Override
    public void login(final String user, final  String password, final OnLoginListener listener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtil.post(user, password, new OnHttpListener() {
                    @Override
                    public void onFinish(String response) {

                        if(response=="ok"){
                            listener.onSuccess();
                        }
                        else {
                            listener.onIdOrPswError();
                        }

                    }

                    @Override
                    public void onError() {

                        listener.onNetError();
                    }
                });
            }
        }).start();

    }
}
