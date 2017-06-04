package com.ipbase.followup.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kesar.mvp.presenter.AbsBasePresenter;

/**
 * 用于MVP模式中Activity的基础类
 * Created by kesar on 2016/4/22.
 */
public abstract class AbsViewActivity<P extends AbsBasePresenter> extends AbsButterknifeActivity
{
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // 实例化presenter
        mPresenter=buildPresenter();
        if(mPresenter!=null){
            // 调用presenter
            mPresenter.onCreate();
        }
    }

    /**
     * 实例化Presenter，自己手动实例它
     * @return
     */
    protected abstract P buildPresenter();

    /**
     * 返回一个Presenter实例
     * @return
     */
    public P getPresenter(){
        if(mPresenter==null){
            throw new NullPointerException("你没重写buildPresenter方法返回一个Presenter实例");
        }
        return mPresenter;
    }
}
