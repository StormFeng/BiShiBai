package com.midian.bishilai.utils;

import android.os.CountDownTimer;
import android.widget.Button;

/**
 * Created by Administrator on 2016/11/2 0002.
 */

public class HelpUtil {
    public static void downTime(final Button var) {
        CountDownTimer mCountDownTimer = new CountDownTimer(59 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String timeText = "秒";
                var.setClickable(false);
                var
                        .setText(millisUntilFinished / 1000 + timeText);
            }

            @Override
            public void onFinish() {
                var.setClickable(true);
                var.setText("获取验证码");
            }
        };
        mCountDownTimer.start();
    }
}
