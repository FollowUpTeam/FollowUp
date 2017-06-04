package com.ipbase.followup.activity;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import com.ipbase.followup.R;
import com.ipbase.followup.activity.base.AbsViewActivity;
import com.kesar.mvp.presenter.impl.RegisterPresenter;
import com.kesar.mvp.view.IRegisterView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 注册界面
 */
public class RegActivity extends AbsViewActivity<RegisterPresenter> implements IRegisterView
{
    @Bind(R.id.et_phone)
    EditText mEtPhone;
    @Bind(R.id.et_username)
    EditText mEtUserName;
    @Bind(R.id.et_password)
    EditText mEtPassword;
    @Bind(R.id.et_repassword)
    EditText mEtRePassword;
    @Bind(R.id.btn_doregister)
    Button mBtnReg;

    @Override
    protected int getLayoutId()
    {
        return R.layout.aty_reg;
    }

    @Override
    protected RegisterPresenter buildPresenter()
    {
        return RegisterPresenter.build(this);
    }

    @Override
    public void initView()
    {
    }

    @Override
    public Context getContext()
    {
        return getApplicationContext();
    }

    @Override
    public void showToast(String text)
    {
        toast(text);
    }

    @OnClick(R.id.btn_doregister)
    protected void clickDoRegBtn(){
        getPresenter().clickDoRegBtn();
    }

    @Override
    public void finishActivity()
    {
        this.finish();
    }

    @Override
    public String getEtPhoneNumText()
    {
        return mEtPhone.getText().toString();
    }

    @Override
    public String getEtUserNameText()
    {
        return mEtUserName.getText().toString();
    }

    @Override
    public String getEtPassWordText()
    {
        return mEtPassword.getText().toString();
    }

    @Override
    public String getEtRePassWordText()
    {
        return mEtRePassword.getText().toString();
    }
}
