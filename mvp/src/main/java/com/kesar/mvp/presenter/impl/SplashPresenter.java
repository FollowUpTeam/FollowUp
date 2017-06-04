package com.kesar.mvp.presenter.impl;

import com.kesar.mvp.model.IBmobInitModel;
import com.kesar.mvp.model.impl.BmobInitModel;
import com.kesar.mvp.presenter.AbsBasePresenter;
import com.kesar.mvp.view.ISplashView;

import java.util.concurrent.TimeUnit;

/**
 * 启动画面的Presenter
 * Created by kesar on 2016/4/3.
 */
public class SplashPresenter extends AbsBasePresenter<ISplashView,IBmobInitModel>
{
    private final int wait_time=5; // 启动画面等待时间

    private SplashPresenter(ISplashView view){
        super(view,new BmobInitModel());
    }

    /**
     * 唯一获取实例的方式
     * @param view
     * @return
     */
    public static SplashPresenter build(ISplashView view)
    {
        return new SplashPresenter(view);
    }


    /**
     * 在其他线程中加载和初始化数据
     */
    public void loadAndIntData(){
        getView().getHandler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                // 加载初始化bmob
                getModel().initBmobSdk(getView().getContext());
                // 跳转
                getView().skipToLoginActivity();
                //getView().skipToMainActivity();

            }
        }, TimeUnit.SECONDS.toMillis(wait_time));
    }
}
