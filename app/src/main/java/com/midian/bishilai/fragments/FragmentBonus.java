package com.midian.bishilai.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midian.bishilai.R;
import com.midian.bishilai.datasource.FramentBonusDataResource;
import com.midian.bishilai.tpl.FragmentBonusTpl;

import java.util.ArrayList;

import midian.baselib.base.BaseFragment;
import midian.baselib.base.BaseListFragment;
import midian.baselib.shizhefei.view.listviewhelper.IDataAdapter;
import midian.baselib.shizhefei.view.listviewhelper.IDataSource;

/**
 * 我的钱包-奖金
 * Created by Administrator on 2016/10/25 0025.
 */

public class FragmentBonus extends BaseListFragment{

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new FramentBonusDataResource(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        return FragmentBonusTpl.class;
    }
}
