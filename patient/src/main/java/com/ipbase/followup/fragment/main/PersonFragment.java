package com.ipbase.followup.fragment.main;

import com.ipbase.followup.R;
import com.kesar.mvp.presenter.impl.PersonPresenter;
import com.kesar.mvp.view.IPersonView;


/**
 * 项目名称：FollowUp
 * 类描述：用户界面
 * 创建人：lxh
 * 创建时间：2016/4/13 8:16
 * 修改人：lxh
 * 修改时间：2016/4/13 8:16
 * 修改备注：
 */
public class PersonFragment extends TitleBarFragment<PersonPresenter> implements IPersonView
{

    @Override
    protected int getLayoutId()
    {
        return R.layout.fragment_person;
    }

    @Override
    public void initView()
    {
        setTitle("用户");
        setRightBtnVisable(false);
        setRightToLeftBtnVisable(false);
    }

    @Override
    protected PersonPresenter buildPresenter()
    {
        return PersonPresenter.build(this);
    }

    @Override
    public void showToast(String text)
    {
        toast(text);
    }
}
