package com.suwonsmartapp.studyexam;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout 화면 붙이기
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.btn_test);
        Button button2 = (Button)findViewById(R.id.btn_test2);

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
        if (v.getId() == R.id.btn_test) {
            Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btn_test2) {
            Toast.makeText(getApplicationContext(), "click2", Toast.LENGTH_SHORT).show();
        }
    }
}
