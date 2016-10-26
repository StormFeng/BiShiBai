package com.bishilai.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.bishilai.bishilai.R;

import midian.baselib.bean.NetResult;
import midian.baselib.view.BaseTpl;

/**
 * 待评价
 */
public class FragmentReadyCommentTpl extends BaseTpl<NetResult> {

    public FragmentReadyCommentTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FragmentReadyCommentTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.item_book;
    }

    @Override
    public void setBean(NetResult bean, int position) {
    }
}
