package com.midian.bishilai.app;

import com.midian.base.util.ShareUtil;

import midian.baselib.app.AppContext;

/**
 * Created by Administrator on 2016/11/3 0003.
 */

public class BaseAppContext extends AppContext{

    @Override
    public void onCreate() {
        super.onCreate();
        ShareUtil.init();
    }
}
