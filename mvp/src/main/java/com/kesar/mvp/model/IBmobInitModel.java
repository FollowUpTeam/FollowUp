package com.kesar.mvp.model;

import android.content.Context;

import com.kesar.mvp.model.base.IModel;

/**
 * Created by kesar on 2016/4/9.
 */
public interface IBmobInitModel extends IModel
{
    void initBmobSdk(Context context);
}
