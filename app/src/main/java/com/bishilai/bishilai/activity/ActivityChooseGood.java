package com.bishilai.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.TextView;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.adapter.AdapterGridView13;
import com.bishilai.bishilai.adapter.AdapterGridViewChooseGood;
import com.jaeger.library.StatusBarUtil;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.base.BaseActivity;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;

/**
 * 选择商品
 * Created by Administrator on 2016/10/26 0026.
 */

public class ActivityChooseGood extends BaseActivity {

    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.tag_Effect)
    TagFlowLayout tagEffect;
    @BindView(R.id.tag_Season)
    TagFlowLayout tagSeason;
    @BindView(R.id.gridView)
    GridView gridView;

    private List<String> effectTagString=new ArrayList<>();
    private List<String> seasonTagString=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosegood);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
            StatusBarUtil.setTranslucentForImageViewInFragment(_activity, 0, null);
        }
        topbar = findView(R.id.topbar);
        topbar.setBackgroundColor(getResources().getColor(R.color.green));
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        topbar.setTitle("选择商品");

        effectTagString.add("全部");
        effectTagString.add("丰胸");
        effectTagString.add("美白");
        effectTagString.add("瘦身");
        effectTagString.add("除皱");
        effectTagString.add("丰胸");
        effectTagString.add("高贵");
        effectTagString.add("迷人");

        seasonTagString.add("春季");
        seasonTagString.add("夏季");
        seasonTagString.add("秋季");
        seasonTagString.add("冬季");

        tagEffect.setAdapter(new TagAdapter<String>(effectTagString) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(_activity).inflate(R.layout.tag_layout, tagEffect, false);
                tv.setText(s);
                return tv;
            }
        });

        tagSeason.setAdapter(new TagAdapter<String>(seasonTagString) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(_activity).inflate(R.layout.tag_layout, tagSeason, false);
                tv.setText(s);
                return tv;
            }
        });
        gridView.setAdapter(new AdapterGridViewChooseGood(_activity));
    }

}
