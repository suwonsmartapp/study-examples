
package com.suwonsmartapp.studyexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class TargetActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        // 넘어오는 값 받는 방법
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        String key2 = intent.getStringExtra("key2");

        Toast.makeText(getApplicationContext(), "key : " + key + ", key2 : " + key2,
                Toast.LENGTH_SHORT).show();

        // 죽는 버튼
        findViewById(R.id.btn_finish).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("result", "결과");

        // 나를 호출한 Activity에 intent를 전달
        setResult(RESULT_OK, intent);

        // Activity 종료
        finish();
    }
}
