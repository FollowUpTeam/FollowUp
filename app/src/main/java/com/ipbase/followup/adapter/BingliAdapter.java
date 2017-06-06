package com.ipbase.followup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ipbase.followup.R;
import com.ipbase.followup.bean.Bingli;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by LockyLuo on 2017/4/30.
 * 重写适配器，实现自定义布局，功能
 */

public class BingliAdapter extends BaseAdapter {
    private List<Bingli> data;
    private static Context context;
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
        if (view == null) {

            view = mInflater.inflate(R.layout.bingli_item, null);
            viewHolder=new ViewHolder(view);
//            viewHolder.ivGravatar=(ImageView)view.findViewById(R.id.iv_gravatar);
//            viewHolder.tv_UserName=(TextView)view.findViewById(R.id.tv_patientName);
//            viewHolder.tv_gender=(TextView)view.findViewById(R.id.tv_gender);
//            viewHolder.age=(TextView)view.findViewById(R.id.tv_age);
//            viewHolder.readFlagText=(TextView)view.findViewById(R.id.tv_bingliFlag);
//            viewHolder.readFlagImg=(ImageView)view.findViewById(R.id.iv_gravatar);
//            viewHolder.tv1=(TextView)view.findViewById(R.id.tv_zhengzhuang);
//            viewHolder.tv2=(TextView)view.findViewById(R.id.tv_zhengduan);
//            viewHolder.tv3=(TextView)view.findViewById(R.id.tv_fabing);
//            viewHolder.date=(TextView)view.findViewById(R.id.tv_date);
//            viewHolder.tv_huizheng=(TextView)view.findViewById(R.id.tv_huizhen);
//            viewHolder.tv_pinglun=(TextView)view.findViewById(R.id.tv_pinglun);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvPatientName.setText(data.get(position).getName());
        viewHolder.ivGravatar.setImageDrawable(data.get(position).getHead());
        viewHolder.tvGender.setText(data.get(position).getGender());
        viewHolder.tvAge.setText(data.get(position).getAge());

        viewHolder.tvHuizhen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("huizhen1");
            }
        });
        viewHolder.tvPinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("huizhen2");
            }
        });



        return view;
    }



    //控制toast时间-----------------
    private static Toast mToast;

    public static void showToast(String msg) {

        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }


    static class ViewHolder {
        @Bind(R.id.iv_gravatar)
        ImageView ivGravatar;
        @Bind(R.id.tv_patientName)
        TextView tvPatientName;
        @Bind(R.id.tv_gender)
        TextView tvGender;
        @Bind(R.id.tv_age)
        TextView tvAge;
        @Bind(R.id.tv_bingliFlag)
        TextView tvBingliFlag;
        @Bind(R.id.iv_readFlagImage)
        ImageView ivReadFlagImage;
        @Bind(R.id.tv_zhengzhuang)
        TextView tvZhengzhuang;
        @Bind(R.id.tv_zhengduan)
        TextView tvZhengduan;
        @Bind(R.id.tv_fabing)
        TextView tvFabing;
        @Bind(R.id.split)
        LinearLayout split;
        @Bind(R.id.tv_date)
        TextView tvDate;
        @Bind(R.id.tv_huizhen)
        TextView tvHuizhen;
        @Bind(R.id.tv_pinglun)
        TextView tvPinglun;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
