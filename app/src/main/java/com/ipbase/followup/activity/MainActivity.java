package com.ipbase.followup.activity;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.ipbase.followup.R;
import com.ipbase.followup.activity.base.AbsViewActivity;
import com.kesar.mvp.presenter.impl.MainPresenter;
import com.ipbase.followup.fragment.main.BingLiFragment;
import com.ipbase.followup.fragment.main.DataFragment;
import com.ipbase.followup.fragment.main.FollowUpFragment;
import com.ipbase.followup.fragment.main.NewsFragment;
import com.ipbase.followup.fragment.main.PersonFragment;
import com.kesar.mvp.view.IMainView;
import com.kesar.mvp.view.ITitleBarView;
import com.ipbase.followup.widget.TitleBar;

import butterknife.Bind;

/**
 * 项目名称：FollowUp
 * 类描述：主界面
 * 创建人：lxh
 * 创建时间：2016/4/13 8:16
 * 修改人：lxh
 * 修改时间：2016/4/13 8:16
 * 修改备注：
 */
public class MainActivity extends AbsViewActivity<MainPresenter> implements IMainView, ITitleBarView, TitleBar.BtnClickListener
{

    @Bind(android.R.id.tabhost)
    FragmentTabHost mTabHost; // 定义FragmentTabHost对象

    @Bind(R.id.tbv_titlebar)
    TitleBar mTitleBar; // 标题栏View

    // 定义一个布局
    private LayoutInflater layoutInflater;

    // 定义数组来存放Fragment界面
    protected final Class fragmentArray[] = {NewsFragment.class, BingLiFragment.class, FollowUpFragment.class, DataFragment.class, PersonFragment.class};

    // 定义数组来存放按钮图片
    private final int mImageViewArray[] = {R.drawable.icon_news, R.drawable.icon_bingli, R.drawable.icon_followup, R.drawable.icon_data, R.drawable.icon_person};

    // Tab选项卡的文字
    private final String mTextViewArray[] = {"消息", "病历", "随访", "数据", "用户"};


    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter buildPresenter()
    {
        return MainPresenter.build(this);
    }

    @Override
    public void initView()
    {
        // 实例化布局对象
        layoutInflater = LayoutInflater.from(this);

        //实例化标题栏View
        mTitleBar.setTitleBarListener(this);

        // 实例化TabHost对象，得到TabHost
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        // 给每个Tab按钮设置图片和文字
        for (int i = 0; i < fragmentArray.length; i++)
        {
            // 为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextViewArray[i]).setIndicator(getTabItemView(i));
            // 将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            // 设置Tab按钮的背景
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
            final int j = i;
            mTabHost.getTabWidget().getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTabHost.setCurrentTab(j);
                    mTabHost.getTabWidget().requestFocus(View.FOCUS_FORWARD);
                    switch (j)
                    {
                        case 0:
                            setTitle("消息");
                            setRightBtnVisable(true);
                            setRightToLeftBtnVisable(true);
                            setRightBtnImage(R.drawable.icon_more);
                            break;
                        case 1:
                            setTitle("病历");
                            setRightBtnVisable(true);
                            setRightToLeftBtnVisable(false);
                            setRightBtnImage(R.drawable.icon_add);
                            break;
                        case 2:
                            setTitle("随访");
                            setRightBtnVisable(true);
                            setRightToLeftBtnVisable(false);
                            setRightBtnImage(R.drawable.icon_add);
                            break;
                        case 3:
                            setTitle("数据报表");
                            setRightBtnVisable(true);
                            setRightToLeftBtnVisable(false);
                            setRightBtnImage(R.drawable.icon_add);
                            break;
                        case 4:
                            setTitle("用户");
                            setRightBtnVisable(false);
                            setRightToLeftBtnVisable(false);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }

    @Override
    public Context getContext()
    {
        return getApplicationContext();
    }

    @Override
    public void showToast(String text)
    {
        toast(text);
    }

    /**
     * 给Tab按钮设置图标和文字
     *
     * @param index
     * @return
     */
    private View getTabItemView(int index)
    {
        View view = layoutInflater.inflate(R.layout.item_tab_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_tab);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.tv_tab);
        textView.setText(mTextViewArray[index]);

        return view;
    }

    @Override
    public void leftClick()
    {
    }

    @Override
    public void rightClick()
    {
        getPresenter().rightClick();
    }

    @Override
    public void rightToLeftClick()
    {
        getPresenter().rightToLeftClick();
    }

    /**
     * 设置标题
     *
     * @param title
     */
    @Override
    public void setTitle(String title)
    {
        if (mTitleBar != null)
        {
            mTitleBar.setTitle(title);
        }
    }

    /**
     * 设置右侧靠左的按钮是否可见
     *
     * @param flag
     */
    @Override
    public void setRightToLeftBtnVisable(boolean flag)
    {
        if (mTitleBar != null)
        {
            mTitleBar.setRightToLeftBtnVisable(flag);
        }
    }

    /**
     * 设置右侧按钮是否可见
     *
     * @param flag 是否可见
     */
    @Override
    public void setRightBtnVisable(boolean flag)
    {
        if (mTitleBar != null)
        {
            mTitleBar.setRightBtnVisable(flag);
        }
    }

    /**
     * 设置右侧按钮的图标
     *
     * @param resId
     */
    @Override
    public void setRightBtnImage(int resId)
    {
        if (mTitleBar != null)
        {
            mTitleBar.setRightBtnImage(resId);
        }
    }
}
