package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //private TextView textView;
    private Button button;
    EditText text;
    String a = "aaaaaa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView1);
        button = (Button) findViewById(R.id.button1);
        text = findViewById(R.id.editText2);
        //создаем обработчик нажтия
        View.OnClickListener slushatButt = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = text.getText().toString();
                textView.setText(a);
            }
        };
        //присвоим обработчик кнопке
        button.setOnClickListener(slushatButt);
    }
}