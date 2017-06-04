package com.kesar.mvp.model;

import android.content.Context;

import com.kesar.mvp.model.base.CallBack;
import com.kesar.mvp.model.base.IModel;
import com.ipbase.followup.model.bean.User;

/**
 * Created by kesar on 2016/4/9.
 */
public interface IRegisterModel extends IModel
{
    /**
     * 创建User
     * @param phone
     * @param username
     * @param password
     * @return
     */
    User buildUser(String phone,String username,String password);

    /**
     * 注册用户
     * @param context
     * @param user
     * @param callBack
     */
    void doRegister(Context context, User user, final CallBack callBack);

}
