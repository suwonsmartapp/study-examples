package com.suwonsmartapp.studyexam;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.suwonsmartapp.studyexam.event.ButtonClickEvent;
import com.suwonsmartapp.studyexam.event.CustomEvent;
import com.suwonsmartapp.studyexam.event.MyEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by junsuk on 15. 6. 13..
 *
 * https://github.com/greenrobot/EventBus
 */
public class TestFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    public void showMsg() {
        Toast.makeText(getActivity(), "메세지 받았다", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        EventBus.getDefault().register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        EventBus.getDefault().unregister(this);
    }

    public void onEvent(MyEvent event) {
        if (event instanceof ButtonClickEvent) {
            Toast.makeText(getActivity(), "TAG : " + ((ButtonClickEvent)event).getView().getTag(), Toast.LENGTH_SHORT).show();
        } else if (event instanceof CustomEvent) {
            Toast.makeText(getActivity(), "CustomEvent", Toast.LENGTH_SHORT).show();
        }
    }

    public void onEvent(Integer id) {

    }
}
