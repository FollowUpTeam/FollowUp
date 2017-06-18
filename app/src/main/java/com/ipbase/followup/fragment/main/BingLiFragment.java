package com.ipbase.followup.fragment.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ipbase.followup.R;
import com.ipbase.followup.activity.BingliDetailActivity;
import com.ipbase.followup.adapter.BingliAdapter;
import com.ipbase.followup.bean.Bingli;
import com.kesar.library.bmob.BmobSDK;
import com.kesar.mvp.presenter.impl.BingLiPresenter;
import com.kesar.mvp.view.IBingLiView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;


/**
 * 项目名称：FollowUp
 * 类描述：病历界面
 * 创建人：lxh
 * 创建时间：2016/4/13 8:16
 * 修改人：locky
 * 修改时间：2017/6/6
 * 修改备注：实现功能
 */
public class BingLiFragment extends TitleBarFragment<BingLiPresenter> implements IBingLiView {


    @Bind(R.id.lv_bingliFragment)
    ListView lvBingliFragment;
    @Bind(R.id.bingli_swipeRefresh)
    SwipeRefreshLayout bingliSwipeRefresh;
    //public static SwipeRefreshLayout refreshLayout;
    private List<Bingli> list = new ArrayList<>();
    //private HashMap<String, Object> map = new HashMap<>();
    private Bingli bingliData = new Bingli();
    private BingliAdapter bingliAdapter;
    private int gravatar;
    private String name;
    private String sex;
    private View rootView;
    private boolean isRefreshing=false;
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

    public void initList() {//创建病例数据列表
        bingliAdapter = new BingliAdapter(getContext(), list);
        lvBingliFragment.setAdapter(bingliAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
            ButterKnife.bind(this, rootView);
            initList();
            bingliSwipeRefresh.post(new Runnable(){
                @Override
                public void run() {
                    bingliSwipeRefresh.setRefreshing(true);
                }
            });


            bingliSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {

                    new Thread(getDataRunable).start();//启动刷新数据线程
                }

            });

            lvBingliFragment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//跳转详细病历
                    BingliDetailActivity.bingli=list.get(position);
                    Intent intent=new Intent(getContext(),BingliDetailActivity.class);
                    startActivity(intent);
                }
            });
            lvBingliFragment.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    dialogDel(position);//删除本地数据
                    return true;
                }
            });
        }


        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onResume() {//返回界面时刷新
        super.onResume();
        new Thread(getDataRunable).start();

    }

    protected void dialogDel(final int position) //删除确认对话框
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("确认删除此病历？");
        builder.setItems(new String[]{"确认删除"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                    {
                        deleteBingli(list.get(position));
                        list.remove(position);
                        stopRefresh();
                    }

                        break;
                }
            }
        });
        builder.show();
    }

    private void deleteBingli(Bingli bingli)//删除bmob病历
    {
        bingli.delete(bingli.getObjectId(), new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    toast("删除成功");
                }else{
                }
            }

        });
    }

    private List<Bingli> getBmobBingli()
    {
        BmobQuery<Bingli> query1=new BmobQuery<>();
        query1.setLimit(100);
        query1.order("-createdAt");
        query1.addWhereEqualTo("doctor", BmobUser.getCurrentUser());
        query1.findObjects(new FindListener<Bingli>() {
            @Override
            public void done(List<Bingli> bmobList, BmobException e) {
                if(e==null){
                    list=bmobList;
                    initList();
                }else{
                }
            }
        });
        return list;
    }

    Runnable getDataRunable = new Runnable() {
        @Override
        public void run() {
            bingliAdapter=new BingliAdapter(getContext(),getBmobBingli());
            isRefreshing=false;

            getActivity().runOnUiThread(stopRefreshRunnable);//更新listview界面数据
        }
    };

    Runnable stopRefreshRunnable=new Runnable() {
        @Override
        public void run() {
            stopRefresh();
        }
    };


    private void stopRefresh() {
        bingliAdapter.notifyDataSetChanged();
        bingliSwipeRefresh.setRefreshing(false);

        //toast("已刷新病历列表");
    }


}
