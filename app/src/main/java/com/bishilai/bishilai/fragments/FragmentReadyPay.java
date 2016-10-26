package com.bishilai.bishilai.fragments;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.datasource.FramentAllBookDataResource;
import com.bishilai.bishilai.datasource.FramentReadyPayDataResource;
import com.bishilai.bishilai.tpl.FragmentAllBookTpl;
import com.bishilai.bishilai.tpl.FragmentReadyPayTpl;

import java.util.ArrayList;

import midian.baselib.base.BaseListFragment;
import midian.baselib.shizhefei.view.listviewhelper.IDataSource;

/**
 * 待付款
 * Created by Administrator on 2016/10/26 0026.
 */

public class FragmentReadyPay extends BaseListFragment{


    @Override
    protected int getLayoutId() {
        return R.layout.base_putorefreshlistview;
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new FramentReadyPayDataResource(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        listView.setDivider(null);
        return FragmentReadyPayTpl.class;
    }
}
