package com.midian.bishilai.fragments;

import com.midian.base.base.BaseListFragment;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;
import com.midian.bishilai.R;
import com.midian.bishilai.datasource.FramentReadyPayDataResource;
import com.midian.bishilai.datasource.FramentReadyReceiveDataResource;
import com.midian.bishilai.tpl.FragmentReadyPayTpl;
import com.midian.bishilai.tpl.FragmentReadyReceiveTpl;

import java.util.ArrayList;


/**
 * 待收货
 * Created by Administrator on 2016/10/26 0026.
 */

public class FragmentReadyReceive extends BaseListFragment {


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
