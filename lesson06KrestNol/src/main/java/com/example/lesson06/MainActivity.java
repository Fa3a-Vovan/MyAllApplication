package com.example.lesson06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button1.setText("Кнопка №1");
        button2.setText("Кнопка №2");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                button1.setEnabled(false);
                textView.setText("Нажата кнопка №1");
                button2.setEnabled(true);
                break;
            case R.id.button2:
                button2.setEnabled(false);
                textView.setText("Нажата кнопка №2");
                button1.setEnabled(true);
                break;
        }
    }
}