package com.bishilai.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.activity.ActivityBookDetail;
import com.bishilai.bishilai.activity.ActivityGoodDetail;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.bean.NetResult;
import midian.baselib.utils.UIHelper;
import midian.baselib.view.BaseTpl;

/**
 * 待付款
 */
public class FragmentReadyPayTpl extends BaseTpl<NetResult> {

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

    public FragmentReadyPayTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FragmentReadyPayTpl(Context context) {
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
                UIHelper.jump(_activity, ActivityBookDetail.class);
                break;
        }
    }
}
