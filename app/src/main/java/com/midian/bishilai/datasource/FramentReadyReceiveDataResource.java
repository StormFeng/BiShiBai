package com.midian.bishilai.datasource;

import android.content.Context;

import java.util.ArrayList;

import midian.baselib.base.BaseListDataSource;
import midian.baselib.bean.NetResult;

/**
 * 待收货
 */
public class FramentReadyReceiveDataResource extends BaseListDataSource {

    public FramentReadyReceiveDataResource(Context context) {
        super(context);
    }

    @Override
    protected ArrayList load(int page) throws Exception {
        this.page=page;
        ArrayList<NetResult> models = new ArrayList<>();
        for(int i=0;i<10;i++){
            NetResult netResult = new NetResult();
            models.add(netResult);
        }
        hasMore=false;
        return models;
    }
}
