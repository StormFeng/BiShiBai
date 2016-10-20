package com.bishilai.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.bishilai.bishilai.R;

import midian.baselib.bean.NetResult;
import midian.baselib.view.BaseTpl;

public class CommentTopTpl extends BaseTpl<NetResult>{

    public CommentTopTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommentTopTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_comment_top;
    }

    @Override
    public void setBean(NetResult bean, int position) {
    }
}
