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
import com.midian.bishilai.datasource.ActivityCouponDataResource;
import com.midian.bishilai.datasource.ActivityMyNewsDataResource;
import com.midian.bishilai.tpl.ActivityCouponTpl;
import com.midian.bishilai.tpl.ActivityMyNewsTpl;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

/**
 * 优惠券
 * Created by Administrator on 2016/10/25 0025.
 */

public class ActivityCoupon extends BaseListActivity {

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
        topbar.setTitle("优惠券");
        listView.setDivider(null);
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new ActivityCouponDataResource(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        return ActivityCouponTpl.class;
    }
}
