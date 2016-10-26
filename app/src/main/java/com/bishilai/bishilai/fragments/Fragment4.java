package com.bishilai.bishilai.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.activity.ActivityMyWallet;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseFragment;
import midian.baselib.utils.UIHelper;

/**
 * Fragment4
 * Created by Alex on 2016/5/19.
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab4, null);
        ButterKnife.bind(this, v);
        return v;
    }

    @OnClick({R.id.iv_Login, R.id.tv_AllBook, R.id.tv_ReadyPay, R.id.tv_ReadyReceive, R.id.tv_ReadyComment, R.id.tv_Wallet, R.id.tv_Collect, R.id.tv_News, R.id.tv_Vip, R.id.tv_Coupon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_Login:
                break;
            case R.id.tv_AllBook:
                break;
            case R.id.tv_ReadyPay:
                break;
            case R.id.tv_ReadyReceive:
                break;
            case R.id.tv_ReadyComment:
                break;
            case R.id.tv_Wallet:
                UIHelper.jump(_activity, ActivityMyWallet.class);
                break;
            case R.id.tv_Collect:
                break;
            case R.id.tv_News:
                break;
            case R.id.tv_Vip:
                break;
            case R.id.tv_Coupon:
                break;
        }
    }
}