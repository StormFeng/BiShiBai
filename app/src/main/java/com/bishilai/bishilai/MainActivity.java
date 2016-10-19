package com.bishilai.bishilai;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

import com.bishilai.bishilai.fragments.Fragment1;
import com.bishilai.bishilai.fragments.Fragment2;
import com.bishilai.bishilai.fragments.Fragment3;
import com.bishilai.bishilai.fragments.Fragment4;
import com.bishilai.bishilai.widget.GradientTabStripAdapter;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;
import am.widget.basetabstrip.BaseTabStrip;
import midian.baselib.base.BaseFragmentActivity;
import midian.baselib.widget.GradientTabStrip;

public class MainActivity extends BaseFragmentActivity implements BaseTabStrip.OnItemClickListener {

    private ViewPager vpFragments;
    private GradientTabStripAdapter adapter;
    private List<Fragment> fragments=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpFragments = (ViewPager) findViewById(R.id.gts_vp_fragments);
        GradientTabStrip tabStrip = (GradientTabStrip) findViewById(R.id.gradientTabStrip);
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        adapter = new GradientTabStripAdapter(getSupportFragmentManager(),fragments);
        vpFragments.setAdapter(adapter);
        tabStrip.setAdapter(adapter);
        tabStrip.bindViewPager(vpFragments);
        tabStrip.setOnItemClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }else{
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
            StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this,0,null);
        }
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onSelectedClick(int position) {

    }

    @Override
    public void onDoubleClick(int position) {

    }
}
