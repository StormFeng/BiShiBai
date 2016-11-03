package com.bishilai.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.utils.HelpUtil;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseActivity;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;

/**
 * 忘记密码
 * Created by Administrator on 2016/10/26 0026.
 */

public class ActivityForgetPass extends BaseActivity {


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
    @BindView(R.id.btn_Confirm)
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);
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
        topbar.setTitle("忘记密码");
    }

    @OnClick({R.id.btn_Code, R.id.btn_Confirm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Code:
                HelpUtil.downTime(btnCode);
                break;
            case R.id.btn_Confirm:
                break;
        }
    }


}
