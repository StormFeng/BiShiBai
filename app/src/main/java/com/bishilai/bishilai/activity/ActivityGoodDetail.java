package com.bishilai.bishilai.activity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.bishilai.bishilai.R;
import com.bishilai.bishilai.adapter.AdapterRecommendGood;
import com.bishilai.bishilai.fragments.FragmentGoodDetail;
import com.bishilai.bishilai.utils.AddToCartHelper;
import com.bishilai.bishilai.utils.ScreenUtils;
import com.bishilai.bishilai.widget.Banner;
import com.bishilai.bishilai.widget.ButtonGroup;
import com.bishilai.bishilai.widget.ButtonGroupListener;
import com.bishilai.bishilai.widget.CountView;
import com.bishilai.bishilai.widget.HorizontalListView;
import com.bishilai.bishilai.widget.ScrollChangeListenerView;
import com.daimajia.androidanimations.library.BaseViewAnimator;
import com.daimajia.androidanimations.library.YoYo;
import com.jaeger.library.StatusBarUtil;
import com.makeramen.roundedimageview.RoundedImageView;
import com.nineoldandroids.animation.ObjectAnimator;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midian.baselib.base.BaseFragmentActivity;
import midian.baselib.utils.UIHelper;
import midian.baselib.widget.BaseLibTopbarView;
import midian.baselib.widget.ScrollChangeListener;

/**
 * Created by Administrator on 2016/10/19 0019.
 */

public class ActivityGoodDetail extends BaseFragmentActivity implements Banner.OnBannerClickListener {
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
    @BindView(R.id.countView)
    CountView countView;
    @BindView(R.id.btn_AddGood)
    Button btnAddGood;
    @BindView(R.id.tv_ShopCard)
    TextView tvShopCard;
    @BindView(R.id.horizontalListView)
    HorizontalListView horizontalListView;
    @BindView(R.id.buttonGroup)
    ButtonGroup buttonGroup;
    @BindView(R.id.tv_GoodDetai)
    TextView tvGoodDetai;
    @BindView(R.id.tv_Parameter)
    TextView tvParameter;
    @BindView(R.id.tv_Comment)
    TextView tvComment;

    private int[] location = new int[2];
    private Handler handler = new Handler();
    private Fragment fragment;
    private int flag;
    private ArrayList<String> images = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
    private float var1, var2;
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
        tagText.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                LogUtils.e(selectPosSet);
            }
        });

        scrollView.setChangeListener(scrollChangeListener);

        horizontalListView.setAdapter(new AdapterRecommendGood(_activity));

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

    TagAdapter<String> imageAdapter = new TagAdapter<String>(images) {
        @Override
        public View getView(FlowLayout parent, int position, String s) {
            RoundedImageView iv = (RoundedImageView) LayoutInflater.from(_activity).inflate(R.layout.tag_imagelayout, tagImage, false);
            ac.setImage(iv, images.get(position));
            return iv;
        }
    };

    TagAdapter<String> textAdapter = new TagAdapter<String>(tags) {
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
            if (0 == location[1]) {
                buttonGroup.getLocationOnScreen(location);
            }
            if (y < 0) {
                topbar.setTitle("");
                topbar.setBackgroundColor(Color.parseColor("#00FFFFFF"));
            } else if (y < 850 && y >= 0) {
                topbar.setTitle("");
                topbar.setVisibility(View.VISIBLE);
                var1 = (float) y / 850;
                var2 = var1 * 255;
                var3 = Integer.toHexString((int) var2);
                if (var3.length() == 1) {
                    var3 = "0" + var3;
                }
                color = new StringBuffer("#EB6563").insert(1, var3).toString();
                //LogUtils.e("y:"+y+"\n"+"var3:"+var3+"\n"+"color:"+color);
                topbar.setBackgroundColor(Color.parseColor(color));
            } else if (y >= 850) {
                topbar.setTitle("商品详情");
                topbar.setBackgroundColor(Color.parseColor("#EB6563"));
            }
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
        bundle.putString("position",position-1+"");
        UIHelper.jump(_activity, ActivityViewPhoto.class, bundle);
    }

    @OnClick({R.id.countView, R.id.btn_AddGood, R.id.tv_GoodDetai, R.id.tv_Parameter, R.id.tv_Comment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.countView:
                break;
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
                UIHelper.jump(_activity,ActivityComment.class);
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
                        .playOn(tvShopCard);
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
}
