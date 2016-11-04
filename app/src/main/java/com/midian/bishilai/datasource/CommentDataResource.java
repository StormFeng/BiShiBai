package com.midian.bishilai.datasource;

import android.content.Context;
import java.util.ArrayList;
import midian.baselib.base.BaseListDataSource;
import midian.baselib.bean.NetResult;

public class CommentDataResource extends BaseListDataSource {

    public CommentDataResource(Context context) {
        super(context);
    }

    public CommentDataResource(Context context, String activity_id) {
        super(context);
    }

    @Override
    protected ArrayList load(int page) throws Exception {
        this.page=page;
        ArrayList<NetResult> models = new ArrayList<>();
        if(page==1){
            NetResult top = new NetResult();
            top.setItemViewType(0);
            models.add(top);
        }
        for(int i=0;i<10;i++){
            NetResult netResult = new NetResult();
            netResult.setItemViewType(1);
            models.add(netResult);
        }
        hasMore=false;
        return models;
    }
}
