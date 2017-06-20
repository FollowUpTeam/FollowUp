package com.ipbase.followup.adapter;

import android.content.Context;
import android.view.View;

import com.ipbase.followup.R;
import com.ipbase.followup.adapter.base.BaseRecyclerAdapter;
import com.ipbase.followup.adapter.base.BaseRecyclerHolder;
import com.ipbase.followup.adapter.base.IMutlipleItem;
import com.ipbase.followup.bean.FollowUp;
import com.ipbase.followup.bean.Friend;
import com.ipbase.followup.db.NewFriendManager;
import com.ipbase.followup.model.bean.User;

import java.util.Collection;


/**联系人
 * 一种简洁的Adapter实现方式，可用于多种Item布局的recycleView实现，不用再写ViewHolder啦
 * @author :smile
 * @project:ContactNewAdapter
 * @date :2016-04-27-14:18
 */
public class FollowUpAdapter extends BaseRecyclerAdapter<FollowUp> {

    public FollowUpAdapter(Context context, IMutlipleItem<FollowUp> items, Collection<FollowUp> datas) {
        super(context,items,datas);
    }

    @Override
    public void bindView(BaseRecyclerHolder holder, FollowUp followUp, int position) {
        holder.setText(R.id.tv_followup_name, followUp.getTitle());
        holder.setText(R.id.tv_followup_time, followUp.getCreatedAt());
        holder.setText(R.id.tv_followup_status, followUp.getStatus());
    }

}
