package com.midian.bishilai.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.midian.base.base.BaseFragmentActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;
import com.midian.base.widget.PhotoPicker.PhotoPreview;
import com.midian.base.widget.ScrollChangeListener;
import com.midian.bishilai.R;
import com.midian.bishilai.adapter.AdapterListViewComment;
import com.midian.bishilai.adapter.AdapterListviewRecomment;
import com.midian.bishilai.fragments.FragmentGoodDetail;
import com.midian.bishilai.utils.AddToCartHelper;
import com.midian.bishilai.utils.ScreenUtils;
import com.midian.bishilai.widget.Banner;
import com.midian.bishilai.widget.ButtonGroup;
import com.midian.bishilai.widget.ButtonGroupListener;
import com.midian.bishilai.widget.HorizontalListView;
import com.midian.bishilai.widget.ScrollChangeListenerView;
import com.midian.bishilai.widget.ShareDialog;
import com.daimajia.androidanimations.library.BaseViewAnimator;
import com.daimajia.androidanimations.library.YoYo;
import com.jaeger.library.StatusBarUtil;
import com.nineoldandroids.animation.ObjectAnimator;
import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品详情页面
 * Created by Administrator on 2016/10/19 0019.
 */

public class ActivityGoodDetail extends BaseFragmentActivity implements Banner.OnBannerClickListener {


    @BindView(R.id.bannerView)
    Banner bannerView;
    @BindView(R.id.tv_GoodDetai)
    TextView tvGoodDetai;
    @BindView(R.id.tv_Parameter)
    TextView tvParameter;
    @BindView(R.id.tv_Comment)
    TextView tvComment;

    @BindView(R.id.buttonGroup)
    ButtonGroup buttonGroup;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.scrollView)
    ScrollChangeListenerView scrollView;
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.tv_ShopCard)
    TextView tvShopCard;
    @BindView(R.id.tv_Count)
    TextView tvCount;
    @BindView(R.id.btn_AddGood)
    Button btnAddGood;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.horizontalListView)
    HorizontalListView horizontalListView;


    private int[] location = new int[2];
    private Handler handler = new Handler();
    private Fragment fragment;
    private int flag;
    private ArrayList<String> images = new ArrayList<>();
    private float var1, var2;
    private int temp;
    private String var3, color;
    private FragmentGoodDetail fragmentGoodDetail;
    private List<Fragment> fragments = new ArrayList<>();

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
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        topbar.setRightImageButton(R.drawable.icon_share, listener);

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

        scrollView.setChangeListener(scrollChangeListener);

        List<String> list = new ArrayList<>();
        list.add("规格");
        list.add("详情");
        list.add("商品参数");
        buttonGroup.addButton(list);
        buttonGroup.setButtonColor(getResources().getColor(R.color.text_bg99), getResources().getColor(R.color.alpha));
        buttonGroup.setAfterClickedListener(buttonGroupListener);

        fragment = new Fragment();
        fragmentGoodDetail = new FragmentGoodDetail();
        for (int i = 0; i < 3; i++) {
            fragments.add(fragment);
        }
        switchFragment(fragment, fragmentGoodDetail);
        listView.setAdapter(new AdapterListViewComment(_activity));
        horizontalListView.setAdapter(new AdapterListviewRecomment(_activity));
    }

    public void switchFragment(Fragment from, Fragment to) {
        FragmentTransaction mTransaction = fm.beginTransaction();
        if (mFragment != to) {
            mFragment = to;
            System.out.println("to.isAdded()" + to.isAdded());
            if (to.isAdded()) {
                mTransaction.hide(from).show(to).commit();
            } else {
                mTransaction.hide(from).add(R.id.fl_content, to).commit();
            }

        }
    }


    ButtonGroupListener buttonGroupListener = new ButtonGroupListener() {
        @Override
        public void afterClicked(int id) {
            switchFragment(fragment, fragments.get(id));
        }
    };


    ScrollChangeListener scrollChangeListener = new ScrollChangeListener() {
        @Override
        public void onScrollChanged(ScrollView scrollView, int x, int y, int oldx, int oldy) {
            if (0 == location[1]) {
                tvGoodDetai.getLocationOnScreen(location);
                temp = location[1] - topbar.getHeight();
            }
            if (y < 0) {
                topbar.setTitle("");
                topbar.setBackgroundColor(Color.parseColor("#00FFFFFF"));
            } else if (y < temp && y >= 0) {
                topbar.setTitle("");
                topbar.setVisibility(View.VISIBLE);
                var1 = (float) y / temp;
                var2 = var1 * 255;
                var3 = Integer.toHexString((int) var2);
                if (var3.length() == 1) {
                    var3 = "0" + var3;
                }
                color = new StringBuffer("#07A746").insert(1, var3).toString();
//                LogUtils.e("y:"+y+"\n"+"var3:"+var3+"\n"+"color:"+color);
                topbar.setBackgroundColor(Color.parseColor(color));
            } else if (y >= temp) {
                topbar.setTitle("商品详情");
                topbar.setBackgroundColor(Color.parseColor("#07A746"));
            }
        }
    };

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.right_ib:
                    new ShareDialog(_activity,"分享标题","分享内容",
                            "http://mengzhu.img-cn-shenzhen.aliyuncs.com/8a995245582430320158247ca4890008@800h_1000w_1080x480","").show();
                    break;
            }
        }
    };

    @Override
    public void OnBannerClick(View view, int position) {
        PhotoPreview.builder()
                .setPhotos(images)
                .setCurrentItem(position-1)
                .setShowDeleteButton(false)
                .start(_activity);
    }

    @OnClick({R.id.btn_AddGood, R.id.tv_GoodDetai, R.id.tv_Parameter, R.id.tv_Comment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_AddGood:
                Add2CartAnim();
                break;
            case R.id.tv_GoodDetai:
                scrollToPosition();
                break;
            case R.id.tv_Parameter:
                scrollToPosition();
                break;
            case R.id.tv_Comment:
                UIHelper.jump(_activity, ActivityComment.class);
                break;
        }
    }

    private void scrollToPosition() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, location[1] - topbar.getHeight());
            }
        });
    }

    private void Add2CartAnim() {
        /* 起点 */
        int[] startXY = new int[2];
        btnAddGood.getLocationInWindow(startXY);
        startXY[0] += btnAddGood.getWidth() / 2;
        //startXY[1] += mBtnAddToCart.getHeight() / 2;
        int fx = startXY[0];
        int fy = startXY[1];
        final ImageView animImg = new ImageView(this);
//        Bitmap bm = ((BitmapDrawable) mGoodsView.getDrawable()).getBitmap();
        Bitmap bm = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_launcher)).getBitmap();
        animImg.setImageBitmap(Bitmap.createScaledBitmap(bm, 96, 96, false));

        ViewGroup anim_mask_layout = AddToCartHelper.createAnimLayout(this);
        anim_mask_layout.addView(animImg);
        final View v = AddToCartHelper.addViewToAnimLayout(this, anim_mask_layout, animImg, startXY, true);
        if (v == null) {
            return;
        }
        /* 终点 */
        final View cartView = tvShopCard;
        int[] endXY = new int[2];
        cartView.getLocationInWindow(endXY);
        int tx = endXY[0] + cartView.getWidth() / 2 - 48;
        int ty = endXY[1] + cartView.getHeight() / 2;
        /* 中点 */
        int mx = (tx + fx) / 2;
        int my = ScreenUtils.getScreenHeight(_activity) / 2;
        AddToCartHelper.startAnimationForJd(v, 0, 0, fx, fy, mx, my, tx, ty, new AddToCartHelper.AnimationListener() {
            @Override
            public void onAnimationEnd() {
//                mBinding.setAmount(++mAmount);
                //动画结束，做一下别的
                YoYo.with(new ScaleUpAnimator())
                        .duration(500)
                        .playOn(tvCount);
            }
        });
    }

    public class ScaleUpAnimator extends BaseViewAnimator {
        @Override
        public void prepare(View target) {
            //ViewGroup parent = (ViewGroup)target.getParent();
            //int distance = parent.getHeight() - target.getTop();
            getAnimatorAgent().playTogether(
                    //ObjectAnimator.ofFloat(target,"alpha",0,1,1),
                    ObjectAnimator.ofFloat(target, "scaleX", 0.8f, 1f, 1.4f, 1.2f, 1),
                    ObjectAnimator.ofFloat(target, "scaleY", 0.8f, 1f, 1.4f, 1.2f, 1)
                    //ObjectAnimator.ofFloat(target,"translationY",distance,-60,0)
            );
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        LogUtils.e("onActivityResult");
    }
}
