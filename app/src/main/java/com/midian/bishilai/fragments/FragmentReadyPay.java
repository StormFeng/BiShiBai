package com.midian.bishilai.fragments;

import com.midian.base.base.BaseListFragment;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;
import com.midian.bishilai.R;
import com.midian.bishilai.datasource.FramentReadyPayDataResource;
import com.midian.bishilai.tpl.FragmentReadyPayTpl;

import java.util.ArrayList;

/**
 * 待付款
 * Created by Administrator on 2016/10/26 0026.
 */

public class FragmentReadyPay extends BaseListFragment {


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
