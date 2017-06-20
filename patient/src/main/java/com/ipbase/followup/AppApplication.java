package com.ipbase.followup;

import android.app.Application;

import com.ipbase.followup.base.UniversalImageLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import butterknife.ButterKnife;
import cn.bmob.newim.BmobIM;

/**
 * Created by kesar on 2016/4/3.
 */
public class AppApplication extends Application
{

    private static AppApplication INSTANCE;
    public static AppApplication INSTANCE(){
        return INSTANCE;
    }
    private void setInstance(AppApplication app) {
        setAppApplication(app);
    }
    private static void setAppApplication(AppApplication a) {
        AppApplication.INSTANCE = a;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        ButterKnife.setDebug(BuildConfig.DEBUG);
        setInstance(this);
        //只有主进程运行的时候才需要初始化
        if ( getApplicationInfo().packageName.equals( getMyProcessName() ) )
        {
            //im初始化
            BmobIM.init( this );
            //注册消息接收器
            BmobIM.registerDefaultMessageHandler( new DemoMessageHandler( this ) );
        }
        //uil初始化
        UniversalImageLoader.initImageLoader(this);
    }

    /**
     * 获取当前运行的进程名
     *
     * @return
     */
    public static String getMyProcessName()
    {
        try
        {
            File file = new File( "/proc/" + android.os.Process.myPid() + "/" + "cmdline" );
            BufferedReader mBufferedReader = new BufferedReader( new FileReader( file ) );
            String processName = mBufferedReader.readLine().trim();
            mBufferedReader.close();
            return processName;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            return null;
        }
    }

}
