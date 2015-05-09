package com.suwonsmartapp.studyexam.multimedia;

import com.suwonsmartapp.studyexam.R;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MultimediaActivity extends ActionBarActivity implements View.OnClickListener {
    private final static int REQUEST_CODE_GET_MUSIC = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);

        // 삐비비빅 (local 파일 직접 재생)
        findViewById(R.id.btn_play).setOnClickListener(this);

        // 파일 선택
        findViewById(R.id.btn_pick).setOnClickListener(this);
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

            if (mediaPlayer != null) {
                mediaPlayer.release();
                mediaPlayer = null;
            }
            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setDataSource(getApplicationContext(), dataUri);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
