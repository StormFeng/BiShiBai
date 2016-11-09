package com.midian.bishilai.tpl;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.midian.base.bean.NetResult;
import com.midian.base.util.UIHelper;
import com.midian.base.view.BaseTpl;
import com.midian.bishilai.R;
import com.midian.bishilai.activity.ActivityBookDetail;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 全部订单
 */
public class FragmentAllBookTpl extends BaseTpl<NetResult> {

    @BindView(R.id.tv_BookNumber)
    TextView tvBookNumber;
    @BindView(R.id.tv_Status)
    TextView tvStatus;
    @BindView(R.id.iv_Good)
    ImageView ivGood;
    @BindView(R.id.tv_Name)
    TextView tvName;
    @BindView(R.id.tv_Count)
    TextView tvCount;
    @BindView(R.id.tv_Price)
    TextView tvPrice;
    @BindView(R.id.btn_Cancel)
    Button btnCancel;
    @BindView(R.id.btn_Confirm)
    Button btnConfirm;
    @BindView(R.id.ll_Item)
    LinearLayout llItem;

    public FragmentAllBookTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FragmentAllBookTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.item_book;
    }

    @Override
    public void setBean(NetResult bean, int position) {
    }

    @OnClick({R.id.btn_Cancel, R.id.btn_Confirm, R.id.ll_Item})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Cancel:
                break;
            case R.id.btn_Confirm:
                break;
            case R.id.ll_Item:
                Bundle bundle=new Bundle();
                bundle.putString("flag","全部订单");
                UIHelper.jump(_activity, ActivityBookDetail.class,bundle);
                break;
        }
    }
}
