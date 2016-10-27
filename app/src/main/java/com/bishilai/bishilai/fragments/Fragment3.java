package com.bishilai.bishilai.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.adapter.ExpandableListAdapter;
import com.bishilai.bishilai.widget.SmoothCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseFragment;
import midian.baselib.widget.BaseLibTopbarView;

import static midian.baselib.widget.BaseLibTopbarView.MODE_WITH_INPUT;

/**
 * 购物车
 */
public class Fragment3 extends BaseFragment {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    @BindView(R.id.cb_SelectAll)
    SmoothCheckBox cbSelectAll;
    @BindView(R.id.tv_AllMoney)
    TextView tvAllMoney;
    @BindView(R.id.tv_Transport)
    TextView tvTransport;
    @BindView(R.id.btn_Settlement)
    Button btnSettlement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab3, null);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {
        topbar.setBackgroundColor(getResources().getColor(R.color.green));
        topbar.setTitle("购物车");
        topbar.setRightText("编辑",null);
        expandableListView.setGroupIndicator(null);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return true;
            }
        });
        expandableListView.setAdapter(new ExpandableListAdapter(_activity));
        for(int i=0;i<9;i++){
            expandableListView.expandGroup(i);
        }
    }

    @OnClick({R.id.cb_SelectAll, R.id.btn_Settlement})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cb_SelectAll:
                break;
            case R.id.btn_Settlement:
                break;
        }
    }
}