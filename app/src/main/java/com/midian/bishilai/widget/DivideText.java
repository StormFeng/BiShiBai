package com.midian.bishilai.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.midian.bishilai.R;


/**
 * Created by Administrator on 2016/10/17 0017.
 */

public class DivideText extends LinearLayout {

    Context context;
    private TextView tv;

    public DivideText(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public DivideText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    public void init(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.dividetext, this);//topbar的布局
        tv = (TextView) findViewById(R.id.tv);
    }

    public DivideText setTitle(String title) {
        tv.setText(title);
        return this;
    }
}
