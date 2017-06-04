package com.kesar.mvp.view;

import com.kesar.mvp.view.base.IView;

/**
 * 登陆用的View
 * Created by kesar on 2016/4/9.
 */
public interface ILoginView extends IView
{
    String getEtPhoneNumText();
    String getEtPassWordText();

    void skipToMainActivity();
    void skipToRegActivity();
    void skipToForgetPwdActivity();

    void showDialog();
    void dismissDialog();
}
