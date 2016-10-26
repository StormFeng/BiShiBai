package com.bishilai.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.bishilai.bishilai.R;

import midian.baselib.bean.NetResult;
import midian.baselib.view.BaseTpl;

/**
 * 待收货
 */
public class FragmentReadyReceiveTpl extends BaseTpl<NetResult> {

    public FragmentReadyReceiveTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FragmentReadyReceiveTpl(Context context) {
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
