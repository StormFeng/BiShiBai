package com.midian.base.util;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by Administrator on 2016/11/3 0003.
 */

public class ShareUtil {
    public static void init(){
        PlatformConfig.setWeixin("wx6ec4b95185411c3c", "e27867f76bca1a55204d97ef785237d1");
        PlatformConfig.setQQZone("1105617978","U9N7NQne0tMIcaS0");
        PlatformConfig.setSinaWeibo("902141203","347df4167afd79fa1c822860a15aae14");

        //新浪后台的回调地址
        Config.REDIRECT_URL = "http://www.sina.com";
    }
}
