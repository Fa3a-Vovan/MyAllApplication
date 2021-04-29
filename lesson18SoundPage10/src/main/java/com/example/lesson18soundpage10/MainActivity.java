package com.example.lesson18soundpage10;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    String TAG = "myLogs";
    SoundManager soundManager;
    int meow, bark, moo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Start");
        Button button1 = findViewById(R.id.button1); button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.button2); button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.button3); button3.setOnClickListener(this);

        soundManager = new SoundManager(getApplicationContext());
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        meow = soundManager.load(R.raw.cat);
        bark = soundManager.load(R.raw.barkloud);
        moo = soundManager.load(R.raw.cow);
        SeekBar sb;
        sb = findViewById(R.id.seekBar1); sb.setOnSeekBarChangeListener(this);
        sb = findViewById(R.id.seekBar2); sb.setOnSeekBarChangeListener(this);
        sb = findViewById(R.id.seekBar3); sb.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1: soundManager.play(meow); break;
            case R.id.button2: soundManager.play(bark); break;
            case R.id.button3: soundManager.play(moo); break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.seekBar1: soundManager.setVolume((float)progress/100.0f);
                Log.d(TAG, "setVolume = " + progress/100.0f); break;
            case R.id.seekBar2: soundManager.setBalance((float)progress/100.0f);
                Log.d(TAG, "setBalance = " + progress/100.0f); break;
            case R.id.seekBar3: soundManager.setSpeed((float)progress/100.0f);
                Log.d(TAG, "setSpeed = " + progress/100.0f); break;
        }
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }
}