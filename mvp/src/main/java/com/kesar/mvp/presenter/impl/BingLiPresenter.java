package com.kesar.mvp.presenter.impl;

import com.kesar.mvp.model.IBingLiModel;
import com.kesar.mvp.model.impl.BingLiModel;
import com.kesar.mvp.presenter.AbsBasePresenter;
import com.kesar.mvp.view.IBingLiView;

/**
 * MVP Presenter for BingLiFragment
 * Created by kesar on 2016/4/23.
 */
public class BingLiPresenter extends AbsBasePresenter<IBingLiView,IBingLiModel>
{
    private BingLiPresenter(IBingLiView view)
    {
        super(view, new BingLiModel());
    }

    public static BingLiPresenter build(IBingLiView view){
        return new BingLiPresenter(view);
    }
}
