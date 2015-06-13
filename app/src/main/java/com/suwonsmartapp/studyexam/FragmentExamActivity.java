package com.suwonsmartapp.studyexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class FragmentExamActivity extends AppCompatActivity implements View.OnClickListener {

    private TestFragment mTestFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_exam);

        findViewById(R.id.btn_change).setOnClickListener(this);

        // 프래그먼트 가져오는 방법
        mTestFragment = (TestFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_red);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragment_exam, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        // 프래그먼트 관리
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_content, new BlankFragment())
                .addToBackStack(null)       // 프래그먼트 뒤로 가기 위한 설정
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }

    }

}
