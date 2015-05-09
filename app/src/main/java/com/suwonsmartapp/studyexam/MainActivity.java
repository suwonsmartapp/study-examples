
package com.suwonsmartapp.studyexam;

import com.suwonsmartapp.studyexam.broadcast.BroadcastActivity;
import com.suwonsmartapp.studyexam.cal.CalendarActivity;
import com.suwonsmartapp.studyexam.chat.ClientActivity;
import com.suwonsmartapp.studyexam.db.DbActivity;
import com.suwonsmartapp.studyexam.multimedia.MultimediaActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

// 195~220
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

        // ListView
        findViewById(R.id.btn_listview).setOnClickListener(this);

        // 달력 GridView
        findViewById(R.id.btn_gridview).setOnClickListener(this);

        // 441쪽 스레드
        findViewById(R.id.btn_thread).setOnClickListener(this);

        // 445쪽 스레드
        findViewById(R.id.btn_thread_handler).setOnClickListener(this);

        // 552쪽 DB
        findViewById(R.id.btn_create_helper).setOnClickListener(this);

        // 브로드캐스트 리시버
        findViewById(R.id.btn_send_broadcast).setOnClickListener(this);

        // 채팅 클라이언트
        findViewById(R.id.btn_client).setOnClickListener(this);


        // 멀티미디어
        findViewById(R.id.btn_multimedia).setOnClickListener(this);
    }

    // Activity 가 소멸 될 때 호출 됨
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 메모리 해제 등
    }

    // 화면이 안 보일 때 호출
    @Override
    protected void onStop() {
        super.onStop();

    }

    // 화면이 안 보여지기 직전에 호출
    @Override
    protected void onPause() {
        super.onPause();
    }

    // onPause에서 다시 화면이 보여지기 직전에 호출
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    // 보이기 바로 전에 호출
    @Override
    protected void onStart() {
        super.onStart();
    }

    // 보여졌을 때 호출
    @Override
    protected void onResume() {
        super.onResume();
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
            case R.id.btn_listview:
                startActivity(new Intent(getApplicationContext(), ListViewActivity.class));
                break;
            case R.id.btn_gridview:
                startActivity(new Intent(getApplicationContext(), CalendarActivity.class));
                break;
            case R.id.btn_thread:
                startActivity(new Intent(getApplicationContext(), ThreadActivity.class));
                break;
            case R.id.btn_thread_handler:
                startActivity(new Intent(getApplicationContext(),
                        ProgressbarThreadHandlerActivity.class));
                break;
            case R.id.btn_create_helper:
                startActivity(new Intent(getApplicationContext(), DbActivity.class));
                break;
            case R.id.btn_send_broadcast:
                startActivity(new Intent(getApplicationContext(), BroadcastActivity.class));
                break;
            case R.id.btn_client:
                startActivity(new Intent(getApplicationContext(), ClientActivity.class));
                break;
            case R.id.btn_multimedia:
                startActivity(new Intent(getApplicationContext(), MultimediaActivity.class));
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
