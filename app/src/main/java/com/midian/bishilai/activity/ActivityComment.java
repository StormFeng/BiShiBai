package com.midian.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.midian.base.base.BaseMultiTypeListActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;
import com.midian.bishilai.R;
import com.midian.bishilai.datasource.CommentDataResource;
import com.midian.bishilai.tpl.CommentBotTpl;
import com.midian.bishilai.tpl.CommentTopTpl;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 评论列表页面
 * Created by Administrator on 2016/10/20 0020.
 */

public class ActivityComment extends BaseMultiTypeListActivity {

    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
            StatusBarUtil.setTranslucentForImageViewInFragment(_activity, 0, null);
        }
        topbar.setTitle("");
        topbar.setBackgroundColor(getResources().getColor(R.color.orange));
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        topbar.setLeftText("商品评价",UIHelper.finish(_activity));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_comment;
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new CommentDataResource(_activity);
    }

    @Override
    protected ArrayList<Class> getTemplateClasses() {
        ArrayList tpls = new ArrayList();
        tpls.add(CommentTopTpl.class);
        tpls.add(CommentBotTpl.class);
        return tpls;
    }
}
