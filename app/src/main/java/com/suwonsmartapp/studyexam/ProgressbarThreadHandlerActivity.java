
package com.suwonsmartapp.studyexam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressbarThreadHandlerActivity extends ActionBarActivity implements
        View.OnClickListener {

    private static final String TAG = ProgressbarThreadHandlerActivity.class.getSimpleName();
    private ProgressBar mProgressBar;
    private int value;
    private boolean runnnig;

    private TextView mTextView;

    // 1. 핸들러 객체 만드는 방법
    private Handler mProgressHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mTextView.setText(mProgressBar.getProgress() + "%");
        }
    };

    private Handler mDialogHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // 다이얼로그 띄우기
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    ProgressbarThreadHandlerActivity.this);
            builder.setTitle("알림");
            builder.setMessage("다운로드 완료");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(ProgressbarThreadHandlerActivity.this, "OK", Toast.LENGTH_SHORT)
                            .show();
                }
            });
            builder.setNegativeButton("cancel", null);
            builder.show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar_thread_handler);

        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);

        mTextView = (TextView) findViewById(R.id.tv_percent);
        findViewById(R.id.btn_start).setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        runnnig = false;
    }

    @Override
    public void onClick(View v) {
        runnnig = true;
        value = 0;
        mProgressBar.setProgress(value);

        new Thread() {
            @Override
            public void run() {
                while (runnnig) {
                    try {
                        Thread.sleep(10);
                        value++;
                        mProgressBar.setProgress(value);

                        // 1. 핸들러 객체 만드는 방법
                        mProgressHandler.sendEmptyMessage(0);

                    } catch (InterruptedException e) {
                        Log.e(TAG, "익셉션 !!!!");
                    }

                    if (value > mProgressBar.getMax()) {
                        runnnig = false;

                        mDialogHandler.sendEmptyMessage(0);
                    }
                }
            }
        }.start();
    }
}
