package com.ipbase.followup.fragment.main;

import android.util.Log;

import com.ipbase.followup.R;
import com.kesar.mvp.presenter.impl.NewsPresenter;
import com.kesar.mvp.view.INewsView;

/**
 * 项目名称：FollowUp
 * 类描述：消息界面
 * 创建人：lxh
 * 创建时间：2016/4/13 8:16
 * 修改人：lxh
 * 修改时间：2016/4/13 8:16
 * 修改备注：
 */
public class NewsFragment extends TitleBarFragment<NewsPresenter> implements INewsView
{
    @Override
    protected int getLayoutId()
    {
        return R.layout.fragment_news;
    }

    @Override
    protected NewsPresenter buildPresenter()
    {
        return NewsPresenter.build(this);
    }

    @Override
    public void initView()
    {
        setTitle("消息");
        setRightBtnVisable(true);
        setRightToLeftBtnVisable(true);
        setRightBtnImage(R.drawable.icon_more);
    }

    @Override
    public void showToast(String text)
    {
        toast(text);
    }
}
