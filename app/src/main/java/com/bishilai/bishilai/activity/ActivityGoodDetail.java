package com.bishilai.bishilai.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.bishilai.bishilai.R;
import com.bishilai.bishilai.widget.Banner;
import com.bishilai.bishilai.widget.ScrollChangeListenerView;
import com.jaeger.library.StatusBarUtil;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.base.BaseActivity;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;
import midian.baselib.widget.ScrollChangeListener;

/**
 * Created by Administrator on 2016/10/19 0019.
 */

public class ActivityGoodDetail extends BaseActivity implements Banner.OnBannerClickListener {
    @BindView(R.id.bannerView)
    Banner bannerView;
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.tag_Text)
    TagFlowLayout tagText;
    @BindView(R.id.scrollView)
    ScrollChangeListenerView scrollView;
    @BindView(R.id.tag_Image)
    TagFlowLayout tagImage;

    private int flag;
    private ArrayList<String> images = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gooddetail);
        ButterKnife.bind(this);
        initView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
            StatusBarUtil.setTranslucentForImageViewInFragment(_activity, 0, null);
        }
    }

    private void initView() {
        topbar.getLine_iv().setVisibility(View.GONE);
        topbar.setTitle("");
        topbar.setLeftImageButton(R.drawable.icon_back, listener);

        bannerView.setBannerStyle(Banner.CIRCLE_INDICATOR);//设置圆形指示器
        bannerView.setIndicatorGravity(Banner.CENTER);
        bannerView.isAutoPlay(true);
        bannerView.setDelayTime(5000);//设置轮播间隔时间
        bannerView.setOnBannerClickListener(this);
        if (flag == 0) {
            flag++;
            for (int i = 0; i < 3; i++) {
                images.add("http://mengzhu.img-cn-shenzhen.aliyuncs.com/8a99524557c2dec90157c72795010007");
            }
        }
        bannerView.setImages(images.toArray());

        for (int i = 1; i < 4; i++) {
            tags.add(Math.pow(8, i) + "GB");
        }

        tagImage.setAdapter(imageAdapter);
        tagText.setAdapter(textAdapter);
        imageAdapter.setSelectedList(0);
        textAdapter.setSelectedList(0);
        tagImage.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                LogUtils.e(selectPosSet);
            }
        });

        scrollView.setChangeListener(scrollChangeListener);
    }

    TagAdapter<String> imageAdapter=new TagAdapter<String>(images) {
        @Override
        public View getView(FlowLayout parent, int position, String s) {
            RoundedImageView iv = (RoundedImageView) LayoutInflater.from(_activity).inflate(R.layout.tag_imagelayout, tagImage, false);
            ac.setImage(iv,images.get(position));
            return iv;
        }
    };

    TagAdapter<String> textAdapter=new TagAdapter<String>(tags) {
        @Override
        public View getView(FlowLayout parent, int position, String s) {
            TextView tv = (TextView) LayoutInflater.from(_activity).inflate(R.layout.tag_layout, tagText, false);
            tv.setText(s);
            return tv;
        }
    };

    ScrollChangeListener scrollChangeListener = new ScrollChangeListener() {
        @Override
        public void onScrollChanged(ScrollView scrollView, int x, int y, int oldx, int oldy) {

        }
    };

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    @Override
    public void OnBannerClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("pic", images);
        UIHelper.jump(_activity, ActivityViewPhoto.class, bundle);
    }
}
