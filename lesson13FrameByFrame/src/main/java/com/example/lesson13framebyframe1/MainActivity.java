package com.example.lesson13framebyframe1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Начнем", Toast.LENGTH_SHORT).show();

        ImageView img = (ImageView) findViewById(R.id.image);
        img.setBackgroundResource(R.drawable.draw);

        AnimationDrawable frame = (AnimationDrawable) img.getBackground();
        frame.start();

        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

//        ratingBar.setStepSize((float) 0.10);
        SeekBar sAA = (SeekBar) findViewById(R.id.setAlpha);
        sAA.setOnSeekBarChangeListener
                (new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                frame.setAlpha(progress);
                ratingBar.setNumStars(5);
                ratingBar.setRating((float)progress/50);
                Toast.makeText(MainActivity.this, "RatingBar: " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "STOP", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.restart:
                restart();
            case R.id.exit:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    void restart() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}