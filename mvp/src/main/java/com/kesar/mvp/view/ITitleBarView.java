package com.kesar.mvp.view;

/**
 * MVP View For TitleBar
 * Created by kesar on 2016/4/23.
 */
public interface ITitleBarView
{
    /**
     * 设置标题
     *
     * @param title
     */
     void setTitle(String title);

    /**
     * 设置右侧靠左的按钮是否可见
     *
     * @param flag
     */
     void setRightToLeftBtnVisable(boolean flag);

    /**
     * 设置右侧按钮是否可见
     *
     * @param flag 是否可见
     */
     void setRightBtnVisable(boolean flag);

    /**
     * 设置右侧按钮的图标
     *
     * @param resId
     */
    void setRightBtnImage(int resId);
}
