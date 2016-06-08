package com.example.lenovo.present;

import android.text.Editable;

/**
 * Created by lenovo on 2016/6/8.
 */
public interface LoginPresent {

    public void onDestroy();
    public void validate(String username, String password);
}
