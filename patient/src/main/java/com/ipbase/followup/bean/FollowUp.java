package com.ipbase.followup.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/6/19.
 */

public class FollowUp extends BmobObject{
    private String title; //随访问卷标题
    private String status; //问卷阅读状态
    private String content; //内容

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
