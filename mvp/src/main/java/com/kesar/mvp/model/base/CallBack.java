package com.kesar.mvp.model.base;

/**
 * 回调函数
 * Created by kesar on 2016/4/9.
 */
public interface CallBack
{
    void onSuccess();
    void onFailure(Exception s);
    void onFinish();
}
