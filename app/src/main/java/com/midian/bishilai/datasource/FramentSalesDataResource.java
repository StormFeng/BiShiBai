package  com.midian.bishilai.datasource;

import android.content.Context;

import com.midian.base.base.BaseListDataSource;
import com.midian.base.bean.NetResult;

import java.util.ArrayList;


/**
 * 我的消费额
 */
public class FramentSalesDataResource extends BaseListDataSource {

    public FramentSalesDataResource(Context context) {
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
