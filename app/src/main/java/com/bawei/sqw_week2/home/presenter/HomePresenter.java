package com.bawei.sqw_week2.home.presenter;

import com.bawei.sqw_week2.bean.Banner;
import com.bawei.sqw_week2.bean.Category;
import com.bawei.sqw_week2.bean.MessageBean;
import com.bawei.sqw_week2.bean.Product;
import com.bawei.sqw_week2.bean.Shopper;
import com.bawei.sqw_week2.home.model.HomeModel;
import com.bawei.sqw_week2.home.view.IView;
import com.bawei.sqw_week2.net.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by 小哥 on 2018/11/9.
 */

public class HomePresenter {
    private IView iv;
    private HomeModel model;

    public void attach(IView iv) {
        this.iv = iv;
        model = new HomeModel();
    }

    public void getBanner() {
        String url = "http://www.zhaoapi.cn/ad/getAd";
        Type type = new TypeToken<MessageBean<List<Banner>>>() {
        }.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void success(Object obj) {
                MessageBean<List<Banner>> data = (MessageBean<List<Banner>>) obj;
                iv.getBanner(data);
            }

            @Override
            public void failed(Exception e) {

            }
        },type);
    }

    public void getCategory() {

        Type type = new TypeToken<Category>() {
        }.getType();

        model.getData("http://www.zhaoapi.cn/product/getCatagory", new ICallBack() {
            @Override
            public void success(Object obj) {
                Category category = (Category) obj;
                if (category != null) {
                    iv.getCategory(category.getData());
                }
            }

            @Override
            public void failed(Exception e) {
                iv.failed(e);
            }
        }, type);

    }
    public void getProduct(){
        String url = "http://www.zhaoapi.cn/product/getCarts?uid=71";
        Type type = new TypeToken<MessageBean<List<Shopper>>>() {
        }.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void success(Object obj) {
                MessageBean<List<Shopper>> data = (MessageBean<List<Shopper>>) obj;
                iv.getProduct(data);
            }

            @Override
            public void failed(Exception e) {
                iv.failed(e);
            }
        },type);
    }

    public void detach() {
        if (iv != null) {
            iv = null;
        }
    }

}
