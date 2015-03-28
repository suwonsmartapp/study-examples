
package com.suwonsmartapp.studyexam;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * page.352
 */
public class CustomAdapter extends ArrayAdapter {
    public CustomAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = super.getView(position, convertView, parent);

        // 애니메이션 438 ~
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.translation);
        convertView.setAnimation(animation);

        return convertView;
    }
}
