package com.ipbase.followup.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ipbase.followup.R;
import com.ipbase.followup.activity.base.AbsViewActivity;
import com.kesar.common_utils.SkipActivityUtil;
import com.kesar.mvp.presenter.impl.LoginPresenter;
import com.kesar.mvp.view.ILoginView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 登陆界面
 */
public class LoginActivity extends AbsViewActivity<LoginPresenter> implements ILoginView
{
    @Bind(R.id.et_phone)
    EditText mEtPhoneNum;
    @Bind(R.id.et_password)
    EditText mEtPassword;
    @Bind(R.id.tv_regiter)
    TextView mTvRegister;
    @Bind(R.id.tv_forgetpwd)
    TextView mTvForgetPwd;
    @Bind(R.id.btn_dologin)
    Button mBtnDoLogin;

    private ProgressDialog mLoadDialog;

    @Override
    protected int getLayoutId()
    {
        return R.layout.aty_login;
    }

    @Override
    protected LoginPresenter buildPresenter()
    {
        return LoginPresenter.build(this);
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

    @Override
    public String getEtPhoneNumText()
    {
        return mEtPhoneNum.getText().toString();
    }

    @Override
    public String getEtPassWordText()
    {
        return mEtPassword.getText().toString();
    }

    @Override
    public void skipToMainActivity()
    {
        SkipActivityUtil.skip(this, MainActivity.class);
        finish();
    }

    @Override
    public void skipToRegActivity()
    {
        SkipActivityUtil.skip(this, RegActivity.class);
    }

    @Override
    public void skipToForgetPwdActivity()
    {
        //SkipActivityUtil.skip(this,);
    }

    @Override
    public void showDialog()
    {
        if (mLoadDialog == null)
        {
            mLoadDialog = new ProgressDialog(this);
            mLoadDialog.setMessage("登陆中");
        }
        mLoadDialog.show();
    }

    @Override
    public void dismissDialog()
    {
        if (mLoadDialog == null) return;
        if (mLoadDialog.isShowing()) mLoadDialog.dismiss();
    }

    /**
     * 登陆操作
     */
    @OnClick(R.id.btn_dologin)
    protected void clickDoLoginBtn()
    {
        getPresenter().clickDoLoginBtn();
    }

    /**
     * 跳转注册界面
     */
    @OnClick(R.id.tv_regiter)
    protected void clickSkipToRegActivity()
    {
        getPresenter().skipToRegActivity();
    }

    /**
     * 跳转到忘记密码界面
     */
    @OnClick(R.id.tv_forgetpwd)
    protected void clickSkipToForgetPwdActivity()
    {
        getPresenter().skipToForgetPwdActivity();
    }
}
