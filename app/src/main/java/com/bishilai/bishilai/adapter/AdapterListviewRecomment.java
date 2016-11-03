package com.bishilai.bishilai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bishilai.bishilai.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 推荐商品
 * Created by Administrator on 2016/10/17 0017.
 */

public class AdapterListviewRecomment extends BaseAdapter {

    private Context context;

    public AdapterListviewRecomment(Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview12, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.rlType.setVisibility(View.GONE);
//        viewHolder.tv1.setText("");
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv1)
        TextView tv1;
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.rl_Type)
        RelativeLayout rlType;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
