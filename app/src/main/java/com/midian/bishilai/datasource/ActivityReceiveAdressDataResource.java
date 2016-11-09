package com.midian.bishilai.datasource;

import android.content.Context;

import com.midian.base.base.BaseListDataSource;
import com.midian.base.bean.NetResult;

import java.util.ArrayList;

/**
 * 收货地址
 */
public class ActivityReceiveAdressDataResource extends BaseListDataSource {

    public ActivityReceiveAdressDataResource(Context context) {
        super(context);
    }

    @Override
    protected ArrayList load(int page) throws Exception {
        this.page=page;
        ArrayList<NetResult> models = new ArrayList<>();
        for(int i=0;i<5;i++){
            NetResult netResult = new NetResult();
            models.add(netResult);
        }
        hasMore=false;
        return models;
    }
}
