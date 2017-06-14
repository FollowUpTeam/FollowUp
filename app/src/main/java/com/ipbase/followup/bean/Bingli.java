package com.ipbase.followup.bean;

import android.graphics.drawable.Drawable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.socketio.callback.StringCallback;


/**
 * Created by LockyLuo on 2017/5/26.
 */

public class Bingli extends BmobObject{



    private BmobUser doctor;
    private BmobUser patient;

    public BmobUser getDoctor() {
        return doctor;
    }

    public void setDoctor(BmobUser doctor) {
        this.doctor = doctor;
    }

    public BmobUser getPatient() {
        return patient;
    }

    public void setPatient(BmobUser patient) {
        this.patient = patient;
    }

    public BmobFile getHead() {
        return head;
    }

    public void setHead(BmobFile head) {
        this.head = head;
    }

    private BmobFile head;
    private String name;
    private String age;
    private String gender;
    private String zhengzhuang;
    private String zhenduan;
    private String fabing;





    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


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



}
