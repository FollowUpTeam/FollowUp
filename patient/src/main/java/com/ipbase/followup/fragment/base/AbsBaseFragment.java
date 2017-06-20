package com.ipbase.followup.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kesar.common_utils.ToastUtils;


/**
 * Created by kesar on 2016/4/22.
 */
public abstract class AbsBaseFragment extends Fragment
{
    protected final String TAG =getClass().getName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(getLayoutId(),null);
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
        ToastUtils.show(getContext(),resId);
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
            ToastUtils.show(getContext(),text);
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
