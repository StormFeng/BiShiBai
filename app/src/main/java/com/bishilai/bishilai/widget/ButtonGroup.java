package com.bishilai.bishilai.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.apkfuns.logutils.LogUtils;
import com.bishilai.bishilai.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/20 0020.
 */

public class ButtonGroup extends LinearLayout implements View.OnClickListener {

    private Context context;
    private LinearLayout linearLayout;
    private List<Button> buttons=new ArrayList<>();
    private Button temp;
    private ButtonGroupListener listener;

    public ButtonGroup(Context context) {
        super(context);
        this.context=context;
        initView();
    }

    public ButtonGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initView();
    }

    private void initView(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_buttongroup, this);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
    }

    public ButtonGroup addButton(List<String> var){
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setOrientation(HORIZONTAL);
        linearLayout.setLayoutParams(layoutParams);
        for(int i=0;i<var.size();i++){
            String s=var.get(i);
            LinearLayout.LayoutParams itemParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            itemParams.width=0;
            itemParams.weight=1;
            Button button=new Button(context);
            button.setText(s);
            button.setLayoutParams(itemParams);
            button.setOnClickListener(this);
            button.setTag(i);
            buttons.add(button);
            linearLayout.addView(button);
        }

        return this;
    }

    public ButtonGroup setButtonColor(int textColor,int backColor){
        for(Button button : buttons){
            button.setTextColor(textColor);
            button.setBackgroundColor(backColor);
        }
        buttons.get(0).performClick();
        return this;
    }

    @Override
    public void onClick(View v) {
        temp = (Button) v;
        int id = (int) temp.getTag();
        LogUtils.e(id);
        for(int i=0;i<buttons.size();i++){
            if(id!=i){
                buttons.get(i).setClickable(true);
                buttons.get(i).setTextColor(getResources().getColor(R.color.text_bg99));
            }else{
                if(temp.isClickable()){
                    buttons.get(i).setClickable(false);
                    buttons.get(i).setTextColor(getResources().getColor(R.color.orange));
                }else{
                    return;
                }
            }
        }
        if(listener!=null){
            listener.afterClicked(id);
        }
    }

    public void setAfterClickedListener(ButtonGroupListener listener){
        this.listener=listener;
    }
}
