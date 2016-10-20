package com.bishilai.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bishilai.bishilai.R;
import midian.baselib.bean.NetResult;
import midian.baselib.view.BaseTpl;

public class CommentBotTpl extends BaseTpl<NetResult>{

    public static LinearLayout ll_Comment;
    public CommentBotTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommentBotTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_comment_bot;
    }

    @Override
    public void setBean(NetResult bean, int position) {
    }
}
