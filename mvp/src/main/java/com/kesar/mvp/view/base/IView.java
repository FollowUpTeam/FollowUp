package com.kesar.mvp.view.base;

import android.content.Context;

/**
 * Created by kesar on 2016/4/3.
 */
public interface IView
{
    /**
     * 将需要在onCreate()方法中做的操作都在这个方法实现
     */
    public void initView();

    public Context getContext();

    public void showToast(String text);
}