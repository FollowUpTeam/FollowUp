package com.ipbase.followup.model.bean;


import cn.bmob.v3.BmobUser;

/**
 * Created by kesar on 2016/4/3.
 */
public class User extends BmobUser
{
    private String realName; // 真实姓名
    private int age; // 年龄
    private int sex; // 性别
    private String work; // 工作
    private String avatar; //头像
    private Boolean isPatient; //是否是病人，true为病人，false为医生

    public String getRealName()
    {
        return realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getSex()
    {
        return sex;
    }

    public void setSex(int sex)
    {
        this.sex = sex;
    }

    public String getWork()
    {
        return work;
    }

    public void setWork(String work)
    {
        this.work = work;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getPatient() {
        return isPatient;
    }

    public void setPatient(Boolean patient) {
        isPatient = patient;
    }
}
