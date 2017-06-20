package com.ipbase.followup.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ipbase.followup.R;
import com.ipbase.followup.activity.base.AbsViewActivity;
import com.ipbase.followup.base.ParentWithNaviActivity;
import com.ipbase.followup.event.FinishEvent;
import com.ipbase.followup.model.BaseModel;
import com.ipbase.followup.model.UserModel;
import com.kesar.mvp.presenter.impl.RegisterPresenter;
import com.kesar.mvp.view.IRegisterView;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

/**
 * 注册界面
 */
public class RegActivity extends ParentWithNaviActivity
{
   /* @Bind(R.id.et_phone)
    EditText mEtPhone;
    @Bind(R.id.et_username)
    EditText mEtUserName;
    @Bind(R.id.et_password)
    EditText mEtPassword;
    @Bind(R.id.et_repassword)
    EditText mEtRePassword;
    @Bind(R.id.btn_doregister)
    Button mBtnReg;*/
   @Bind(R.id.et_username)
   EditText et_username;
    @Bind(R.id.et_password)
    EditText et_password;
    @Bind(R.id.btn_register)
    Button btn_register;

    @Bind(R.id.et_password_again)
    EditText et_password_again;

    @Override
    protected String title() {
        return "注册";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initNaviView();
    }

    @OnClick(R.id.btn_register)
    public void onRegisterClick(View view){
        UserModel.getInstance().register(et_username.getText().toString(), et_password.getText().toString(),et_password_again.getText().toString(),new LogInListener() {
            @Override
            public void done(Object o, BmobException e) {
                if(e==null){
                    EventBus.getDefault().post(new FinishEvent());
                    startActivity(MainActivity.class, null, true);
                }else{
                    if(e.getErrorCode()== BaseModel.CODE_NOT_EQUAL){
                        et_password_again.setText("");
                    }
                    toast(e.getMessage()+"("+e.getErrorCode()+")");
                }
            }
        });
    }

   /* @Override
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
    }*/
}
