package com.bishilai.bishilai.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

public class DaoGoodBean {

    private List<GoodBean> list=new ArrayList<>();

    public static GoodBean  getGoodBeanList() {

        GoodBean.ContentBean.GooddetailBean gooddetailBean00=new GoodBean.ContentBean.GooddetailBean();
        gooddetailBean00.setId("0");
        gooddetailBean00.setPic("http://mengzhu.img-cn-shenzhen.aliyuncs.com/8a99524557c2dec90157c72795010007");
        gooddetailBean00.setCount("1");
        gooddetailBean00.setLimitcount("2");
        gooddetailBean00.setName("洁面乳");
        gooddetailBean00.setPrice("111");
        gooddetailBean00.setIsedit(false);
        gooddetailBean00.setIsselected(false);

        GoodBean.ContentBean.GooddetailBean gooddetailBean01=new GoodBean.ContentBean.GooddetailBean();
        gooddetailBean01.setId("1");
        gooddetailBean01.setPic("http://mengzhu.img-cn-shenzhen.aliyuncs.com/8a99524557c2dec90157c72795010007");
        gooddetailBean01.setCount("1");
        gooddetailBean01.setLimitcount("3");
        gooddetailBean01.setName("BB霜");
        gooddetailBean01.setPrice("222");
        gooddetailBean01.setIsedit(false);
        gooddetailBean01.setIsselected(false);
        List<GoodBean.ContentBean.GooddetailBean> list=new ArrayList<>();
        list.add(gooddetailBean00);
        list.add(gooddetailBean01);

        GoodBean.ContentBean contentBean=new GoodBean.ContentBean();
        contentBean.setGooddetail(list);
        contentBean.setId("00");
        contentBean.setAdress("广州天河公园");
        contentBean.setIsselected(false);

        GoodBean.ContentBean.GooddetailBean gooddetailBean11=new GoodBean.ContentBean.GooddetailBean();
        gooddetailBean11.setId("3");
        gooddetailBean11.setPic("http://mengzhu.img-cn-shenzhen.aliyuncs.com/8a99524557c2dec90157c72795010007");
        gooddetailBean11.setCount("1");
        gooddetailBean11.setLimitcount("5");
        gooddetailBean11.setName("男士洁面乳");
        gooddetailBean11.setPrice("888");
        gooddetailBean11.setIsedit(false);
        gooddetailBean11.setIsselected(false);
        List<GoodBean.ContentBean.GooddetailBean> list1=new ArrayList<>();
        list1.add(gooddetailBean11);

        GoodBean.ContentBean contentBean1=new GoodBean.ContentBean();
        contentBean1.setGooddetail(list1);
        contentBean1.setId("01");
        contentBean1.setAdress("广州市天河又一城");
        contentBean1.setIsselected(false);


        List<GoodBean.ContentBean> contentBeanList=new ArrayList<>();
        contentBeanList.add(contentBean);
        contentBeanList.add(contentBean1);

        GoodBean goodBean=new GoodBean();
        goodBean.setContent(contentBeanList);
        return goodBean;
    }
}
