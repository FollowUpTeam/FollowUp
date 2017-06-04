package com.kesar.mvp.view;

import com.kesar.mvp.view.base.IView;

/**
 * 注册view
 * Created by kesar on 2016/4/5.
 */
public interface IRegisterView extends IView
{
    /**
     * 关闭activity
     */
    public void finishActivity();

    /**
     * 获取edittext中手机号文本
     * @return
     */
    public String getEtPhoneNumText();

    /**
     * 获取edittext中用户名文本
     * @return
     */
    public String getEtUserNameText();

    /**
     * 获取edittext中密码文本
     * @return
     */
    public String getEtPassWordText();

    /**
     * 获取edittext中重输密码文本
     * @return
     */
    public String getEtRePassWordText();
}
