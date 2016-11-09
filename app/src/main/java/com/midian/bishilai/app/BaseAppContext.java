package com.midian.bishilai.app;

import com.midian.base.app.AppContext;
import com.midian.base.util.ShareUtil;

/**
 * Created by Administrator on 2016/11/3 0003.
 */

public class BaseAppContext extends AppContext {

    @Override
    public void onCreate() {
        super.onCreate();
        ShareUtil.init();
    }
}
