package com.midian.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;
import com.midian.bishilai.R;
import com.midian.bishilai.utils.HelpUtil;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册
 * Created by Administrator on 2016/10/26 0026.
 */

public class ActivityRegister extends BaseActivity {


    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.et_Phone)
    EditText etPhone;
    @BindView(R.id.btn_Code)
    Button btnCode;
    @BindView(R.id.et_Code)
    EditText etCode;
    @BindView(R.id.et_NewPass)
    EditText etNewPass;
    @BindView(R.id.et_Invitation)
    EditText etInvitation;
    @BindView(R.id.btn_Register)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
            StatusBarUtil.setTranslucentForImageViewInFragment(_activity, 0, null);
        }

        topbar = findView(R.id.topbar);
        topbar.setBackgroundColor(getResources().getColor(R.color.green));
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        topbar.setTitle("注册");
    }

    @OnClick({R.id.btn_Code, R.id.btn_Register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Code:
                HelpUtil.downTime(btnCode);
                break;
            case R.id.btn_Register:
                break;
        }
    }
}
