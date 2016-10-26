package com.bishilai.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.bishilai.bishilai.R;

import midian.baselib.bean.NetResult;
import midian.baselib.view.BaseTpl;

/**
 * 优惠券
 */
public class ActivityCouponTpl extends BaseTpl<NetResult> {

    public ActivityCouponTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ActivityCouponTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.item_coupon;
    }

    @Override
    public void setBean(NetResult bean, int position) {
    }
}
