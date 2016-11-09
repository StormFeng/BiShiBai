package com.midian.bishilai.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import com.apkfuns.logutils.LogUtils;
import com.midian.bishilai.R;
import java.util.ArrayList;
import java.util.List;

/**
 * GradientTabStripAdapter
 * Created by Alex on 2016/5/19.
 */
public class GradientTabStripAdapter extends FragmentPagerAdapter implements
        GradientTabStrip.GradientTabAdapter {

    private List<Fragment> fragments=new ArrayList<>();



    public GradientTabStripAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            default:
            case 0:
                return "首页";
            case 1:
                return "产品";
            case 2:
                return "购物车";
            case 3:
                return "我的";
        }
    }

    @Override
    public Drawable getNormalDrawable(int position, Context context) {
        switch (position) {
            default:
            case 0:
                return ContextCompat.getDrawable(context, R.drawable.icon_home_nomal);
            case 1:
                return ContextCompat.getDrawable(context, R.drawable.icon_good_nomal);
            case 2:
                return ContextCompat.getDrawable(context, R.drawable.icon_shopcar_nomal);
            case 3:
                return ContextCompat.getDrawable(context, R.drawable.icon_personl_nomal);
        }
    }

    @Override
    public Drawable getSelectedDrawable(int position, Context context) {
        switch (position) {
            default:
            case 0:
                return ContextCompat.getDrawable(context, R.drawable.icon_home_press);
            case 1:
                return ContextCompat.getDrawable(context, R.drawable.icon_good_press);
            case 2:
                return ContextCompat.getDrawable(context, R.drawable.icon_shopcar_press);
            case 3:
                return ContextCompat.getDrawable(context, R.drawable.icon_personl_press);
        }
    }

    @Override
    public boolean isTagEnable(int position) {
//        return position != 3;
        return false;
    }

    @Override
    public String getTag(int position)
    {
//        switch (position) {
//            default:
//            case 0:
//                return "888";
//            case 1:
//                return "";
//            case 2:
//                return "new";
//        }
        return "";
    }
}
