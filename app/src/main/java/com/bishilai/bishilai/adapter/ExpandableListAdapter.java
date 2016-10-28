package com.bishilai.bishilai.adapter;

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
import com.bishilai.bishilai.R;
import com.bishilai.bishilai.widget.NoticeDialog;
import com.bishilai.bishilai.widget.SmoothCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.utils.UIHelper;

/**
 * 购物车
 * Created by Administrator on 2016/10/27 0027.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;

    public ExpandableListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return 9;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 2;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
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
            String tag=groupPosition+","+childPosition;
            holder.cbItem.setTag(tag);
            holder.tvReduce.setTag(tag);
            holder.tvAdd.setTag(tag);
            holder.ivDelete.setTag(tag);
            holder.cbItem.setOnClickListener(listener);
            holder.tvReduce.setOnClickListener(listener);
            holder.tvAdd.setOnClickListener(listener);
            holder.ivDelete.setOnClickListener(listener);
        }
        if(groupPosition%2==0){
            holder.llEdit.setVisibility(View.VISIBLE);
            holder.llNomal.setVisibility(View.GONE);
        }else{
            holder.llEdit.setVisibility(View.GONE);
            holder.llNomal.setVisibility(View.VISIBLE);
        }
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogUtils.e("点击-----------------------");
            switch (v.getId()){
                case R.id.cb_GroupItem:
                    LogUtils.e(v.getTag());
                    isChecked((SmoothCheckBox) v);
                    break;
                case R.id.cb_Item:
                    LogUtils.e(v.getTag());
                    isChecked((SmoothCheckBox) v);
                    break;
                case R.id.tv_Reduce:
                    LogUtils.e(v.getTag());
                    break;
                case R.id.tv_Add:
                    LogUtils.e(v.getTag());
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

    private void isChecked(SmoothCheckBox v) {
        SmoothCheckBox checkBox = v;
        if(checkBox.isChecked()){
            checkBox.setChecked(false);
        }else{
            checkBox.setChecked(true);
        }
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
