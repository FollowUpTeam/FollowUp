package com.ipbase.followup.bean;

import android.graphics.drawable.Drawable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.socketio.callback.StringCallback;


/**
 * Created by LockyLuo on 2017/5/26.
 */

public class Bingli extends BmobObject{

    public Drawable getHead() {
        return head;
    }

    public void setHead(Drawable head) {
        this.head = head;
    }

    private Drawable head;
    private String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getZhengzhuang() {
        return zhengzhuang;
    }

    public void setZhengzhuang(String zhengzhuang) {
        this.zhengzhuang = zhengzhuang;
    }

    public String getZhenduan() {
        return zhenduan;
    }

    public void setZhenduan(String zhenduan) {
        this.zhenduan = zhenduan;
    }

    public String getFabing() {
        return fabing;
    }

    public void setFabing(String fabing) {
        this.fabing = fabing;
    }

    private String gender;
    private String zhengzhuang;
    private String zhenduan;
    private String fabing;

}
