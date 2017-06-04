package com.ipbase.followup;

import android.app.Application;
import butterknife.ButterKnife;

/**
 * Created by kesar on 2016/4/3.
 */
public class AppApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        ButterKnife.setDebug(BuildConfig.DEBUG);
    }
}
