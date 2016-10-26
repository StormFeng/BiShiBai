package com.bishilai.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.bishilai.bishilai.R;

import midian.baselib.bean.NetResult;
import midian.baselib.view.BaseTpl;

/**
 * 我的银行卡
 */
public class ActivityMyNewsTpl extends BaseTpl<NetResult> {

    public ActivityMyNewsTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ActivityMyNewsTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.item_card;
    }

    @Override
    public void setBean(NetResult bean, int position) {
    }
}
