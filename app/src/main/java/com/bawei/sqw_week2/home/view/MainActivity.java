package com.bawei.sqw_week2.home.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.sqw_week2.adapter.BannerAdapter;
import com.bawei.sqw_week2.adapter.CategotyAdapter;
import com.bawei.sqw_week2.adapter.ProductAdapter;
import com.bawei.sqw_week2.bean.Banner;
import com.bawei.sqw_week2.bean.Category;
import com.bawei.sqw_week2.bean.MessageBean;
import com.bawei.sqw_week2.bean.Product;
import com.bawei.sqw_week2.bean.Shopper;
import com.bawei.sqw_week2.home.presenter.HomePresenter;
import com.bawei.sqw_week2.ui.activity.QrcodeActivity;
import com.bawei.sqw_week2.ui.activity.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView{


    private ImageView imgScanner;
    private ViewPager vpBanner;
    private GridView gvCategory;
    private RecyclerView gvProduct;

    private List<Banner> bannerList;
    private List<Category.DataBean> categoryList;
    private List<Product> productList;

    private BannerAdapter bannerAdapter;
    private CategotyAdapter categotyAdapter;
    private ProductAdapter productAdapter;
    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

        setListener();
    }

    private void setListener() {
        imgScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QrcodeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {

        bannerList = new ArrayList<>();
        categoryList = new ArrayList<>();
        productList = new ArrayList<>();

        bannerAdapter = new BannerAdapter(this, bannerList);
        categotyAdapter = new CategotyAdapter(this, categoryList);
        productAdapter = new ProductAdapter(this, productList);

        vpBanner.setAdapter(bannerAdapter);
        gvCategory.setAdapter(categotyAdapter);
        gvProduct.setAdapter(productAdapter);

        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        gvProduct.setLayoutManager(layoutManager);

        presenter = new HomePresenter();
        presenter.attach(this);
        presenter.getBanner();
        presenter.getCategory();
        presenter.getProduct();
    }

    private void initView() {
        imgScanner = findViewById(R.id.btn_scan_qr_code);
        vpBanner = findViewById(R.id.view_page);
        gvCategory = findViewById(R.id.gv_category);
        gvProduct = findViewById(R.id.gv_product);
    }


    @Override
    public void getBanner(MessageBean<List<Banner>> banners) {
        if (banners != null){
            List<Banner> data = banners.getData();
            if (data != null){
                bannerList.clear();
                bannerList.addAll(data);
                bannerAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void getCategory(List<Category.DataBean> list) {
        if (list != null){
            categoryList.clear();
            categoryList.addAll(list);
            categotyAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getProduct(MessageBean<List<Shopper>> products) {
        List<Shopper> shoppers = products.getData();
        if (shoppers != null){
            productList.clear();
            for(Shopper shopper : shoppers){
                List<Product> list = shopper.getList();
                if (list != null){
                    productList.addAll(list);
                }
            }
            productAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void failed(Exception e) {
        Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.detach();
        }
    }
}
