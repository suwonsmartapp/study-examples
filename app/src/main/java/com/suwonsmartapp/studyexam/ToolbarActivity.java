package com.suwonsmartapp.studyexam;

import com.suwonsmartapp.studyexam.fragment.ToolbarFragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by junsuk on 15. 6. 27..
 */
public class ToolbarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_toolbar);

        // ToolbarFragment 를 R.id.container 영역에 추가
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new ToolbarFragment())
                .commit();
    }
}
