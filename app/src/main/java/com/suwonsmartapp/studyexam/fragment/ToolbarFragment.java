package com.suwonsmartapp.studyexam.fragment;

import com.suwonsmartapp.studyexam.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by junsuk on 15. 6. 27..
 */
public class ToolbarFragment extends Fragment implements Toolbar.OnMenuItemClickListener {
    Toolbar mToolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_toolbar, container, false);

        mToolbar = (Toolbar)rootView.findViewById(R.id.toolbar);

        // 타이틀
        mToolbar.setTitle("ToolbarFragment");

        // 메뉴
        mToolbar.inflateMenu(R.menu.menu_broadcast);
        mToolbar.setOnMenuItemClickListener(this);


        return rootView;
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_settings:
                // 처리
                break;
        }
        return false;
    }
}
