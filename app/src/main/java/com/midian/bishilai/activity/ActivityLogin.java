package com.midian.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.bishilai.R;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录
 * Created by Administrator on 2016/10/26 0026.
 */

public class ActivityLogin extends BaseActivity {

    @BindView(R.id.et_Phone)
    EditText etPhone;
    @BindView(R.id.et_Pass)
    EditText etPass;
    @BindView(R.id.tv_ForgetPass)
    TextView tvForgetPass;
    @BindView(R.id.btn_Login)
    Button btnLogin;
    @BindView(R.id.iv_WeChat)
    ImageView ivWeChat;
    @BindView(R.id.iv_QQ)
    ImageView ivQQ;
    @BindView(R.id.iv_Sina)
    ImageView ivSina;
    @BindView(R.id.tv_Register)
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
            StatusBarUtil.setTranslucentForImageViewInFragment(_activity, 0, null);
        }
    }

    @OnClick({R.id.btn_Login, R.id.iv_WeChat, R.id.iv_QQ, R.id.iv_Sina, R.id.tv_Register, R.id.tv_ForgetPass})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Login:
                break;
            case R.id.tv_Register:
                UIHelper.jump(_activity,ActivityRegister.class);
                break;
            case R.id.tv_ForgetPass:
                UIHelper.jump(_activity,ActivityForgetPass.class);
                break;
            case R.id.iv_WeChat:
                break;
            case R.id.iv_QQ:
                break;
            case R.id.iv_Sina:
                break;
        }
    }
}
