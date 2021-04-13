package com.example.lesson14addelfromjava;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.os.PersistableBundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayoutMainLay;
    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    LayoutParams layoutParamsMainLay = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    LayoutParams layoutParamsLay = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
    LayoutParams layoutParamsBut = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    Button[] button1;
    Button[] button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayoutMainLay = new LinearLayout(this);
        linearLayout1 = new LinearLayout(this);
        linearLayout1.setBackgroundResource(R.mipmap.ic_launcher);
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout2 = new LinearLayout(this);
        linearLayoutMainLay.addView(linearLayout1, layoutParamsLay);
        linearLayoutMainLay.addView(linearLayout2, layoutParamsLay);
        button1 = new Button[5];
        for (int i = 0; i < 5; i++){
            button1[i] = new Button(this);
            button1[i].setId(i);
            button1[i].setLayoutParams(layoutParamsBut);
            linearLayout1.addView(button1[i]);
        }
        button2 = new Button[5];
        for (int i = 0; i < 5; i++){
            button2[i] = new Button(this);
            button2[i].setId(i);
            button2[i].setLayoutParams(layoutParamsBut);
            button2[i].setBackgroundResource(R.mipmap.ic_launcher);
            linearLayout2.addView(button2[i]);
        }
        setContentView(linearLayoutMainLay, layoutParamsMainLay);
    }
}