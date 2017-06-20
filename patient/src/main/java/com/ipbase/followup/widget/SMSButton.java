package com.ipbase.followup.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 短信验证码按钮
 * Created by kesar on 2016/4/24.
 */
public class SMSButton extends Button implements View.OnClickListener
{
    private int mTimeCount = 30; // 30s计数

    private OnClickListener mOnClickListener; // 按钮点击事件，外部添加的

    private CharSequence mText; // 记录按钮文本

    public SMSButton(Context context)
    {
        this(context, null);
    }

    public SMSButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SMSButton(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr, 0);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SMSButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        super.setOnClickListener(this);
    }


    private Timer mTimer = new Timer();

    private TimerTask mTimerTask = new TimerTask()
    {
        private volatile int count = mTimeCount;

        @Override
        public void run()
        {
            setText(count + "s");
            if (count == 0)
            {
                count = mTimeCount;
                stopCounter();
                return;
            }
            count--;
        }
    };

    @Override
    public void setOnClickListener(OnClickListener l)
    {
        this.mOnClickListener = l;
    }

    @Override
    public void onClick(View v)
    {
        if (mOnClickListener != null)
        {
            mOnClickListener.onClick(v);
        }
        startCounter();
    }

    private void startCounter()
    {
        setEnabled(false);
        mText = getText();
        if (mTimer != null)
            mTimer.schedule(mTimerTask, 0, 1000);
    }

    private void stopCounter()
    {
        setText(mText);
        setEnabled(true);
        if (mTimer != null)
            mTimer.cancel();
    }
}
