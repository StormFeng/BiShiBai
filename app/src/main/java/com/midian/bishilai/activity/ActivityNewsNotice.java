package com.midian.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;
import com.midian.bishilai.R;
import com.jaeger.library.StatusBarUtil;
import com.kyleduo.switchbutton.SwitchButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 消息通知
 * Created by Administrator on 2016/10/26 0026.
 */

public class ActivityNewsNotice extends BaseActivity {


    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.btn_SwitchNews)
    SwitchButton btnSwitchNews;
    @BindView(R.id.btn_SwitchSound)
    SwitchButton btnSwitchSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsnotice);
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
        topbar.setTitle("消息通知");
    }

    @OnClick({R.id.btn_SwitchNews, R.id.btn_SwitchSound})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_SwitchNews:
                break;
            case R.id.btn_SwitchSound:
                break;
        }
    }
}
