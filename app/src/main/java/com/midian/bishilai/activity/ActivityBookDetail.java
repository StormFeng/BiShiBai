package com.midian.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.midian.bishilai.R;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseActivity;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;

/**
 * 订单详情
 * Created by Administrator on 2016/10/27 0027.
 */

public class ActivityBookDetail extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.tv_Status)
    TextView tvStatus;
    @BindView(R.id.tv_Description)
    TextView tvDescription;
    @BindView(R.id.tv_BookStatus)
    TextView tvBookStatus;
    @BindView(R.id.tv_Time)
    TextView tvTime;
    @BindView(R.id.ll_Book)
    LinearLayout llBook;
    @BindView(R.id.tv_ReceivePeople)
    TextView tvReceivePeople;
    @BindView(R.id.tv_Phone)
    TextView tvPhone;
    @BindView(R.id.tv_ReceiveAdress)
    TextView tvReceiveAdress;
    @BindView(R.id.tvDeliverAdress)
    TextView tvDeliverAdress;
    @BindView(R.id.iv_Good)
    ImageView ivGood;
    @BindView(R.id.tv_GoodName)
    TextView tvGoodName;
    @BindView(R.id.tv_Price)
    TextView tvPrice;
    @BindView(R.id.tv_Count)
    TextView tvCount;
    @BindView(R.id.tv_AllGoodMoney)
    TextView tvAllGoodMoney;
    @BindView(R.id.tv_ShippingPrice)
    TextView tvShippingPrice;
    @BindView(R.id.tv_AllMoney)
    TextView tvAllMoney;
    @BindView(R.id.tv_BookNumber)
    TextView tvBookNumber;
    @BindView(R.id.tv_AllMoneyToPay)
    TextView tvAllMoneyToPay;
    @BindView(R.id.btn_Cancel)
    Button btnCancel;
    @BindView(R.id.btn_Ok)
    Button btnOk;

    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookdetail);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
            StatusBarUtil.setTranslucentForImageViewInFragment(_activity, 0, null);
        }

        flag = mBundle.getString("flag");
        if ("待评价".equals(flag)) {
            llBook.setVisibility(View.GONE);
        }

        topbar = findView(R.id.topbar);
        topbar.setBackgroundColor(getResources().getColor(R.color.green));
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        topbar.setTitle("订单详情");

    }

    @OnClick({R.id.ll_Book, R.id.btn_Cancel, R.id.btn_Ok})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_Book:
                break;
            case R.id.btn_Cancel:
                break;
            case R.id.btn_Ok:
                break;
        }
    }
}
