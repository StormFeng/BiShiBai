package com.midian.bishilai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.midian.base.app.AppContext;
import com.midian.bishilai.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 评论
 * Created by Administrator on 2016/10/17 0017.
 */

public class AdapterListViewComment extends BaseAdapter {

    private Context context;
    private List<String> images=new ArrayList<>();

    public AdapterListViewComment(Context context) {
        this.context = context;
        for (int i = 0; i < 2; i++) {
            images.add("http://mengzhu.img-cn-shenzhen.aliyuncs.com/8a99524557c2dec90157c72795010007");
        }
    }

    @Override
    public int getCount() {
        return 1;
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
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_comment, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if(position==0){
            viewHolder.tagImage.setAdapter(new TagAdapter<String>(images) {
                @Override
                public View getView(FlowLayout parent, int position, String o) {
                    RoundedImageView iv = (RoundedImageView) LayoutInflater.from(context).inflate(R.layout.tag_imagelayout, viewHolder.tagImage, false);
                    AppContext ac = (AppContext) context.getApplicationContext();
                    ac.setImage(iv,images.get(position));
                    return iv;
                }
            });
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_Name)
        TextView tvName;
        @BindView(R.id.tv_Time)
        TextView tvTime;
        @BindView(R.id.tv_Content)
        TextView tvContent;
        @BindView(R.id.tag_Image)
        TagFlowLayout tagImage;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
