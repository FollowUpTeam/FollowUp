package com.ipbase.followup.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ipbase.followup.R;

/**
 * 标题栏
 *
 * @author lxh
 * @time 2016/4/13 17:15
 */
public class TitleBar extends RelativeLayout implements View.OnClickListener {

    private ImageButton btnLeft;     //左侧按钮
    private ImageButton btnRight;    //右侧按钮
    private ImageButton btnRightToLeft;    //右侧靠近左边的按钮
    private TextView tvTitle;   //标题文本
    private BtnClickListener listener;

    public TitleBar(Context context) {
        this(context,null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 初始化组件
     *
     * @param context
     */
    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.titlebar, this);
        btnLeft = (ImageButton) findViewById(R.id.btn_titlebar_left);
        btnRight = (ImageButton) findViewById(R.id.btn_titlebar_right);
        btnRightToLeft = (ImageButton) findViewById(R.id.btn_titlebar_right_to_left);
        tvTitle = (TextView) findViewById(R.id.tv_titlebar_name);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
        btnRightToLeft.setOnClickListener(this);
    }

    public void setTitleBarListener(BtnClickListener listener) {
        this.listener = listener;
    }

    /**
     * 按钮点击接口
     */
    public interface BtnClickListener {
        void leftClick();

        void rightClick();

        void rightToLeftClick();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_titlebar_left:
                listener.leftClick();
                break;
            case R.id.btn_titlebar_right:
                listener.rightClick();
                break;
            case R.id.btn_titlebar_right_to_left:
                listener.rightToLeftClick();
                break;
            default:
                break;
        }
    }

    /**
     * 设置左侧按钮是否可见
     *
     * @param flag 是否可见
     */
    public void setLeftBtnVisable(boolean flag) {
        if (flag) {
            btnLeft.setVisibility(VISIBLE);
        } else {
            btnLeft.setVisibility(GONE);
        }
    }

    /**
     * 设置右侧按钮是否可见
     *
     * @param flag 是否可见
     */
    public void setRightBtnVisable(boolean flag) {
        if (flag) {
            btnRight.setVisibility(VISIBLE);
        } else {
            btnRight.setVisibility(GONE);
        }
    }

    /**
     * 设置右侧靠左的按钮是否可见
     *
     * @param flag 是否可见
     */
    public void setRightToLeftBtnVisable(boolean flag) {
        if (flag) {
            btnRightToLeft.setVisibility(VISIBLE);
        } else {
            btnRightToLeft.setVisibility(GONE);
        }
    }

    /**
     * 设置右侧按钮的图标
     *
     * @param resId
     */
    public void setRightBtnImage(int resId) {
        if (btnRight != null) {
            btnRight.setImageResource(resId);
        } else {
            btnRight = (ImageButton) findViewById(R.id.btn_titlebar_right);
            btnRight.setOnClickListener(this);
        }
    }

    /**
     * 设置标题文字
     *
     * @param str
     */
    public void setTitle(String str) {
        tvTitle.setText(str);
    }
}
