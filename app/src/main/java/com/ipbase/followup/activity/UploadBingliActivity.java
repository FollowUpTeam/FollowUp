package com.ipbase.followup.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.ipbase.followup.R;
import com.ipbase.followup.activity.base.AbsViewActivity;
import com.ipbase.followup.bean.Bingli;
import com.ipbase.followup.model.bean.User;
import com.ipbase.followup.widget.TitleBar;
import com.kesar.mvp.presenter.impl.MainPresenter;
import com.kesar.mvp.view.IMainView;
import com.kesar.mvp.view.ITitleBarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class UploadBingliActivity extends AbsViewActivity<MainPresenter> implements IMainView, ITitleBarView, TitleBar.BtnClickListener {

    @Bind(R.id.tbv_titlebar_upload)
    TitleBar tbvTitlebarUpload;
    @Bind(R.id.et_zhuYaoZhengZhuang)
    EditText etZhuYaoZhengZhuang;
    @Bind(R.id.et_zhenDuan)
    EditText etZhenDuan;
    @Bind(R.id.et_faBingGuoCheng)
    EditText etFaBingGuoCheng;
    @Bind(R.id.ll_jiuZhenXinXi)
    LinearLayout llJiuZhenXinXi;
    @Bind(R.id.btn_jiuZhenXinXi)
    ImageButton btnJiuZhenXinXi;
    @Bind(R.id.btn_RenYuanXinXi)
    ImageButton btnRenYuanXinXi;
    @Bind(R.id.ll_RenYuanXinXi)
    LinearLayout llRenYuanXinXi;
    private LayoutInflater layoutInflater;
    private static List<User> patientDatalist = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_upload_bingli;
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
        tbvTitlebarUpload.setTitleBarListener(this);
        setTitle("添加病历");
        setLeftBtnVisable(true);
        setRightBtnVisable(true);
        setRightBtnImage(R.drawable.icon_save);
        setRightToLeftBtnVisable(false);
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
        dialogFinish();
    }

    @Override
    public void rightClick() {
        UploadBingliData();
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
        if (tbvTitlebarUpload != null) {
            tbvTitlebarUpload.setTitle(title);
        }
    }

    /**
     * 设置左侧按钮是否可见
     *
     * @param flag 是否可见
     */
    @Override
    public void setLeftBtnVisable(boolean flag) {
        if (tbvTitlebarUpload != null) {
            tbvTitlebarUpload.setLeftBtnVisable(flag);
        }
    }

    /**
     * 设置右侧靠左的按钮是否可见
     *
     * @param flag
     */
    @Override
    public void setRightToLeftBtnVisable(boolean flag) {
        if (tbvTitlebarUpload != null) {
            tbvTitlebarUpload.setRightToLeftBtnVisable(flag);
        }
    }

    /**
     * 设置右侧按钮是否可见
     *
     * @param flag 是否可见
     */
    @Override
    public void setRightBtnVisable(boolean flag) {
        if (tbvTitlebarUpload != null) {
            tbvTitlebarUpload.setRightBtnVisable(flag);
        }
    }

    /**
     * 设置右侧按钮的图标
     *
     * @param resId
     */
    @Override
    public void setRightBtnImage(int resId) {
        if (tbvTitlebarUpload != null) {
            tbvTitlebarUpload.setRightBtnImage(resId);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.et_zhuYaoZhengZhuang)
    public void onDtZhuYaoZhengZhuangClicked() {
    }

    @OnClick(R.id.et_zhenDuan)
    public void onDtZhenDuanClicked() {
    }

    @OnClick(R.id.et_faBingGuoCheng)
    public void onEtFaBingGuoChengClicked() {
    }

    @OnClick(R.id.ll_jiuZhenXinXi)
    public void onLlJiuZhenXinXiClicked() {
        toast("跳转到病人信息");
    }

    @OnClick(R.id.btn_jiuZhenXinXi)
    public void onViewClicked() {
        toast("btn跳转到病人信息");
    }

    protected void dialogFinish() //删除确认对话框
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("");
        builder.setMessage("确认直接返回？");

        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 点击“确认”后的操作
                finish();
            }
        });
        builder.setNegativeButton("返回", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 点击“返回”后的操作
            }
        });
        //builder.show();
        //使用创建器生成一个对话框对象
        AlertDialog ad = builder.create();
        ad.show();

    }


    @OnClick(R.id.btn_RenYuanXinXi)
    public void onBtnRenYuanXinXiClicked() {
        showDialogChoosePatient();
    }

    @OnClick(R.id.ll_RenYuanXinXi)
    public void onLlRenYuanXinXiClicked() {
        showDialogChoosePatient();
    }

    private void UploadBingliData() {
        if (etZhuYaoZhengZhuang.getText().toString().equals("") ||
                etZhenDuan.getText().toString().equals("") ||
                etFaBingGuoCheng.getText().toString().equals("")) {
            toast("信息不全");
            return;
        }
        BmobUser bmobUser = BmobUser.getCurrentUser();
        //toast(bmobUser.getUsername());
        Bingli bingli = new Bingli();
        bingli.setDoctor(BmobUser.getCurrentUser());
        bingli.setName("老王");
        bingli.setAge("23");
        bingli.setGender("男");
        bingli.setReadFlag(false);
        bingli.setZhengzhuang(etZhuYaoZhengZhuang.getText().toString());
        bingli.setZhenduan(etZhenDuan.getText().toString());
        bingli.setFabing(etFaBingGuoCheng.getText().toString());
        bingli.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    toast("添加成功");
                    finish();
                } else {
                    toast("添加失败" + e.getMessage());
                }
            }
        });
    }

    private List<User> getPatientDataList() {
        BmobQuery<User> bmobQuery = new BmobQuery<>();
        bmobQuery.addQueryKeys("objectId");
        bmobQuery.addQueryKeys("username");
        bmobQuery.addQueryKeys("realName");
        bmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> object, BmobException e) {
                if (e == null) {
                    patientDatalist=object;
                    toast("共" + object.size() + "条数据。");
                    //注意：这里的Person对象中只有指定列的数据。
                } else {
                    toast("查询失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });
        return patientDatalist;
    }

    private void showDialogChoosePatient()//选择病人弹出对话框
    {

        toast("请选择病人");
    }
}
