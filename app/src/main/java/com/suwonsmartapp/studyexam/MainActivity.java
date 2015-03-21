
package com.suwonsmartapp.studyexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private static final int JUMP_REQEUST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout 화면 붙이기
        setContentView(R.layout.activity_main);

        // 클릭 이벤트
        clickEventInit();

        // 화면 이동 처리
        findViewById(R.id.btn_jump).setOnClickListener(this);
        findViewById(R.id.btn_browser).setOnClickListener(this);
        findViewById(R.id.btn_jump_target).setOnClickListener(this);
        // 띄우고 받기
        findViewById(R.id.btn_jump_target2).setOnClickListener(this);
    }

    private void clickEventInit() {
        Button button = (Button) findViewById(R.id.btn_test);
        Button button2 = (Button) findViewById(R.id.btn_test2);

        // 첫번째
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "click2", Toast.LENGTH_SHORT).show();
            }
        });

        // 두번째
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_test) {
                    Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
                } else if (v.getId() == R.id.btn_test2) {
                    Toast.makeText(getApplicationContext(), "click2", Toast.LENGTH_SHORT).show();
                }
            }
        };
        button.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);

        // 세번째
        button.setOnClickListener(this);
        button2.setOnClickListener(this);

        // 네번째
        findViewById(R.id.btn_test).setOnClickListener(this);
        findViewById(R.id.btn_test2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_test2:
                Toast.makeText(getApplicationContext(), "click2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_jump:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-4899-3729"));
                startActivity(intent);
                break;
            case R.id.btn_browser:
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(intent2);
                break;
            case R.id.btn_jump_target:
                Intent intent3 = new Intent(getApplicationContext(), TargetActivity.class);
                // 넘길 데이터 설정
                intent3.putExtra("key", "값");
                intent3.putExtra("key2", "값2");
                startActivity(intent3);
                break;
            case R.id.btn_jump_target2:
                Intent intent4 = new Intent(getApplicationContext(), TargetActivity.class);
                startActivityForResult(intent4, JUMP_REQEUST_CODE);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == JUMP_REQEUST_CODE) {
                String result = data.getStringExtra("result");
                Toast.makeText(getApplicationContext(), "result : " + result, Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }
}
