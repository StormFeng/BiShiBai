package com.midian.bishilai.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;

import com.midian.base.app.AppManager;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.bishilai.MainActivity;
import com.midian.bishilai.R;

public class ActivityWelcom extends BaseActivity implements OnClickListener {
    private Button button;
    private Object app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView iv = (ImageView) findViewById(R.id.imageView1);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);
//        button.setVisibility(View.GONE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setAnimationListener(aListener);
        iv.setAnimation(alphaAnimation);
    }


    private AnimationListener aListener = new AnimationListener() {

        @Override
        public void onAnimationEnd(Animation arg0) {
            button.postDelayed(new Runnable() {

                @Override
                public void run() {
                    inApp();
                }
            }, 3000);
        }

        @Override
        public void onAnimationRepeat(Animation arg0) {
        }

        @Override
        public void onAnimationStart(Animation arg0) {
        }
    };


    @Override
    public void onClick(View v) {
        super.onClick(v);
        v.setEnabled(false);
        UIHelper.jump(ActivityWelcom.this, MainActivity.class);
        ac.setBoolean("app", true);
        finish();
    }

    @Override
    public void onParseError(String tag) {
        super.onParseError(tag);
        AppManager.getAppManager().appExit(_activity);
        inApp();
    }

    private  void inApp(){
        if (ac.getBoolean("app")) {
            UIHelper.jump(ActivityWelcom.this, MainActivity.class);
        } else {
            ac.setBoolean("app", true);
            UIHelper.jump(ActivityWelcom.this, ActivityGuide.class);
        }
        finish();
    }
}
