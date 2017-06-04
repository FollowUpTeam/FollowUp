package com.ipbase.followup.fragment.main;

import com.ipbase.followup.R;
import com.kesar.mvp.presenter.impl.FollowUpPresenter;
import com.kesar.mvp.view.IFollowUpView;

/**
 * 项目名称：FollowUp
 * 类描述：随访界面
 * 创建人：lxh
 * 创建时间：2016/4/13 8:16
 * 修改人：lxh
 * 修改时间：2016/4/13 8:16
 * 修改备注：
 */
public class FollowUpFragment extends TitleBarFragment<FollowUpPresenter> implements IFollowUpView
{
    @Override
    protected int getLayoutId()
    {
        return R.layout.fragment_followup;
    }

    @Override
    public void initView()
    {
        setTitle("随访");
        setRightBtnVisable(true);
        setRightToLeftBtnVisable(false);
        setRightBtnImage(R.drawable.icon_add);
    }

    @Override
    protected FollowUpPresenter buildPresenter()
    {
        return FollowUpPresenter.build(this);
    }

    @Override
    public void showToast(String text)
    {
        toast(text);
    }
}
