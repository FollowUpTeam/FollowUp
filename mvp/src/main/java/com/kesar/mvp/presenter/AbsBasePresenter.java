package com.kesar.mvp.presenter;

import com.kesar.mvp.model.base.IModel;
import com.kesar.mvp.view.base.IView;

/**
 * 每次创建一个Presenter类的时候必须继承它
 * Created by kesar on 2016/4/3.
 */
public abstract class AbsBasePresenter<V extends IView,M extends IModel> implements IPresenter<V,M>
{
    private final V mView;
    private final M mModel;

    public AbsBasePresenter(V view, M model)
    {
        this.mView = view;
        this.mModel=model;
    }

    @Override
    public void onCreate()
    {
        if(mView!=null){
            mView.initView();
        }
    }

    @Override
    public V getView()
    {
        return mView;
    }

    @Override
    public M getModel()
    {
        return mModel;
    }
}
