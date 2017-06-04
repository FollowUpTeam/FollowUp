package com.kesar.common_utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Activity跳转用的,减少代码行数
 * Created by kesar on 2016/4/4.
 */
public class SkipActivityUtil
{
    public static void skip(Activity aty,Class clazz){
        Intent intent=new Intent(aty.getApplicationContext(),clazz);
        aty.startActivity(intent);
    }
}
