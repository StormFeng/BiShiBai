package com.bishilai.bishilai.fragments;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.datasource.FramentReadyPayDataResource;
import com.bishilai.bishilai.datasource.FramentReadyReceiveDataResource;
import com.bishilai.bishilai.tpl.FragmentReadyPayTpl;
import com.bishilai.bishilai.tpl.FragmentReadyReceiveTpl;

import java.util.ArrayList;

import midian.baselib.base.BaseListFragment;
import midian.baselib.shizhefei.view.listviewhelper.IDataSource;

/**
 * 待收货
 * Created by Administrator on 2016/10/26 0026.
 */

public class FragmentReadyReceive extends BaseListFragment{


    @Override
    protected int getLayoutId() {
        return R.layout.base_putorefreshlistview;
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new FramentReadyReceiveDataResource(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        listView.setDivider(null);
        return FragmentReadyReceiveTpl.class;
    }
}
