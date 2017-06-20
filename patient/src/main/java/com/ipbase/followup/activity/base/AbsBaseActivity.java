package com.ipbase.followup.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.kesar.common_utils.ToastUtils;


/**
 * 最最基础的Activity类
 * Created by kesar on 2016/4/3.
 */
public abstract class AbsBaseActivity extends AppCompatActivity
{
    protected final String TAG =getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // 设置layout布局
        setContentView(getLayoutId());
    }

    /**
     * 获取布局layout Id，自己写返回layout id
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * toast字符串资源
     * @param resId
     */
    protected void toast(int resId){
        ToastUtils.show(getApplicationContext(),resId);
    }

    /**
     * toast文本
     * @param text
     */
    protected void toast(String text){
        if(TextUtils.isEmpty(text)){
            log("toast失败，字符串是空的");
        }
        else{
            ToastUtils.show(getApplicationContext(),text);
        }
    }

    /**
     * 打印log
     * @param text
     */
    protected void log(String text){
        if(TextUtils.isEmpty(text)){
            Log.i(TAG,"log失败,字符串是空的");
        }
        else{
            Log.i(TAG,text);
        }
    }
}
