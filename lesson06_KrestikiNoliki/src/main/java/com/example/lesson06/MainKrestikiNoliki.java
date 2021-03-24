package com.example.lesson06;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainKrestikiNoliki extends AppCompatActivity implements View.OnClickListener {
    ResultAnalysis analysis = new ResultAnalysis();
    ArtificialIntelligence ai = new ArtificialIntelligence();

    TextView textView, result;
    Button button[] = new Button[9];
    int a1 = 0;
    int a2[][] = new int[3][3];
    int viborPartnera = 0;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.first: viborPartnera = 0; return true;
            case R.id.second: viborPartnera = 1; return true;
            case R.id.third: reStart(); return true;
            case R.id.fourth: vihod(); return true;
            case R.id.item1:
                Toast.makeText(this,"item 1 selected", Toast.LENGTH_SHORT).show();  return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    void reStart(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
    void vihod(){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.krestiki_noliki);

        textView = findViewById(R.id.textView);result = findViewById(R.id.result);
        button[0] = findViewById(R.id.b0);button[0].setOnClickListener(this);
        button[1] = findViewById(R.id.b1);button[1].setOnClickListener(this);
        button[2] = findViewById(R.id.b2);button[2].setOnClickListener(this);
        button[3] = findViewById(R.id.b3);button[3].setOnClickListener(this);
        button[4] = findViewById(R.id.b4);button[4].setOnClickListener(this);
        button[5] = findViewById(R.id.b5);button[5].setOnClickListener(this);
        button[6] = findViewById(R.id.b6);button[6].setOnClickListener(this);
        button[7] = findViewById(R.id.b7);button[7].setOnClickListener(this);
        button[8] = findViewById(R.id.b8);button[8].setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b0:button[0].setEnabled(false);
                if (a1%2==0){button[0].setText("X");a2[0][0]=1;} else {button[0].setText("O");a2[0][0]=2;}
                result.setText(analysis.analysis(a2));
                lockAll(String.valueOf(result.getText()));
                a1++;
                if(viborPartnera==0){
                    if (a1 % 2 != 0){
                        int k=2;
                        k=ai.computerSelection(a2);
                        button[k].setText("O");
                        button[k].setEnabled(false);
                        result.setText(analysis.analysis(a2));
                        lockAll(String.valueOf(result.getText()));
                        a1++;
                    }
                } break;
            case R.id.b1:button[1].setEnabled(false);
                if (a1%2==0){button[1].setText("X");a2[0][1]=1;} else {button[1].setText("O");a2[0][1]=2;}
                result.setText(analysis.analysis(a2));
                lockAll(String.valueOf(result.getText()));
                a1++;
                if(viborPartnera==0){
                    if (a1 % 2 != 0){
                        int k;
                        k=ai.computerSelection(a2);
                        button[k].setText("O");
                        button[k].setEnabled(false);
                        result.setText(analysis.analysis(a2));
                        lockAll(String.valueOf(result.getText()));
                        a1++;
                    }
                } break;
            case R.id.b2:button[2].setEnabled(false);
                if (a1%2==0){button[2].setText("X");a2[0][2]=1;} else {button[2].setText("O");a2[0][2]=2;}
                result.setText(analysis.analysis(a2));
                lockAll(String.valueOf(result.getText()));
                a1++;
                if(viborPartnera==0){
                    if (a1 % 2 != 0){
                        int k;
                        k=ai.computerSelection(a2);
                        button[k].setText("O");
                        button[k].setEnabled(false);
                        result.setText(analysis.analysis(a2));
                        lockAll(String.valueOf(result.getText()));
                        a1++;
                    }
                } break;
            case R.id.b3:button[3].setEnabled(false);
                if (a1%2==0){button[3].setText("X");a2[1][0]=1;} else {button[3].setText("O");a2[1][0]=2;}
                result.setText(analysis.analysis(a2));
                lockAll(String.valueOf(result.getText()));
                a1++;
                if(viborPartnera==0){
                    if (a1 % 2 != 0){
                        int k;
                        k=ai.computerSelection(a2);
                        button[k].setText("O");
                        button[k].setEnabled(false);
                        result.setText(analysis.analysis(a2));
                        lockAll(String.valueOf(result.getText()));
                        a1++;
                    }
                } break;
            case R.id.b4:button[4].setEnabled(false);
                if (a1%2==0){button[4].setText("X");a2[1][1]=1;} else {button[4].setText("O");a2[1][1]=2;}
                result.setText(analysis.analysis(a2));
                lockAll(String.valueOf(result.getText()));
                a1++;
                if(viborPartnera==0){
                    if (a1 % 2 != 0){
                        int k;
                        k=ai.computerSelection(a2);
                        button[k].setText("O");
                        button[k].setEnabled(false);
                        result.setText(analysis.analysis(a2));
                        lockAll(String.valueOf(result.getText()));
                        a1++;
                    }
                } break;
            case R.id.b5:button[5].setEnabled(false);
                if (a1%2==0){button[5].setText("X");a2[1][2]=1;} else {button[5].setText("O");a2[1][2]=2;}
                result.setText(analysis.analysis(a2));
                lockAll(String.valueOf(result.getText()));
                a1++;
                if(viborPartnera==0){
                    if (a1 % 2 != 0){
                        int k;
                        k=ai.computerSelection(a2);
                        button[k].setText("O");
                        button[k].setEnabled(false);
                        result.setText(analysis.analysis(a2));
                        lockAll(String.valueOf(result.getText()));
                        a1++;
                    }
                } break;
            case R.id.b6:button[6].setEnabled(false);
                if (a1%2==0){button[6].setText("X");a2[2][0]=1;} else {button[6].setText("O");a2[2][0]=2;}
                result.setText(analysis.analysis(a2));
                lockAll(String.valueOf(result.getText()));
                a1++;
                if(viborPartnera==0){
                    if (a1 % 2 != 0){
                        int k;
                        k=ai.computerSelection(a2);
                        button[k].setText("O");
                        button[k].setEnabled(false);
                        result.setText(analysis.analysis(a2));
                        lockAll(String.valueOf(result.getText()));
                        a1++;
                    }
                } break;
            case R.id.b7:button[7].setEnabled(false);
                if (a1%2==0){button[7].setText("X");a2[2][1]=1;} else {button[7].setText("O");a2[2][1]=2;}
                result.setText(analysis.analysis(a2));
                lockAll(String.valueOf(result.getText()));
                a1++;
                if(viborPartnera==0){
                    if (a1 % 2 != 0){
                        int k;
                        k=ai.computerSelection(a2);
                        button[k].setText("O");
                        button[k].setEnabled(false);
                        result.setText(analysis.analysis(a2));
                        lockAll(String.valueOf(result.getText()));
                        a1++;
                    }
                } break;
            case R.id.b8:button[8].setEnabled(false);
                if (a1%2==0){button[8].setText("X");a2[2][2]=1;} else {button[8].setText("O");a2[2][2]=2;}
                result.setText(analysis.analysis(a2));
                lockAll(String.valueOf(result.getText()));
                a1++;
                if(viborPartnera==0){
                    if (a1 % 2 != 0){
                        int k;
                        k=ai.computerSelection(a2);
                        button[k].setText("O");
                        button[k].setEnabled(false);
                        result.setText(analysis.analysis(a2));
                        lockAll(String.valueOf(result.getText()));
                        a1++;
                    }
                } break;
        }
    }
    void lockAll (String s){
        if(s==analysis.crossesWon()||s==analysis.zerosWon()){
            button[0].setEnabled(false);
            button[1].setEnabled(false);
            button[2].setEnabled(false);
            button[3].setEnabled(false);
            button[4].setEnabled(false);
            button[5].setEnabled(false);
            button[6].setEnabled(false);
            button[7].setEnabled(false);
            button[8].setEnabled(false);
        }
    }
}
