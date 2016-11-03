package com.bishilai.bishilai.tpl;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.activity.ActivityBookDetail;
import com.bishilai.bishilai.widget.NoticeDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.bean.NetResult;
import midian.baselib.utils.UIHelper;
import midian.baselib.view.BaseTpl;

/**
 * 待收货
 */
public class FragmentReadyReceiveTpl extends BaseTpl<NetResult> {

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

    public FragmentReadyReceiveTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FragmentReadyReceiveTpl(Context context) {
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
        btnCancel.setText("查看物流");
        btnConfirm.setText("确认收货");
        btnConfirm.setTextColor(getResources().getColor(R.color.bsl_red));
        btnConfirm.setBackgroundResource(R.drawable.bg_4stroke_grey);
    }

    @OnClick({R.id.btn_Cancel, R.id.btn_Confirm, R.id.ll_Item})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Cancel:
                NoticeDialog noticeDialog = new NoticeDialog(_activity);
                noticeDialog.getOkButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UIHelper.t(_activity,"确认");
                    }
                });
                noticeDialog.setNoticeContent("确认取消该订单吗？").show();
                break;
            case R.id.btn_Confirm:
                break;
            case R.id.ll_Item:
                Bundle bundle=new Bundle();
                bundle.putString("flag","待收货");
                UIHelper.jump(_activity, ActivityBookDetail.class,bundle);
                break;
        }
    }
}
