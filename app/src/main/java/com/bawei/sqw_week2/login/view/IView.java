package com.bawei.sqw_week2.login.view;

import android.content.Context;

/**
 * Created by 小哥 on 2018/11/9.
 */

public interface IView<T>{

    void success(T t);

    void failed(Exception e);

    void setUsername(String username);

    void setPassword(String password);

    String getUsername();

    String getPassword();

    void checkData(boolean isChecked, String msg);

    Context getContext();

    void setCheckBox(boolean isChecked);

    boolean isRemember();
}
