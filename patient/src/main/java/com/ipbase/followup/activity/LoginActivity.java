package com.ipbase.followup.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.ipbase.followup.R;
import com.ipbase.followup.base.BaseActivity;
import com.ipbase.followup.event.FinishEvent;
import com.ipbase.followup.model.UserModel;
import com.ipbase.followup.model.bean.User;
import com.kesar.common_utils.SkipActivityUtil;
import com.kesar.common_utils.ToastUtils;

import org.greenrobot.eventbus.Subscribe;

import butterknife.Bind;
import butterknife.OnClick;
import cn.bmob.newim.BmobIM;
import cn.bmob.newim.bean.BmobIMUserInfo;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

/**
 * 登陆界面
 */
public class LoginActivity extends BaseActivity
{

    @Bind(R.id.et_username)
    EditText et_username;
    @Bind(R.id.et_password)
    EditText et_password;
    @Bind(R.id.btn_login)
    Button btn_login;
    @Bind(R.id.tv_register)
    TextView tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @OnClick(R.id.btn_login)
    public void onLoginClick(View view){
        UserModel.getInstance().login(et_username.getText().toString(), et_password.getText().toString(), new LogInListener() {

            @Override
            public void done(Object o, BmobException e) {
                if (e == null) {
                    User user =(User)o;
                    if (!user.getPatient())
                    {
                        toast("登录失败，该帐号为医生用户");
                        return;
                    }
                    BmobIM.getInstance().updateUserInfo(new BmobIMUserInfo(user.getObjectId(), user.getUsername(), user.getAvatar()));
                    startActivity(MainActivity.class, null, true);
                } else {
                    toast(e.getMessage() + "(" + e.getErrorCode() + ")");
                }
            }
        });
    }

    @OnClick(R.id.tv_register)
    public void onRegisterClick(View view){
        startActivity(RegActivity.class, null, false);
    }

    @Subscribe
    public void onEventMainThread(FinishEvent event){
        finish();
    }

   /* @Bind(R.id.et_phone)
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_login);

    }

    @OnClick(R.id.btn_dologin)
    public void onLoginClick(View view){
        UserModel.getInstance().login(mEtPhoneNum.getText().toString(), mEtPassword.getText().toString(), new LogInListener() {

            @Override
            public void done(Object o, BmobException e) {
                if (e == null) {
                    User user =(User)o;
                    BmobIM.getInstance().updateUserInfo(new BmobIMUserInfo(user.getObjectId(), user.getUsername(), user.getAvatar()));
                    startActivity(MainActivity.class, null, true);
                } else {
                    toast(e.getMessage() + "(" + e.getErrorCode() + ")");
                }
            }
        });
    }

    public void skipToMainActivity()
    {
        SkipActivityUtil.skip(this, MainActivity.class);
        finish();
    }

    public void skipToRegActivity()
    {
        SkipActivityUtil.skip(this, RegActivity.class);
    }

    public void skipToForgetPwdActivity()
    {
        //SkipActivityUtil.skip(this,);
    }

    public void showDialog()
    {
        if (mLoadDialog == null)
        {
            mLoadDialog = new ProgressDialog(this);
            mLoadDialog.setMessage("登陆中");
        }
        mLoadDialog.show();
    }

    public void dismissDialog()
    {
        if (mLoadDialog == null) return;
        if (mLoadDialog.isShowing()) mLoadDialog.dismiss();
    }*/

    /**
     * 登陆操作
     */
  /*  @OnClick(R.id.btn_dologin)
    protected void clickDoLoginBtn()
    {
    }*/

    /**
     * 检查输入
     * @param phoneNum
     * @param passWord
     * @return
     */
    /*private boolean checkInput(String phoneNum,String passWord){
        if(TextUtils.isEmpty(phoneNum)){
            ToastUtils.showLong(this,"账号不能为空");
            return false;
        }
        if(TextUtils.isEmpty(passWord)){
            ToastUtils.showLong(this,"密码不能为空");
            return false;
        }
        return true;
    }

    *//**
     * 跳转注册界面
     *//*
    @OnClick(R.id.tv_regiter)
    protected void clickSkipToRegActivity()
    {
        skipToRegActivity();
    }

    *//**
     * 跳转到忘记密码界面
     *//*
    @OnClick(R.id.tv_forgetpwd)
    protected void clickSkipToForgetPwdActivity()
    {

    }*/
}
