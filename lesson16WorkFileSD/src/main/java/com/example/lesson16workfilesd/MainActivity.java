package com.example.lesson16workfilesd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "myLogs";
    TextView textView2;
    EditText editText, editText1, editText2;
    Button button, button2, button3, button4, button5;

    public static final int REQUEST_WRITE_STORAGE = 1;// Создаем идентефикатор permission

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Заготовка");
        textView2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button); button.setOnClickListener(this);
        button2 = findViewById(R.id.button2); button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3); button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4); button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5); button5.setOnClickListener(this);
///////////////////// Android 6 /////////////////////////////////////////////
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && permission != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Permission to record denied");
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_STORAGE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_WRITE_STORAGE: {
                if (grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "Permission has been denied by user");
                } else {
                    Log.d(TAG, "Permission has been granted by user");
                }
                return;
            }
        }
    }
//////////////////////////////////////////////////////////////////////

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button: createFileSDAll(editText.getText().toString(), editText1.getText().toString()
                    , editText2.getText().toString()); break;
            case R.id.button2: createFileSDApp(editText.getText().toString(), editText1.getText().toString()
                    , editText2.getText().toString()); break;
            case R.id.button3: textView2.setText(readFile(editText.getText().toString(), editText1.getText().toString(),
                    editText2.getText().toString())); break;
            case R.id.button4: deleteMyFile(editText.getText().toString(), editText1.getText().toString()
            ); break;
            case R.id.button5: deleteALL();
        }
    }

    void createFileSDAll(String fileName, String filePath, String information) {
        Log.d(TAG, "Создать файл: " + fileName);
        //проверяем доступность SD, если true то SD-card доступна
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Log.d(TAG, "SD-card не до ступна");
            return;
        }
        File sdPath = Environment.getExternalStorageDirectory(); //получаем путь к SD
        sdPath = new File(sdPath.getAbsolutePath() + "/" + filePath); //добавляем свой каталог к пути
        sdPath.mkdirs(); //создаем каталог
        File sdFile = new File(sdPath, fileName); //формируем объект File, который содержит путь к файлу
        try {
            BufferedWriter bfWrit = new BufferedWriter(new FileWriter(sdFile)); //открываем поток для записи
            bfWrit.write(information); //пишем данные
            bfWrit.close(); //закрываем поток
            Log.d(TAG, "файл записан на SD: " + sdFile);
        } catch (IOException e) {e.printStackTrace();}
    }

    void createFileSDApp(String fileName, String filePath, String information) {
        Log.d(TAG, "Запись файла: " + fileName);
        //проверяем доступность SD, если true то SD-card доступна
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Log.d(TAG, "SD-card не доступна");
            return;
        }
        File sdPath = new File(this.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), filePath);// файл получил название директории и файла
        if (!sdPath.mkdirs()){ Log.e(TAG, "Directory not created");}
        File sdFile = new File(sdPath, fileName);// формируем объект File, который содержит путь к файлу
        try {
            BufferedWriter bfWrit = new BufferedWriter(new FileWriter(sdFile));// открываем поток для записи
            bfWrit.write(information);// пишем данные
            bfWrit.close();// закрываем поток
            Log.d(TAG, "файл записан на SD: " + sdFile);
        } catch (IOException e) {e.printStackTrace();}
    }

    String  readFile (String fileName, String filePath, String information) {
        Log.d(TAG, "Чтение файла: " + fileName);
        String str = "", str1 = "";// сюда будет помещено содержимое файла
        //проверяем наличие SD-card
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Log.d(TAG, "SD-карта не доступна");
            return "";
        }
        File sdPath = Environment.getExternalStorageDirectory();// получить путь к SD
        sdPath = new File(sdPath.getAbsolutePath() + "/" + filePath);// добавляем свой каталог к пути
        sdPath.mkdirs();// создаем каталог
        File sdFile = new File(sdPath, fileName);// формируем объект File, который содержит путь к файлу
        try { // открываем поток для чтения
            Log.d(TAG,  " try { Чтение файла: " + sdFile);
            BufferedReader bufRead = new BufferedReader(new FileReader(sdFile));
            while ((str1 = bufRead.readLine()) != null){ // В цикле построчно считываем файл
                str = str+str1;
                Log.d(TAG, str);
            }
        } catch (FileNotFoundException e) {e.printStackTrace();} catch (IOException e) {e.printStackTrace();}
        return str;
    }

    void deleteMyFile (String fileName, String filePath) {
        //проверяем наличие SD
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Log.d(TAG, "SD-карта не доступна"); return;
        }
        File sdPath = Environment.getExternalStorageDirectory();// получаем путь к SD
        sdPath = new File(sdPath.getAbsolutePath() + "/" + filePath);// добавляем свой каталог к пути
        File sdFile = new File(sdPath, fileName);
        Log.d(TAG, "Удаление файла: " + sdFile);

        sdFile.delete();// Удаление файла по указанному пути и имени

    }
    void deleteALL (){
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Log.d(TAG, "SD-карта не доступна");
            return;
        }
        File sdPath = new File(String.valueOf(this.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)));
        recursiveDelete(sdPath);
        Log.d(TAG,  "All directories have been deleted " + sdPath);
    }
    void recursiveDelete(File fileDirectory) {
        if (fileDirectory.isDirectory()){
            for (File child : fileDirectory.listFiles()){
                recursiveDelete(child);
                child.delete();
                Log.d(TAG, "file del " + child);
            }
            fileDirectory.delete();
        }
    }
}