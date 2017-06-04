package com.kesar.mvp.view;

import android.os.Handler;

import com.kesar.mvp.view.base.IView;

/**
 * 启动画面的View
 * Created by kesar on 2016/4/3.
 */
public interface ISplashView extends IView
{
    /**
     * 跳转到登陆界面
     */
    void skipToLoginActivity();

    /**
     * 跳转到主界面
     */
    void skipToMainActivity();

    Handler getHandler();
}