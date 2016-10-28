package com.bishilai.bishilai.tpl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.bishilai.bishilai.R;
import com.bishilai.bishilai.widget.NoticeDialog;
import com.bishilai.bishilai.widget.SmoothCheckBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.bean.NetResult;
import midian.baselib.utils.UIHelper;
import midian.baselib.view.BaseTpl;

/**
 * 收货地址
 */
public class ActivityReceiveAdressTpl extends BaseTpl<NetResult> {


    @BindView(R.id.checkbox)
    SmoothCheckBox checkbox;
    @BindView(R.id.tv_Title)
    TextView tvTitle;
    @BindView(R.id.iv_Delete)
    ImageView ivDelete;
    @BindView(R.id.tv_Name)
    TextView tvName;
    @BindView(R.id.tv_Phone)
    TextView tvPhone;
    @BindView(R.id.tv_Adress)
    TextView tvAdress;

    private List<HashMap<Integer,Boolean>> isSelected=new ArrayList<>();
    private HashMap<Integer,Boolean> item=new HashMap<>();

    public ActivityReceiveAdressTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ActivityReceiveAdressTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.item_receiveadress;
    }

    @Override
    public void setBean(NetResult bean, int position) {
        item.put(position,false);
        if(!isSelected.contains(item)){
            isSelected.add(item);
        }
        checkbox.setTag(position);
    }

    @OnClick({R.id.checkbox, R.id.iv_Delete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkbox:
                if(checkbox.isChecked()){
                    checkbox.setChecked(false);
                }else{
                    checkbox.setChecked(true);
                }
                LogUtils.e(view.getTag());
                break;
            case R.id.iv_Delete:
                NoticeDialog noticeDialog = new NoticeDialog(_activity);
                noticeDialog.getOkButton().setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UIHelper.t(_activity,"确认");
                    }
                });
                noticeDialog.setNoticeContent("确认删除该收货地址吗？").show();
                break;
        }
    }
}
