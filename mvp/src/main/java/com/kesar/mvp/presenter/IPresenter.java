package com.kesar.mvp.presenter;

import com.kesar.mvp.model.base.IModel;
import com.kesar.mvp.view.base.IView;

/**
 * Created by kesar on 2016/4/3.
 */
public interface IPresenter<V extends IView,M extends IModel>
{
    /**
     * 在Aty和frag中onCreate方法中调用的方法
     */
    void onCreate();

    V getView();

    M getModel();
}