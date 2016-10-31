package com.bishilai.bishilai.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.bishilai.bishilai.R;
import com.bishilai.bishilai.adapter.ExpandableListAdapter;
import com.bishilai.bishilai.bean.DaoGoodBean;
import com.bishilai.bishilai.bean.GoodBean;
import com.bishilai.bishilai.bean.UpdateView;
import com.bishilai.bishilai.widget.SmoothCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseFragment;
import midian.baselib.widget.BaseLibTopbarView;

import static midian.baselib.widget.BaseLibTopbarView.MODE_WITH_INPUT;

/**
 * 购物车
 */
public class Fragment3 extends BaseFragment implements UpdateView {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    @BindView(R.id.cb_SelectAll)
    SmoothCheckBox cbSelectAll;
    @BindView(R.id.tv_AllMoney)
    TextView tvAllMoney;
    @BindView(R.id.tv_Transport)
    TextView tvTransport;
    @BindView(R.id.btn_Settlement)//结算按钮
    Button btnSettlement;

    private GoodBean goodBeanList;
    private ExpandableListAdapter adapter;
    private TextView tvRight;
    private boolean isEdit=true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab3, null);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {
        topbar.setBackgroundColor(getResources().getColor(R.color.green));
        topbar.setTitle("购物车");
        tvRight=topbar.getRight_tv();
        topbar.setRightText("编辑",listener);
        expandableListView.setGroupIndicator(null);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return true;
            }
        });
        goodBeanList = DaoGoodBean.getGoodBeanList();
        adapter=new ExpandableListAdapter(_activity,goodBeanList);
        adapter.setChangedListener(this);
        expandableListView.setAdapter(adapter);
        for(int i=0;i<goodBeanList.getContent().size();i++){
            expandableListView.expandGroup(i);
        }
    }

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isEdit){
                isEdit=false;
                tvRight.setText("完成");
                for(int i=0;i<goodBeanList.getContent().size();i++){
                    for(int n=0;n<goodBeanList.getContent().get(i).getGooddetail().size();n++){
                        goodBeanList.getContent().get(i).getGooddetail().get(n).setIsedit(true);
                    }
                }
            }else{
                isEdit=true;
                tvRight.setText("编辑");
                for(int i=0;i<goodBeanList.getContent().size();i++){
                    for(int n=0;n<goodBeanList.getContent().get(i).getGooddetail().size();n++){
                        goodBeanList.getContent().get(i).getGooddetail().get(n).setIsedit(false);
                    }
                }
            }
            adapter.notifyDataSetChanged();
        }
    };

    @OnClick({R.id.cb_SelectAll, R.id.btn_Settlement})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cb_SelectAll:
                int allCount=goodBeanList.getAllcount();
                int allMoney=goodBeanList.getAllmoney();
                if(!cbSelectAll.isChecked()){
                    cbSelectAll.setChecked(true);
                    for(int i=0;i<goodBeanList.getContent().size();i++){
                        goodBeanList.getContent().get(i).setIsselected(true);
                        for(int n=0;n<goodBeanList.getContent().get(i).getGooddetail().size();n++){
                            if(!goodBeanList.getContent().get(i).getGooddetail().get(n).isselected()){
                                allCount++;
                                allMoney+=Integer.valueOf(goodBeanList.getContent().get(i).getGooddetail().get(n).getCount())
                                        *Integer.valueOf(goodBeanList.getContent().get(i).getGooddetail().get(n).getPrice());
                                goodBeanList.getContent().get(i).getGooddetail().get(n).setIsselected(true);
                            }
                        }
                    }
                }else{
                    cbSelectAll.setChecked(false);
                    for(int i=0;i<goodBeanList.getContent().size();i++){
                        goodBeanList.getContent().get(i).setIsselected(false);
                        for(int n=0;n<goodBeanList.getContent().get(i).getGooddetail().size();n++){
                            goodBeanList.getContent().get(i).getGooddetail().get(n).setIsselected(false);
                        }
                        allCount=0;
                        allMoney=0;
                    }
                }
                goodBeanList.setAllmoney(allMoney);
                goodBeanList.setAllcount(allCount);
                update(allCount,allMoney);
                adapter.notifyDataSetChanged();
                break;
            case R.id.btn_Settlement:
                break;
        }
    }

    @Override
    public void update(int count, int price) {
        LogUtils.d(count);
        btnSettlement.setText("结算("+count+")");
        tvAllMoney.setText("￥"+price);
    }
}