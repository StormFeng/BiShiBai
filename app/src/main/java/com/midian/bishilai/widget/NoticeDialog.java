package com.midian.bishilai.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.midian.bishilai.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

public class NoticeDialog extends Dialog {

    @BindView(R.id.tv_notice)
    TextView tvNotice;
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.btn_ok)
    Button btnOk;
    private Context context;

    public NoticeDialog(Context context) {
        super(context, R.style.diy_dialog);
        init(context);
    }

    public NoticeDialog(Context context, int themeResId) {
        super(context, R.style.diy_dialog);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        Window w = this.getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.gravity = Gravity.CENTER;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        w.setAttributes(lp);
        this.setCanceledOnTouchOutside(true);
        View v = View.inflate(context, R.layout.dialog_notice, null);
        this.setContentView(v);
        ButterKnife.bind(this,v);
    }

    public NoticeDialog setNoticeContent(String var){
        tvNotice.setText(var);
        return this;
    }

    public View getOkButton(){
        return btnOk;
    }

    @OnClick({R.id.btn_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                this.dismiss();
                break;
        }
    }
}
