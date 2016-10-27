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
 * 产品
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
    @BindView(R.id.ll_FirstCard)
    LinearLayout llFirstCard;

    AdapterGridView21 adapter21;
    AdapterGridView21 adapter22;
    AdapterGridView21 adapter23;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab2, null);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {
        topbar.setBackgroundColor(getResources().getColor(R.color.green));
        topbar.setMode(MODE_WITH_INPUT);
        topbar.setLeftImageButton(R.drawable.icon_love,null);
        topbar.setRightImageButton(R.drawable.icon_talk,null);
        adapter21=new AdapterGridView21(_activity,7);
        adapter22=new AdapterGridView21(_activity,11);
        adapter23=new AdapterGridView21(_activity,3);

        gridView1.setAdapter(adapter21);
        gridView2.setAdapter(adapter22);
        gridView3.setAdapter(adapter23);
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