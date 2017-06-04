package com.kesar.mvp.model.impl;

import android.content.Context;

import com.kesar.mvp.model.IBmobInitModel;
import com.ipbase.followup.model.work.BmobWork;

/**
 * Bmob初始化的model
 * Created by kesar on 2016/4/3.
 */
public class BmobInitModel implements IBmobInitModel
{
    private final BmobWork mWork;

    public BmobInitModel()
    {
        mWork=new BmobWork();
    }

    /**
     * 初始化bmob sdk
     * @param context
     */
    public void initBmobSdk(Context context){
        mWork.initSDK(context);
    }
}
