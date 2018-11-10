package com.bawei.sqw_week2.regist.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.sqw_week2.regist.presenter.RegistPresenter;
import com.bawei.sqw_week2.ui.activity.R;

public class RegistActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private RegistPresenter presenter;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etPasswordConfirm;
    private Button btnRegist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        initView();

        initData();

        setListener();

    }

    private void initData() {
        presenter = new RegistPresenter();
        presenter.attach(this);
    }

    private void setListener() {
        btnRegist.setOnClickListener(this);
    }

    private void initView() {
        etUsername = findViewById(R.id.ed_regist_username);
        etPassword = findViewById(R.id.et_regist_password);
        etPasswordConfirm = findViewById(R.id.ed_regist_password_confirm);
        btnRegist = findViewById(R.id.btn_regist_regist);
    }

    @Override
    public String getUsername() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public String getConfirmPassword() {
        return etPasswordConfirm.getText().toString();
    }

    @Override
    public void checkData(boolean isCkecked, String msg) {
        if (isCkecked){
            presenter.regist();
        }else{
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void exit() {
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_regist_regist:
                presenter.check();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.detach();
        }
    }
}
