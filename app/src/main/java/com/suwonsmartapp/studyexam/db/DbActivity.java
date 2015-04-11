
package com.suwonsmartapp.studyexam.db;

import com.suwonsmartapp.studyexam.R;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class DbActivity extends ActionBarActivity implements View.OnClickListener {

    private ListView mListView;
    private Button mButton;
    private EditText mNameEditText;
    private EditText mEmailEditText;

    private PersonDbHelper mPersonDbHelper;
    private SimpleCursorAdapter mAdapter;

    private ArrayList<Person> mPersonList;
    private Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        // view
        mListView = (ListView) findViewById(R.id.lv_person);
        mNameEditText = (EditText) findViewById(R.id.et_name);
        mEmailEditText = (EditText) findViewById(R.id.et_email);
        mButton = (Button) findViewById(R.id.btn_input);
        mButton.setOnClickListener(this);

        // data 준비
        // mPersonList = new ArrayList<>();
        // mPersonList.add(new Person("서현수", "12312@12313.com"));
        // mPersonList.add(new Person("김재현", "12312@12313.com"));
        // mPersonList.add(new Person("윤태웅", "12312@12313.com"));
        // mPersonList.add(new Person("오준석", "12312@12313.com"));

        // db insert
        mPersonDbHelper = new PersonDbHelper(getApplicationContext());
        mPersonDbHelper.open();

        // for (Person person : mPersonList) {
        // mPersonDbHelper.insert(person);
        // }

        mCursor = mPersonDbHelper.selectAll();
        // mAdapter
        mAdapter = new SimpleCursorAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_2,
                mCursor,
                new String[] {
                        "name", "email"
                },
                new int[] {
                        android.R.id.text1, android.R.id.text2
                },
                0);

        mListView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {
        String name = mNameEditText.getText().toString();
        String email = mEmailEditText.getText().toString();

        mPersonDbHelper.insert(name, email);

        mAdapter = new SimpleCursorAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_2,
                mPersonDbHelper.selectAll(),
                new String[] {
                        "name", "email"
                },
                new int[] {
                        android.R.id.text1, android.R.id.text2
                },
                0);
        mListView.setAdapter(mAdapter);
    }
}
