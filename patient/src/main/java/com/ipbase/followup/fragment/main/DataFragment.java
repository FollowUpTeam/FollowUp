package com.ipbase.followup.fragment.main;

import com.ipbase.followup.R;
import com.kesar.mvp.presenter.impl.DataPresenter;
import com.kesar.mvp.view.IDataView;

/**
 * 项目名称：FollowUp
 * 类描述：数据界面
 * 创建人：lxh
 * 创建时间：2016/4/13 8:16
 * 修改人：lxh
 * 修改时间：2016/4/13 8:16
 * 修改备注：
 */
public class DataFragment extends TitleBarFragment<DataPresenter> implements IDataView
{
    @Override
    protected int getLayoutId()
    {
        return R.layout.fragment_data;
    }

    @Override
    public void initView()
    {
        setTitle("数据报表");
        setRightBtnVisable(true);
        setRightToLeftBtnVisable(false);
        setRightBtnImage(R.drawable.icon_add);
    }

    @Override
    protected DataPresenter buildPresenter()
    {
        return DataPresenter.build(this);
    }

    @Override
    public void showToast(String text)
    {
        toast(text);
    }
}
