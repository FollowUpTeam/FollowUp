package com.ipbase.followup.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * 使用注解框架Butterknife的fragment
 * Created by kesar on 2016/4/23.
 */
public abstract class AbsButterknifeFragment extends AbsBaseFragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this,view);
        return view;
    }
}
