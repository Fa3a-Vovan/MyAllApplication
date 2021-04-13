package com.example.lesson15workfile2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                createFile(editText.getText().toString());
                break;
            case R.id.button2:
                saveFile(editText.getText().toString(), editText2.getText().toString());
                break;
            case R.id.button3:
                textView2.setText(readFile(editText.getText().toString()));
                break;
            case R.id.button4:
                deleteMyFile(editText.getText().toString());
                break;
        }
    }

    void createFile(String fileName) {
        Log.d(TAG, "Создать файл: " + fileName);
        try {
            FileOutputStream outputStream = this.openFileOutput(fileName, this.MODE_PRIVATE);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void saveFile(String fileName, String information) {
        Log.d(TAG, "Запись файла: " + fileName);
        try {
            FileOutputStream outputStream = this.openFileOutput(fileName, this.MODE_APPEND);// MODE_PRIVATE для перезаписи
            outputStream.write(information.getBytes());
            Log.i(TAG, "" + information.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String readFile(String fileName) {
        Log.d(TAG, "Чтение файла: " + fileName);
        String ret = "";
        try {
            InputStream inputStream = openFileInput(fileName);
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();
                String receiveString = "";

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                    Log.d(TAG, "receiveString= " + receiveString);
                }
                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e(TAG, "Can not read file: " + e.toString());
        }
        return ret;
    }

    void deleteMyFile(String fileName) {
        Log.d(TAG, "Удаление файла: " + fileName);
        this.deleteFile(fileName);
    }
}