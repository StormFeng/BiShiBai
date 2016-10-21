package com.bishilai.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.bishilai.bishilai.R;
import com.bishilai.bishilai.widget.ButtonGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.bean.NetResult;
import midian.baselib.view.BaseTpl;

public class CommentTopTpl extends BaseTpl<NetResult> {

    @BindView(R.id.buttonGroup)
    ButtonGroup buttonGroup;

    private List<String> buttons;
    private boolean flag=true;

    public CommentTopTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommentTopTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_comment_top;
    }

    @Override
    public void setBean(NetResult bean, int position) {
        if(bean!=null){
            if(bean.getItemViewType()==0){
                if(flag){
                    flag=false;
                    buttons=new ArrayList<>();
                    buttons.add("最热门");
                    buttons.add("最新");
                    buttonGroup.addButton(buttons);
                    buttonGroup.setButtonColor(getResources().getColor(R.color.text_bg99),getResources().getColor(R.color.alpha));
                }
            }
        }
    }
}
