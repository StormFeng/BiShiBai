package com.midian.bishilai.activity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.PopupWindow;

import com.jaeger.library.StatusBarUtil;
import com.midian.bishilai.R;
import com.midian.bishilai.adapter.AdapterGridViewSpringHealth;
import com.midian.bishilai.widget.SelectView;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.base.BaseActivity;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;

/**
 * 春季养生
 * Created by Administrator on 2016/11/1 0001.
 */

public class ActivitySpringHealth extends BaseActivity implements SelectView.onStatusChangeListener {

    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.gridView)
    GridView gridView;
    @BindView(R.id.selectView)
    SelectView selectView;
    @BindView(R.id.view)
    View view;

    private PopupWindow popupWindow;
    private View menu;

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
        topbar.setTitle("春季养生");

        gridView.setAdapter(new AdapterGridViewSpringHealth(_activity));

        menu = LayoutInflater.from(_activity).inflate(R.layout.layout_popup, null);
        String[] tabs = {"推荐", "新品", "价格", "筛选"};
        selectView.init(tabs);
        selectView.setOnStatusChangeListener(this);
    }

    @Override
    public void onStatusChange(int position, boolean... status) {
        UIHelper.t(_activity, "tab" + position + "被选中");
        switch (position) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                if (status[0]) {
                    showMenu(selectView, menu);
                } else {
                    view.setVisibility(View.GONE);
                    popupWindow.dismiss();
                }
                break;
        }
    }

    private void showMenu(View parent, View contentView) {
        view.setVisibility(View.VISIBLE);
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int width = manager.getDefaultDisplay().getWidth();
        popupWindow = new PopupWindow(contentView, width, 600);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        popupWindow.showAsDropDown(parent, 0, 30);
    }


    @Override
    public void onBackPressed() {
        if(popupWindow.isShowing()){
            selectView.getTextView(3).performClick();
            return;
        }
        super.onBackPressed();
    }
}
