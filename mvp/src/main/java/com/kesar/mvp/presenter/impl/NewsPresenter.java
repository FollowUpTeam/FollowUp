package com.kesar.mvp.presenter.impl;

import com.kesar.mvp.model.INewsModel;
import com.kesar.mvp.model.impl.NewsModel;
import com.kesar.mvp.presenter.AbsBasePresenter;
import com.kesar.mvp.view.INewsView;

/**
 * Presenter For NewsPresenter
 * Created by kesar on 2016/4/23.
 */
public class NewsPresenter extends AbsBasePresenter<INewsView,INewsModel>
{

    private NewsPresenter(INewsView view)
    {
        super(view, new NewsModel());
    }

    public static NewsPresenter build(INewsView view){
        return new NewsPresenter(view);
    }
}
