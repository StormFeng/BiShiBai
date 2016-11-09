package com.midian.bishilai.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midian.base.base.BaseListFragment;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;
import com.midian.bishilai.R;
import com.midian.bishilai.datasource.FramentAllBookDataResource;
import com.midian.bishilai.tpl.FragmentAllBookTpl;

import java.util.ArrayList;

/**
 * 全部订单
 * Created by Administrator on 2016/10/26 0026.
 */

public class FragmentAllBook extends BaseListFragment {


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
