package com.bishilai.bishilai.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.adapter.AdapterGridView1;
import com.bishilai.bishilai.adapter.AdapterGridView2;
import com.bishilai.bishilai.adapter.AdapterGridView3;
import com.bishilai.bishilai.widget.Banner;
import com.bishilai.bishilai.widget.InnerGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseFragment;
import midian.baselib.widget.BaseLibTopbarView;

/**
 * Fragment1
 * Created by Alex on 2016/5/19.
 */
public class Fragment1 extends BaseFragment {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.bannerView)
    Banner bannerView;
    @BindView(R.id.tv_Tab1)
    TextView tvTab1;
    @BindView(R.id.tv_Tab2)
    TextView tvTab2;
    @BindView(R.id.tv_Tab3)
    TextView tvTab3;
    @BindView(R.id.tv_Tab4)
    TextView tvTab4;
    @BindView(R.id.gridView1)
    GridView gridView1;
    @BindView(R.id.gridView2)
    InnerGridView gridView2;
    @BindView(R.id.gridView3)
    InnerGridView gridView3;
    @BindView(R.id.gridView4)
    InnerGridView gridView4;
    @BindView(R.id.gridView5)
    InnerGridView gridView5;
    @BindView(R.id.gridView6)
    InnerGridView gridView6;
    @BindView(R.id.gridView7)
    InnerGridView gridView7;
    @BindView(R.id.gridView8)
    InnerGridView gridView8;

    private List<String> images = new ArrayList<>();
    private int flag = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab1, null);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {
        bannerView.setBannerStyle(Banner.CIRCLE_INDICATOR);//设置圆形指示器
        bannerView.setIndicatorGravity(Banner.CENTER);
        bannerView.isAutoPlay(true);
        bannerView.setDelayTime(5000);//设置轮播间隔时间
//        bannerView.setOnBannerClickListener(this);
        if (flag == 0) {
            flag++;
            for (int i = 0; i < 3; i++) {
                images.add("http://mengzhu.img-cn-shenzhen.aliyuncs.com/8a99524557c2dec90157c72795010007");
            }
        }
        bannerView.setImages(images.toArray());
        gridView1.setAdapter(new AdapterGridView1(_activity));
        gridView2.setAdapter(new AdapterGridView2(_activity));
        gridView3.setAdapter(new AdapterGridView3(_activity));
        gridView4.setAdapter(new AdapterGridView3(_activity));
        gridView5.setAdapter(new AdapterGridView3(_activity));
        gridView6.setAdapter(new AdapterGridView3(_activity));
        gridView7.setAdapter(new AdapterGridView3(_activity));
        gridView8.setAdapter(new AdapterGridView3(_activity));
    }
}
