package com.midian.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.midian.bishilai.R;
import com.jaeger.library.StatusBarUtil;
import com.kyleduo.switchbutton.SwitchButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseActivity;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;

/**
 * 添加收货地址
 * Created by Administrator on 2016/10/27 0027.
 */

public class ActivityAddAdress extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.et_Name)
    EditText etName;
    @BindView(R.id.et_Phone)
    EditText etPhone;
    @BindView(R.id.et_Location)
    EditText etLocation;
    @BindView(R.id.et_Adress)
    EditText etAdress;
    @BindView(R.id.sb_Check)
    SwitchButton sbCheck;
    @BindView(R.id.btn_Save)
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addadress);
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
        topbar.setRightImageButton(R.drawable.icon_add, null);
        topbar.setTitle("收货地址");
    }

    @OnClick({R.id.sb_Check, R.id.btn_Save})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sb_Check:
                break;
            case R.id.btn_Save:
                break;
        }
    }
}
