package com.bawei.sqw_week2.regist.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 小哥 on 2018/11/9.
 */

public class RegistModel {
    private Context context;
    private SharedPreferences sp;

    public RegistModel(Context context) {
        // 持有的不是V层的引用，防止内存泄漏，通过context.getApplicationContext()
        this.context = context.getApplicationContext();
        sp = this.context.getSharedPreferences("user", Context.MODE_PRIVATE);
    }
    public boolean regist(String username, String password) {
        sp.edit().putString("username", username)
                .putString("password", password)
                .commit();
        return true;
    }
}