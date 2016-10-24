package com.bishilai.bishilai.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bishilai.bishilai.R;
import com.jaeger.library.StatusBarUtil;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseActivity;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;

import static midian.baselib.widget.BaseLibTopbarView.MODE_WITH_INPUT;

/**
 * Created by Administrator on 2016/10/18 0018.
 */

public class ActivitySearchResult extends BaseActivity {

    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.tag_HotTag)
    TagFlowLayout tagHotTag;//热门搜索标签
    @BindView(R.id.tv_ClearAll)
    LinearLayout tvClearAll;//清空
    @BindView(R.id.tag_HistoryTag)
    TagFlowLayout tagHistoryTag;//历史搜索标签

    private List<String> hotTagString=new ArrayList<>();
    private List<String> historyTagString=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
        StatusBarUtil.setTranslucentForImageView(_activity, 0, null);
        topbar.setMode(MODE_WITH_INPUT);
        topbar.setBackgroundColor(getResources().getColor(R.color.green));
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        topbar.setRightText("搜索", listener);

        hotTagString.add("丰胸乳液");
        hotTagString.add("减肥套餐包");
        hotTagString.add("春季养生产品");
        hotTagString.add("增肥");
        hotTagString.add("美白除皱产品");
        hotTagString.add("祛斑");
        hotTagString.add("生发");

        historyTagString.add("美白");
        historyTagString.add("养眼产品");
        historyTagString.add("祛痘产品");


        tagHotTag.setAdapter(new TagAdapter<String>(hotTagString) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(_activity).inflate(R.layout.tag_layout, tagHotTag, false);
                tv.setText(s);
                return tv;
            }
        });

        tagHistoryTag.setAdapter(new TagAdapter<String>(historyTagString) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(_activity).inflate(R.layout.tag_layout, tagHistoryTag, false);
                tv.setText(s);
                return tv;
            }
        });
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @OnClick(R.id.tv_ClearAll)
    public void onClick() {
    }


}
