package com.example.lesson05;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spanned;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page03);
        TextView textView1 = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.TextView4);
        TextView textView5 = findViewById(R.id.TextView5);
        TextView textView6 = findViewById(R.id.TextView6);
        TextView textView7 = findViewById(R.id.TextView7);
        TextView textView8 = findViewById(R.id.TextView8);
        TextView textView9 = findViewById(R.id.TextView9);
        TextView textView91 = findViewById(R.id.TextView91);
        TextView resultat = findViewById(R.id.resultat);
        resultat.setText(getString(android.R.string.httpErrorBadUrl));


        Resources res = getResources();

        boolean a1 = res.getBoolean(R.bool.a1);
        if (a1) {
            textView1.setText("true");
        }
        textView2.setText("" + a1);
        int a2 = res.getInteger(R.integer.a2);
        textView3.setText("" + a2);
        String a3 = res.getString(R.string.a3);
        textView4.setText(a3);

        //вывод обычной строки
        String b1 = res.getString(R.string.b1);
        textView5.setText(b1);

        //Считывание строки в кавычках
        String b2 = res.getString(R.string.b2);
        textView6.setText(b2);

        //Передаем данные из программы
        String b3 = res.getString(R.string.b3);
        String b31 = String.format(b3, "1", "3");
        textView7.setText(b31);

        //Считываение строки html_string из ресурса
        //Теги пропускаются
        String b4 = res.getString(R.string.b4);
        Spanned b41 = android.text.Html.fromHtml(b4);
        textView8.setText(b41);

        String[] names = getResources().getStringArray(R.array.string);
        for (int i = 0; i < names.length; i++) {
            textView9.setText("Name[" + i + "]: " + names[i] + "\n");
        }
        int[] digits = getResources().getIntArray(R.array.integer);
        for (int i = 0; i < digits.length; i++) {
            textView91.setText("Digits[" + i + "]: " + names[i] + "\n");
        }// И хотя все элементы массивов выводились на экран, но выводились она в одни и те же
        // элементы, поэтому вы видите только последний элементы каждого массива

    }
}