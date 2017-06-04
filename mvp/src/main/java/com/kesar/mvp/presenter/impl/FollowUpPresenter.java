package com.kesar.mvp.presenter.impl;

import com.kesar.mvp.model.IFollowUpModel;
import com.kesar.mvp.model.impl.FollowUpModel;
import com.kesar.mvp.presenter.AbsBasePresenter;
import com.kesar.mvp.view.IFollowUpView;

/**
 * MVP Presenter For FollowUpFragment
 * Created by kesar on 2016/4/23.
 */
public class FollowUpPresenter extends AbsBasePresenter<IFollowUpView,IFollowUpModel>
{
    private FollowUpPresenter(IFollowUpView view)
    {
        super(view, new FollowUpModel());
    }

    public static FollowUpPresenter build(IFollowUpView view){
        return new FollowUpPresenter(view);
    }
}
