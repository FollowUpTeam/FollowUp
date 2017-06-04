package com.kesar.mvp.model.impl;

import android.content.Context;

import com.kesar.mvp.model.base.CallBack;
import com.kesar.mvp.model.ILoginModel;
import com.ipbase.followup.model.bean.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * 登陆model
 * Created by kesar on 2016/4/9.
 */
public class LoginModel implements ILoginModel
{
    @Override
    public User buildUser(String phoneNum, String passWord)
    {
        User user = new User();
        user.setUsername(phoneNum);
        user.setPassword(passWord);
        return user;
    }

    @Override
    public void doLogin(Context context, User user, final CallBack callBack)
    {
        if (user == null || context == null) return;
        user.login(new SaveListener<Object>()
        {
            @Override
            public void done(Object o, BmobException e)
            {
                if (callBack == null)
                {
                    return;
                }
                if (e == null)
                {
                    callBack.onSuccess();
                }
                else
                {
                    callBack.onFailure(e);
                }
                callBack.onFinish();
            }
        });
    }
}
