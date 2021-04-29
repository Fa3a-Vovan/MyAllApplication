package com.example.lesson18soundtouch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, SoundPool.OnLoadCompleteListener {
    String TAG = "myLogs";
    private SoundPool _soundPool;
    private int _soundID;
    boolean _loaded = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.textView);
        view.setOnTouchListener(this);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        linearLayout.setOnTouchListener(this);
        _soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        _soundPool.setOnLoadCompleteListener(this);
        _soundID = _soundPool.load(this, R.raw.ne_tot_gonduras, 1);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(TAG, "arg1");
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (_loaded) {
                _soundPool.play(_soundID, 1, 1, 1, 0, 1);
            }
        }
        return false;
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        _loaded = true;
    }
}