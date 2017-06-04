package com.kesar.mvp.model.impl;

import android.content.Context;

import com.kesar.mvp.model.base.CallBack;
import com.kesar.mvp.model.IRegisterModel;
import com.ipbase.followup.model.bean.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * 注册Model
 * Created by kesar on 2016/4/5.
 */
public class RegisterModel implements IRegisterModel
{
    @Override
    public User buildUser(String phone, String realName, String password)
    {
        User user = new User();
        user.setUsername(phone);
        user.setRealName(realName);
        user.setPassword(password);
        user.setMobilePhoneNumber(phone);
        return user;
    }

    @Override
    public void doRegister(Context context, User user, final CallBack callBack)
    {
        user.signUp(new SaveListener<Object>()
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
