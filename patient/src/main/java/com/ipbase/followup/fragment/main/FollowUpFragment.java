package com.ipbase.followup.fragment.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.ipbase.followup.R;
import com.ipbase.followup.activity.ChatActivity;
import com.ipbase.followup.activity.DoFollowUpActivity;
import com.ipbase.followup.activity.NewFriendActivity;
import com.ipbase.followup.activity.SearchUserActivity;
import com.ipbase.followup.adapter.FollowUpAdapter;
import com.ipbase.followup.adapter.OnRecyclerViewListener;
import com.ipbase.followup.adapter.base.IMutlipleItem;
import com.ipbase.followup.base.ParentWithNaviActivity;
import com.ipbase.followup.base.ParentWithNaviFragment;
import com.ipbase.followup.bean.Conversation;
import com.ipbase.followup.bean.FollowUp;
import com.ipbase.followup.bean.Friend;
import com.ipbase.followup.bean.NewFriendConversation;
import com.ipbase.followup.bean.PrivateConversation;
import com.ipbase.followup.db.NewFriend;
import com.ipbase.followup.db.NewFriendManager;
import com.ipbase.followup.model.UserModel;
import com.ipbase.followup.model.bean.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bmob.newim.BmobIM;
import cn.bmob.newim.bean.BmobIMConversation;
import cn.bmob.newim.bean.BmobIMUserInfo;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.DeleteListener;
import cn.bmob.v3.listener.FindListener;

/**
 * 项目名称：FollowUp
 * 类描述：随访界面
 * 创建人：lxh
 * 创建时间：2016/4/13 8:16
 * 修改人：lxh
 * 修改时间：2016/4/13 8:16
 * 修改备注：
 */
public class FollowUpFragment extends ParentWithNaviFragment
{
    @Bind( R.id.rc_view )
    RecyclerView rc_view;
    @Bind( R.id.sw_refresh )
    SwipeRefreshLayout sw_refresh;
    FollowUpAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected String title() {
        return "随访";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate( R.layout.fragment_followup, container, false );
        initNaviView();
        ButterKnife.bind( this, rootView );
        //单一布局
        IMutlipleItem<FollowUp> mutlipleItem = new IMutlipleItem<FollowUp>()
        {

            @Override
            public int getItemViewType( int postion, FollowUp c )
            {
                return 0;
            }

            @Override
            public int getItemLayoutId( int viewtype )
            {
                return R.layout.item_followup;
            }

            @Override
            public int getItemCount( List< FollowUp > list )
            {
                return list.size();
            }
        };
        adapter = new FollowUpAdapter( getActivity(), mutlipleItem, null );
        rc_view.setAdapter( adapter );
        layoutManager = new LinearLayoutManager( getActivity() );
        rc_view.setLayoutManager( layoutManager );
        sw_refresh.setEnabled( true );
        setListener();

        return rootView;
    }

    private void setListener(){
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                sw_refresh.setRefreshing(true);
                query();
            }
        });
        sw_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                query();
            }
        });
        adapter.setOnRecyclerViewListener(new OnRecyclerViewListener() {
            @Override
            public void onItemClick(int position) {
                    startActivity(DoFollowUpActivity.class, null);
            }

            @Override
            public boolean onItemLongClick(final int position) {
                return true;
            }
        });
    }

    @Override
    public void onResume()
    {
        super.onResume();
        sw_refresh.setRefreshing( true );
        query();
    }

    /**
     * 查询随访
     */
    public void query(){
        getFollowUps(new FindListener<FollowUp>() {
            @Override
            public void onSuccess(List<FollowUp> list) {
                adapter.bindDatas(list);
                adapter.notifyDataSetChanged();
                sw_refresh.setRefreshing(false);
            }

            @Override
            public void onError(int i, String s) {
                toast(s);
                adapter.bindDatas(null);
                adapter.notifyDataSetChanged();
                sw_refresh.setRefreshing(false);
            }
        });
    }

    /**
     * 获取随访列表的数据
     *
     * @return
     */
    public void getFollowUps(final FindListener<FollowUp> listener){
        BmobQuery<FollowUp> query = new BmobQuery<>();
        query.order("-updatedAt");
        query.findObjects(getContext(), new FindListener<FollowUp>() {
            @Override
            public void onSuccess(List<FollowUp> list) {
                if (list != null && list.size() > 0) {
                    listener.onSuccess(list);
                } else {
                    listener.onError(0, "暂无随访问卷");
                }
            }

            @Override
            public void onError(int i, String s) {
                listener.onError(i, s);
            }
        });

    }

   /* @Override
    protected int getLayoutId()
    {
        return R.layout.fragment_followup;
    }

    @Override
    public void initView()
    {
        *//*setTitle("随访");
        setRightBtnVisable(true);
        setRightToLeftBtnVisable(false);
        setRightBtnImage(R.drawable.icon_add);*//*
    }

    @Override
    protected FollowUpPresenter buildPresenter()
    {
        return FollowUpPresenter.build(this);
    }

    @Override
    public void showToast(String text)
    {
        toast(text);
    }*/
}
