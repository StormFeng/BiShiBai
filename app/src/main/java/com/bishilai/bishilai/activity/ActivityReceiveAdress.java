package com.bishilai.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.datasource.ActivityReceiveAdressDataResource;
import com.bishilai.bishilai.tpl.ActivityReceiveAdressTpl;
import com.jaeger.library.StatusBarUtil;
import java.util.ArrayList;
import midian.baselib.base.BaseListActivity;
import midian.baselib.shizhefei.view.listviewhelper.IDataSource;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;

/**
 * 收货地址
 * Created by Administrator on 2016/10/27 0027.
 */

public class ActivityReceiveAdress  extends BaseListActivity{

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
        topbar.setRightImageButton(R.drawable.icon_add,UIHelper.OnClickJump(_activity,ActivityAddAdress.class));
        topbar.setTitle("收货地址");
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new ActivityReceiveAdressDataResource(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        return ActivityReceiveAdressTpl.class;
    }
}
