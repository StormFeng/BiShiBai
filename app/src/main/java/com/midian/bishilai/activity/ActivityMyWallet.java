package com.midian.bishilai.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.midian.bishilai.R;
import com.midian.bishilai.fragments.FragmentBonus;
import com.midian.bishilai.fragments.FragmentSales;
import com.jaeger.library.StatusBarUtil;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.DummyPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseFragmentActivity;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;

/**
 * 我的钱包
 * Created by Administrator on 2016/10/25 0025.
 */

public class ActivityMyWallet extends BaseFragmentActivity {
    @BindView(R.id.tv_Bonus)
    TextView tvBonus;
    @BindView(R.id.tv_Sales)
    TextView tvSales;
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.ll_Sales)
    LinearLayout llSales;
    @BindView(R.id.ll_Bonus)
    LinearLayout llBonus;
    @BindView(R.id.tv_Balance)
    TextView tvBalance;
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mywallet);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
            StatusBarUtil.setTranslucentForImageViewInFragment(_activity, 0, null);
        }
        initView();
        initMagicIndicator();
    }

    private void initView() {
        topbar.setBackgroundColor(Color.parseColor("#00ffffff"));
        topbar.setTitle("");
        topbar.setLeftImageButton(R.drawable.icon_back,UIHelper.finish(_activity));
        topbar.setRightImageButton(R.drawable.icon_bankcard,UIHelper.OnClickJump(_activity,ActivityCard.class));
        fragments.add(new FragmentBonus());
        fragments.add(new FragmentSales());
        viewPager.setAdapter(new FragmentPagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setButton(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setButton(int position) {
        if (position == 0) {
            tvBonus.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.icon_bonus_select), null, null, null);
            tvBonus.setTextColor(Color.parseColor("#FFA95D"));
            tvSales.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.icon_sales_nomal), null, null, null);
            tvSales.setTextColor(Color.parseColor("#666666"));
        } else {
            tvBonus.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.icon_bonus_nomal), null, null, null);
            tvBonus.setTextColor(Color.parseColor("#666666"));
            tvSales.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.icon_sales_select), null, null, null);
            tvSales.setTextColor(Color.parseColor("#FFA95D"));
        }
    }

    private void initMagicIndicator() {
        magicIndicator.setBackgroundColor(Color.parseColor("#FFFFFF"));
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                return new DummyPagerTitleView(context);
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                float lineHeight = context.getResources().getDimension(R.dimen.small_navigator_height);
                indicator.setLineHeight(lineHeight);
                indicator.setColors(Color.parseColor("#FFA95D"));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }

    @OnClick({R.id.ll_Bonus, R.id.ll_Sales, R.id.tv_Balance})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_Bonus:
                viewPager.setCurrentItem(0);
                setButton(0);
                break;
            case R.id.ll_Sales:
                viewPager.setCurrentItem(1);
                setButton(1);
                break;
            case R.id.tv_Balance:
                UIHelper.jump(_activity, ActivityBalance.class);
                break;
        }
    }
}
