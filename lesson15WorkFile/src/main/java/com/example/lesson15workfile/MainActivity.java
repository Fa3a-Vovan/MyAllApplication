package com.example.lesson15workfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "myLogs";
    TextView textView2;
    EditText editText, editText2;
    Button button, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Заготовка");
        textView2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button); button.setOnClickListener(this);
        button2 = findViewById(R.id.button2); button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3); button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4); button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button: createFile(editText.getText().toString()); break;
            case R.id.button2: saveFile(editText.getText().toString(), editText2.getText().toString()); break;
            case R.id.button3: textView2.setText(readFile(editText2.getText().toString())); break;
            case R.id.button4: deleteMyFile(editText.getText().toString()); break;
        }
    }

    void createFile(String fileName) {
        Log.d(TAG, "Создать файл: " + fileName);
    }

    void saveFile (String fileName, String information) {
        Log.d(TAG, "Запись файла: " + fileName);
    }

    String  readFile (String fileName) {
        Log.d(TAG, "Чтение файла: " + fileName); return fileName;
    }

    void deleteMyFile (String fileName) {
        Log.d(TAG, "Удаление файла: " + fileName);
    }
}