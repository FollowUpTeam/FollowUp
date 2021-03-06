package com.kesar.common_utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Toast工具类：让使用Toast更简单
 * Created by kesar on 2016/4/22.
 */
public class ToastUtils {
    private final static String TAG = "ToastUtils";

    public static void show(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
        Log.i(TAG, context.getResources().getString(resId));
    }

//    public static void show(Context context,String text){
//        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
//        Log.i(TAG,text);
//    }

    /**
     * 可覆盖前一条消息显示的toast工具
     */
    private static Toast mToast;//控制toast时间

    public static void show(Context context, String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
        Log.i(TAG, text);
    }

    public static void showLong(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
        Log.i(TAG, context.getResources().getString(resId));
    }

    public static void showLong(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
        Log.i(TAG, text);
    }

}