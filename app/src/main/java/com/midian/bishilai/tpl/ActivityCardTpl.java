package com.midian.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.midian.bishilai.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.bean.NetResult;
import midian.baselib.view.BaseTpl;

/**
 * 我的银行卡
 */
public class ActivityCardTpl extends BaseTpl<NetResult> {

    public ActivityCardTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ActivityCardTpl(Context context) {
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
