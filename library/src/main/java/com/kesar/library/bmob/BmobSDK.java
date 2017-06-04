package com.kesar.library.bmob;

import android.content.Context;

import cn.bmob.v3.Bmob;

/**
 * Bmob sdk二次封装
 * Created by kesar on 2016/4/24.
 */
public class BmobSDK
{
    private final static String BMOB_CACHE_DIRNAME="followup"; // Bmob缓存文件夹名
    private final static String BMOB_APPID="ceab8798fef29823aa758cb2cea06bfd"; // Bmob开发appid

    /**
     * 初始化sdk
     * @param context
     */
    public static void init(Context context){
        Bmob.initialize(context, BMOB_APPID);
    }
}
