package com.midian.bishilai.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.midian.base.util.UIHelper;
import com.midian.bishilai.R;
import com.midian.bishilai.activity.ActivityGoodDetail;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/17 0017.
 */

public class AdapterGridView11 extends BaseAdapter {

    private Context context;

    public AdapterGridView11(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 6;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview11, null);
            viewHolder = new ViewHolder(convertView);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        viewHolder.tv1.setText("");
        if(position%6==0){
            convertView.setBackgroundColor(Color.parseColor("#FC7E7E"));
        }else if(position%6==1){
            convertView.setBackgroundColor(Color.parseColor("#9EDAFF"));
        }else if(position%6==2){
            convertView.setBackgroundColor(Color.parseColor("#B1DF84"));
        }else if(position%6==3){
            convertView.setBackgroundColor(Color.parseColor("#FFAD3F"));
        }else if(position%6==4){
            convertView.setBackgroundColor(Color.parseColor("#19BC9C"));
        }else if(position%6==5){
            convertView.setBackgroundColor(Color.parseColor("#FF99CA"));
        }
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
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.tv3)
        TextView tv3;
        @BindView(R.id.iv)
        ImageView iv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
