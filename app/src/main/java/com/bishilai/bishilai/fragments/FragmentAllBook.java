package com.bishilai.bishilai.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.datasource.FramentAllBookDataResource;
import com.bishilai.bishilai.tpl.FragmentAllBookTpl;

import java.util.ArrayList;
import midian.baselib.base.BaseListFragment;
import midian.baselib.shizhefei.view.listviewhelper.IDataSource;

/**
 * 全部订单
 * Created by Administrator on 2016/10/26 0026.
 */

public class FragmentAllBook extends BaseListFragment{


    @Override
    protected int getLayoutId() {
        return R.layout.base_putorefreshlistview;
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new FramentAllBookDataResource(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        listView.setDivider(null);
        return FragmentAllBookTpl.class;
    }
}
