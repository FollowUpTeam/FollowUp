package com.kesar.mvp.presenter.impl;

import android.text.TextUtils;

import com.kesar.mvp.model.IRegisterModel;
import com.kesar.mvp.model.base.CallBack;
import com.ipbase.followup.model.bean.User;
import com.kesar.mvp.model.impl.RegisterModel;
import com.kesar.mvp.presenter.AbsBasePresenter;
import com.kesar.mvp.view.IRegisterView;

/**
 * 注册Presenter
 * Created by kesar on 2016/4/5.
 */
public class RegisterPresenter extends AbsBasePresenter<IRegisterView, IRegisterModel>
{

    private RegisterPresenter(IRegisterView mView)
    {
        super(mView, new RegisterModel());
    }

    public static RegisterPresenter build(IRegisterView mView)
    {
        return new RegisterPresenter(mView);
    }

    /**
     * 点击注册按钮
     */
    public void clickDoRegBtn()
    {
        String phoneNum = getView().getEtPhoneNumText();
        String userName = getView().getEtUserNameText();
        String passWord = getView().getEtPassWordText();
        String rePassWord = getView().getEtRePassWordText();
        if (!checkInput(phoneNum, userName, passWord, rePassWord)) return;
        User user = getModel().buildUser(phoneNum, userName, passWord);
        getModel().doRegister(getView().getContext(), user, new CallBack()
        {

            @Override
            public void onSuccess()
            {
                getView().showToast("注册成功");
                getView().finishActivity();
            }

            @Override
            public void onFailure(Exception e)
            {
                getView().showToast("注册失败，失败信息：" + e.getMessage());
            }

            @Override
            public void onFinish()
            {

            }
        });
    }

    /**
     * 检查输入
     *
     * @param phoneNum
     * @param userName
     * @param passWord
     * @param rePassWord
     * @return
     */
    private boolean checkInput(String phoneNum, String userName, String passWord, String rePassWord)
    {
        if (TextUtils.isEmpty(phoneNum))
        {
            getView().showToast("手机号码不能为空");
            return false;
        }
        if (TextUtils.isEmpty(userName))
        {
            getView().showToast("用户名不能为空");
            return false;
        }
        if (TextUtils.isEmpty(passWord))
        {
            getView().showToast("密码不能为空");
            return false;
        }
        if (TextUtils.isEmpty(rePassWord))
        {
            getView().showToast("确认密码不能为空");
            return false;
        }
        if (!passWord.equals(rePassWord))
        {
            getView().showToast("密码和确认密码不一致");
            return false;
        }
        return true;
    }
}
