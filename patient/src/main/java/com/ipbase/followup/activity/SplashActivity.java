package com.ipbase.followup.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.ipbase.followup.R;
import com.ipbase.followup.activity.base.AbsViewActivity;
import com.ipbase.followup.base.BaseActivity;
import com.ipbase.followup.model.UserModel;
import com.ipbase.followup.model.bean.User;
import com.kesar.common_utils.SkipActivityUtil;
import com.kesar.mvp.view.ISplashView;

/**
 * 启动画面
 * Created by kesar on 2016/4/3.
 */
public class SplashActivity extends BaseActivity
{
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.aty_splash );
        Handler handler = new Handler( Looper.getMainLooper() );
        handler.postDelayed( new Runnable()
        {
            @Override
            public void run()
            {
                User user = UserModel.getInstance().getCurrentUser();
                if ( user == null )
                {
                    startActivity( LoginActivity.class, null, true );
                }
                else
                {
                    startActivity( MainActivity.class, null, true );
                }
            }
        }, 2000 );

    }
   /* @Override
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
        SkipActivityUtil.skip(this,LoginActivity.class);
        //SkipActivityUtil.skip(this,MainActivity.class);

        finish();
    }

    @Override
    public void skipToMainActivity()
    {
        SkipActivityUtil.skip(this,MainActivity.class);
        finish();
    }*/
}
