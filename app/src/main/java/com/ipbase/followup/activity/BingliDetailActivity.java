package com.ipbase.followup.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ipbase.followup.R;
import com.ipbase.followup.activity.base.AbsViewActivity;
import com.ipbase.followup.bean.Bingli;
import com.ipbase.followup.fragment.main.BingLiFragment;
import com.ipbase.followup.widget.TitleBar;
import com.kesar.mvp.presenter.impl.MainPresenter;
import com.kesar.mvp.view.IMainView;
import com.kesar.mvp.view.ITitleBarView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class BingliDetailActivity extends AbsViewActivity<MainPresenter> implements IMainView, ITitleBarView, TitleBar.BtnClickListener {


    @Bind(R.id.tbv_titlebar_bingliDetail)
    TitleBar tbvTitlebarBingliDetail;
    @Bind(R.id.tv_zhuYaoZhengZhuang)
    TextView tvZhuYaoZhengZhuang;
    @Bind(R.id.tv_zhenDuan)
    TextView tvZhenDuan;
    @Bind(R.id.tv_faBingGuoCheng)
    TextView tvFaBingGuoCheng;
    @Bind(R.id.detail_btn_jiuZhenXinXi)
    ImageButton detailBtnJiuZhenXinXi;
    @Bind(R.id.detail_ll_jiuZhenXinXi)
    LinearLayout detailLlJiuZhenXinXi;
    @Bind(R.id.detail_btn_RenYuanXinXi)
    ImageButton detailBtnRenYuanXinXi;
    @Bind(R.id.detail_ll_RenYuanXinXi)
    LinearLayout detailLlRenYuanXinXi;
    @Bind(R.id.bingli_detail_name)
    TextView bingliDetailName;
    private LayoutInflater layoutInflater;
    public static Bingli bingli;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bingli_detail;
    }

    @Override
    protected MainPresenter buildPresenter() {
        return MainPresenter.build(this);
    }

    @Override
    public void initView() {
        // 实例化布局对象
        layoutInflater = LayoutInflater.from(this);
        //实例化标题栏View
        tbvTitlebarBingliDetail.setTitleBarListener(this);
        setTitle("查看病历");
        setLeftBtnVisable(true);
        setRightBtnVisable(true);
        setRightBtnImage(R.drawable.icon_save);
        setRightToLeftBtnVisable(false);
        initData();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void showToast(String text) {
        toast(text);
    }

    @Override
    public void leftClick() {
        finish();
    }

    @Override
    public void rightClick() {

    }

    @Override
    public void rightToLeftClick() {
        getPresenter().rightToLeftClick();
    }

    /**
     * 设置标题
     *
     * @param title
     */
    @Override
    public void setTitle(String title) {
        if (tbvTitlebarBingliDetail != null) {
            tbvTitlebarBingliDetail.setTitle(title);
        }
    }

    /**
     * 设置左侧按钮是否可见
     *
     * @param flag 是否可见
     */
    @Override
    public void setLeftBtnVisable(boolean flag) {
        if (tbvTitlebarBingliDetail != null) {
            tbvTitlebarBingliDetail.setLeftBtnVisable(flag);
        }
    }

    /**
     * 设置右侧靠左的按钮是否可见
     *
     * @param flag
     */
    @Override
    public void setRightToLeftBtnVisable(boolean flag) {
        if (tbvTitlebarBingliDetail != null) {
            tbvTitlebarBingliDetail.setRightToLeftBtnVisable(flag);
        }
    }

    /**
     * 设置右侧按钮是否可见
     *
     * @param flag 是否可见
     */
    @Override
    public void setRightBtnVisable(boolean flag) {
        if (tbvTitlebarBingliDetail != null) {
            tbvTitlebarBingliDetail.setRightBtnVisable(flag);
        }
    }

    /**
     * 设置右侧按钮的图标
     *
     * @param resId
     */
    @Override
    public void setRightBtnImage(int resId) {
        if (tbvTitlebarBingliDetail != null) {
            tbvTitlebarBingliDetail.setRightBtnImage(resId);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }


    void initData() {
        tvFaBingGuoCheng.setText(bingli.getFabing().toString());
        tvZhuYaoZhengZhuang.setText(bingli.getZhengzhuang().toString());
        tvZhenDuan.setText(bingli.getZhenduan().toString());
        bingliDetailName.setText(bingli.getName().toString());
        setReadFlag();
        BingLiFragment.waitForRefresh=1;
    }

    void setReadFlag() {
        if (bingli.getReadFlag()) {
            return;
        }
        Bingli bingliFlag = new Bingli();
        bingliFlag.setReadFlag(true);
        bingliFlag.update(bingli.getObjectId(), new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    toast("已读");
                } else {
                    toast("更新标记失败");
                }
            }

        });
    }


    @OnClick(R.id.detail_btn_jiuZhenXinXi)
    public void onDetailBtnJiuZhenXinXiClicked() {
    }

    @OnClick(R.id.detail_ll_jiuZhenXinXi)
    public void onDetailLlJiuZhenXinXiClicked() {
    }

    @OnClick(R.id.detail_btn_RenYuanXinXi)
    public void onDetailBtnRenYuanXinXiClicked() {
    }

    @OnClick(R.id.detail_ll_RenYuanXinXi)
    public void onDetailLlRenYuanXinXiClicked() {
    }
}
