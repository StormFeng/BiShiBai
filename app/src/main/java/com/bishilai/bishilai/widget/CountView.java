package com.bishilai.bishilai.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.bishilai.bishilai.R;

/**
 * Created by Administrator on 2016/10/19 0019.
 */

public class CountView extends LinearLayout {

    Context context;
    private View vReduce;
    private View vPlus;
    private TextView tvCount;

    public CountView(Context context) {
        super(context);
        this.context=context;
        initView(context);
    }

    public CountView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.linearlayout_countview, this);
        vReduce=findViewById(R.id.imageView1);
        vPlus=findViewById(R.id.imageView2);
        tvCount=(TextView) findViewById(R.id.textView);
        tvCount.setText("0");
        vReduce.setOnClickListener(reduceListener);
        vPlus.setOnClickListener(plusListener);
    }

    OnClickListener reduceListener=new OnClickListener() {
        @Override
        public void onClick(View v) {
            String var1=tvCount.getText().toString();
            int var2 = Integer.parseInt(var1);
            if(var2==1){
                tvCount.setTextColor(getResources().getColor(R.color.text_bg90));
                tvCount.setText("0");
            }else if(var2>1){
                tvCount.setTextColor(getResources().getColor(R.color.text_bg22));
                tvCount.setText(--var2+"");
            }else{
                tvCount.setTextColor(getResources().getColor(R.color.text_bg90));
                return;
            }
        }
    };

    OnClickListener plusListener=new OnClickListener() {
        @Override
        public void onClick(View v) {
            String var1=tvCount.getText().toString();
            int var2 = Integer.parseInt(var1);
            tvCount.setTextColor(getResources().getColor(R.color.text_bg22));
            LogUtils.e(var2);
            tvCount.setText(++var2+"");
        }
    };

    public int getCount(){
        return Integer.parseInt(tvCount.getText().toString());
    }
}
