package com.ipbase.followup.fragment.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ipbase.followup.R;
import com.ipbase.followup.adapter.BingliAdapter;
import com.ipbase.followup.bean.Bingli;
import com.kesar.mvp.presenter.impl.BingLiPresenter;
import com.kesar.mvp.view.IBingLiView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 项目名称：FollowUp
 * 类描述：病历界面
 * 创建人：lxh
 * 创建时间：2016/4/13 8:16
 * 修改人：lxh
 * 修改时间：2016/4/13 8:16
 * 修改备注：
 */
public class BingLiFragment extends TitleBarFragment<BingLiPresenter> implements IBingLiView {


    @Bind(R.id.lv_bingliFragment)
    ListView lvBingliFragment;

    private List<Bingli> list = new ArrayList<>();
    //private HashMap<String, Object> map = new HashMap<>();
    private Bingli bingliData = new Bingli();
    private BingliAdapter bingliAdapter;
    private int gravatar;
    private String name;
    private String sex;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bingli;
    }

    @Override
    public void initView() {
        setTitle("病历");
        setRightBtnVisable(true);
        setRightToLeftBtnVisable(false);
        setRightBtnImage(R.drawable.icon_add);

    }

    @Override
    protected BingLiPresenter buildPresenter() {
        return BingLiPresenter.build(this);
    }


    @Override
    public void showToast(String text) {
        toast(text);
    }

    public void initList() {
        bingliData.setName("老王");
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.head);
        bingliData.setHead(drawable);
        bingliData.setGender("男");
        bingliData.setAge("23");
        list.add(bingliData);
        bingliAdapter = new BingliAdapter(getContext(), list);
        lvBingliFragment.setAdapter(bingliAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        initList();
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);


    }


}
