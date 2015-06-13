package com.suwonsmartapp.studyexam.multimedia;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.suwonsmartapp.studyexam.R;

import java.io.IOException;

public class MultimediaActivity extends ActionBarActivity implements View.OnClickListener {
    private final static int REQUEST_CODE_GET_MUSIC = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);

        // 다른 곳에서 호출 되었을 때 null 이 아님
        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = intent.getData();
            try {
                if (uri != null) {
                    playMusic(uri);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 삐비비빅 (local 파일 직접 재생)
        findViewById(R.id.btn_play).setOnClickListener(this);

        // 파일 선택
        findViewById(R.id.btn_pick).setOnClickListener(this);

        // 메세지 받는 앱 호출하여 메세지 보내기
        findViewById(R.id.btn_send_message).setOnClickListener(this);

        // 카톡으로 메세지 보내기
        findViewById(R.id.btn_send_message_kakao).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play:
                // 삐비비빅
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarm);
                mediaPlayer.start();
                break;
            case R.id.btn_pick:
                try {
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setType("audio/*");
                    startActivityForResult(Intent.createChooser(intent, "앱 선택"), REQUEST_CODE_GET_MUSIC);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "실행 할 앱이 없습니다.", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_send_message:
                // Chooser를 통한 메세지 전송
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String message = ((EditText)findViewById(R.id.et_message)).getText().toString();
                intent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(intent);
                break;

            case R.id.btn_send_message_kakao:
                // 카톡으로 메세지 전송
                PackageManager pm = getPackageManager();
                Intent kakaoIntent = pm.getLaunchIntentForPackage("com.kakao.talk");
                kakaoIntent.setAction(Intent.ACTION_SEND);
                kakaoIntent.setType("text/plain");
                String kakaoMessage = ((EditText)findViewById(R.id.et_message)).getText().toString();
                kakaoIntent.putExtra(Intent.EXTRA_TEXT, kakaoMessage);
                startActivity(kakaoIntent);
                break;
        }
    }
    MediaPlayer mediaPlayer;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_GET_MUSIC
                && resultCode == RESULT_OK) {
            Uri dataUri = data.getData();
            Toast.makeText(getApplicationContext(), dataUri.toString(), Toast.LENGTH_SHORT).show();

            try {
                playMusic(dataUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void playMusic(Uri dataUri) throws IOException {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setDataSource(getApplicationContext(), dataUri);
        mediaPlayer.start();
    }
}
