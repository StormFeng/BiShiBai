package com.midian.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.midian.base.widget.PhotoPicker.PhotoPicker;
import com.midian.bishilai.R;
import com.jaeger.library.StatusBarUtil;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseActivity;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;

/**
 * Created by Administrator on 2016/10/26 0026.
 */

public class ActivityPersonalData extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.iv_Head)
    RoundedImageView ivHead;
    @BindView(R.id.ll_Head)
    LinearLayout llHead;
    @BindView(R.id.tv_Name)
    TextView tvName;
    @BindView(R.id.ll_Name)
    LinearLayout llName;
    @BindView(R.id.tv_Sex)
    TextView tvSex;
    @BindView(R.id.ll_Sex)
    LinearLayout llSex;
    @BindView(R.id.tv_Birthday)
    TextView tvBirthday;
    @BindView(R.id.ll_BirthDay)
    LinearLayout llBirthDay;
    @BindView(R.id.tv_Number)
    TextView tvNumber;
    @BindView(R.id.ll_Phone)
    LinearLayout llPhone;
    @BindView(R.id.tv_CardId)
    TextView tvCardId;
    @BindView(R.id.ll_CardId)
    LinearLayout llCardId;
    @BindView(R.id.ll_ReceiveAdress)
    LinearLayout llReceiveAdress;
    @BindView(R.id.tv_MemberType)
    TextView tvMemberType;
    @BindView(R.id.ll_MemberType)
    LinearLayout llMemberType;
    @BindView(R.id.tv_MemberId)
    TextView tvMemberId;
    @BindView(R.id.ll_MemberId)
    LinearLayout llMemberId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldata);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
            StatusBarUtil.setTranslucentForImageViewInFragment(_activity, 0, null);
        }

        topbar=findView(R.id.topbar);
        topbar.setBackgroundColor(getResources().getColor(R.color.green));
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        topbar.setTitle("个人资料");
    }

    @OnClick({R.id.ll_Head, R.id.ll_Name, R.id.ll_Sex, R.id.ll_BirthDay, R.id.ll_Phone, R.id.ll_CardId, R.id.ll_ReceiveAdress, R.id.ll_MemberType, R.id.ll_MemberId})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_Head:
                PhotoPicker.builder()
                        .setPhotoCount(9)
                        .setGridColumnCount(4)
                        .start(this);
                break;
            case R.id.ll_Name:
                break;
            case R.id.ll_Sex:
                break;
            case R.id.ll_BirthDay:
                break;
            case R.id.ll_Phone:
                break;
            case R.id.ll_CardId:
                break;
            case R.id.ll_ReceiveAdress:
                break;
            case R.id.ll_MemberType:
                break;
            case R.id.ll_MemberId:
                break;
        }
    }
}
