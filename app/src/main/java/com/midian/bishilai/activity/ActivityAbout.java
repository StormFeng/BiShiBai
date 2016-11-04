package com.midian.bishilai.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.midian.bishilai.R;
import com.midian.bishilai.widget.ShareDialog;
import com.jaeger.library.StatusBarUtil;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.utils.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseActivity;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;

/**
 * 关于
 * Created by Administrator on 2016/10/26 0026.
 */

public class ActivityAbout extends BaseActivity {

    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.ll_Update)
    LinearLayout llUpdate;
    @BindView(R.id.ll_Advice)
    LinearLayout llAdvice;
    @BindView(R.id.ll_Share)
    LinearLayout llShare;
    @BindView(R.id.tv_Name)
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
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
        topbar.setTitle("关于碧诗莱");
    }

    @OnClick({R.id.ll_Update, R.id.ll_Advice, R.id.ll_Share})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_Update:
                break;
            case R.id.ll_Advice:
                break;
            case R.id.ll_Share:
                new ShareDialog(_activity).show();
                break;
        }
    }
}
