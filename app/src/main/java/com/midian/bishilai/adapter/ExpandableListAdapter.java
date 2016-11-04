package com.midian.bishilai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.midian.bishilai.R;
import com.midian.bishilai.bean.GoodBean;
import com.midian.bishilai.bean.UpdateView;
import com.midian.bishilai.widget.NoticeDialog;
import com.midian.bishilai.widget.SmoothCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.utils.UIHelper;

/**
 * 购物车
 * Created by Administrator on 2016/10/27 0027.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private GoodBean goodBean;
    private UpdateView updateViewListener;

    public ExpandableListAdapter(Context context,GoodBean goodBean) {
        this.context = context;
        this.goodBean=goodBean;
    }

    @Override
    public int getGroupCount() {
        return goodBean.getContent().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return goodBean.getContent().get(groupPosition).getGooddetail().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return goodBean.getContent().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return goodBean.getContent().get(groupPosition).getGooddetail().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_shopingcargroup, parent, false);
            holder = new GroupViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }
        holder.cbGroupItem.setTag(groupPosition);
        holder.cbGroupItem.setOnClickListener(listener);
        holder.tvPosition.setText(goodBean.getContent().get(groupPosition).getAdress());
        if(goodBean.getContent().get(groupPosition).isselected()){
            if(!holder.cbGroupItem.isChecked()){
                holder.cbGroupItem.setChecked(true);
            }
        }else{
            holder.cbGroupItem.setChecked(false);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_shopingcarchild, parent, false);
            holder = new ChildViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ChildViewHolder) convertView.getTag();
        }
        String tag=groupPosition+","+childPosition;
        holder.cbItem.setTag(tag);
        holder.tvReduce.setTag(tag);
        holder.tvAdd.setTag(tag);
        holder.ivDelete.setTag(tag);
        holder.cbItem.setOnClickListener(listener);
        holder.tvReduce.setOnClickListener(listener);
        holder.tvAdd.setOnClickListener(listener);
        holder.ivDelete.setOnClickListener(listener);
        if(goodBean.getContent().get(groupPosition).getGooddetail().get(childPosition).isselected()){
            holder.cbItem.setChecked(true);
        }else{
            holder.cbItem.setChecked(false);
        }
        if(goodBean.getContent().get(groupPosition).getGooddetail().get(childPosition).isedit()){
            holder.llEdit.setVisibility(View.VISIBLE);
            holder.llNomal.setVisibility(View.GONE);
            holder.ivDelete.setVisibility(View.VISIBLE);
        }else{
            holder.llEdit.setVisibility(View.GONE);
            holder.llNomal.setVisibility(View.VISIBLE);
            holder.ivDelete.setVisibility(View.GONE);
        }
        holder.tvGoodName.setText(goodBean.getContent().get(groupPosition).getGooddetail().get(childPosition).getName());
        holder.tvLimitCount.setText("限购"+goodBean.getContent().get(groupPosition).getGooddetail().get(childPosition).getLimitcount()+"件");
        holder.tvPrice.setText("￥"+goodBean.getContent().get(groupPosition).getGooddetail().get(childPosition).getPrice());
        holder.tvCount.setText("x"+goodBean.getContent().get(groupPosition).getGooddetail().get(childPosition).getCount());
        holder.etCount.setText(goodBean.getContent().get(groupPosition).getGooddetail().get(childPosition).getCount());

        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SmoothCheckBox checkBox;
            String tag = v.getTag().toString();
            String[] split;
            int groupId = 0;
            int childId = 0;
            int childSize = 0;
            int groupPosition = 0;
            int allCount=goodBean.getAllcount();
            int allMoney=goodBean.getAllmoney();
            if(tag.contains(",")){
                split = tag.split(",");
                groupId=Integer.parseInt(split[0]);
                childId=Integer.parseInt(split[1]);
            }else{
                groupPosition = Integer.parseInt(tag);
                childSize = goodBean.getContent().get(groupPosition).getGooddetail().size();
            }
            switch (v.getId()){
                case R.id.cb_GroupItem:
                    checkBox = (SmoothCheckBox) v;
                    goodBean.getContent().get(groupPosition).setIsselected(!checkBox.isChecked());
                    if(!checkBox.isChecked()){
                        for(int i=0;i<childSize;i++){
                            if(!goodBean.getContent().get(groupPosition).getGooddetail().get(i).isselected()){
                                allCount++;
                                goodBean.getContent().get(groupPosition).getGooddetail().get(i).setIsselected(!checkBox.isChecked());
                                allMoney+=Integer.valueOf(goodBean.getContent().get(groupPosition).getGooddetail().get(i).getCount())
                                        *Integer.valueOf(goodBean.getContent().get(groupPosition).getGooddetail().get(i).getPrice());
                            }
                        }
                    }else{
                        allCount-=childSize;
                        for(int i=0;i<childSize;i++){
                            goodBean.getContent().get(groupPosition).getGooddetail().get(i).setIsselected(!checkBox.isChecked());
                            allMoney-=Integer.valueOf(goodBean.getContent().get(groupPosition).getGooddetail().get(i).getCount())
                                    *Integer.valueOf(goodBean.getContent().get(groupPosition).getGooddetail().get(i).getPrice());
                        }
                    }
                    goodBean.setAllcount(allCount);
                    goodBean.setAllmoney(allMoney);
                    notifyDataSetChanged();
                    updateViewListener.update(allCount,allMoney);
                    break;
                case R.id.cb_Item:
                    checkBox = (SmoothCheckBox) v;
                    int n=0;
                    goodBean.getContent().get(groupId).getGooddetail().get(childId).setIsselected(!checkBox.isChecked());
                    for(int i=0;i<goodBean.getContent().get(groupId).getGooddetail().size();i++){
                        if(goodBean.getContent().get(groupId).getGooddetail().get(i).isselected()){
                            n++;
                        }
                    }
                    if(n==goodBean.getContent().get(groupId).getGooddetail().size()){
                        goodBean.getContent().get(groupId).setIsselected(true);
                    }else{
                        goodBean.getContent().get(groupId).setIsselected(false);
                    }
                    if(!checkBox.isChecked()){
                        allCount++;
                        allMoney+=Integer.valueOf(goodBean.getContent().get(groupId).getGooddetail().get(childId).getCount())
                                *Integer.valueOf(goodBean.getContent().get(groupId).getGooddetail().get(childId).getPrice());
                    }else{
                        allCount--;
                        allMoney-=Integer.valueOf(goodBean.getContent().get(groupId).getGooddetail().get(childId).getCount())
                                *Integer.valueOf(goodBean.getContent().get(groupId).getGooddetail().get(childId).getPrice());
                    }
                    goodBean.setAllcount(allCount);
                    goodBean.setAllmoney(allMoney);
                    notifyDataSetChanged();
                    updateViewListener.update(allCount,allMoney);
                    break;
                case R.id.tv_Reduce:
                    String var1 = goodBean.getContent().get(groupId).getGooddetail().get(childId).getCount();
                    if(Integer.valueOf(var1)>1){
                        goodBean.getContent().get(groupId).getGooddetail().get(childId).setCount(reduceCount(var1));
                        if(goodBean.getContent().get(groupId).getGooddetail().get(childId).isselected()){
                            allMoney-=Integer.valueOf(goodBean.getContent().get(groupId).getGooddetail().get(childId).getPrice());
                            updateViewListener.update(allCount,allMoney);
                        }
                        goodBean.setAllmoney(allMoney);
                        notifyDataSetChanged();
                    }
                    break;
                case R.id.tv_Add:
                    String var2 = goodBean.getContent().get(groupId).getGooddetail().get(childId).getCount();
                    goodBean.getContent().get(groupId).getGooddetail().get(childId).setCount(addCount(var2));
                    notifyDataSetChanged();
                    allMoney=goodBean.getAllmoney();
                    if(goodBean.getContent().get(groupId).getGooddetail().get(childId).isselected()){
                        allMoney+=Integer.valueOf(goodBean.getContent().get(groupId).getGooddetail().get(childId).getPrice());
                        updateViewListener.update(allCount,allMoney);
                    }
                    goodBean.setAllmoney(allMoney);
                    notifyDataSetChanged();
                    break;
                case R.id.iv_Delete:
                    LogUtils.e(v.getTag());
                    NoticeDialog noticeDialog = new NoticeDialog(context);
                    noticeDialog.getOkButton().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            UIHelper.t(context,"确认");
                        }
                    });
                    noticeDialog.setNoticeContent("确认删除该商品吗？").show();
                    break;
            }
        }
    };

    public void setChangedListener(UpdateView listener){
        if(updateViewListener==null){
            this.updateViewListener=listener;
        }
    }

    private String addCount(String var2) {
        Integer inte = Integer.valueOf(var2);
        inte++;
        return inte+"";
    }

    private String reduceCount(String var){
        Integer integer = Integer.valueOf(var);
        if(integer>1){
            integer--;
        }
        return integer+"";
    }


    static class GroupViewHolder {
        @BindView(R.id.cb_GroupItem)
        SmoothCheckBox cbGroupItem;
        @BindView(R.id.tv_Position)
        TextView tvPosition;

        GroupViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ChildViewHolder {
        @BindView(R.id.cb_Item)
        SmoothCheckBox cbItem;
        @BindView(R.id.tv_GoodName)
        TextView tvGoodName;
        @BindView(R.id.tv_LimitCount)
        TextView tvLimitCount;
        @BindView(R.id.tv_Price)
        TextView tvPrice;
        @BindView(R.id.tv_Count)
        TextView tvCount;
        @BindView(R.id.et_Count)
        EditText etCount;
        @BindView(R.id.tv_Reduce)
        TextView tvReduce;
        @BindView(R.id.tv_Add)
        TextView tvAdd;
        @BindView(R.id.iv_Delete)
        ImageView ivDelete;
        @BindView(R.id.ll_Nomal)
        LinearLayout llNomal;
        @BindView(R.id.ll_Edit)
        LinearLayout llEdit;

        ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
