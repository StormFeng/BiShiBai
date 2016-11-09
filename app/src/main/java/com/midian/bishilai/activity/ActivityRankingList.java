package com.midian.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;

import com.jaeger.library.StatusBarUtil;
import com.midian.bishilai.R;
import com.midian.bishilai.adapter.AdapterGridViewRankingList;
import com.midian.bishilai.widget.SelectView;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.base.BaseActivity;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;

/**
 * 排行榜
 * Created by Administrator on 2016/11/1 0001.
 */

public class ActivityRankingList extends BaseActivity {

    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.gridView)
    GridView gridView;
    @BindView(R.id.selectView)
    SelectView selectView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankinglist);
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
        topbar.setTitle("排行榜");

        gridView.setAdapter(new AdapterGridViewRankingList(_activity));
        selectView.setVisibility(View.GONE);
    }
}
