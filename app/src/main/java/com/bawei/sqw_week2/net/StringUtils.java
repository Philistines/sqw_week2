package com.bawei.sqw_week2.net;

/**
 * Created by 小哥 on 2018/11/9.
 */

public class StringUtils {
    public static String https2Http(String url) {
        return url.replace("https", "http");
    }
}
