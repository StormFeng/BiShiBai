package com.midian.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;
import com.midian.bishilai.R;


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
        return R.layout.item_mynews;
    }

    @Override
    public void setBean(NetResult bean, int position) {
    }
}
