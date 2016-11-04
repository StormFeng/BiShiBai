package com.midian.bishilai.fragments;

import com.midian.bishilai.R;
import com.midian.bishilai.datasource.FramentReadyCommentDataResource;
import com.midian.bishilai.datasource.FramentReadyReceiveDataResource;
import com.midian.bishilai.tpl.FragmentReadyCommentTpl;
import com.midian.bishilai.tpl.FragmentReadyReceiveTpl;

import java.util.ArrayList;

import midian.baselib.base.BaseListFragment;
import midian.baselib.shizhefei.view.listviewhelper.IDataSource;

/**
 * 待评价
 * Created by Administrator on 2016/10/26 0026.
 */

public class FragmentReadyComment extends BaseListFragment{


    @Override
    protected int getLayoutId() {
        return R.layout.base_putorefreshlistview;
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new FramentReadyCommentDataResource(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        listView.setDivider(null);
        return FragmentReadyCommentTpl.class;
    }
}
