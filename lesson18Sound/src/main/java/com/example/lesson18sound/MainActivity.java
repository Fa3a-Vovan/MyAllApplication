package com.example.lesson18sound;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SoundPool.OnLoadCompleteListener/*implements View.OnClickListener*/ {

    final String TAG = "myLogs";
    int _soundIDRes, _soundIDRe1;
    SoundPool _soundPool, _soundPool1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);

//        Подключаем звук через ресурсы //но так не заработает музло в начале
//        soundIDRes = soundPool.load(this, R.raw.ne_tot_gonduras, 1);
//        soundPool.play(soundIDRes,1,1,1,0,1);

        //Подключаем звук через ресурсы
        _soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                Log.d(TAG, "arg1="+sampleId+"   arg2=" +status);
                soundPool.play(_soundIDRes, 1, 1, 1, 0, 1);
            }
        });
        _soundIDRes = _soundPool.load(this, R.raw.ne_tot_gonduras, 1);
        ///////////////////////////////////////////////
        // Ниже через интерфейс implements SoundPool.OnLoadCompleteListener
        _soundPool1 = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        _soundPool1.setOnLoadCompleteListener(this);
        // подключаем звук через ресурсы
        _soundIDRe1 = _soundPool1.load(this, R.raw.ne_tot_gonduras,1);
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int arg1, int arg2) {
        Log.d(TAG, "arg1="+arg1+"   arg2=" +arg2);
        _soundPool1.play(_soundIDRe1, 1, 1, 1, 0,1);
    }
}

//    final String TAG = "myLogs";
//    int soundIDJava, soundIDRes;
//    SoundPool soundPool;
//    AssetManager assetManager;
//    AssetFileDescriptor assetFileDescriptor = null;
//    Button button1, button2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Log.d(TAG, "Start");
//
//        button1 = findViewById(R.id.button1); button1.setOnClickListener(this);
//        button2 = findViewById(R.id.button2); button2.setOnClickListener(this);
//        // soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
//        // С версии Android 5.0 верхняя строка считается устаревшей. Делаем как ниже
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
//        } else {
//            AudioAttributes attributes = new AudioAttributes.Builder()
//                    .setUsage(AudioAttributes.USAGE_GAME)
//                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//                    .build();
//            soundPool = new SoundPool.Builder().setAudioAttributes(attributes).build();
//        }
//        // подключаем звук через ресурсы
//        soundIDRes = soundPool.load(this, R.raw.ne_tot_gonduras, 1);
//        // подключаем звук через Java
//        assetManager = getAssets();
//        try {
//            assetFileDescriptor = assetManager.openFd("ne_tot_gonduras.mp3");
//        } catch (IOException e) {e.printStackTrace();}
//        soundIDJava = soundPool.load(assetFileDescriptor, 1);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.button1: soundPool.play(soundIDJava, 1, 1, 1, 0, 1); break;
//            case R.id.button2: soundPool.play(soundIDRes, 1.0f, 1.0f, 1, 0, 1f); break;
//        }
//    }
//}