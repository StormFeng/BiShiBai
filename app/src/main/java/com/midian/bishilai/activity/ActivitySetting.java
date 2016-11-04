package com.midian.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
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
 * Created by Administrator on 2016/10/26 0026.
 */

public class ActivitySetting extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.tv_PersonlData)
    TextView tvPersonlData;
    @BindView(R.id.tv_ChangePass)
    TextView tvChangePass;
    @BindView(R.id.tv_ReceiveAdress)
    TextView tvReceiveAdress;
    @BindView(R.id.tv_NewsNotice)
    TextView tvNewsNotice;
    @BindView(R.id.tv_AboutCompany)
    TextView tvAboutCompany;
    @BindView(R.id.btn_SignOut)
    Button btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
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
        topbar.setTitle("系统设置");
    }

    @OnClick({R.id.tv_PersonlData, R.id.tv_ChangePass, R.id.tv_ReceiveAdress, R.id.tv_NewsNotice, R.id.tv_AboutCompany, R.id.btn_SignOut})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_PersonlData:
                UIHelper.jump(_activity,ActivityPersonalData.class);
                break;
            case R.id.tv_ChangePass:
                UIHelper.jump(_activity,ActivityChangePass.class);
                break;
            case R.id.tv_ReceiveAdress:
                UIHelper.jump(_activity,ActivityReceiveAdress.class);
                break;
            case R.id.tv_NewsNotice:
                UIHelper.jump(_activity,ActivityNewsNotice.class);
                break;
            case R.id.tv_AboutCompany:
                UIHelper.jump(_activity,ActivityAbout.class);
                break;
            case R.id.btn_SignOut:
                break;
        }
    }
}
