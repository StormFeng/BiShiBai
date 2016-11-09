package com.midian.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;
import com.midian.bishilai.R;


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
