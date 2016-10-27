package com.bishilai.bishilai.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.apkfuns.logutils.LogUtils;
import com.bishilai.bishilai.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/27 0027.
 */

public class ShareDialog extends Dialog {

    @BindView(R.id.iv_WeChat)
    ImageView ivWeChat;
    @BindView(R.id.iv_Circle)
    ImageView ivCircle;
    @BindView(R.id.iv_Sina)
    ImageView ivSina;
    private Context context;

    public ShareDialog(Context context) {
        super(context,R.style.bottom_dialog);
        init(context);
    }

    public ShareDialog(Context context, int themeResId) {
        super(context, R.style.bottom_dialog);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        Window w = this.getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        w.setAttributes(lp);
        this.setCanceledOnTouchOutside(true);
        View v = View.inflate(context, R.layout.dialog_share, null);
        this.setContentView(v);
        ButterKnife.bind(this,v);
    }

    @OnClick({R.id.iv_WeChat, R.id.iv_Circle, R.id.iv_Sina})
    public void onClick(View view) {
        LogUtils.e(view.getId());
        switch (view.getId()) {
            case R.id.iv_WeChat:
                break;
            case R.id.iv_Circle:
                break;
            case R.id.iv_Sina:
                break;
        }
    }
}
