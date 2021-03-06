package com.midian.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.midian.base.base.BaseListActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;
import com.midian.bishilai.R;
import com.midian.bishilai.datasource.ActivityReceiveAdressDataResource;
import com.midian.bishilai.tpl.ActivityReceiveAdressTpl;
import com.jaeger.library.StatusBarUtil;
import java.util.ArrayList;

/**
 * 收货地址
 * Created by Administrator on 2016/10/27 0027.
 */

public class ActivityReceiveAdress  extends BaseListActivity {

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
