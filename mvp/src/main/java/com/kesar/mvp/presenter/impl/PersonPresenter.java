package com.kesar.mvp.presenter.impl;

import com.kesar.mvp.model.IPersonModel;
import com.kesar.mvp.model.impl.PersonModel;
import com.kesar.mvp.presenter.AbsBasePresenter;
import com.kesar.mvp.view.IPersonView;

/**
 * MVP Presenter For PersonFragment
 * Created by kesar on 2016/4/23.
 */
public class PersonPresenter extends AbsBasePresenter<IPersonView,IPersonModel>
{
    private PersonPresenter(IPersonView view)
    {
        super(view, new PersonModel());
    }

    public static PersonPresenter build(IPersonView view){
        return new PersonPresenter(view);
    }
}
