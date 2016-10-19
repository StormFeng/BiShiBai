package com.bishilai.bishilai.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.bishilai.bishilai.MainActivity;
import com.bishilai.bishilai.R;
import com.bishilai.bishilai.activity.ActivityGoodDetail;
import com.bishilai.bishilai.adapter.AdapterGridView11;
import com.bishilai.bishilai.adapter.AdapterGridView12;
import com.bishilai.bishilai.adapter.AdapterGridView13;
import com.bishilai.bishilai.widget.Banner;
import com.bishilai.bishilai.widget.InnerGridView;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.base.BaseFragment;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;
import midian.baselib.widget.ScrollChangeListener;
import midian.baselib.widget.ScrollViewWidthListener;
import midian.baselib.widget.pulltorefresh.PullToRefreshBase;
import midian.baselib.widget.pulltorefresh.PullToRefreshScrollView;

import static midian.baselib.widget.BaseLibTopbarView.MODE_WITH_INPUT;

/**
 * Fragment1
 * Created by Alex on 2016/5/19.
 */
public class Fragment1 extends BaseFragment implements Banner.OnBannerClickListener {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.refreshScrollView)
    PullToRefreshScrollView refreshScrollView;

    private Banner bannerView;
    private TextView tvTab1;
    private TextView tvTab2;
    private TextView tvTab3;
    private TextView tvTab4;
    private InnerGridView gridView1;
    private InnerGridView gridView2;
    private InnerGridView gridView3;
    private InnerGridView gridView4;
    private InnerGridView gridView5;
    private InnerGridView gridView6;
    private InnerGridView gridView7;
    private InnerGridView gridView8;


    private List<String> images = new ArrayList<>();
    private int flag = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.basescrollview, null);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {

        View content = LayoutInflater.from(_activity).inflate(R.layout.fragment_tab11, null);
        topbar.setBackgroundColor(getResources().getColor(R.color.alpha));
        topbar.getLine_iv().setVisibility(View.GONE);
        topbar.setMode(MODE_WITH_INPUT);
        bannerView = (Banner) content.findViewById(R.id.bannerView);
        gridView1 = (InnerGridView) content.findViewById(R.id.gridView1);
        gridView2 = (InnerGridView) content.findViewById(R.id.gridView2);
        gridView3 = (InnerGridView) content.findViewById(R.id.gridView3);
        gridView4 = (InnerGridView) content.findViewById(R.id.gridView4);
        gridView5 = (InnerGridView) content.findViewById(R.id.gridView5);
        gridView6 = (InnerGridView) content.findViewById(R.id.gridView6);
        gridView7 = (InnerGridView) content.findViewById(R.id.gridView7);
        gridView8 = (InnerGridView) content.findViewById(R.id.gridView8);
        refreshScrollView.setPullLoadEnabled(false);
        refreshScrollView.scrollView.addView(content);

        bannerView.setBannerStyle(Banner.CIRCLE_INDICATOR);//设置圆形指示器
        bannerView.setIndicatorGravity(Banner.CENTER);
        bannerView.isAutoPlay(true);
        bannerView.setDelayTime(5000);//设置轮播间隔时间
        bannerView.setOnBannerClickListener(this);
        if (flag == 0) {
            flag++;
            for (int i = 0; i < 3; i++) {
                images.add("http://mengzhu.img-cn-shenzhen.aliyuncs.com/8a99524557c2dec90157c72795010007");
            }
        }
        bannerView.setImages(images.toArray());

        gridView1.setAdapter(new AdapterGridView11(_activity));
        gridView2.setAdapter(new AdapterGridView12(_activity));
        gridView3.setAdapter(new AdapterGridView13(_activity));
        gridView4.setAdapter(new AdapterGridView13(_activity));
        gridView5.setAdapter(new AdapterGridView13(_activity));
        gridView6.setAdapter(new AdapterGridView13(_activity));
        gridView7.setAdapter(new AdapterGridView13(_activity));
        gridView8.setAdapter(new AdapterGridView13(_activity));

        refreshScrollView.setOnRefreshListener(onRefreshListener);
        refreshScrollView.scrollView.setVerticalScrollBarEnabled(false);


        refreshScrollView.scrollView.setChangeListener(new ScrollChangeListener() {
            @Override
            public void onScrollChanged(ScrollView scrollView, int x, int y, int oldx, int oldy) {
                if(y<0){
                    topbar.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                } else if(y<485 && y>=0){
                    topbar.setVisibility(View.VISIBLE);
                    float var1 = (float)y/485;
                    float var2 = var1 * 255;
                    String var3 = Integer.toHexString((int) var2);
                    if(var3.length()==1){
                        var3="0"+var3;
                    }
                    String color=new StringBuffer("#EB6563").insert(1,var3).toString();
                    //LogUtils.e("y:"+y+"\n"+"var3:"+var3+"\n"+"color:"+color);
                    topbar.setBackgroundColor(Color.parseColor(color));
                }else if(y>=485){
                    topbar.setBackgroundColor(Color.parseColor("#EB6563"));
                }
            }
        });
    }

    PullToRefreshBase.OnRefreshListener<ScrollView> onRefreshListener=new PullToRefreshBase.OnRefreshListener<ScrollView>() {
        @Override
        public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {

        }

        @Override
        public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {

        }
    };

    @Override
    public void OnBannerClick(View view, int position) {
        UIHelper.jump(_activity, ActivityGoodDetail.class);
    }
}
