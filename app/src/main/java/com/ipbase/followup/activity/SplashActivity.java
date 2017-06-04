package com.ipbase.followup.activity;

import android.content.Context;
import android.os.Handler;

import com.ipbase.followup.R;
import com.ipbase.followup.activity.base.AbsViewActivity;
import com.kesar.common_utils.SkipActivityUtil;
import com.kesar.mvp.presenter.impl.SplashPresenter;
import com.kesar.mvp.view.ISplashView;

/**
 * 启动画面
 * Created by kesar on 2016/4/3.
 */
public class SplashActivity extends AbsViewActivity<SplashPresenter> implements ISplashView
{
    @Override
    protected int getLayoutId()
    {
        return R.layout.aty_splash;
    }

    @Override
    protected SplashPresenter buildPresenter()
    {
        return SplashPresenter.build(this);
    }

    @Override
    public void initView()
    {
        getPresenter().loadAndIntData();
    }

    @Override
    public Handler getHandler(){
        return new Handler();
    }

    @Override
    public Context getContext()
    {
        return getApplicationContext();
    }

    @Override
    public void showToast(String text)
    {
        toast(text);
    }

    @Override
    public void skipToLoginActivity()
    {
        //SkipActivityUtil.skip(this,LoginActivity.class);
        SkipActivityUtil.skip(this,MainActivity.class);

        finish();
    }

    @Override
    public void skipToMainActivity()
    {
        SkipActivityUtil.skip(this,MainActivity.class);
        finish();
    }
}
