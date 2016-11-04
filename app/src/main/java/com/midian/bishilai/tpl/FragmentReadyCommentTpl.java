package com.midian.bishilai.tpl;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.midian.bishilai.R;
import com.midian.bishilai.activity.ActivityBookDetail;
import com.midian.bishilai.widget.NoticeDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.bean.NetResult;
import midian.baselib.utils.UIHelper;
import midian.baselib.view.BaseTpl;

/**
 * 待评价
 */
public class FragmentReadyCommentTpl extends BaseTpl<NetResult> {

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

    public FragmentReadyCommentTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FragmentReadyCommentTpl(Context context) {
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
        btnCancel.setText("删除订单");
        btnConfirm.setText("去评价");
        btnConfirm.setTextColor(getResources().getColor(R.color.green));
        btnConfirm.setBackgroundResource(R.drawable.bg_4stroke_grey);
    }

    @OnClick({R.id.btn_Cancel, R.id.btn_Confirm, R.id.ll_Item})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Cancel:
                NoticeDialog noticeDialog = new NoticeDialog(_activity);
                noticeDialog.getOkButton().setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UIHelper.t(_activity,"确认");
                    }
                });
                noticeDialog.setNoticeContent("确认删除该订单吗？").show();
                break;
            case R.id.btn_Confirm:
                break;
            case R.id.ll_Item:
                Bundle bundle=new Bundle();
                bundle.putString("flag","待评价");
                UIHelper.jump(_activity, ActivityBookDetail.class,bundle);
                break;
        }
    }
}
