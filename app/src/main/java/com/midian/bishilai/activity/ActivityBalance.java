package com.midian.bishilai.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.midian.bishilai.R;
import com.midian.bishilai.datasource.ActivityBalanceDataResource;
import com.midian.bishilai.tpl.ActivityBalanceTpl;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import midian.baselib.base.BaseListActivity;
import midian.baselib.shizhefei.view.listviewhelper.IDataAdapter;
import midian.baselib.shizhefei.view.listviewhelper.IDataSource;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;

/**
 * Created by Administrator on 2016/10/25 0025.
 */

/**
 * 我的余额明细
 */
public class ActivityBalance extends BaseListActivity {

    private BaseLibTopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        topbar.setTitle("余额明细");
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new ActivityBalanceDataResource(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        return ActivityBalanceTpl.class;
    }

}
