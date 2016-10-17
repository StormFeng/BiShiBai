package com.bishilai.bishilai.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bishilai.bishilai.R;

import midian.baselib.base.BaseFragment;

/**
 * Fragment2
 * Created by Alex on 2016/5/19.
 */
public class Fragment2 extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_tab2,null);
        return v;
    }
}