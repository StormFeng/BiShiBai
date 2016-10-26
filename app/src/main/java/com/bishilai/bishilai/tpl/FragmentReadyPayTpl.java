package com.bishilai.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.bishilai.bishilai.R;

import midian.baselib.bean.NetResult;
import midian.baselib.view.BaseTpl;

/**
 * 待付款
 */
public class FragmentReadyPayTpl extends BaseTpl<NetResult> {

    public FragmentReadyPayTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FragmentReadyPayTpl(Context context) {
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
