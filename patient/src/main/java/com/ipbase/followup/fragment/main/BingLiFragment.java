package com.ipbase.followup.fragment.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ipbase.followup.R;
import com.ipbase.followup.activity.BingliDetailActivity;
import com.ipbase.followup.activity.UploadBingliActivity;
import com.ipbase.followup.adapter.BingliAdapter;
import com.ipbase.followup.base.ParentWithNaviActivity;
import com.ipbase.followup.base.ParentWithNaviFragment;
import com.ipbase.followup.bean.Bingli;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.DeleteListener;
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
public class BingLiFragment extends ParentWithNaviFragment {


    @Bind(R.id.lv_bingliFragment)
    ListView lvBingliFragment;
    @Bind(R.id.bingli_swipeRefresh)
    SwipeRefreshLayout bingliSwipeRefresh;
    private List<Bingli> list = new ArrayList<>();
    private Bingli bingliData = new Bingli();
    private BingliAdapter bingliAdapter;
    private int gravatar;
    private String name;
    private String sex;
    private boolean isRefreshing=false;
    public static int waitForRefresh=0;
   /* @Override
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
    }*/

    @Override
    protected String title() {
        return "病历";
    }

    @Override
    public Object right() {
        return R.drawable.base_action_bar_add_bg_selector;
    }

    @Override
    public ParentWithNaviActivity.ToolBarListener setToolBarListener() {
        return new ParentWithNaviActivity.ToolBarListener() {
            @Override
            public void clickLeft() {

            }

            @Override
            public void clickRight() {
                startActivity(UploadBingliActivity.class,null);
            }
        };
    }

    public void initList() {//创建病例数据列表
        bingliAdapter = new BingliAdapter(getContext(), list);
        lvBingliFragment.setAdapter(bingliAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_bingli,container, false);
        initNaviView();
        ButterKnife.bind(this, rootView);

        bingliSwipeRefresh.post(new Runnable(){
            @Override
            public void run() {
                bingliSwipeRefresh.setRefreshing(true);
                new Thread(getDataRunable).start();
            }
        });
        //initList();
//            new Thread(getDataRunable).start();

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

        if(waitForRefresh==1)
        {
            waitForRefresh=0;
            new Thread(getDataRunable).start();
        }
//        new Thread(getDataRunable).start();
    }

    void setReadFlag(Bingli bingli,Boolean bool) {
        Bingli bingliFlag = new Bingli();
        bingliFlag.setReadFlag(bool);
        bingliFlag.update(getContext(),bingli.getObjectId(), new UpdateListener() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailure(int i, String s) {
                toast("设置失败");
            }

        });
    }

    protected void dialogDel(final int position) //删除确认对话框
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("其它？");
        builder.setItems(new String[]{"删除此病历","标记为未读"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                    {
                        deleteBingli(list.get(position));
                        list.remove(position);
                        stopRefresh();
                    }break;
                    case 1:
                    {
                        setReadFlag(list.get(position),false);
                        new Thread(getDataRunable).start();
                    }break;
                }
            }
        });
        builder.show();
    }

    private void deleteBingli(Bingli bingli)//删除bmob病历
    {
        bingli.delete(getContext(), bingli.getObjectId(), new DeleteListener() {
            @Override
            public void onSuccess() {
                toast("删除成功");
            }

            @Override
            public void onFailure(int i, String s) {
                toast("删除失败");
            }
        });
    }

    private List<Bingli> getBmobBingli()
    {
        BmobQuery<Bingli> query1=new BmobQuery<>();
        query1.setLimit(100);
        query1.order("-createdAt");
        query1.addWhereEqualTo("doctor", BmobUser.getCurrentUser(getContext()));
        query1.findObjects(getContext(),new FindListener<Bingli>() {
            @Override
            public void onSuccess(List<Bingli> bmobList) {
                list=bmobList;
                initList();
                toast("已刷新病历列表");
            }

            @Override
            public void onError(int i, String s) {
                toast("刷新病历列表失败："+s);
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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(bingliSwipeRefresh!=null)
                bingliSwipeRefresh.setRefreshing(false);
            }
        }, 1000);
        //toast("已刷新病历列表");
    }


}
