package com.bishilai.bishilai.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.activity.ActivitySearchResult;
import com.bishilai.bishilai.adapter.AdapterGridView21;
import com.bishilai.bishilai.widget.InnerGridView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseFragment;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;

import static midian.baselib.widget.BaseLibTopbarView.MODE_WITH_INPUT;

/**
 * Fragment2
 * Created by Alex on 2016/5/19.
 */
public class Fragment2 extends BaseFragment {

    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.gridView1)
    InnerGridView gridView1;
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
    @BindView(R.id.gridView9)
    InnerGridView gridView9;
    @BindView(R.id.ll_FirstCard)
    LinearLayout llFirstCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab2, null);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {
        topbar.setBackgroundColor(getResources().getColor(R.color.orange));
        topbar.setMode(MODE_WITH_INPUT);

        gridView1.setAdapter(new AdapterGridView21(_activity));
        gridView2.setAdapter(new AdapterGridView21(_activity));
        gridView3.setAdapter(new AdapterGridView21(_activity));
        gridView4.setAdapter(new AdapterGridView21(_activity));
        gridView5.setAdapter(new AdapterGridView21(_activity));
        gridView6.setAdapter(new AdapterGridView21(_activity));
        gridView7.setAdapter(new AdapterGridView21(_activity));
        gridView8.setAdapter(new AdapterGridView21(_activity));
        gridView9.setAdapter(new AdapterGridView21(_activity));
    }

    @OnClick({R.id.topbar, R.id.ll_FirstCard})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.topbar:
                break;
            case R.id.ll_FirstCard:
                UIHelper.jump(_activity, ActivitySearchResult.class);
                break;
        }
    }
}