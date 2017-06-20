package com.kesar.mvp.model;

import android.content.Context;

import com.ipbase.followup.model.bean.User;
import com.kesar.mvp.model.base.CallBack;
import com.kesar.mvp.model.base.IModel;

/**
 * 登陆model
 * Created by kesar on 2016/4/9.
 */
public interface ILoginModel extends IModel
{
    User buildUser(String phoneNum, String passWord);

    /**
     * 登陆操作
     * @param context
     * @param user
     * @param callBack
     */
    void doLogin(Context context, User user, final CallBack callBack);
}
