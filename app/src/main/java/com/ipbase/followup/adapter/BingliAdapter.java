package com.ipbase.followup.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.ipbase.followup.R;
import com.ipbase.followup.bean.Bingli;

import java.util.List;

/**
 * Created by LockyLuo on 2017/4/30.
 * 重写适配器，实现自定义布局，功能
 */

public class BingliAdapter extends BaseAdapter {
    private List<Bingli> data;
    private Context context;
    private LayoutInflater mInflater;
    private String[][] imgUrls;
    private ViewHolder viewHolder;



    public BingliAdapter(Context context, List<Bingli> data) {


        this.context = context;
        this.data = data;

        mInflater = LayoutInflater.from(context);
    }

    //获取ListView的项个数
    public int getCount() {
        return data.size();
    }

    //获取项
    public Object getItem(int position) {
        return data.get(position);
    }

    //获取项的ID
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup viewGroup) {
        data.get(position);
        viewHolder=null;
        if(view==null)
        {
            viewHolder=new ViewHolder();
            view=mInflater.inflate(R.layout.bingli_item,null);

            viewHolder.iv_head=(ImageView)view.findViewById(R.id.iv_gravatar);
            viewHolder.tv_UserName=(TextView)view.findViewById(R.id.tv_patientName);
            viewHolder.tv_gender=(TextView)view.findViewById(R.id.tv_gender);
            viewHolder.age=(TextView)view.findViewById(R.id.tv_age);
            viewHolder.readFlagText=(TextView)view.findViewById(R.id.tv_bingliFlag);
            viewHolder.readFlagImg=(ImageView)view.findViewById(R.id.iv_gravatar);
            viewHolder.tv1=(TextView)view.findViewById(R.id.tv_zhengzhuang);
            viewHolder.tv2=(TextView)view.findViewById(R.id.tv_zhengduan);
            viewHolder.tv3=(TextView)view.findViewById(R.id.tv_fabing);
            viewHolder.date=(TextView)view.findViewById(R.id.tv_date);
            viewHolder.tv_huizheng=(TextView)view.findViewById(R.id.tv_huizhen);
            viewHolder.tv_pinglun=(TextView)view.findViewById(R.id.tv_pinglun);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tv_UserName.setText(data.get(position).getName());
        viewHolder.iv_head.setImageDrawable(data.get(position).getHead());
        viewHolder.tv_gender.setText(data.get(position).getGender());
        viewHolder.age.setText(data.get(position).getAge());

        viewHolder.tv_huizheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    private View.OnClickListener onClickListenerUserDetail=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };


    //通过ViewHolder显示项的内容
    static class ViewHolder {
        public ImageView iv_head;
        public TextView tv_UserName;
        public TextView tv_gender;
        public TextView age;
        public TextView readFlagText;
        public ImageView readFlagImg;
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;
        public TextView date;
        public TextView tv_huizheng;
        public TextView tv_pinglun;


    }

    //控制toast时间-----------------
    private static Toast mToast;
    public static void showToast(Context context, String msg) {

        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }


}
