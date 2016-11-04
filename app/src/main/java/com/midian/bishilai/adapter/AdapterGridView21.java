package com.midian.bishilai.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.midian.bishilai.R;
import com.midian.bishilai.activity.ActivityGoodDetail;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.utils.UIHelper;

/**
 * Created by Administrator on 2016/10/17 0017.
 */

public class AdapterGridView21 extends BaseAdapter {

    private Context context;
    private int size;

    public AdapterGridView21(Context context,int size) {
        this.context = context;
        this.size=size;
    }

    @Override
    public int getCount() {
        return size;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview21, null);
            viewHolder = new ViewHolder(convertView);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        viewHolder.tv1.setText("");
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.jump((Activity) context, ActivityGoodDetail.class);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv1)
        TextView tv1;
        @BindView(R.id.iv)
        ImageView iv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
