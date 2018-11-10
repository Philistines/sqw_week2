package com.bawei.sqw_week2.home.model;

import com.bawei.sqw_week2.net.HttpUtils;
import com.bawei.sqw_week2.net.ICallBack;

import java.lang.reflect.Type;

/**
 * Created by 小哥 on 2018/11/9.
 */

public class HomeModel {

    public void getData(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url, callBack, type);
    }
}
