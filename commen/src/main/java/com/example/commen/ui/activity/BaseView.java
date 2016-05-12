package com.example.commen.ui.activity;

import android.view.View;

/**
 * Created by Administrator on 2016/3/18.
 */
public interface BaseView {


    /**
     * 初始化数据
     */
    void initData();

    /**
     * 在线程中初始化数据
     */
    void initDataFromThread();

    /**
     * 初始化控件
     */
    void initWidget();

    /**
     * 点击事件回调方法
     */
    void widgetClick(View v);
}
