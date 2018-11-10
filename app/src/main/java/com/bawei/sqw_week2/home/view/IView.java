package com.bawei.sqw_week2.home.view;

import android.content.Context;

import com.bawei.sqw_week2.bean.Banner;
import com.bawei.sqw_week2.bean.Category;
import com.bawei.sqw_week2.bean.MessageBean;
import com.bawei.sqw_week2.bean.Product;
import com.bawei.sqw_week2.bean.Shopper;

import java.util.List;

/**
 * Created by 小哥 on 2018/11/9.
 */

public interface IView {

    void getBanner(MessageBean<List<Banner>> banners);

    void getCategory(List<Category.DataBean> list);

    void getProduct(MessageBean<List<Shopper>> products);

    Context getContext();

    void failed(Exception e);

}
