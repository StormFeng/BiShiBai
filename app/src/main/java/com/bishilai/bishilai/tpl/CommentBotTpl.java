package com.bishilai.bishilai.tpl;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.apkfuns.logutils.LogUtils;
import com.bishilai.bishilai.R;
import com.bishilai.bishilai.activity.ActivityViewPhoto;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.bean.NetResult;
import midian.baselib.utils.UIHelper;
import midian.baselib.view.BaseTpl;

public class CommentBotTpl extends BaseTpl<NetResult> {

    @BindView(R.id.iv_Images)
    TagFlowLayout ivImages;

    private ArrayList<String> images;

    public CommentBotTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommentBotTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.item_comment_bot;
    }

    @Override
    public void setBean(NetResult bean, int position) {
        if(bean!=null){
            if(bean.getItemViewType()==1){
                images=new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    images.add("http://mengzhu.img-cn-shenzhen.aliyuncs.com/8a99524557c2dec90157c72795010007");
                }
                LogUtils.e("ivImages.setAdapter(imageAdapter);");
                ivImages.setAdapter(new TagAdapter<String>(images) {
                    @Override
                    public View getView(FlowLayout parent, final int position, String s) {
                        RoundedImageView iv = (RoundedImageView) LayoutInflater.from(_activity).inflate(R.layout.tag_commentimage, ivImages, false);
                        ac.setImage(iv, images.get(position));
                        iv.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Bundle bundle=new Bundle();
                                bundle.putStringArrayList("pic",images);
                                bundle.putString("position",position+"");
                                UIHelper.jump(_activity, ActivityViewPhoto.class,bundle);
                            }
                        });
                        return iv;
                    }
                });
            }
        }
    }
}
