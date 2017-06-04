package com.ipbase.followup.model.manager;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences 管理类
 * Created by kesar on 2016/4/24.
 */
public class SpfManager
{
    private final Context mContext;

    public SpfManager(Context context){
        this.mContext=context;
    }

    public SharedPreferences getSharedPreferences(String name){
        return mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
    }
}
