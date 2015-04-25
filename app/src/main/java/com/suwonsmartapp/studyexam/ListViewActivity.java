
package com.suwonsmartapp.studyexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // 1. 데이타 준비
        ArrayList<String> mNameList = new ArrayList<>();
        mNameList.add("오준석");
        mNameList.add("김재현");
        mNameList.add("서현수");
        mNameList.add("백정한");
        mNameList.add("오준석");
        mNameList.add("김재현");
        mNameList.add("서현수");
        mNameList.add("백정한");
        mNameList.add("오준석");
        mNameList.add("김재현");
        mNameList.add("서현수");
        mNameList.add("백정한");
        mNameList.add("오준석");
        mNameList.add("김재현");
        mNameList.add("서현수");
        mNameList.add("백정한");
        mNameList.add("오준석");
        mNameList.add("김재현");
        mNameList.add("서현수");
        mNameList.add("백정한");
        mNameList.add("오준석");
        mNameList.add("김재현");
        mNameList.add("서현수");
        mNameList.add("백정한");
        mNameList.add("오준석");
        mNameList.add("김재현");
        mNameList.add("서현수");
        mNameList.add("백정한");
        mNameList.add("오준석");
        mNameList.add("김재현");
        mNameList.add("서현수");
        mNameList.add("백정한");
        mNameList.add("오준석");
        mNameList.add("김재현");
        mNameList.add("서현수");
        mNameList.add("백정한");
        mNameList.add("오준석");
        mNameList.add("김재현");
        mNameList.add("서현수");
        mNameList.add("백정한");

        // 2. 어댑터
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                mNameList);

        // 3. 리스트뷰에 어댑터를 붙인다
        ListView listView = (ListView) findViewById(R.id.lv_name);

        // 4. 그리드뷰에 어댑터를 붙인다
        GridView gridView = (GridView) findViewById(R.id.gv_name);

        // option. 커스텀 어댑터
        CustomAdapter adapter2 = new CustomAdapter(getApplicationContext(),
                R.layout.listview_item,
                mNameList);

        // 기본 ArrayAdapter 사용
        // listView.setAdapter(adapter);
        // gridView.setAdapter(adapter);

        // ArrayAdapter 를 상속해서 커스텀한 어댑터를 사용
        listView.setAdapter(adapter2);
        gridView.setAdapter(adapter2);
    }

}
