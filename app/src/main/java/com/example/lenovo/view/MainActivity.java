package com.example.lenovo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lenovo.mvpdemo.R;
import com.example.lenovo.present.LoginPresent;
import com.example.lenovo.present.LoginPresentImpl;

public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private ProgressBar mProgressBar;
    private EditText userName;
    private EditText password;
    private Button btn_login;
    private LoginPresent mLoginPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mProgressBar=(ProgressBar)findViewById(R.id.progressBar);
        userName=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        btn_login=(Button)findViewById(R.id.button);
        btn_login.setOnClickListener(this);
        mLoginPresent=new LoginPresentImpl(this);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mLoginPresent.onDestroy();
    }
    @Override
    public void showProgerss() {

        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void disProgress() {

        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void loginUserIdEmpty() {
        userName.setError("user id is empty");
    }

    @Override
    public void loginPasswordEmpty() {
        password.setError("password is empty");
    }

    @Override
    public void loginIdOrPsdError() {
        Toast.makeText(getApplicationContext(), "user id or password is error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginNetError() {
        Toast.makeText(getApplicationContext(), "net is unavaible", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

        mLoginPresent.validate(userName.getText().toString(), password.getText().toString());
    }
}
