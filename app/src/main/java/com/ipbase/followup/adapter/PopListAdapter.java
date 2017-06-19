package com.ipbase.followup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ipbase.followup.R;
import com.ipbase.followup.activity.UploadBingliActivity;
import com.ipbase.followup.model.bean.User;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by LockyLuo on 2017/6/18.
 */

public class PopListAdapter extends BaseAdapter {
    private List<User> data;
    private static Context context;
    private LayoutInflater mInflater;
    private String[][] imgUrls;
    private ViewHolder viewHolder;

    public PopListAdapter(Context context, List<User> data) {


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
        viewHolder = null;
        if (view == null) {

            view = mInflater.inflate(R.layout.pop_listview_item, null);
            viewHolder = new ViewHolder(view);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvPoplistItemUserName.setText(data.get(position).getUsername());
        viewHolder.tvPoplistItemRealName.setText(data.get(position).getRealName());
        viewHolder.llListviewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadBingliActivity.patientUser=data.get(position);
                showToast(data.get(position).getRealName());
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
        @Bind(R.id.tv_poplistItemUserName)
        TextView tvPoplistItemUserName;
        @Bind(R.id.tv_poplistItemRealName)
        TextView tvPoplistItemRealName;
        @Bind(R.id.ll_listviewItem)
        LinearLayout llListviewItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
