package com.bishilai.bishilai.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bishilai.bishilai.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.base.BaseFragment;
import midian.baselib.widget.BaseLibTopbarView;

import static midian.baselib.widget.BaseLibTopbarView.MODE_WITH_INPUT;

/**
 * Fragment3
 * Created by Alex on 2016/5/19.
 */
public class Fragment3 extends BaseFragment {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab3, null);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {
        topbar.setBackgroundColor(getResources().getColor(R.color.orange));
        topbar.setMode(MODE_WITH_INPUT);
    }
}