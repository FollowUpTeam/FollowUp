package com.ipbase.followup.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ipbase.followup.R;
import com.ipbase.followup.base.ImageLoaderFactory;
import com.ipbase.followup.base.ParentWithNaviActivity;
import com.ipbase.followup.bean.AddFriendMessage;
import com.ipbase.followup.model.bean.User;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import cn.bmob.newim.BmobIM;
import cn.bmob.newim.bean.BmobIMConversation;
import cn.bmob.newim.bean.BmobIMMessage;
import cn.bmob.newim.bean.BmobIMUserInfo;
import cn.bmob.newim.core.BmobIMClient;
import cn.bmob.newim.listener.MessageSendListener;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;

/**
 * 随访问卷填写
 */
public class DoFollowUpActivity extends ParentWithNaviActivity
{

    @Bind( R.id.btn_add_friend )
    Button btn_add_friend;

    @Override
    protected String title()
    {
        return "随方问卷填写";
    }

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_do_followup );
        initNaviView();
    }

    @OnClick( R.id.btn_add_friend )
    public void onAddClick( View view )
    {
        toast("提交成功");
        finish();
    }

}
