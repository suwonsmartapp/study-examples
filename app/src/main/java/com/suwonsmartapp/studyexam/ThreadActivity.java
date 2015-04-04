
package com.suwonsmartapp.studyexam;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

// 441~442 예제 페이지 참고
public class ThreadActivity extends ActionBarActivity implements View.OnClickListener {

    private static final String TAG = ThreadActivity.class.getSimpleName();

    private boolean running;
    private int value;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        mTextView = (TextView) findViewById(R.id.tv_thread_text);

        findViewById(R.id.btn_thread).setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        running = true;

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (running) {
                    try {
                        Thread.sleep(1000);
                        value++;
                        Log.d(TAG, "value : " + value);
                    } catch (InterruptedException e) {
                        Log.e("SampleJavaThread", "Exception in thread", e);
                    }
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        running = false;
        value = 0;
    }

    @Override
    public void onClick(View v) {
        mTextView.setText("스레드에서 받은 값 : " + value);
    }

}
