package com.midian.bishilai.fragments;

import com.midian.base.base.BaseListFragment;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;
import com.midian.bishilai.R;
import com.midian.bishilai.datasource.FramentReadyCommentDataResource;
import com.midian.bishilai.tpl.FragmentReadyCommentTpl;
import java.util.ArrayList;

/**
 * 待评价
 * Created by Administrator on 2016/10/26 0026.
 */

public class FragmentReadyComment extends BaseListFragment {


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
