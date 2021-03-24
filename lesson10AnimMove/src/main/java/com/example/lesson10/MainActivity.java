package com.example.lesson10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int menuA = 1;
    final int menuR = 2;
    final int menuS = 3;
    final int menuT = 4;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView1);
        button = findViewById(R.id.button1);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main, menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Animation anim = null;
        switch (item.getItemId()){
            case R.id.alpha1: anim = AnimationUtils.loadAnimation(this, R.anim.alpha1); break;
            case R.id.rotate1: anim = AnimationUtils.loadAnimation(this, R.anim.rotate1); break;
            case R.id.scale1: anim = AnimationUtils.loadAnimation(this, R.anim.scale1); break;
            case R.id.translate1: anim = AnimationUtils.loadAnimation(this, R.anim.translate1); break;
            case R.id.exit: finish(); break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Animation anim = null;
        switch (item.getItemId()){
            case R.id.alpha1: anim = AnimationUtils.loadAnimation(this, R.anim.alpha1); break;
            case R.id.rotate1: anim = AnimationUtils.loadAnimation(this, R.anim.rotate1); break;
            case R.id.scale1: anim = AnimationUtils.loadAnimation(this, R.anim.scale1); break;
            case R.id.translate1: anim = AnimationUtils.loadAnimation(this, R.anim.translate1); break;
        }
        button.startAnimation(anim);
        return super.onContextItemSelected(item);
    }
}