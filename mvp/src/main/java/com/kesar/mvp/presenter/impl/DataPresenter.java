package com.kesar.mvp.presenter.impl;

import com.kesar.mvp.model.IDataModel;
import com.kesar.mvp.model.impl.DataModel;
import com.kesar.mvp.presenter.AbsBasePresenter;
import com.kesar.mvp.view.IDataView;

/**
 * MVP Present For DataFragment
 * Created by kesar on 2016/4/23.
 */
public class DataPresenter extends AbsBasePresenter<IDataView,IDataModel>
{
    private DataPresenter(IDataView view)
    {
        super(view, new DataModel());
    }

    public static DataPresenter build(IDataView view){
        return new DataPresenter(view);
    }
}
