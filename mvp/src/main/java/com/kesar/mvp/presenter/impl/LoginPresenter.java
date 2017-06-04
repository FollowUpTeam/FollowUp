package com.kesar.mvp.presenter.impl;

import android.text.TextUtils;

import com.kesar.mvp.model.ILoginModel;
import com.kesar.mvp.model.base.CallBack;
import com.ipbase.followup.model.bean.User;
import com.kesar.mvp.model.impl.LoginModel;
import com.kesar.mvp.presenter.AbsBasePresenter;
import com.kesar.mvp.view.ILoginView;

/**
 * 登陆Presenter
 * Created by kesar on 2016/4/9.
 */
public class LoginPresenter extends AbsBasePresenter<ILoginView,ILoginModel>
{
    private LoginPresenter(ILoginView mView)
    {
        super(mView,new LoginModel());
    }

    public static LoginPresenter build(ILoginView view){
        return new LoginPresenter(view);
    }

    /**
     * 跳转到注册界面
     */
    public void skipToRegActivity(){
        getView().skipToRegActivity();
    }

    /**
     * 跳转到忘记密码界面
     */
    public void skipToForgetPwdActivity(){
        getView().skipToForgetPwdActivity();
    }

    /**
     * 点击登陆按钮
     */
    public void clickDoLoginBtn(){
        String phoneNum=getView().getEtPhoneNumText();
        String passWord=getView().getEtPassWordText();
        if(!checkInput(phoneNum,passWord)) return;

        User user=getModel().buildUser(phoneNum,passWord);
        getView().showDialog();
        getModel().doLogin(getView().getContext(), user, new CallBack()
        {
            @Override
            public void onSuccess()
            {
                getView().showToast("登陆成功");
                getView().skipToMainActivity();
            }

            @Override
            public void onFailure(Exception e)
            {
                getView().showToast(e.getMessage());
            }

            @Override
            public void onFinish()
            {
                getView().dismissDialog();
            }
        });
    }

    /**
     * 检查输入
     * @param phoneNum
     * @param passWord
     * @return
     */
    private boolean checkInput(String phoneNum,String passWord){
        if(TextUtils.isEmpty(phoneNum)){
            getView().showToast("手机号码不能为空");
            return false;
        }
        if(TextUtils.isEmpty(passWord)){
            getView().showToast("密码不能为空");
            return false;
        }
        return true;
    }
}
