package com.ipbase.followup.bean;

import cn.bmob.newim.bean.BmobIMExtraMessage;

/**
 * 自定义消息，随访问卷
 * Created by Administrator on 2017/6/18.
 */

public class Questionaire extends BmobIMExtraMessage {

    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    public  Questionaire(){}

    @Override
    public String getMsgType() {
        return "questionaire";
    }

    @Override
    public boolean isTransient() {
        //设置为true,表明为暂态消息，那么这条消息并不会保存到对方的本地db中
        //设置为false,则会保存到对方指定会话的本地数据库中
        return true;
    }
}
