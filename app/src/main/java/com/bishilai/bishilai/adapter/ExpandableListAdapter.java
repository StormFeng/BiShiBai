package com.bishilai.bishilai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.bishilai.bishilai.R;
import com.bishilai.bishilai.widget.SmoothCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
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
            holder.cbItem.setOnClickListener(listener);
            holder.tvReduce.setOnClickListener(listener);
            holder.tvAdd.setOnClickListener(listener);
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

        ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
