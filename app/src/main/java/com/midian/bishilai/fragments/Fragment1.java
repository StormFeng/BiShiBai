package com.midian.bishilai.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.midian.base.base.BaseFragment;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;
import com.midian.base.widget.ScrollChangeListener;
import com.midian.base.widget.pulltorefresh.PullToRefreshBase;
import com.midian.base.widget.pulltorefresh.PullToRefreshScrollView;
import com.midian.bishilai.R;
import com.midian.bishilai.activity.ActivityChooseGood;
import com.midian.bishilai.activity.ActivityGoodDetail;
import com.midian.bishilai.activity.ActivityRankingList;
import com.midian.bishilai.activity.ActivitySpringHealth;
import com.midian.bishilai.adapter.AdapterGridView11;
import com.midian.bishilai.adapter.AdapterGridView12;
import com.midian.bishilai.adapter.AdapterGridView13;
import com.midian.bishilai.widget.Banner;
import com.midian.bishilai.widget.DivideText;
import com.midian.bishilai.widget.InnerGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.midian.base.widget.BaseLibTopbarView.MODE_WITH_INPUT;

/**
 * 首页
 */
public class Fragment1 extends BaseFragment implements Banner.OnBannerClickListener, View.OnClickListener {
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
    private LinearLayout llLookMore;

    private DivideText divideText1;

    private float var1,var2;
    private String var3,color;
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

        View content = LayoutInflater.from(_activity).inflate(R.layout.fragment_tab1, null);
        topbar.setBackgroundColor(getResources().getColor(R.color.alpha));
        topbar.getLine_iv().setVisibility(View.GONE);
        topbar.setMode(MODE_WITH_INPUT);
        topbar.setLeftImageButton(R.drawable.icon_love,null);
        topbar.setRightImageButton(R.drawable.icon_talk,null);
        bannerView = (Banner) content.findViewById(R.id.bannerView);
        gridView1 = (InnerGridView) content.findViewById(R.id.gridView1);
        gridView2 = (InnerGridView) content.findViewById(R.id.gridView2);
        gridView3 = (InnerGridView) content.findViewById(R.id.gridView3);
        divideText1 = (DivideText) content.findViewById(R.id.divideText1);
        llLookMore = (LinearLayout) content.findViewById(R.id.ll_LookMore);
        tvTab1 = (TextView) content.findViewById(R.id.tv_Tab1);
        tvTab2 = (TextView) content.findViewById(R.id.tv_Tab2);
        tvTab3 = (TextView) content.findViewById(R.id.tv_Tab3);
        tvTab4 = (TextView) content.findViewById(R.id.tv_Tab4);
        tvTab1.setOnClickListener(this);
        tvTab2.setOnClickListener(this);
        tvTab3.setOnClickListener(this);
        tvTab4.setOnClickListener(this);
        llLookMore.setOnClickListener(this);
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

        divideText1.setTitle("明星产品");

        refreshScrollView.setOnRefreshListener(onRefreshListener);
        refreshScrollView.scrollView.setVerticalScrollBarEnabled(false);


        refreshScrollView.scrollView.setChangeListener(new ScrollChangeListener() {
            @Override
            public void onScrollChanged(ScrollView scrollView, int x, int y, int oldx, int oldy) {
                if(y<0){
                    topbar.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                } else if(y<485 && y>=0){
                    topbar.setVisibility(View.VISIBLE);
                    var1 = (float)y/485;
                    var2 = var1 * 255;
                    var3 = Integer.toHexString((int) var2);
                    if(var3.length()==1){
                        var3="0"+var3;
                    }
                    color=new StringBuffer("#07A746").insert(1,var3).toString();
                    //LogUtils.e("y:"+y+"\n"+"var3:"+var3+"\n"+"color:"+color);
                    topbar.setBackgroundColor(Color.parseColor(color));
                }else if(y>=485){
                    topbar.setBackgroundColor(Color.parseColor("#07A746"));
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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_LookMore:

                break;
            case R.id.tv_Tab1:
                UIHelper.jump(_activity, ActivityRankingList.class);
                break;
            case R.id.tv_Tab3:
                UIHelper.jump(_activity, ActivitySpringHealth.class);
                break;
            case R.id.tv_Tab4:
                UIHelper.jump(_activity, ActivityChooseGood.class);
                break;
        }
    }
}
