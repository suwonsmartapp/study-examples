package com.suwonsmartapp.studyexam.chat;


import com.suwonsmartapp.studyexam.R;
import com.suwonsmartapp.studyexam.chat.client.ChatClient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by junsuk on 15. 4. 17..
 */
public class ClientActivity extends Activity implements View.OnClickListener {

    private ChatClient mChatClient;
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilent);

        mMessageEditText = (EditText)findViewById(R.id.et_message);
        findViewById(R.id.btn_send).setOnClickListener(this);

        new Thread(new Runnable() {
            @Override
            public void run() {

                mChatClient = new ChatClient();
                mChatClient.connect();
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                mChatClient.sendMessage(mMessageEditText.getText().toString());
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mChatClient.disconnect();
    }
}
