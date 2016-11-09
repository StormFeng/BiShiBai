package com.midian.bishilai.tpl;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.midian.base.bean.NetResult;
import com.midian.base.util.UIHelper;
import com.midian.base.view.BaseTpl;
import com.midian.base.widget.PhotoPicker.PhotoPreview;
import com.midian.bishilai.R;
import com.midian.bishilai.widget.CommentPopup;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommentBotTpl extends BaseTpl<NetResult> {

    @BindView(R.id.iv_Images)
    TagFlowLayout ivImages;
    @BindView(R.id.iv_Comment)
    ImageView ivComment;

    private ArrayList<String> images;
    private CommentPopup mCommentPopup;

    public CommentBotTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommentBotTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        mCommentPopup=new CommentPopup(_activity);
        mCommentPopup.setOnCommentPopupClickListener(new CommentPopup.OnCommentPopupClickListener() {
            @Override
            public void onLikeClick(View v, TextView likeText) {
                if (v.getTag() == null) {
                    v.setTag(1);
                    likeText.setText("取消");
                }
                else {
                    switch ((int) v.getTag()) {
                        case 0:
                            v.setTag(1);
                            likeText.setText("取消");
                            break;
                        case 1:
                            v.setTag(0);
                            likeText.setText("赞  ");
                            break;
                    }
                }
            }

            @Override
            public void onCommentClick(View v) {
                UIHelper.t(_activity,"评论");
            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.item_comment_bot;
    }

    @Override
    public void setBean(NetResult bean, int position) {
        if (bean != null) {
            if (bean.getItemViewType() == 1) {
                images = new ArrayList<>();
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
                                PhotoPreview.builder()
                                        .setPhotos(images)
                                        .setCurrentItem(position)
                                        .setShowDeleteButton(false)
                                        .start(_activity);
                            }
                        });
                        return iv;
                    }
                });
            }
        }
    }

    @OnClick(R.id.iv_Comment)
    public void onClick() {
        mCommentPopup.showPopupWindow(ivComment);
    }
}
