package com.midian.bishilai.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.apkfuns.logutils.LogUtils;
import com.midian.bishilai.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import midian.baselib.base.BaseFragment;

/**
 * Created by Administrator on 2016/10/20 0020.
 */

public class FragmentGoodDetail extends BaseFragment {

    @BindView(R.id.webView)
    WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gooddetail, null);
        ButterKnife.bind(this, v);
        webView.loadUrl("http://www.baidu.com");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl("http://www.baidu.com");
                return true;
            }
        });
        return v;
    }
}
