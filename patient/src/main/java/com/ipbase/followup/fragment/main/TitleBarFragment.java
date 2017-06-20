package com.ipbase.followup.fragment.main;

import android.os.Bundle;

import com.ipbase.followup.fragment.base.AbsViewFragment;
import com.kesar.mvp.presenter.AbsBasePresenter;
import com.kesar.mvp.view.ITitleBarView;

/**
 * 项目名称：FollowUp
 * 类描述：MainActivity对应的Fragment抽象类,For MVP
 * 创建人：lxh
 * 创建时间：2016/4/13 18:51
 * 修改人：kesar
 * 修改时间：2016/4/23 12:30
 * 修改备注：
 */
public abstract class TitleBarFragment<P extends AbsBasePresenter> extends AbsViewFragment<P>
{
    // 用于操作TitleBar的ITitleBarView的实例
    protected ITitleBarView mTitleBarView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        if (getActivity() instanceof ITitleBarView)
        {
            mTitleBarView = (ITitleBarView) getActivity();
        }
        super.onCreate(savedInstanceState);
    }

    /**
     * 设置标题
     *
     * @param text
     */
    public void setTitle(String text)
    {
        if (mTitleBarView != null)
        {
            mTitleBarView.setTitle(text);
        }
    }

    /**
     * 设置右侧靠左的按钮是否可见
     *
     * @param flag
     */
    public void setRightToLeftBtnVisable(boolean flag)
    {
        if (mTitleBarView != null)
        {
            mTitleBarView.setRightToLeftBtnVisable(flag);
        }
    }

    /**
     * 设置右侧按钮是否可见
     *
     * @param flag 是否可见
     */
    public void setRightBtnVisable(boolean flag)
    {
        if (mTitleBarView != null)
        {
            mTitleBarView.setRightBtnVisable(flag);
        }
    }

    /**
     * 设置右侧按钮的图标
     *
     * @param resId
     */
    public void setRightBtnImage(int resId)
    {
        if (mTitleBarView != null)
        {
            mTitleBarView.setRightBtnImage(resId);
        }
    }
}
