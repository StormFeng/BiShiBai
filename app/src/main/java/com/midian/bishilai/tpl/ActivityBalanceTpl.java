package com.midian.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.midian.bishilai.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.bean.NetResult;
import midian.baselib.view.BaseTpl;

public class ActivityBalanceTpl extends BaseTpl<NetResult> {

    @BindView(R.id.tv_Type)
    TextView tvType;
    @BindView(R.id.tv_Time)
    TextView tvTime;
    @BindView(R.id.tv_Money)
    TextView tvMoney;

    public ActivityBalanceTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ActivityBalanceTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.item_bonus;
    }

    @Override
    public void setBean(NetResult bean, int position) {
        if (bean != null) {
            tvType.setText("推荐奖金");
        }
    }
}
