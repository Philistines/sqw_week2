package com.bawei.sqw_week2.regist.view;

import android.content.Context;

/**
 * Created by 小哥 on 2018/11/9.
 */

public interface IView {

    String getUsername();

    String getPassword();

    String getConfirmPassword();

    void checkData(boolean isCkecked, String msg);

    Context getContext();

    void exit();
}
