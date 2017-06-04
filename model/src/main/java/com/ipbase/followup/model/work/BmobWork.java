package com.ipbase.followup.model.work;

import android.content.Context;

import com.kesar.library.bmob.BmobSDK;

/**
 * Bomb的初始化的业务逻辑
 * Created by kesar on 2016/4/3.
 */
public class BmobWork {
    /**
     * 初始化Bmob SDK
     *
     * @param context
     */
    public void initSDK(Context context) {
        BmobSDK.init(context);
    }
}
