package com.kesar.mvp.presenter.impl;

import com.kesar.mvp.model.IMainModel;
import com.kesar.mvp.model.impl.MainModel;
import com.kesar.mvp.presenter.AbsBasePresenter;
import com.kesar.mvp.view.IMainView;

/**
 * 项目名称：FollowUp
 * 类描述：
 * 创建人：lxh
 * 创建时间：2016/4/13 15:53
 * 修改人：lxh
 * 修改时间：2016/4/13 15:53
 * 修改备注：
 */
public class MainPresenter extends AbsBasePresenter<IMainView, IMainModel>
{
    private MainPresenter(IMainView mView) {
        super(mView,new MainModel());
    }

    public static MainPresenter build(IMainView view) {
        return new MainPresenter(view);
    }

    /**
     * 点击标题栏右侧按钮
     */
    public void rightClick() {
        getView().showToast("rightClick");
    }

    /**
     * 点击标题栏右侧靠左的按钮
     */
    public void rightToLeftClick() {
        getView().showToast("rightToLeftClick");
    }

}
