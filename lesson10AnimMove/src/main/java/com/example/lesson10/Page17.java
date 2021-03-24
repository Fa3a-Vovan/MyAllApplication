package com.example.lesson10;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Page17 extends AppCompatActivity implements Animation.AnimationListener {
    Animation animation = null;
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
        menu.add(Menu.NONE, R.anim.alpha1, Menu.NONE, "Прозрачность1").setAlphabeticShortcut('a');
        menu.add(Menu.NONE, R.anim.scale1, Menu.NONE, "Размер1").setAlphabeticShortcut('s');
        menu.add(Menu.NONE, R.anim.translate1, Menu.NONE, "Передвижение1").setAlphabeticShortcut('t');
        menu.add(Menu.NONE, R.anim.rotate1, Menu.NONE, "Поворот1").setAlphabeticShortcut('r');
        return (super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        animation = AnimationUtils.loadAnimation(this, item.getItemId());
        animation.setAnimationListener(this);
        button.startAnimation(animation);
        return true;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        button.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        button.setVisibility(View.VISIBLE);
        textView.startAnimation(animation);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        button.setVisibility(View.VISIBLE);
        textView.startAnimation(animation);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Animation alpha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha1);
        textView.startAnimation(alpha);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) { }
            public void onAnimationEnd(Animation animation) {
                perehod();
            }
            public void onAnimationRepeat(Animation animation) {    }
        });
        return super.onContextItemSelected(item);
    }

    void perehod(){
        String schet="1";
        Intent intent = new Intent (this, MainActivity.class);
        intent.putExtra("schet", schet);
        startActivity(intent);
        finish();
    }
}