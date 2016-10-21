package com.bishilai.bishilai.activity;

import android.os.Bundle;

import com.apkfuns.logutils.LogUtils;
import com.bishilai.bishilai.R;

import java.util.ArrayList;
import midian.baselib.base.BaseActivity;
import ru.truba.touchgallery.GalleryWidget.GalleryViewPager;
import ru.truba.touchgallery.GalleryWidget.UrlPagerAdapter;

/**
 * Created by Administrator on 2016/10/15 0015.
 */
public class ActivityViewPhoto extends BaseActivity {

    GalleryViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewphoto);
        viewPager=findView(R.id.viewer);
        ArrayList<String> pics = mBundle.getStringArrayList("pic");
        UrlPagerAdapter pagerAdapter = new UrlPagerAdapter(this, pics);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(pagerAdapter);

        if(!"".equals(mBundle.getString("position"))){
            LogUtils.e("mBundle.getString(\"position\"):"+mBundle.getString("position"));
            viewPager.setCurrentItem(Integer.valueOf(mBundle.getString("position")));
        }
    }
}
