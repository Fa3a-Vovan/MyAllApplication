package com.example.lesson10saper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Analysis analysis = new Analysis();

    TextView textView, textView2, result;
    Button button[][] = new Button[4][4];
    int cageOfField[][] = new int[4][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textPreview);
        textView2 = findViewById(R.id.quantity_of_mines);
        result = findViewById(R.id.result);

        button[0][0] = findViewById(R.id.button0_0); registerForContextMenu(button[0][0]); button[0][0].setOnClickListener(this);
        button[0][1] = findViewById(R.id.button0_1); registerForContextMenu(button[0][1]); button[0][1].setOnClickListener(this);
        button[0][2] = findViewById(R.id.button0_2); registerForContextMenu(button[0][2]); button[0][2].setOnClickListener(this);
        button[0][3] = findViewById(R.id.button0_3); registerForContextMenu(button[0][3]); button[0][3].setOnClickListener(this);

        button[1][0] = findViewById(R.id.button1_0); registerForContextMenu(button[1][0]); button[1][0].setOnClickListener(this);
        button[1][1] = findViewById(R.id.button1_1); registerForContextMenu(button[1][1]); button[1][1].setOnClickListener(this);
        button[1][2] = findViewById(R.id.button1_2); registerForContextMenu(button[1][2]); button[1][2].setOnClickListener(this);
        button[1][3] = findViewById(R.id.button1_3); registerForContextMenu(button[1][3]); button[1][3].setOnClickListener(this);

        button[2][0] = findViewById(R.id.button2_0); registerForContextMenu(button[2][0]); button[2][0].setOnClickListener(this);
        button[2][1] = findViewById(R.id.button2_1); registerForContextMenu(button[2][1]); button[2][1].setOnClickListener(this);
        button[2][2] = findViewById(R.id.button2_2); registerForContextMenu(button[2][2]); button[2][2].setOnClickListener(this);
        button[2][3] = findViewById(R.id.button2_3); registerForContextMenu(button[2][3]); button[2][3].setOnClickListener(this);

        button[3][0] = findViewById(R.id.button3_0); registerForContextMenu(button[3][0]); button[3][0].setOnClickListener(this);
        button[3][1] = findViewById(R.id.button3_1); registerForContextMenu(button[3][1]); button[3][1].setOnClickListener(this);
        button[3][2] = findViewById(R.id.button3_2); registerForContextMenu(button[3][2]); button[3][2].setOnClickListener(this);
        button[3][3] = findViewById(R.id.button3_3); registerForContextMenu(button[3][3]); button[3][3].setOnClickListener(this);
        textView2.setText(analysis.createGameField(cageOfField));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
                finish();
            case R.id.restart:
                reStart();
        }
        return super.onOptionsItemSelected(item);
    }

    void reStart() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        switch (v.getId()){
            case R.id.button0_0: inflater.inflate(R.menu.context_0_0, menu); break;
            case R.id.button0_1: inflater.inflate(R.menu.context_0_1, menu); break;
            case R.id.button0_2: inflater.inflate(R.menu.context_0_2, menu); break;
            case R.id.button0_3: inflater.inflate(R.menu.context_0_3, menu); break;

            case R.id.button1_0: inflater.inflate(R.menu.context_1_0, menu); break;
            case R.id.button1_1: inflater.inflate(R.menu.context_1_1, menu); break;
            case R.id.button1_2: inflater.inflate(R.menu.context_1_2, menu); break;
            case R.id.button1_3: inflater.inflate(R.menu.context_1_3, menu); break;

            case R.id.button2_0: inflater.inflate(R.menu.context_2_0, menu); break;
            case R.id.button2_1: inflater.inflate(R.menu.context_2_1, menu); break;
            case R.id.button2_2: inflater.inflate(R.menu.context_2_2, menu); break;
            case R.id.button2_3: inflater.inflate(R.menu.context_2_3, menu); break;

            case R.id.button3_0: inflater.inflate(R.menu.context_3_0, menu); break;
            case R.id.button3_1: inflater.inflate(R.menu.context_3_1, menu); break;
            case R.id.button3_2: inflater.inflate(R.menu.context_3_2, menu); break;
            case R.id.button3_3: inflater.inflate(R.menu.context_3_3, menu); break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.de_mine00: if (cageOfField[0][0] == 1) { boom();} else {analysis.deMine(0, 0, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.de_mine01: if (cageOfField[0][1] == 1) { boom();} else {analysis.deMine(0, 1, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.de_mine02: if (cageOfField[0][2] == 1) { boom();} else {analysis.deMine(0, 2, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.de_mine03: if (cageOfField[0][3] == 1) { boom();} else {analysis.deMine(0, 3, cageOfField, button); analysis.winner(cageOfField, result, button);} break;

            case R.id.de_mine10: if (cageOfField[1][0] == 1) { boom();} else {analysis.deMine(1, 0, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.de_mine11: if (cageOfField[1][1] == 1) { boom();} else {analysis.deMine(1, 1, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.de_mine12: if (cageOfField[1][2] == 1) { boom();} else {analysis.deMine(1, 2, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.de_mine13: if (cageOfField[1][3] == 1) { boom();} else {analysis.deMine(1, 3, cageOfField, button); analysis.winner(cageOfField, result, button);} break;

            case R.id.de_mine20: if (cageOfField[2][0] == 1) { boom();} else {analysis.deMine(2, 0, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.de_mine21: if (cageOfField[2][1] == 1) { boom();} else {analysis.deMine(2, 1, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.de_mine22: if (cageOfField[2][2] == 1) { boom();} else {analysis.deMine(2, 2, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.de_mine23: if (cageOfField[2][3] == 1) { boom();} else {analysis.deMine(2, 3, cageOfField, button); analysis.winner(cageOfField, result, button);} break;

            case R.id.de_mine30: if (cageOfField[3][0] == 1) { boom();} else {analysis.deMine(3, 0, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.de_mine31: if (cageOfField[3][1] == 1) { boom();} else {analysis.deMine(3, 1, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.de_mine32: if (cageOfField[3][2] == 1) { boom();} else {analysis.deMine(3, 2, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.de_mine33: if (cageOfField[3][3] == 1) { boom();} else {analysis.deMine(3, 3, cageOfField, button); analysis.winner(cageOfField, result, button);} break;

            case  R.id.flag00: button[0][0].setText("!"); break;
            case  R.id.flag01: button[0][1].setText("!"); break;
            case  R.id.flag02: button[0][2].setText("!"); break;
            case  R.id.flag03: button[0][3].setText("!"); break;

            case  R.id.flag10: button[1][0].setText("!"); break;
            case  R.id.flag11: button[1][1].setText("!"); break;
            case  R.id.flag12: button[1][2].setText("!"); break;
            case  R.id.flag13: button[1][3].setText("!"); break;

            case  R.id.flag20: button[2][0].setText("!"); break;
            case  R.id.flag21: button[2][1].setText("!"); break;
            case  R.id.flag22: button[2][2].setText("!"); break;
            case  R.id.flag23: button[2][3].setText("!"); break;

            case  R.id.flag30: button[3][0].setText("!"); break;
            case  R.id.flag31: button[3][1].setText("!"); break;
            case  R.id.flag32: button[3][2].setText("!"); break;
            case  R.id.flag33: button[3][3].setText("!"); break;

            case  R.id.unFlag00: button[0][0].setText(""); break;
            case  R.id.unFlag01: button[0][1].setText(""); break;
            case  R.id.unFlag02: button[0][2].setText(""); break;
            case  R.id.unFlag03: button[0][3].setText(""); break;

            case  R.id.unFlag10: button[1][0].setText(""); break;
            case  R.id.unFlag11: button[1][1].setText(""); break;
            case  R.id.unFlag12: button[1][2].setText(""); break;
            case  R.id.unFlag13: button[1][3].setText(""); break;

            case  R.id.unFlag20: button[2][0].setText(""); break;
            case  R.id.unFlag21: button[2][1].setText(""); break;
            case  R.id.unFlag22: button[2][2].setText(""); break;
            case  R.id.unFlag23: button[2][3].setText(""); break;

            case  R.id.unFlag30: button[3][0].setText(""); break;
            case  R.id.unFlag31: button[3][1].setText(""); break;
            case  R.id.unFlag32: button[3][2].setText(""); break;
            case  R.id.unFlag33: button[3][3].setText(""); break;
        }
        return super.onContextItemSelected(item);
    }

    void boom() {
        button[0][0].setEnabled(false);
        button[0][1].setEnabled(false);
        button[0][2].setEnabled(false);
        button[0][3].setEnabled(false);

        button[1][0].setEnabled(false);
        button[1][1].setEnabled(false);
        button[1][2].setEnabled(false);
        button[1][3].setEnabled(false);

        button[2][0].setEnabled(false);
        button[2][1].setEnabled(false);
        button[2][2].setEnabled(false);
        button[2][3].setEnabled(false);

        button[3][0].setEnabled(false);
        button[3][1].setEnabled(false);
        button[3][2].setEnabled(false);
        button[3][3].setEnabled(false);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_boom);
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (cageOfField[i][j]==1){
                    button[i][j].setText("бум");
                    button[i][j].startAnimation(animation);
                }
            }
        }
        result.setText("You lose");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0_0: if (cageOfField[0][0] == 1) { boom();} else {analysis.deMine(0, 0, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.button0_1: if (cageOfField[0][1] == 1) { boom();} else {analysis.deMine(0, 1, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.button0_2: if (cageOfField[0][2] == 1) { boom();} else {analysis.deMine(0, 2, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.button0_3: if (cageOfField[0][3] == 1) { boom();} else {analysis.deMine(0, 3, cageOfField, button); analysis.winner(cageOfField, result, button);} break;

            case R.id.button1_0: if (cageOfField[1][0] == 1) { boom();} else {analysis.deMine(1, 0, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.button1_1: if (cageOfField[1][1] == 1) { boom();} else {analysis.deMine(1, 1, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.button1_2: if (cageOfField[1][2] == 1) { boom();} else {analysis.deMine(1, 2, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.button1_3: if (cageOfField[1][3] == 1) { boom();} else {analysis.deMine(1, 3, cageOfField, button); analysis.winner(cageOfField, result, button);} break;

            case R.id.button2_0: if (cageOfField[2][0] == 1) { boom();} else {analysis.deMine(2, 0, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.button2_1: if (cageOfField[2][1] == 1) { boom();} else {analysis.deMine(2, 1, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.button2_2: if (cageOfField[2][2] == 1) { boom();} else {analysis.deMine(2, 2, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.button2_3: if (cageOfField[2][3] == 1) { boom();} else {analysis.deMine(2, 3, cageOfField, button); analysis.winner(cageOfField, result, button);} break;

            case R.id.button3_0: if (cageOfField[3][0] == 1) { boom();} else {analysis.deMine(3, 0, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.button3_1: if (cageOfField[3][1] == 1) { boom();} else {analysis.deMine(3, 1, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.button3_2: if (cageOfField[3][2] == 1) { boom();} else {analysis.deMine(3, 2, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
            case R.id.button3_3: if (cageOfField[3][3] == 1) { boom();} else {analysis.deMine(3, 3, cageOfField, button); analysis.winner(cageOfField, result, button);} break;
        }
    }
}