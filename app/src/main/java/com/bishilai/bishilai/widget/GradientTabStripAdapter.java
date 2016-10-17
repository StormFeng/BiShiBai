package com.bishilai.bishilai.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import com.apkfuns.logutils.LogUtils;
import com.bishilai.bishilai.R;
import java.util.ArrayList;
import java.util.List;

import midian.baselib.widget.GradientTabStrip;

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
                return "微信";
            case 1:
                return "通讯录";
            case 2:
                return "发现";
            case 3:
                return "我";
        }
    }

    @Override
    public Drawable getNormalDrawable(int position, Context context) {
        switch (position) {
            default:
            case 0:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_chat_normal);
            case 1:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_contacts_normal);
            case 2:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_discovery_normal);
            case 3:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_account_normal);
        }
    }

    @Override
    public Drawable getSelectedDrawable(int position, Context context) {
        switch (position) {
            default:
            case 0:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_chat_selected);
            case 1:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_contacts_selected);
            case 2:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_discovery_selected);
            case 3:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_account_selected);
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
