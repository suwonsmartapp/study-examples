package com.suwonsmartapp.studyexam.event;

import android.view.View;

/**
 * Created by junsuk on 15. 6. 13..
 */
public class ButtonClickEvent implements MyEvent {
    View view;

    public ButtonClickEvent(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

}
