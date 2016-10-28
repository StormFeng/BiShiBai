package com.bishilai.bishilai.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.activity.ActivityBook;
import com.bishilai.bishilai.activity.ActivityCoupon;
import com.bishilai.bishilai.activity.ActivityMyNews;
import com.bishilai.bishilai.activity.ActivityMyWallet;
import com.bishilai.bishilai.activity.ActivitySetting;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseFragment;
import midian.baselib.utils.UIHelper;

/**
 * 我的
 */
public class Fragment4 extends BaseFragment {

    @BindView(R.id.tv_Account)
    TextView tvAccount;
    @BindView(R.id.iv_Login)
    RoundedImageView ivLogin;
    @BindView(R.id.tv_AllBook)
    TextView tvAllBook;
    @BindView(R.id.tv_ReadyPay)
    TextView tvReadyPay;
    @BindView(R.id.tv_ReadyReceive)
    TextView tvReadyReceive;
    @BindView(R.id.tv_ReadyComment)
    TextView tvReadyComment;
    @BindView(R.id.tv_Wallet)
    TextView tvWallet;
    @BindView(R.id.tv_Collect)
    TextView tvCollect;
    @BindView(R.id.tv_News)
    TextView tvNews;
    @BindView(R.id.tv_Vip)
    TextView tvVip;
    @BindView(R.id.tv_Coupon)
    TextView tvCoupon;
    @BindView(R.id.tv_Setting)
    TextView tvSetting;
    @BindView(R.id.ll_News)
    LinearLayout llNews;
    @BindView(R.id.ll_Vip)
    LinearLayout llVip;
    @BindView(R.id.ll_Coupon)
    LinearLayout llCoupon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab4, null);
        ButterKnife.bind(this, v);
        return v;
    }

    @OnClick({R.id.iv_Login, R.id.tv_AllBook, R.id.tv_ReadyPay, R.id.tv_ReadyReceive, R.id.tv_ReadyComment, R.id.tv_Wallet, R.id.tv_Collect, R.id.ll_News, R.id.ll_Vip, R.id.ll_Coupon, R.id.tv_Setting})
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.iv_Login:
                break;
            case R.id.tv_AllBook:
                bundle.putString("position", "0");
                UIHelper.jump(_activity, ActivityBook.class, bundle);
                break;
            case R.id.tv_ReadyPay:
                bundle.putString("position", "1");
                UIHelper.jump(_activity, ActivityBook.class, bundle);
                break;
            case R.id.tv_ReadyReceive:
                bundle.putString("position", "2");
                UIHelper.jump(_activity, ActivityBook.class, bundle);
                break;
            case R.id.tv_ReadyComment:
                bundle.putString("position", "3");
                UIHelper.jump(_activity, ActivityBook.class, bundle);
                break;
            case R.id.tv_Wallet:
                UIHelper.jump(_activity, ActivityMyWallet.class);
                break;
            case R.id.tv_Collect:
                break;
            case R.id.ll_News:
                UIHelper.jump(_activity, ActivityMyNews.class);
                break;
            case R.id.ll_Vip:
                break;
            case R.id.ll_Coupon:
                UIHelper.jump(_activity, ActivityCoupon.class);
                break;
            case R.id.tv_Setting:
                UIHelper.jump(_activity, ActivitySetting.class);
                break;
        }
    }
}