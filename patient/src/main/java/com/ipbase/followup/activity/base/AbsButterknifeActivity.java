package com.ipbase.followup.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;

/**
 * 带有注解框架Butterknife的Activity
 * Created by kesar on 2016/4/22.
 */
public abstract class AbsButterknifeActivity extends AbsBaseActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
