package com.bishilai.bishilai.activity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.adapter.AdapterGridView13;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseActivity;
import midian.baselib.widget.BaseLibTopbarView;
import midian.baselib.widget.pulltorefresh.PullToRefreshListView;

/**
 * Created by Administrator on 2016/10/18 0018.
 */

public class ActivitySearchResult extends BaseActivity {

    @BindView(R.id.tv_Search)
    TextView tvSearch;
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.gridView)
    GridView gridView;

    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
        StatusBarUtil.setTranslucentForImageView(_activity, 0, null);
        topbar.setBackgroundColor(getResources().getColor(R.color.orange));
        topbar.setLeftImageButton(R.drawable.icon_back,listener);
        topbar.setLeftText("Title",listener);
        topbar.setTitle("");

        gridView.setAdapter(new AdapterGridView13(_activity));
    }

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    @OnClick(R.id.tv_Search)
    public void onClick() {
        View v = getLayoutInflater().inflate(R.layout.menu_list, null);
        showMenu(tvSearch, v);
    }

    private void showMenu(View parent, View contentView) {
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int width = manager.getDefaultDisplay().getWidth();
        popupWindow = new PopupWindow(contentView, width, 600);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        popupWindow.showAsDropDown(parent, 0, 30);
    }
}
