package com.midian.bishilai.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.midian.bishilai.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/4 0004.
 */

public class SelectView extends LinearLayout implements View.OnClickListener{

    private Context context;
    private onSelectListener listener;
    private onStatusChangeListener onStatusChangeListener;
    private int flag=0;
    private boolean var1=true,var2=true;
    private List<TextView> tvs=new ArrayList<>();

    public SelectView(Context context) {
        super(context);
        this.context=context;
        this.setOrientation(HORIZONTAL);
    }

    public SelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        this.setOrientation(HORIZONTAL);
    }

    public TextView getTextView(int arg){
        return tvs.get(arg);
    }

    public void init(String[] var){
        for(int i=0;i<var.length;i++){
            TextView tv=new TextView(context);
            LinearLayout linearLayout=new LinearLayout(context);
            tv.setTag(i);
            tv.setText(var[i]);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
            tv.setGravity(Gravity.CENTER);
            tv.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            linearLayout.setHorizontalGravity(Gravity.CENTER);
            linearLayout.addView(tv);
            linearLayout.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));
            tv.setOnClickListener(this);
            tvs.add(tv);
            addView(linearLayout);
        }
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        setGravity(Gravity.CENTER_VERTICAL);
        tvs.get(0).setClickable(false);
        tvs.get(0).setTextColor(Color.parseColor("#07A746"));
        tvs.get(2).setCompoundDrawablesWithIntrinsicBounds(null, null,getResources().getDrawable(R.drawable.icon_all_grey) ,null);
        tvs.get(3).setCompoundDrawablesWithIntrinsicBounds(null, null,getResources().getDrawable(R.drawable.icon_grey) ,null);
        tvs.get(2).setCompoundDrawablePadding(4);
        tvs.get(3).setCompoundDrawablePadding(4);
    }


    private void changeStatus(int i){
        if(flag!=i){
            flag=i;
            var1=true;
            var2=true;
            if(i<2){
                tvs.get(i).setClickable(false);
                tvs.get(2).setCompoundDrawablesWithIntrinsicBounds(null, null,getResources().getDrawable(R.drawable.icon_all_grey) ,null);
                tvs.get(3).setCompoundDrawablesWithIntrinsicBounds(null, null,getResources().getDrawable(R.drawable.icon_grey) ,null);
            }else if(i==2){
                tvs.get(2).setCompoundDrawablesWithIntrinsicBounds(null, null,getResources().getDrawable(R.drawable.icon_top_green) ,null);
                tvs.get(3).setCompoundDrawablesWithIntrinsicBounds(null, null,getResources().getDrawable(R.drawable.icon_grey) ,null);
            }else if(i==3){
                tvs.get(2).setCompoundDrawablesWithIntrinsicBounds(null, null,getResources().getDrawable(R.drawable.icon_all_grey) ,null);
                tvs.get(3).setCompoundDrawablesWithIntrinsicBounds(null, null,getResources().getDrawable(R.drawable.icon_green) ,null);
            }
            for(int j=0;j<4;j++){
                if(j!=i){
                    tvs.get(j).setClickable(true);
                    tvs.get(j).setTextColor(Color.parseColor("#333333"));
                }
            }
            tvs.get(i).setTextColor(Color.parseColor("#07A746"));
        }else{
            if(i==2) {
                if (!var1) {
                    var1 = true;
                    tvs.get(i).setCompoundDrawablesWithIntrinsicBounds(null, null,getResources().getDrawable(R.drawable.icon_top_green) ,null);
                } else {
                    var1 = false;
                    tvs.get(i).setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.icon_top_grey), null);
                }
            }else {
                if (!var2) {
                    var2 = true;
                    tvs.get(3).setTextColor(Color.parseColor("#07A746"));
                    tvs.get(i).setCompoundDrawablesWithIntrinsicBounds(null, null,getResources().getDrawable(R.drawable.icon_green) ,null);
                } else {
                    var2 = false;
                    tvs.get(3).setTextColor(Color.parseColor("#333333"));
                    tvs.get(i).setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.icon_grey), null);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        int i = (int) v.getTag();
        if(onStatusChangeListener!=null){
            changeStatus(i);
            if(i==2){
                onStatusChangeListener.onStatusChange(i,var1);
            }else if(i==3){
                onStatusChangeListener.onStatusChange(i,var2);
            }else{
                onStatusChangeListener.onStatusChange(i);
            }
        }
    }

    public void setOnSelectListener(onSelectListener listener){
        if(listener==null){
            this.listener=listener;
        }
    }

    public void setOnStatusChangeListener(onStatusChangeListener listener){
        if(onStatusChangeListener==null){
            this.onStatusChangeListener=listener;
        }
    }

    public interface onSelectListener{
        public void onSelectChange(int position);
    }

    public interface onStatusChangeListener{
        public void onStatusChange(int position, boolean... status);
    }
}
