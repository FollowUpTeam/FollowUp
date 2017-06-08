package com.ipbase.followup.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.ipbase.followup.R;
import com.ipbase.followup.activity.base.AbsViewActivity;
import com.ipbase.followup.widget.TitleBar;
import com.kesar.mvp.presenter.impl.MainPresenter;
import com.kesar.mvp.view.IMainView;
import com.kesar.mvp.view.ITitleBarView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UploadBingliActivity extends AbsViewActivity<MainPresenter> implements IMainView, ITitleBarView, TitleBar.BtnClickListener {

    @Bind(R.id.tbv_titlebar_upload)
    TitleBar tbvTitlebarUpload;
    private LayoutInflater layoutInflater;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_upload_bingli);
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_upload_bingli;
    }

    @Override
    protected MainPresenter buildPresenter() {
        return MainPresenter.build(this);
    }

    @Override
    public void initView() {
        // 实例化布局对象
        layoutInflater = LayoutInflater.from(this);

        //实例化标题栏View
        tbvTitlebarUpload.setTitleBarListener(this);
        setTitle("添加病历");
        setRightBtnVisable(true);
        setRightToLeftBtnVisable(false);
        setRightBtnImage(R.drawable.icon_save);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void showToast(String text) {
        toast(text);
    }

    @Override
    public void leftClick() {
    }

    @Override
    public void rightClick() {
        toast("添加成功");
    }

    @Override
    public void rightToLeftClick() {
        getPresenter().rightToLeftClick();
    }

    /**
     * 设置标题
     *
     * @param title
     */
    @Override
    public void setTitle(String title) {
        if (tbvTitlebarUpload != null) {
            tbvTitlebarUpload.setTitle(title);
        }
    }
    /**
     * 设置右侧靠左的按钮是否可见
     *
     * @param flag
     */
    @Override
    public void setRightToLeftBtnVisable(boolean flag)
    {
        if (tbvTitlebarUpload != null)
        {
            tbvTitlebarUpload.setRightToLeftBtnVisable(flag);
        }
    }

    /**
     * 设置右侧按钮是否可见
     *
     * @param flag 是否可见
     */
    @Override
    public void setRightBtnVisable(boolean flag)
    {
        if (tbvTitlebarUpload != null)
        {
            tbvTitlebarUpload.setRightBtnVisable(flag);
        }
    }

    /**
     * 设置右侧按钮的图标
     *
     * @param resId
     */
    @Override
    public void setRightBtnImage(int resId)
    {
        if (tbvTitlebarUpload != null)
        {
            tbvTitlebarUpload.setRightBtnImage(resId);
        }
    }

}
